package com.telusko;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/demoServlet")
public class demoServlet extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        // String name = "Pulkit";

        // req.setAttribute("label", name);
        // RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
        // rd.forward(req, resp);

        Student s = new Student("Pulkit", 1);
        req.setAttribute("student", s);
        RequestDispatcher rd = req.getRequestDispatcher("display.jsp");
        rd.forward(req, resp);
    }
    
}
