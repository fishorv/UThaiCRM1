package com.uthai.service;

import com.uthai.requestPojo.MaterialParam;
import com.uthai.message.NewsMessage;
import com.uthai.reponsePojo.BatchgetMaterial;
import com.uthai.util.AccessToken;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import java.util.Map;

public interface WXService {
    JSONObject doGetStr(String url);
    String doGetString(String url);
    JSONObject doPostStr(String url, String outStr);
    AccessToken getToken();
    int createMenu(String token, String menu);
    MaterialParam initMtr();
    JSONObject getMtr(String token);
    JSONObject sendMessage(String token, NewsMessage mtr_id);
    Map<String, String> getmtrid();
    String [] getAllUserOpenID(String token);
    int setIndustry(String token);
    JSONObject getIndustry(String token);
    BatchgetMaterial getMaterialBase(String token);
    Map<String,Object> getMaterialList(BatchgetMaterial material);
    JSONArray getMaterialByMediaId(String MediaId, String token);
    String getTemplateId(String token,String tamplate_short_id);
    int sendTemplateMSG(String token,String templateId,String who);
}
