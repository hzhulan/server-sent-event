package com.fiberhome.base.controller;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.SecureRandom;
import java.util.Random;

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

    @RequestMapping(value = "/sse/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    @ResponseBody
    public String push(@PathVariable("id") Long id){
        Random r = new SecureRandom();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "data:Testing 1,2,3" + r.nextInt() +"\n\n";
    }

}
