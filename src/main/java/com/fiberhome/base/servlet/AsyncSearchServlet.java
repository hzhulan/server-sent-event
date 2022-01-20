package com.fiberhome.base.servlet;

import com.fiberhome.base.util.AsyncContextBank;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @description:
 * @author: pp_lan
 * @date: 2022/1/20 16:28
 */
@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userId = req.getParameter("userId");
        AsyncContext asyncContext = req.startAsync();
        String requestId = userId;
        AsyncContextBank.put(requestId, asyncContext);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
