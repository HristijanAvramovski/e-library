package com.example.demo.web.filter;

import com.example.demo.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
@WebFilter
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        User user =(User)request.getSession().getAttribute("user");
        String path = request.getServletPath();

        if(request.getParameter("username")!=null && request.getParameter("password")!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }
        else if (!"/login".equals(path) &&
                !"/h2".equals(path) &&
                !"/register".equals(path) &&
                !"/main.css".equals(path) && user==null) {
            response.sendRedirect("/login");
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
    }
}
