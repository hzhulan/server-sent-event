package com.fiberhome.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 聊天室
 * @author: pp_lan
 * @date: 2021/8/29 13:26
 */
@Controller
public class ChatController {

    @RequestMapping("/index")
    public String chat() {
        return "chat";
    }

//    @RequestMapping(value = "/push", produces="text/event-stream")
//    public @ResponseBody String sendMsg() {
//        System.out.println("push msg..");
//        try {
//            Thread.sleep(2000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        //注意：返回数据的格式要严格按照这样写，‘\n\n’不可少
//        return "data:current time: " + new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(new Date())+"\n\n";
//    }

}
