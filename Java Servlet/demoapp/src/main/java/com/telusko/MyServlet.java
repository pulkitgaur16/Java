package com.telusko;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        PrintWriter out = resp.getWriter();
        out.print("Hi ");

        // ServletContext is used to define global Initialization parameters
        // ServletContext ctx = getServletContext();
        // String str = ctx.getInitParameter("name");
        // out.println(str);

        // ServletConfig is used to define parameters that are specifically 
        // for the particular servlet
        ServletConfig cg = getServletConfig();
        String str = cg.getInitParameter("name");
        out.println(str);
    }
}
