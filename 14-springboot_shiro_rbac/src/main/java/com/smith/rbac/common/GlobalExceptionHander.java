package com.smith.rbac.common;

import org.apache.shiro.authz.AuthorizationException;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author gy
 * @date 2020-07-24
 * @description 增加全局异常处理类，对于没有权限的用户跳转到未授权页面
 */
/*
 @ControllerAdvice ，很多初学者可能都没有听说过这个注解，
 实际上，这是一个非常有用的注解，顾名思义，这是一个增强的 Controller。
 使用这个 Controller ，可以实现三个方面的功能：
全局异常处理
全局数据绑定
全局数据预处理
*/
@ControllerAdvice
/*
 @Order(Ordered.HIGHEST_PRECEDENCE)代表这个过滤器在众多过滤器中级别最高，也就是过滤的时候最先执行
 而@Order(Ordered.LOWEST_PRECEDENCE)恰恰相反，表示级别最低，最后执行过滤操作。
 */
@Order(value = Ordered.HIGHEST_PRECEDENCE)

public class GlobalExceptionHander {
    @ExceptionHandler(value = AuthorizationException.class)
    public String handleAuthorException(){
        return "redirect:/unauthorized";
    }
}
