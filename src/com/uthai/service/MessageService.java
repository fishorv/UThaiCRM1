package com.uthai.service;

import com.uthai.message.NewsMessage;
import com.uthai.message.TextMessage;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

public interface MessageService {
    String getMSG(HttpServletRequest request);
    Map<String, String> XmlToMap(HttpServletRequest request) throws IOException;
    String TextMessageToXml(TextMessage textMessage);
    String NewsMessageToXml(NewsMessage newsMessage);
}
