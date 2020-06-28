package com.smith;

import org.beetl.core.resource.WebAppResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.beetl.sql.core.ClasspathLoader;
import org.beetl.sql.core.Interceptor;
import org.beetl.sql.core.UnderlinedNameConversion;
import org.beetl.sql.core.db.MySqlStyle;
import org.beetl.sql.ext.DebugInterceptor;
import org.beetl.sql.ext.spring4.BeetlSqlDataSource;
import org.beetl.sql.ext.spring4.BeetlSqlScannerConfigurer;
import org.beetl.sql.ext.spring4.SqlManagerFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author gaoyu
 * @date 2020-06-23
 * @description
 */

@SpringBootApplication
public class SpringbootBeetlSqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootBeetlSqlApplication.class, args);
    }

    @Bean(initMethod = "init", name = "beetlConfig")
    public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        ResourcePatternResolver patternResolver = ResourcePatternUtils.getResourcePatternResolver(new DefaultResourceLoader());
        try {
            WebAppResourceLoader webAppResourceLoader = new WebAppResourceLoader(patternResolver.getResource("classpath:/templates")
                    .getFile().getPath());
            beetlGroupUtilConfiguration.setResourceLoader(webAppResourceLoader);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return beetlGroupUtilConfiguration;
    }

    @Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }

    @Bean(name = "beetlSqlScannerConfigurer")
    public BeetlSqlScannerConfigurer getBeetlSqlScannerConfigurer() {
        BeetlSqlScannerConfigurer beetlSqlScannerConfigurer = new BeetlSqlScannerConfigurer();
        beetlSqlScannerConfigurer.setBasePackage("com.smith.dao");
        beetlSqlScannerConfigurer.setDaoSuffix("Dao");
        beetlSqlScannerConfigurer.setSqlManagerFactoryBeanName("sqlManagerFactoryBean");
        return beetlSqlScannerConfigurer;
    }



    @Bean(name = "sqlManagerFactoryBean")
    @Primary
    public SqlManagerFactoryBean getSqlManagerFactoryBean(@Qualifier("datasource") DataSource dataSource) {
        SqlManagerFactoryBean sqlManagerFactoryBean = new SqlManagerFactoryBean();
        BeetlSqlDataSource beetlSqlDataSource = new BeetlSqlDataSource();
        beetlSqlDataSource.setMasterSource(dataSource);

        sqlManagerFactoryBean.setCs(beetlSqlDataSource);
        sqlManagerFactoryBean.setDbStyle(new MySqlStyle());
        sqlManagerFactoryBean.setInterceptors(new Interceptor[]{new DebugInterceptor()});
        //开启驼峰
        sqlManagerFactoryBean.setNc(new UnderlinedNameConversion());
        //sql文件路径
        sqlManagerFactoryBean.setSqlLoader(new ClasspathLoader("/sql"));
        return sqlManagerFactoryBean;

    }
    @Bean(name = "datasource")
    public DataSource getDataSource() {
        DataSource dataSource =  DataSourceBuilder.create().url("jdbc:mysql://localhost:3306/learn_springboot?serverTimezone=UTC")
                .username("root").password("qwer1234").build();
        return dataSource;

    }


    @Bean(name = "txManager")
    public DataSourceTransactionManager getDataSourceTransactionManager(@Qualifier("datasource") DataSource datasource) {
        DataSourceTransactionManager dsm = new DataSourceTransactionManager();
        dsm.setDataSource(datasource);
        return dsm;
    }

}
