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
        PrintWriter writer = resp.getWriter();
        writer.println("Mikolaj Cygert ");
        writer.println("JJDD5-Tailandczycy ");
        writer.println(LocalDateTime.now());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter writer = resp.getWriter();
        List<String> listOfParameters = Collections.list(req.getParameterNames());
        for (String parameters : listOfParameters) {
            String[] listOfValues = req.getParameterValues(parameters);
            for (String parameterValues : listOfValues) {
                writer.println(parameters + " : " + parameterValues);
            }
        }
    }
}