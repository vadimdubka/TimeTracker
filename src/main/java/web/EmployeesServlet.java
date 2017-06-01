package web;// Created by sky-vd on 10.04.2017.

import logic.EmplManagSystem;
import entity.Employee;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class EmployeesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<Employee> allEmployees = EmplManagSystem.getInstance().getEmployees(); // получение ответа модели
        req.setAttribute("allEmployees", allEmployees); // создание атрибута запроса. Add the model component’s answer to the request object, so that the JSP can access it.

        String developersEmail = getServletConfig().getInitParameter("developersEmail");
        String adminEmail = getServletContext().getInitParameter("adminEmail");
        req.setAttribute("developersEmail", developersEmail);
        req.setAttribute("adminEmail", adminEmail);



        getServletContext().getRequestDispatcher("/EmployeeManage.jsp").forward(req, resp); // request dispatching - перенаправка запроса с новым атрибутом в jsp файл.
        /* Более развернутая форма
        RequestD ispatcher view = req.getRequestDispatcher("/EmployeeManage.jsp");
        view.forward(req, resp);*/


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=utf-8"); // настройка кодировки страницы
        PrintWriter out = resp.getWriter(); // получение писателя

        String empl_id = req.getParameter("empl_id"); // получение параметра запроса из формы для запроса POST или адресной строки (?имя_параметра=значение&имя_параметра=значение&) для запроса GET по имени параметра

        Employee employee = EmplManagSystem.getInstance().getEmployee(empl_id);
        String s = String.format("<p>%s</p>", employee);
        out.println(s);


    }
}


