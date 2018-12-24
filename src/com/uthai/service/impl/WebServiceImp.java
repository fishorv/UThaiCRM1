package com.uthai.service.impl;

import com.google.gson.JsonObject;
import com.uthai.service.WebService;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
@Service
public class WebServiceImp implements WebService {
    @Resource
    WXServiceImpl wxService;
    @Override
    public Map<String,String> getUserInfo(String token,String openId) {
        String url ="https://api.weixin.qq.com/sns/userinfo?" +
                    "access_token=ACCESS_TOKEN&openid=OPENID&lang=zh_CN".replace("ACCESS_TOKEN",token).replace("OPENID",openId);
        JSONObject jsonObject= wxService.doGetStr(url);
        Map<String,String> map= new HashMap<>();
        map.put("openid",jsonObject.getString("openid"));
        map.put("nickname",jsonObject.getString("nickname"));
        map.put("sex",jsonObject.getString("sex"));
        map.put("province",jsonObject.getString("province"));
        map.put("city",jsonObject.getString("city"));
        map.put("headimgurl",jsonObject.getString("headimgurl"));
        return map;
    }
}
