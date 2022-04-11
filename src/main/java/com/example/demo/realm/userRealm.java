package com.example.demo.realm;

import com.example.demo.bean.users;
import com.example.demo.config.wechatToken;
import com.example.demo.service.serviceImpl.UsersServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.Set;

public class userRealm extends AuthorizingRealm {

    @Autowired
    UsersServiceImpl usersService;

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取当前用户的登录信息
        Subject subject= SecurityUtils.getSubject();
        users u=(users)subject.getPrincipal();  //在认证方法的SimpleAuthenticationInfo时已经把用户信息传送给subject对象中

        //设置角色
        Set<String> roles=new HashSet<>();
        roles.add("manager");
        roles.add("children");
        roles.add("relative");
        roles.add("youke");
        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo(roles);

        //设置权限
        info.addStringPermission("getallChildren");
        return null;
    }

    /**
     * 认证   实现微信openid单点登录的自定义realm
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        wechatToken token=(wechatToken)authenticationToken;
        users users;

        //从token中拿到用户信息
        users=usersService.selectByOpenId(token.getOpenId() );

        System.out.println(users.getOpenId());
        if(users.getUserId()!=null){
            //检查拿到的密码(users.getUserPassword())与传输来的密码(token)是否一致
            //token的getCredentials方法返回值与users.getOpenId()进行比较？（不懂）
            return new SimpleAuthenticationInfo(users,users.getOpenId(),getName());
        }
        return null;

    }

    /**
     *  定义该Realm可以处理哪个类型的token
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token!=null&&token instanceof wechatToken;
    }

}
