package com.uthai.reponsePojo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 永久素材POJO
 */
public class BatchgetMaterial {
    String total_count;
    String item_count;
    JSONArray item;
    public String getTotal_count() {
        return total_count;
    }

    public void setTotal_count(String total_count) {
        this.total_count = total_count;
    }

    public String getItem_count() {
        return item_count;
    }

    public void setItem_count(String item_count) {
        this.item_count = item_count;
    }

    public JSONArray getItem() {
        return item;
    }

    public void setItem(JSONArray item) {
        this.item = item;
    }
}
