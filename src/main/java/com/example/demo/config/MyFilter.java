package com.example.demo.config;

import org.apache.logging.log4j.ThreadContext;
import org.apache.shiro.web.servlet.AdviceFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

//@Slf4j
public class MyFilter extends AdviceFilter {

    /**
     * 执行之前被调用
     */
    @Override
    protected boolean preHandle(ServletRequest servletRequest, ServletResponse servletResponse) throws Exception {
        // 处理业务逻辑（ip地址以及用户名需要在此处进行添加） 可以使用subject对象，因为已经登录
        ThreadContext.put("ip", servletRequest.getLocalAddr());
        ThreadContext.put("username","老陈菜");
        System.out.println("这是执行之前被调用");
        return true;//返回 false 将中断后续拦截器链的执行
    }


    /**
     * 后处理/后置返回处理
     */
//    @Override
//    protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
//        // 处理业务逻辑 .....
//
//    }

    /**
     * 完成处理/后置最终处理
     */
    @Override
    public void afterCompletion(ServletRequest request, ServletResponse response, Exception exception) throws Exception {
        // 处理业务逻辑 .....
        ThreadContext.clearAll();
        System.out.println("这是完成处理/后置最终处理\n");
    }

}


