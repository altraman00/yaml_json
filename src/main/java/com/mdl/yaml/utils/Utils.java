package com.mdl.yaml.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public class Utils {

	/**
	 * 將json轉化為yaml格式并返回String
	 * @param jsonString
	 * @return
	 * @throws JsonProcessingException
	 * @throws IOException
	 */
	public static String asYaml(String jsonString) throws JsonProcessingException, IOException {
		// parse JSON
		JsonNode jsonNodeTree = new ObjectMapper().readTree(jsonString);
		// save it as YAML
		String jsonAsYaml = new YAMLMapper().writeValueAsString(jsonNodeTree);
		System.out.println("\n" + jsonAsYaml);
		return jsonAsYaml;
	}
	

	/**
	 * 讀取json文件并返回字符串
	 * @param url
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("resource")
	public static String readJson(String url) throws Exception {
		File file = new File (url); 
		FileReader fileReader=new FileReader(file); 
		BufferedReader bufReader=new BufferedReader(fileReader);
		String message = new String();
	    String line = null;
	    while ((line = bufReader.readLine()) != null) {
	        message += line;
	    }
	    System.out.println(message);
		return message;
	}

}
