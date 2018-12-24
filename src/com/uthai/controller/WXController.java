package com.uthai.controller;

import com.uthai.service.impl.MessageServiceImpl;
import com.uthai.util.CheckUtil;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
@Controller
@RequestMapping(value = "/wx",produces = "text/plain;charset=utf-8")
public class WXController {
    @Resource
    MessageServiceImpl messageUtil;
    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public String doGet( @Param("signature")String signature,
                         @Param("timestamp")String timestamp,
                         @Param("nonce")String nonce,
                         @Param("echostr")String echostr
    ){
        if (CheckUtil.check(signature,timestamp,nonce)) {
            return echostr;
        }
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String doPost(HttpServletRequest request){
        return messageUtil.getMSG(request);
    }
}
