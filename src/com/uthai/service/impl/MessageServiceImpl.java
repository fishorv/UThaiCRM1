package com.uthai.service.impl;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.uthai.message.NewsMessage;
import com.uthai.message.TextMessage;
import com.uthai.message.item;
import com.uthai.reponsePojo.BMIContent;
import com.uthai.reponsePojo.BMItem;
import com.uthai.reponsePojo.BatchgetMaterial;
import com.uthai.service.MessageService;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Service
public class MessageServiceImpl  implements MessageService {
    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_VOICE="voice";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLICK = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";
    @Resource
    EmpServiceImpl empService;
    @Resource
    WXServiceImpl wxService;
    @Resource
    TokenImpl tokenImpl;
    @Override
    public String getMSG(HttpServletRequest request) {
        TextMessage textMessage = new TextMessage();
        NewsMessage newsMessage = new NewsMessage();
        String token=tokenImpl.getTokenString();
        String msg = null;
        String content = null;
        try {
            Map<String, String> map = XmlToMap(request);
            String toUserName = map.get("ToUserName");
            String fromUserName = map.get("FromUserName");
            String msgType = map.get("MsgType");
            textMessage.setCreateTime(String.valueOf((new Date()).getTime()));
            textMessage.setFromUserName(toUserName);
            textMessage.setToUserName(fromUserName);
            newsMessage.setCreateTime(String.valueOf((new Date()).getTime()));
            newsMessage.setFromUserName(toUserName);
            newsMessage.setToUserName(fromUserName);
            switch(msgType) {
                case MESSAGE_TEXT:
                    if (map.get("Content").equals("lufeicuntest")){ //检测到注册专用序列号
                        int result=empService.register(fromUserName);
                        if (result==0) {
                            content = "注册成功!";
                        }else
                            content = "您已注册" ;
                        textMessage.setContent(content);
                        msg = TextMessageToXml(textMessage);
                        msg = new String(msg.getBytes(), "GBK");
                    }else {
                        content = "系统目前正在维护，请前往官方网站www.uthbaby.com或添加客服：Youyun_1688咨询!";
                        textMessage.setContent(content);
                        msg = TextMessageToXml(textMessage);
                        msg = new String(msg.getBytes(), "GBK");
                    }
                    break;
                case MESSAGE_IMAGE:
                    content = "系统目前正在维护，请前往官方网站www.uthbaby.com或添加客服：Youyun_1688咨询!";
                    textMessage.setContent(content);
                    msg = TextMessageToXml(textMessage);
                    msg = new String(msg.getBytes(), "GBK");
                    break;
                case MESSAGE_VIDEO:
                    content = "系统目前正在维护，请前往官方网站www.uthbaby.com或添加客服：Youyun_1688咨询!";
                    textMessage.setContent(content);
                    msg = TextMessageToXml(textMessage);
                    msg = new String(msg.getBytes(), "GBK");
                    break;
                case MESSAGE_VOICE:
                    content = "系统目前正在维护，请前往官方网站www.uthbaby.com或添加客服：Youyun_1688咨询!";
                    textMessage.setContent(content);
                    msg = TextMessageToXml(textMessage);
                    msg = new String(msg.getBytes(), "GBK");
                    break;
                case MESSAGE_LOCATION:
                    content = "系统目前正在维护，请前往官方网站www.uthbaby.com或添加客服：Youyun_1688咨询!";
                    textMessage.setContent(content);
                    msg = TextMessageToXml(textMessage);
                    msg = new String(msg.getBytes(), "GBK");
                    break;
                case MESSAGE_LINK:
                    content = "系统目前正在维护，请前往官方网站www.uthbaby.com或添加客服：Youyun_1688咨询!";
                    textMessage.setContent(content);
                    msg = TextMessageToXml(textMessage);
                    msg = new String(msg.getBytes(), "GBK");
                    break;
                case MESSAGE_EVENT:
                    String EventType = map.get("Event");
                    if (MESSAGE_SUBSCRIBE.equals(EventType)) {
                        content = "感谢您关注优泰大众健康！系统目前正在维护，请前往官方网站www.uthbaby.com或添加客服：Youyun_1688咨询!";
                        textMessage.setContent(content);
                        msg = TextMessageToXml(textMessage);
                        msg = new String(msg.getBytes(), "GBK");
                    }

                    if (MESSAGE_CLICK.equals(EventType)) {
                        String eventKey=map.get("EventKey");
                        if (!eventKey.substring(0,1).equals("2")){//第一个一级菜单，推送对应的图文消息
                            BatchgetMaterial batchgetMaterial=wxService.getMaterialBase(token);
                            Map<String,Object> material=wxService.getMaterialList(batchgetMaterial);
                            List<BMIContent> contents = (List<BMIContent>) material.get("content");
                            item[] item1 = new item [1];
                            if (eventKey.equals("11")){       //第三代试管
                                for (BMIContent b:contents){
                                    if (b.getTitle().equals("就怕试管一次不成功丨优泰精准测试，让你的成功率一目了然")){
                                        item1[0]= new item();
                                        item1[0].setTitle(b.getTitle());
                                        item1[0].setPicUrl("https://mmbiz.qpic.cn/mmbiz_png/Bica86oNjjnlHTOBDJkvD8ibrqLibjTOQYjic1cCGEhhbHEpA0xyIv5LnxXRgSwibdWLTBrLrlvia8kYowSVg7Fdmjdg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1");
                                        item1[0].setDescription(b.getDigest());
                                        item1[0].setUrl("https://mp.weixin.qq.com/s?__biz=MzU5OTUxMDk2Ng==&tempkey=OTg3XzVrQk9Wcys0ZWdPZzIyWjNCTDh0cTlaUXhLLXJjT1BvbWZYU1EwYTVwaGZFLTFWZ0lFM182cFAtZjU5bmpoYlNyWlRRUUlSSjBhSGROMkNkZXBOaTJkMjYzbU9RdVlwOUU0NWVYZ19zZUd0RWh6MG9BelNpZ2tCbW1oQkZrc1g0Wm84Q3RXbFJHQm1fLTEwUHIzRzB3TDdWNXYyWWxDQTZUTXloemd%2Bfg%3D%3D&chksm=7eb29b8d49c5129bdc5859616ddf7cf67c09a4afb0eaba24b1fb26a90b23a9904be6d787681e#rd");
                                        newsMessage.setArticleCount(1);
                                        newsMessage.setArticles(item1);
                                        newsMessage.setMsgType("news");
                                        msg=NewsMessageToXml(newsMessage);
                                        msg = new String(msg.getBytes(), "GBK");
                                        break;
                                    }
                                }
                            }else if (eventKey.equals("12")){                           //费用及流程
                                for (BMIContent b:contents){
                                    if (b.getTitle().equals("泰国试管多少钱？收费包含了什么项目？")){
                                        item1[0]= new item();
                                        item1[0].setTitle(b.getTitle());
                                        item1[0].setPicUrl("https://mmbiz.qpic.cn/mmbiz_png/Bica86oNjjnlHTOBDJkvD8ibrqLibjTOQYjic1cCGEhhbHEpA0xyIv5LnxXRgSwibdWLTBrLrlvia8kYowSVg7Fdmjdg/640?wx_fmt=png&tp=webp&wxfrom=5&wx_lazy=1&wx_co=1");
                                        item1[0].setDescription(b.getDigest());
                                        item1[0].setUrl("https://mp.weixin.qq.com/s?__biz=MzU5OTUxMDk2Ng==&tempkey=OTg3X2FsTlV6WGJhY2s4WlFIdUlCTDh0cTlaUXhLLXJjT1BvbWZYU1EwYTVwaGZFLTFWZ0lFM182cFAtZjU4Yi1vSUR2elZpN3hJU0JjelZvMzdSU0hLMzBvMDlmcFRBWXFoR2JQLTJ2Q0lLWng5c3d3MGNBTWEydml3RjZ0ZkhrUUNzRFh0bmdicVJ2WVNLeVNlVDgtUUhnVVRWRVpVcHR0bjBEZlI2bmd%2Bfg%3D%3D&chksm=7eb29b8e49c51298222d7bcbf806c5d751749d575d89b3f4a73f949a566809c88083ca67072c#rd");
                                        newsMessage.setArticleCount(1);
                                        newsMessage.setArticles(item1);
                                        newsMessage.setMsgType("news");
                                        msg=NewsMessageToXml(newsMessage);
                                        msg = new String(msg.getBytes(), "GBK");
                                        break;
                                    }
                                }
                            }
                        }else {
                            content = "系统目前正在维护，请前往官方网站www.uthbaby.com或添加客服：Youyun_1688咨询!";
                            textMessage.setContent(content);
                            msg = TextMessageToXml(textMessage);
                            msg = new String(msg.getBytes(), "GBK");
                        }
                        break;
                    }
                    if (MESSAGE_UNSUBSCRIBE.equals(EventType)) {
                        content = "系统目前正在维护，请前往官方网站www.uthbaby.com或添加客服：Youyun_1688咨询!";
                        textMessage.setContent(content);
                        msg = TextMessageToXml(textMessage);
                        msg = new String(msg.getBytes(), "GBK");
                        break;
                    }
                    break;
                default:
                    content = "玩命开发中~";
                    textMessage.setContent(content);
                    msg = TextMessageToXml(textMessage);
                    msg = new String(msg.getBytes(), "GBK");
            }

        } catch (Exception var14) {
            var14.printStackTrace();
            System.out.print("出错");
        }
        System.out.println(msg);
        return msg;
    }

