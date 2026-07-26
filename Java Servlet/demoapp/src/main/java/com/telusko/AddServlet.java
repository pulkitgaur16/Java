package com.telusko;

import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

public class AddServlet extends HttpServlet {
    // post: when you want to save the data on the server
    // public void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException{
    //     int i = Integer.parseInt(req.getParameter("num1"));
    //     int j = Integer.parseInt(req.getParameter("num2"));

    //     int k= i+j;

    //     PrintWriter out = res.getWriter();
    //     out.println("result is: "+ k);
    // }

    // get: when you want to retrieve data from the server
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException{
        int i = Integer.parseInt(req.getParameter("num1"));
        int j = Integer.parseInt(req.getParameter("num2"));

        int k= i+j;

        // PrintWriter out = res.getWriter();
        // out.println("result is: "+ k);

        // to call another Servlet: i) Request Dispatcher
        // ii) Redirect

        // Session Management

        // req.setAttribute("k", k);

        // res.sendRedirect("sq?k="+k);  // URL Rewriting

        // Creating Session
        // HttpSession session = req.getSession();
        // session.setAttribute("k", k);

        // Using cookie
        Cookie cookie = new Cookie("k", k + "");
        res.addCookie(cookie);

        res.sendRedirect("sq");

        // RequestDispatcher rd = req.getRequestDispatcher("sq");
        // rd.forward(req, res);
    }
}
