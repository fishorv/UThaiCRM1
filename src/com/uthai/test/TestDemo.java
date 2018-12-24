package com.uthai.test;
import com.uthai.mapper.OpenidMapper;
import com.uthai.menu.InitButton;
import com.uthai.reponsePojo.*;
import com.uthai.service.impl.TokenImpl;
import com.uthai.service.impl.TokenServiceImpl;
import com.uthai.service.impl.WXServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDemo {
    @Resource
    TokenServiceImpl tokenService;
    @Resource
    WXServiceImpl wxService;
    @Resource
    TokenImpl tokenimpl;
    @Resource
    OpenidMapper openidMapper;

    /**
     * 自定义菜单
     */
    @Test
    public void test1(){
        String token= null;
        token= tokenimpl.getTokenString();
        String menu= JSONObject.fromObject(InitButton.initMenu()).toString();
        wxService.createMenu(token, menu);
    }

    /**
     * 获取所有已关注用户的OpenID
     */
    @Test
    public void test2(){
        String token=null;
        token= tokenimpl.getTokenString();
        String[] result=wxService.getAllUserOpenID(token);
        for (String s:result){
            s=s.replace("\"","");
            openidMapper.insert(s);
        }
    }

    /**
     *设置所属行业
     */
    @Test
    public void test3(){
        String token=null;
        token= tokenimpl.getTokenString();
        int result=wxService.setIndustry(token);
        System.out.println(result);
    }

    /**
     * 获取所设置行业
     */
    @Test
    public void test4(){
        String token=null;
        token= tokenimpl.getTokenString();
        JSONObject result=wxService.getIndustry(token);
        System.out.println(result.getString("primary_industry"));
        System.out.println(result.getString("secondary_industry"));
    }

    /**
     * 获取素材ID
     *
     */
    @Test
    public void test5() {
        String token = tokenimpl.getTokenString();
        BatchgetMaterial batchgetMaterial = wxService.getMaterialBase(token);
        Map<String, Object> material = wxService.getMaterialList(batchgetMaterial);
        List<BMItem> items = (List<BMItem>) material.get("items");
        List<BMIContent> contents =(List<BMIContent>) material.get("content");
        JSONArray result = new JSONArray();
        for (BMIContent b : contents) {
            if (b.getTitle().equals("就怕试管一次不成功丨优泰精准测试，让你的成功率一目了然")) {
                String media_id = b.getThumb_media_id();
                result = wxService.getMaterialByMediaId(media_id, token);
                break;
            }

        }
        System.out.println(result);
    }

    /**
     * 测试消息接收
     */
    @Test
    public void test6(){
        String token= tokenimpl.getTokenString();
        JSONObject jsonObject=wxService.doGetStr("https://api.weixin.qq.com/cgi-bin/get_current_autoreply_info?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN",token));
        System.out.println(jsonObject);
    }

    /**
     * 通过模板段ID获取模板ID
     */
    @Test
    public void test7(){
        String token = tokenimpl.getTokenString();
        String temp = wxService.getTemplateId(token,"TM00721");
        System.out.println(temp);
    }

    /**
     * 发送模板消息
     */
    @Test
    public void test8(){
        String token = tokenimpl.getTokenString();
        int result = wxService.sendTemplateMSG(token,wxService.getTemplateId(token,"OPENTM410037001"),"oti2M1lVCJ7unnfNtnCLkhvn4uF8");
        System.out.println(result);
    }
}
