package com.softserve.itacademy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "TaskListServlet", value = "/tasks-list")
public class TaskListServlet extends HttpServlet {

    private TaskDao taskDao;

    @Override
    public void init() {
        taskDao = TaskDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/WEB-INF/task-list.jsp");
        request.setAttribute("tasks", taskDao.readAll());
        requestDispatcher.forward(request, response);
    }
}
