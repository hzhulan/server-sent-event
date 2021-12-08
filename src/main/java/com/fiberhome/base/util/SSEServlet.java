package com.fiberhome.base.util;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: pp_lan
 * @date: 2021/8/29 14:39
 */
//@WebServlet("/sse")
public class SSEServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ThreadLocal<SimpleDateFormat> sdf = ThreadLocal.withInitial(()-> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public SSEServlet() {
        System.out.println("SSE服务器初始化");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/event-stream");
        response.setHeader("Cache-Control", "no-cache");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Pragma", "no-cache");
        response.setDateHeader("Expires", 0);

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST,GET");
        response.setHeader("allowed-headers", "*");

        // 推送内容
        String str = "data:欢迎" + sdf.get().format(new Date()) + "\n\n";

        response.getWriter().write(str);
    }

}
