package com.smith.session.controller;

import com.smith.session.common.BaseResponse;
import com.smith.session.common.StatusCode;
import com.smith.session.entity.UserOnlineEntity;
import com.smith.session.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author gy
 * @date 2020-07-29
 * @description
 */
@Controller
@RequestMapping("/online")
public class SessionController {

    @Autowired
    private SessionService sessionService;

    @GetMapping("/index")
    public String onlineIndex() {
        return "online";
    }

    @GetMapping("list")
    @ResponseBody
    public List<UserOnlineEntity> list() {
        return sessionService.getOnlineList();
    }

    @PostMapping("takelogout")
    @ResponseBody
    public BaseResponse takeLogout(String id) {
        BaseResponse baseResponse = new BaseResponse(StatusCode.Success);

        try {
            sessionService.takeLogout(id);
        } catch (Exception e) {
            baseResponse = new BaseResponse(StatusCode.Fail);
            baseResponse.setMsg("踢出用户失败" + e.getMessage());
        }
        return baseResponse;
    }


}
