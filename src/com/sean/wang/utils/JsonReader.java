package com.sean.wang.utils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

public class JsonReader {
	public final static JsonReader reader = new JsonReader();
	private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
	private String json = null;
	
	public JsonReader readFrom(String uri){
		try {
			json = new String(Files.readAllBytes(Paths.get(uri)));
		} catch (IOException e) {
			System.err.println("Error: can't find file: " + uri);
			e.printStackTrace();
		}
		return this;
	}
	
	public JsonReader handle(){
		
		JsonObject jsonObj = gson.fromJson(json, JsonObject.class);
		
		return this;
	}
	
	public void traversal(){
		JsonObject jo = gson.fromJson(json, JsonObject.class);
		traversal(jo);
	}
	private void traversal(JsonObject jo){
		jo.entrySet().forEach(e -> {
			System.out.print(e.getKey() + ":");
			if(e.getValue().isJsonObject()){
				System.out.println();
				traversal(gson.fromJson(e.getValue(), JsonObject.class));
			}else{
				System.out.println(e.getValue());
			}
			
		});
	}
	
	public String getString(){
		return json;
	}
	public JsonObject getObject(){
		return gson.fromJson(json, JsonObject.class);
	}
	
}
