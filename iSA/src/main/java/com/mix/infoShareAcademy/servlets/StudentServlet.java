package com.mix.infoShareAcademy.servlets;

import com.mix.infoShareAcademy.dao.RandomStudentDao;
import com.mix.infoShareAcademy.dao.StudentRepositoryDao;
import com.mix.infoShareAcademy.domain.Student;
import com.mix.infoShareAcademy.freemarker.TemplateProvider;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/student")
public class StudentServlet extends HttpServlet {

    @Inject
    private RandomStudentDao randomStudentDao;
    @Inject
    private TemplateProvider templateProvider;

    private static final String TEMPLATE_NAME = "homepage";
    private static final String TEMPLATE_NAME_ADDED = "addedstudent";
    private static final Logger LOG = LoggerFactory.getLogger(StudentServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        resp.addHeader("Content-Type", "text/html; charset=utf-8");

        Student randomStudent = randomStudentDao.getRandomStudent();
        Template template = templateProvider.getTemplate(
                getServletContext(),
                TEMPLATE_NAME);
        Map<String, Object> dataModel = new HashMap<>();
        dataModel.put("student", randomStudent);

        try {
            template.process(dataModel, out);
        } catch (TemplateException e) {
            LOG.error("Didn't print random student" + e);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.addHeader("Content-Type", "text/html; charset=utf-8");
        PrintWriter out = resp.getWriter();
        String id = req.getParameter("id");
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        String team = req.getParameter("team");
        String time = req.getParameter("date");
        if (id == null) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }
        Integer intId = Integer.parseInt(id);
        LocalDateTime date = LocalDateTime.parse(time);

        Student student = new Student();
        student.setName(name);
        student.setId(intId);
        student.setSurname(surname);
        student.setTeam(team);
        student.setTime(date);
        out.println("THIS IS OUR STUDENT" + student);


        StudentRepositoryDao.addUser(student);

//        Template template = templateProvider.getTemplate(
//                getServletContext(),
//                TEMPLATE_NAME);
//        Map<String, Object> dataModelAdded = new HashMap<>();
//        dataModelAdded.put("studentAdd", student);
//
//        try {
//            template.process(dataModelAdded, out);
//        } catch (TemplateException e) {
//            LOG.error("Didn't print random student" + e);
//        }
   }
}
