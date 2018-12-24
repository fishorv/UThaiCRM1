package com.uthai.service.impl;

import com.google.gson.Gson;
import com.uthai.message.NewsMaterial;
import com.uthai.reponsePojo.*;
import com.uthai.requestPojo.MaterialParam;
import com.uthai.message.NewsMessage;
import com.uthai.requestPojo.*;
import com.uthai.service.WXService;
import com.uthai.util.AccessToken;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.*;

@Service
public class WXServiceImpl implements WXService {
    @Resource
    TokenImpl tokenimp;
//    ApplicationContext acc= new ClassPathXmlApplicationContext("applicationContext.xml");
    @Override
    public JSONObject doGetStr(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        JSONObject jsonObject = null;

        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                String result = EntityUtils.toString(entity, "UTF-8");
                jsonObject = JSONObject.fromObject(result);
            }
        } catch (IOException var7) {
            var7.printStackTrace();
        }

        return jsonObject;
    }

    @Override
    public String doGetString(String url) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        String result=null;
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            HttpEntity entity = httpResponse.getEntity();
            if (entity != null) {
                 result = EntityUtils.toString(entity, "UTF-8");
            }
        } catch (IOException var7) {
            var7.printStackTrace();
        }
        return  result;
    }

    @Override
    public JSONObject doPostStr(String url, String outStr) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(url);
        JSONObject jsonObject = null;
        try {
            httpPost.setEntity(new StringEntity(outStr, "UTF-8"));
            HttpResponse httpResponse = httpClient.execute(httpPost);
            String result = EntityUtils.toString(httpResponse.getEntity(), "UTF-8");
            jsonObject = JSONObject.fromObject(result);
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        return jsonObject;
    }

    @Override
    public AccessToken getToken() {
        AccessToken accessToken = new AccessToken();
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET".replace("APPID", "wx0331d8fe4217d8d6").replace("APPSECRET", "b8949ff0e75591908fb5f7bd7d6b205d");
        JSONObject jsonObject = doGetStr(url);
        if (jsonObject != null) {
            if (jsonObject.containsKey("access_token")) {
                accessToken.setAccess_token(jsonObject.getString("access_token"));
                accessToken.setExpires_in(jsonObject.getString("expires_in"));
            } else
                System.out.println(jsonObject.getString("errmsg"));
        }

        return accessToken;
    }

    @Override
    public int createMenu(String token, String menu) {
        String url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", token);
        JSONObject jsonObject = doPostStr(url, menu);
        int resual = 0;
        if (jsonObject != null) {
            resual = jsonObject.getInt("errcode");
        }

        return resual;
    }

    @Override
    public MaterialParam initMtr() {
        MaterialParam param = new MaterialParam();
        param.setType("news");
        param.setCount(3);
        param.setOffset(0);
        return param;
    }

    @Override
    public JSONObject getMtr(String token) {
        String url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", token);
        MaterialParam param = initMtr();
        String dop = JSONObject.fromObject(param).toString();
        JSONObject jsonObject = doPostStr(url, dop);
        return jsonObject;
    }

    @Override
    public JSONObject sendMessage(String token, NewsMessage mtr_id) {
        String url = "https://api.weixin.qq.com/cgi-bin/message/custom/send?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN", token);
        String dop = JSONObject.fromObject(mtr_id).toString();
        JSONObject jsonObject = doPostStr(url, dop);
        return jsonObject;
    }

    @Override
    public Map<String, String> getmtrid() {
        String token = tokenimp.getTokenString();
        List<NewsMaterial> lists = new ArrayList();
        Map<String, String> map = new HashMap();
        Gson gson = new Gson();
        JSONObject jsonObject = getMtr(token);
        if (null != jsonObject) {
            try {
                JSONArray jsonArray = jsonObject.getJSONArray("item");

                for (int i = 0; i < jsonArray.size(); ++i) {
                    JSONObject json = (JSONObject) jsonArray.get(i);
                    json = json.getJSONObject("content");
                    System.out.println(json);
                    JSONArray arr = json.getJSONArray("news_item");
                    json = (JSONObject) arr.get(0);
                    NewsMaterial material = new NewsMaterial();
                    String title = json.getString("title");
                    String author = json.getString("author");
                    String digest = json.getString("digest");
                    String thumb_media_id = json.getString("thumb_media_id");
                    String url = json.getString("url");
                    String content = json.getString("content");
                    material.setTitle(title);
                    material.setAuthor(author);
                    material.setDigest(digest);
                    material.setThumb_media_id(thumb_media_id);
                    material.setUrl(url);
                    material.setContent(content);
                    material.setShow_cover_pic(1);
                    lists.add(material);
                    map = (Map) gson.fromJson(lists.toString(), map.getClass());
                }
            } catch (JSONException var16) {
                var16.printStackTrace();
            }
        }
        return map;
    }

    /**
     * 取所有用户的OpenID,只考虑到10000名用户以下
     * @param token
     * @return
     */
    @Override
    public String[] getAllUserOpenID(String token) {
        String url="https://api.weixin.qq.com/cgi-bin/user/get?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN",token);
        JSONObject jsonObject =null;
        jsonObject=doGetStr(url);
        String [] result=null;
        int count= (int) jsonObject.get("total");
        if (count<10000){
            JSONObject data= (JSONObject) jsonObject.get("data");
            result=data.get("openid").toString().split(",");
        }
        return result;
    }

    @Override
    public int setIndustry(String token) {
        String url="https://api.weixin.qq.com/cgi-bin/template/api_set_industry?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN",token);
        int result=0;
