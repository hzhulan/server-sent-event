package com.fiberhome.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 聊天室
 * @author: pp_lan
 * @date: 2021/8/29 13:26
 */
@Controller("/chat")
public class ChatController {

    @RequestMapping("/index")
    public String chat() {
        return "chat";
    }

}
