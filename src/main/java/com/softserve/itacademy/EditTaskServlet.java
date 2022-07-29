package com.softserve.itacademy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateTaskServlet", value = "/edit-task")
public class EditTaskServlet extends HttpServlet {

    private TaskDao taskDao;
    private Task task;

    @Override
    public void init() {
        taskDao = TaskDao.getInstance();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        task = taskDao.read(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("task", task);
        if (task != null)
            request.getRequestDispatcher("/WEB-INF/edit-task.jsp").forward(request, response);
        else
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        task.setName(request.getParameter("name"));
        task.setPriority(Priority.valueOf(request.getParameter("priority")));
        taskDao.update(task.getId(), task);
        response.sendRedirect("/tasks-list");
    }
}
