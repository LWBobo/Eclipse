package com.chain.common.filter;

import com.chain.entity.UserEntity;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class SecurityFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest)servletRequest;
        HttpSession session = req.getSession();
        UserEntity userEntity = (UserEntity) session.getAttribute("loginuser");
        String requestURI = req.getRequestURI();
        if(requestURI.endsWith("login.action") || requestURI.endsWith("logon.action") || requestURI.endsWith("logout.action")){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        if (userEntity == null) {
            ((HttpServletResponse)servletResponse).sendRedirect("/common/login.action");
            return;
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    public void destroy() {

    }
}