//        Industry industry = (Industry) acc.getBean("industry");
        Industry industry = new Industry();
        industry.setIndustry_id1("12");
        industry.setIndustry_id2("22");
        String dop=JSONObject.fromObject(industry).toString();
        try {
            doPostStr(url,dop);
        }catch (Exception e){
            result=1;
        }
        return result;
    }

    @Override
    public JSONObject getIndustry(String token) {
        String url= "https://api.weixin.qq.com/cgi-bin/template/get_industry?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN",token);
        JSONObject jsonObject = doGetStr(url);
        return jsonObject;
    }

    @Override
    public BatchgetMaterial getMaterialBase(String token) {
        String url = "https://api.weixin.qq.com/cgi-bin/material/batchget_material?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN",token);
        BatchgetMaterial material= new BatchgetMaterial();
        MaterialParam param= new MaterialParam();
        param.setCount(20);
        param.setOffset(0);
        param.setType("news");
        JSONObject jsonObject=doPostStr(url,JSONObject.fromObject(param).toString());
        material.setTotal_count(jsonObject.getString("total_count"));
        material.setItem_count(jsonObject.getString("item_count"));
        material.setItem(jsonObject.getJSONArray("item"));
        return material;
    }

    @Override
    public Map<String, Object> getMaterialList(BatchgetMaterial material) {
        Map<String, Object> result = new HashMap<>();
        List<BMItem> list = new LinkedList<>();
        List<BMIContent> contents = new LinkedList<>();
        JSONObject[] objects= new JSONObject[20];
        for (int i=0;i<Integer.parseInt(material.getItem_count());i++){
            objects[i]=material.getItem().getJSONObject(i);
            BMItem item = new BMItem();
            item.setContent(objects[i].getJSONObject("content"));
            item.setMedia_id(objects[i].getString("media_id"));
            item.setUpdate_time(objects[i].getString("update_time"));
            list.add(item);
        }
        for (int i=0;i<list.size();i++){
            BMNews news=new BMNews();
            BMIContent content=new BMIContent();
            news.setNews_item(list.get(i).getContent());
            BMINewsItem newsItem= new BMINewsItem();
            newsItem.setCreate_time(news.getNews_item().getString("create_time"));
            newsItem.setUpdate_time(news.getNews_item().getString("update_time"));
            JSONArray jsonArray=  new JSONArray();
            jsonArray=JSONArray.fromObject(news.getNews_item().getString("news_item"));
            newsItem.setNews_item(jsonArray.getJSONObject(0));//单图文，多图文将此处改为for循环
            content.setTitle(newsItem.getNews_item().getString("title"));
            content.setContent(newsItem.getNews_item().getString("content"));
            content.setAuthor(newsItem.getNews_item().getString("author"));
            content.setDigest(newsItem.getNews_item().getString("digest"));
            content.setContent_source_url(newsItem.getNews_item().getString("content_source_url"));
            content.setShow_cover_pic(newsItem.getNews_item().getString("show_cover_pic"));
            content.setThumb_media_id(newsItem.getNews_item().getString("thumb_media_id"));
            contents.add(content);
        }
        result.put("items",list);
        result.put("content",contents);
        return result;
    }

    @Override
    public JSONArray getMaterialByMediaId(String mediaId,String token) {
        String url="https://api.weixin.qq.com/cgi-bin/material/get_material?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN",token);
        MediaId media_id=new MediaId();
        media_id.setMedia_id(mediaId);
    return JSONArray.fromObject(doPostStr(url, String.valueOf(JSONObject.fromObject(media_id))));
    }

    @Override
    public String getTemplateId(String token,String template_short_id) {
        String url ="https://api.weixin.qq.com/cgi-bin/template/api_add_template?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN",token);
        String temp_id="{\"template_id_short\":\""+template_short_id+"\"}";
        JSONObject jsonObject= doPostStr(url,temp_id);
        return jsonObject.getString("template_id");
    }

    @Override
    public int sendTemplateMSG(String token,String templateId,String who) {
        String url="https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN".replace("ACCESS_TOKEN",token);
        int result=1;
        TemplateData data= new TemplateData();
        JSONObject templateData=JSONObject.fromObject(data);
        TemplateMSG templateMSG = new TemplateMSG();
        templateMSG.setTouser(who);
        templateMSG.setTemplate_id(templateId);
        templateMSG.setData(templateData);
        templateMSG.setUrl("www.uthbaby.com");
        JSONObject jsonObject = doPostStr(url,JSONObject.fromObject(templateMSG).toString());
        if (jsonObject.getInt("errcode")==0){
            result= 0;
        }
        return result;
    }
}