    @Override
    public Map<String, String> XmlToMap(HttpServletRequest request) throws IOException {
        Map<String, String> map = new HashMap();
        SAXReader reader = new SAXReader();
        InputStream ins = null;
        Document doc = null;

        try {
            ins = request.getInputStream();
        } catch (IOException var10) {
            var10.printStackTrace();
        }

        try {
            doc = reader.read(ins);
        } catch (DocumentException var9) {
            var9.printStackTrace();
        }

        Element root = doc.getRootElement();
        List<Element> list = root.elements();
        Iterator var7 = list.iterator();

        while(var7.hasNext()) {
            Element e = (Element)var7.next();
            map.put(e.getName(), e.getText());
        }
        ins.close();
        return map;
    }

    @Override
    public String TextMessageToXml(TextMessage textMessage) {
        XStream xStream = new XStream(new DomDriver("utf-8"));
        xStream.alias("xml", textMessage.getClass());
        String xml = xStream.toXML(textMessage);
        return xml;
    }

    @Override
    public String NewsMessageToXml(NewsMessage newsMessage) {
        XStream xStream = new XStream(new DomDriver("utf-8"));
        xStream.alias("xml", newsMessage.getClass());
        xStream.alias("item", new item().getClass());
        String xml = xStream.toXML(newsMessage);
        return xml;
    }
}
