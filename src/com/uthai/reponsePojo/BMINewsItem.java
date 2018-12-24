package com.uthai.reponsePojo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class BMINewsItem {
    JSONObject news_item;
    String create_time;
    String update_time;

    public JSONObject getNews_item() {
        return news_item;
    }

    public void setNews_item(JSONObject news_item) {
        this.news_item = news_item;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
