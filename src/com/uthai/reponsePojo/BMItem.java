package com.uthai.reponsePojo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 永久素材中ITEM元素
 */
public class BMItem {
    String media_id;
    JSONObject content;
    String update_time;
    public String getMedia_id() {
        return media_id;
    }

    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }

    public JSONObject getContent() {
        return content;
    }

    public void setContent(JSONObject content) {
        this.content = content;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }
}
