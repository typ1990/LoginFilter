package com.cn;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by typ on 2016/9/13.
 */
//@WebFilter(filterName = "LoginFilter",initParams = {})
public class LoginFilter implements Filter {
    private FilterConfig filterConfig;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
        System.out.println("初始化 filter***********");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req=(HttpServletRequest)servletRequest;
        HttpServletResponse rsp=(HttpServletResponse)servletResponse;
        HttpSession session=req.getSession();
       String noLoginPaths= filterConfig.getInitParameter("noLoginPaths");

        String charset=filterConfig.getInitParameter("charset");

        if(charset==null){
            charset="UTF-8";
        }
        req.setCharacterEncoding(charset);
        System.out.println("登录路径：" + req.getRequestURI().toString());
        System.out.println("过滤字符串："+noLoginPaths);
        if(noLoginPaths!=null){
            String[] strArray=noLoginPaths.split(";");

            for(int i=0;i<strArray.length;i++){
                System.out.println("字符串："+strArray[i]);
                if(strArray[i]==null||"".equals(strArray[i]))continue;

                if(req.getRequestURI().indexOf(strArray[i])!=-1){
                    System.out.println("包含字符串，进入$$$$$$$$$$$$$$$$$$$");
                    filterChain.doFilter(servletRequest,servletResponse);
                    return;
                }
            }
        }

        if(session.getAttribute("username")!=null){
            System.out.println("用户名不为空，进入$$$$$$$$$$$$$$$$$$$$$$$$$");
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            System.out.println("返回登录界面，进入$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
            rsp.sendRedirect(req.getContextPath()+"/login.jsp");
        }

    }

    @Override
    public void destroy() {
        System.out.println("销毁 filter***********");

    }


}
