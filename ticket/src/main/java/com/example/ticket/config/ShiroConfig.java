package com.example.ticket.config;

import com.example.ticket.realm.UserRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import java.util.LinkedHashMap;
import java.util.Map;


@Configuration
public class ShiroConfig {

    // ShiroFilterFactoryBean
    @Bean(name="shiroFilter")
    public ShiroFilterFactoryBean getshiroFilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        // Set security manager
        bean.setSecurityManager(defaultWebSecurityManager);

        // Add shiro 内置过滤器
        /*
            anon: 无需认证就可以访问
            authc：必须认证才能访问
            user：必须拥有 记住我 功能才能访问
            perms：必须拥有对某个资源的权限才能访问
            role：拥有某个角色权限才能访问
         */
        // 拦截
        Map<String, String> filterMap = new LinkedHashMap<>();

        // 授权


        filterMap.put("/user/register", "anon");

        bean.setFilterChainDefinitionMap(filterMap);

        // 无权限则跳转至登陆页面
        bean.setLoginUrl("/toLogin");
        return bean;
    }

    // DefaultWebSecurityManager
    @Bean(name="securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // Relate UserRealm
        securityManager.setRealm(userRealm);
        return securityManager;
    }

    // Create realm entity, need definition
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }
}
