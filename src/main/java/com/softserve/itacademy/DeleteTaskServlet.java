package com.softserve.itacademy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteTaskServlet", value = "/delete-task")
public class DeleteTaskServlet extends HttpServlet {

    private TaskDao taskDao;

    @Override
    public void init() {
        taskDao = TaskDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        taskDao.delete(Integer.parseInt(request.getParameter("id")));
        response.sendRedirect("/tasks-list");
    }
}
