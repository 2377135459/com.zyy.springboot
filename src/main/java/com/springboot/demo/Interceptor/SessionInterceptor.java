package com.springboot.demo.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springboot.demo.util.count.Constant;
import com.springboot.demo.util.session.SessionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 对某些接口进行放行
 */
public class SessionInterceptor implements HandlerInterceptor {
    private static final Logger logger = LoggerFactory.getLogger(SessionInterceptor.class);

    /**
     * void afterCompletion()该方法也是需要当前对应的Interceptor的preHandle方法的返回值为true时才会执行，该方法将在整个请求结束
     * 之后，也就是在DispatcherServlet 渲染了对应的视图之后执行，也就是页面已经渲染完毕后调用此方法。用于进行资源清理。
     */
    @Override
    public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3) throws Exception {
    }

    //执行controller之后执行，可对视图进行渲染
    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3) throws Exception {
    }

    //执行controller之前执行
    @Override
    public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
        //首页路径以及登录放行
        boolean b = false;
        logger.info("拦截器拦截路径" + arg0.getRequestURI());
        if ("/test/hello".equals(arg0.getRequestURI()) || "/".equals(arg0.getRequestURI())) {
            logger.info("拦截成功+路径放行" + arg0.getRequestURI());
            b = true;
        } else if (SessionUtil.getSessionAttribute(Constant.LandUserConstant.USERNAME) != null) {
            b = true;
            logger.info("拦截成功+session存在,放行！");
        } else {
            logger.info("拦截成功+都不满足！自动跳转到登陆页面");
            arg1.sendRedirect("/");
            b = false;
        }
        return b;
    }
}
