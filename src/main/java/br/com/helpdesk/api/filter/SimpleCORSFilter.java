//package br.com.helpdesk.api.filter;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//import org.springframework.core.Ordered;
//import org.springframework.core.annotation.Order;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@Component
//@Order(Ordered.HIGHEST_PRECEDENCE)
//public class SimpleCORSFilter implements Filter {
//
//    private final Log logger = LogFactory.getLog(this.getClass());
//
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//        logger.info("HelpDesk-API | SimpleCORSFilter loaded");
//    }
//
//    @Override
//    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest) req;
//        HttpServletResponse response = (HttpServletResponse) resp;
//
//        response.setHeader("Access-Control-Allow-Origin", "*");
//        response.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
//        response.setHeader("Access-Control-Max-Age", "3600");
//        response.setHeader("Access-Control-Allow-Headers", "origin, x-requested-with, authorization, Content-Type, Authorization");
//
//        if ("OPTIONS".equalsIgnoreCase(request.getMethod()))
//            response.setStatus(HttpServletResponse.SC_OK);
//        else
//            filterChain.doFilter(req, resp);
//    }
//
//    @Override
//    public void destroy() { }
//
//}
