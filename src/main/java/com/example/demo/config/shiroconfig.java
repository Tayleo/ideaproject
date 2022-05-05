package com.example.demo.config;

import com.example.demo.realm.userRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


import javax.servlet.Filter;
import java.util.HashMap;



@Configuration
public class shiroconfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(@Qualifier("defaultWebSecurityManager") DefaultWebSecurityManager defaultWebSecurityManager){
        ShiroFilterFactoryBean factoryBean=new ShiroFilterFactoryBean();
        factoryBean.setSecurityManager(defaultWebSecurityManager);

        /*添加自定义过滤器*/
        HashMap<String, Filter> hashMap = new HashMap<String, Filter>();
        hashMap.put("MyFilter", getTestFilter());
        factoryBean.setFilters(hashMap);

      //  factoryBean.setFilterChainDefinitionMap(filterMap);

        //权限设置
//        Map<String,String> map=new HashMap<>();
//        map.put("/ChildrenController/getallChildren","authc");
//        factoryBean.setFilterChainDefinitionMap(map);
        return factoryBean;
    }

    @Bean
    public DefaultWebSecurityManager defaultWebSecurityManager(@Qualifier("userRealm") userRealm userRealm){

//        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
//        //设置realm
//        List<Realm> realms =new ArrayList<Realm>();
//
//        realms.add(userRealm());
//        realms.add(myShiroRealm());
//        securityManager.setRealms(realms);
//        //记住我
//        securityManager.setRememberMeManager(rememberMeManager());
//        //session管理
//        securityManager.setSessionManager(sessionManager());
//        return securityManager;


        DefaultWebSecurityManager manager=new DefaultWebSecurityManager();
        manager.setRealm(userRealm);
        return manager;
    }

    @Bean
    public userRealm userRealm(){
        return new userRealm();
    }


    /*** 自定义过滤器 */
    @Bean(name = "testFilter")
    public MyFilter getTestFilter(){
        MyFilter testFilter = new MyFilter();
        return testFilter;
    }

}
