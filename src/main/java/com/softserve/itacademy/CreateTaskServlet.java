package com.softserve.itacademy;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateTaskServlet", value = "/create-task")
public class CreateTaskServlet extends HttpServlet {

    private TaskDao taskDao;

    @Override
    public void init() {
        taskDao = TaskDao.getInstance();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getRequestDispatcher("/WEB-INF/create-task.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String name = request.getParameter("name");
        String priority = request.getParameter("priority");
        Task task = new Task(name, Priority.valueOf(priority));
        if (!taskDao.isTaskPresentByName(name)) {
            taskDao.create(task);
            response.sendRedirect("/tasks-list");
        } else {
            request.setAttribute("task", task);
            request.setAttribute("error", "Task with a given name already exists!");
            request.getRequestDispatcher("/WEB-INF/create-task.jsp").forward(request, response);
        }
    }
}
