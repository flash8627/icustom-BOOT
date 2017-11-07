package com.gwtjs.icustom.cloud.zuul;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
/**
 * Created by aGuang on 2017/1/8.
 * zuul不仅只是路由，并且还能过滤，做一些安全验证
 * •	filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下： 
	o	pre：路由之前
	o	routing：路由之时
	o	post： 路由之后
	o	error：发送错误调用
	o	filterOrder：过滤的顺序
	o	shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
	o	run：过滤器的具体逻辑。可用很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
 */
@Component
public class MyZuulFilter extends ZuulFilter{

    private static Logger log = LoggerFactory.getLogger(MyZuulFilter.class);
    
    @Override/**回一个字符串代表过滤器的类型*/
    public String filterType() {
        return "pre";
    }

    @Override/**过滤的顺序*/
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }
    
    /**
     * 
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        log.info(String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString()));
        Object accessToken = request.getParameter("token");
        if(accessToken == null) {
            log.warn("token is empty");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            try {
                ctx.getResponse().getWriter().write("token is empty");
            }catch (Exception e){}

            return null;
        }
        log.info("ok");
        return null;
    }
}
