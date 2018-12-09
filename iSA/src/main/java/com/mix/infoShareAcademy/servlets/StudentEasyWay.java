package com.mix.infoShareAcademy.servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

@WebServlet(urlPatterns = "/student-easy")
public class StudentEasyWay extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        out.println("Mikolaj Cygert ");
        out.println("JJDD5-Tailandczycy ");
        out.println(LocalDateTime.now());


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();

        List<String> parNamesList = Collections.list(req.getParameterNames());
        for (String parameters : parNamesList) {
            String[] parValuesList = req.getParameterValues(parameters);
            for (String parameterValues : parValuesList) {
                out.println( parameters + ":" + parameterValues);
            }

        }
    }
}