package com.fiberhome.base.util;

import javax.servlet.AsyncContext;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * @description:
 * @author: pp_lan
 * @date: 2021/8/29 14:39
 */
//@WebServlet(urlPatterns = { "/role_echo" }, asyncSupported = true)
public class SseTest extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private final static int DEFAULT_TIME_OUT = 10 * 60 * 1000;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO Auto-generated method stub
        resp.setContentType("text/event-stream");
        resp.setCharacterEncoding("UTF-8");
        req.setAttribute("org.apache.catalina.ASYNC_SUPPORTED", true);//注意这里

        AsyncContext actx = req.startAsync(req, resp);
        actx.setTimeout(DEFAULT_TIME_OUT);
        actx.addListener(new AsyncListener() {
            @Override
            public void onComplete(AsyncEvent arg0) throws IOException {
                // TODO Auto-generated method stub
                System.out.println("[echo]event complete:" + arg0.getSuppliedRequest().getRemoteAddr());
            }

            @Override
            public void onError(AsyncEvent arg0) throws IOException {
                // TODO Auto-generated method stub
                System.out.println("[echo]event has error");
            }

            @Override
            public void onStartAsync(AsyncEvent arg0) throws IOException {
                // TODO Auto-generated method stub
                System.out.println("[echo]event start:" + arg0.getSuppliedRequest().getRemoteAddr());
            }

            @Override
            public void onTimeout(AsyncEvent arg0) throws IOException {
                // TODO Auto-generated method stub
                System.out.println("[echo]event time lost");
            }
        });
        new Thread(new AsyncWebService(actx)).start();
    }

    class AsyncWebService implements Runnable {
        AsyncContext ctx;

        public AsyncWebService(AsyncContext ctx) {
            this.ctx = ctx;
        }

        public void run() {
            try {
                //等待十秒钟，以模拟业务方法的执行
                Thread.sleep(10000);
                PrintWriter out = ctx.getResponse().getWriter();
                System.out.println("data:中文" + new Date() + "\r\n");  //js页面EventSource接收数据格式：data：数据 + "\r\n"

                System.out.flush();
                ctx.complete();
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
