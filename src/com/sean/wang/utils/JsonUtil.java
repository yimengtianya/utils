package com.sean.wang.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {
	
	private final static Gson gson = new GsonBuilder().setPrettyPrinting().create();
	
	public static JsonObject merge(JsonObject obj1, JsonObject obj2){
		
		JsonObject result = new JsonObject();
		List<String> sameKey = new ArrayList<>();
		
		obj1.entrySet().forEach(e1 -> {
			obj2.entrySet().forEach(e2 -> {
				if(e1.getKey().equals(e2.getKey())) {
					sameKey.add(e1.getKey());
				}else{
					result.add(e1.getKey(), e1.getValue());
					result.add(e2.getKey(), e2.getValue());
				}
			});
		});
		
		sameKey.forEach(key -> {
			JsonElement je1 = obj1.get(key);
			JsonElement je2 = obj2.get(key);
			if(je1.isJsonObject() && je2.isJsonObject()) {
				result.add(key, merge(gson.fromJson(je1, JsonObject.class),
									  gson.fromJson(je2, JsonObject.class)));
			}else if(!je1.isJsonObject() && !je2.isJsonObject()) {
				if(je1.isJsonArray() && je2.isJsonArray()){
					result.add(key, merge(je1.getAsJsonArray(), je2.getAsJsonArray()));
				}else if(je1.isJsonArray() && !je2.isJsonArray()){
					result.add(key, merge(je1.getAsJsonArray(), je2));
				}else if(!je1.isJsonArray() && je2.isJsonArray()){
					result.add(key, merge(je2.getAsJsonArray(), je1));
				}else{
					result.add(key, obj1.get(key));
				}
			}else {
				System.err.println("Warnging: can not merge json key: '" + key + "' because one is JsonObject but another one is not");
			}
		});
		
		return result;
	}
	
	public static List<String> getSameKey(JsonObject jo1, JsonObject jo2){
		List<String> result = new ArrayList<>();
		return result;
	}
	
	public static JsonArray merge(JsonArray jarr1, JsonArray jarr2){
		Type listType = new TypeToken<List<String>>(){}.getType();
		List<String> str1 = gson.fromJson(jarr1.toString(), listType);
		List<String> str2 = gson.fromJson(jarr2.toString(), listType);
		return gson.fromJson(LsUtil.mergeList(str1, str2).toString(), JsonArray.class);
	}
	
	public static JsonArray merge(JsonArray jarr, JsonElement jelem){
		Type listType = new TypeToken<List<String>>(){}.getType();
		List<String> list = gson.fromJson(jarr.toString(), listType);
		if(!list.contains(jelem.getAsString())){
			list.add(jelem.getAsString());
		}
		return gson.fromJson(list.toString(), JsonArray.class);
	}
}
