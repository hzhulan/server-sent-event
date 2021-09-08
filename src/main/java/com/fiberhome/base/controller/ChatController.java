package com.fiberhome.base.controller;

import com.fiberhome.base.service.ChatService;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Random;

/**
 * @description: 聊天室
 * @author: pp_lan
 * @date: 2021/8/29 13:26
 */
@Controller
public class ChatController {

    @Resource
    private ChatService chatService;

    @RequestMapping("/index")
    public String chat() {
        String test = chatService.test();
        return "chat";
    }

    @RequestMapping(value = "/sse/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public void push(@PathVariable("id") Long id, HttpServletResponse response){

        response.setContentType("text/event-stream");
        response.setCharacterEncoding("utf-8");

        while (true) {
            Random r = new Random();
            try {
                Thread.sleep(1000);
                PrintWriter pw = response.getWriter();
                pw.write("【user】:Testing 1,2,3" + r.nextInt() + "\n\n");
                System.out.println("发送消息...");
                pw.flush();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
