package com.softserve.itacademy;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ReadTaskServlet", value = "/read-task")
public class ReadTaskServlet extends HttpServlet {

    private TaskDao taskDao;

    @Override
    public void init() {
        taskDao = TaskDao.getInstance();
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Task task = taskDao.read(Integer.parseInt(request.getParameter("id")));
        request.setAttribute("task", task);
        if (task != null)
            request.getRequestDispatcher("/WEB-INF/read-task.jsp").forward(request, response);
        else
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
    }
}
