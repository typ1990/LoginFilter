package com.cn;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by typ on 2016/9/13.
 */
//@WebServlet(name ="LoginServlet",urlPatterns = "/servlet/Loginservlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("初始化 Servlet.............");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("进入Servlet-------------------------");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        System.out.println("name:"+username);
        if("admin".equals(username)&&"admin".equals(password)){
           HttpSession httpSession= req.getSession();
           httpSession.setAttribute("username", username);
            resp.sendRedirect(req.getContextPath()+"/success.jsp");
//            req.getRequestDispatcher("/success.jsp").forward(req, resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/fail.jsp");
        }

    }

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("销毁Servlet.....................");


    }
}
