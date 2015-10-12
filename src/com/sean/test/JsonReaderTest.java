package com.sean.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.sean.wang.utils.JsonReader;
import com.sean.wang.utils.JsonUtil;

import junit.framework.TestCase;

public class JsonReaderTest extends TestCase{

	public void testTraversal(){
		JsonReader.reader
					.readFrom("E:/test272/option.json")
					.traversal();
	}
	
	public void testAdd(){
		JsonObject jo = new JsonObject();
		jo.addProperty("m", 1);
		jo.addProperty("c", 2);
		System.out.println(jo.toString());
	}
	
	public void testMergeObject(){
		JsonObject jo1 = JsonReader
									.reader
									.readFrom("E:/json1.json")
									.getObject();
		JsonObject jo2 = JsonReader
									.reader
									.readFrom("E:/json2.json")
									.getObject();
		JsonObject merge = JsonUtil.merge(jo1, jo2);
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		System.out.println(gson.toJson(merge));
	}
	
	public void testMergeArray(){
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		JsonArray jarr1 = gson.fromJson("[1,2,3,4]", JsonArray.class);
		JsonArray jarr2 = gson.fromJson("[1,8,6,5]", JsonArray.class);
		System.out.println(JsonUtil.merge(jarr1, jarr2).toString());
	}
	
}
