package com.fiberhome.base.controller;

import com.fiberhome.base.util.AsyncContextBank;
import com.fiberhome.base.service.ChatService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.AsyncContext;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

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
//        String test = chatService.test();
        return "chat";
    }

//    @RequestMapping(value = "/sse/{id}")
//    public void push(@PathVariable("id") Long id, HttpServletResponse response){
//
//        response.setContentType("text/event-stream");
//        response.setCharacterEncoding("utf-8");
//
//        while (true) {
//            Random r = new Random();
//            try {
//                Thread.sleep(1000);
//                PrintWriter pw = response.getWriter();
//                String msg = "消息" + r.nextInt();
//
//                pw.write("data:" + msg + "\n\n");
//
//                System.out.println("发送消息: " + msg);
//                pw.flush();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//    }

    @RequestMapping(value = "syncHelp")
    @ResponseBody
    public Object syncHelp(String userId) {
        AsyncContext asyncContext = AsyncContextBank.get(userId);
        if (asyncContext == null) {
            return "end";
        }
        System.out.println("获取context，开始推送");


        PrintWriter out = null;
        try {
            TimeUnit.SECONDS.sleep(1);
            asyncContext.getResponse().setContentType("text/html;charset=UTF-8");
            out = asyncContext.getResponse().getWriter();
            out.write("延迟推送结果" + userId);

            out.flush();

            TimeUnit.SECONDS.sleep(1);
            out.write("第二波");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
        return "推送结束";
    }

}
