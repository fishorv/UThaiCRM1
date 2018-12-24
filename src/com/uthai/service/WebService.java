package com.uthai.service;

import com.google.gson.JsonObject;

import java.util.Map;

public interface WebService {
    Map<String,String> getUserInfo(String token , String openId);
}
