package com.sean.jsonutil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class JsonUtil {
	public static void main(String[] args) throws IOException{
		
//		JSONObject jo = new JSONObject(new JSONTokener(new FileReader(new File("e:/test/option.json"))));
//		System.out.println(jo.toString());
		
		Gson gs = new GsonBuilder().setPrettyPrinting().create();
		String json = new String(Files.readAllBytes(Paths.get("e:/test/sample.json")));
	
		C c = gs.fromJson(json, C.class);
		
		c.run();
		System.out.println(c.toString());
	}
}
