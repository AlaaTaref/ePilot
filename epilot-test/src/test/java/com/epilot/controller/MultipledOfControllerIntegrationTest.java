package com.epilot.controller;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.ParseException;
import org.apache.http.util.EntityUtils;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epilot.Application;
import com.epilot.util.ClientUtil;
import com.google.gson.Gson;

import static org.assertj.core.api.Assertions.assertThat;


import spark.Spark;

public class MultipledOfControllerIntegrationTest {

	@BeforeClass
	public static void beforeClass() {
		String[] start = {"start"};
		Application.main(start);
	}

	@AfterClass
	public static void afterClass() {
		Spark.stop();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testMutpileBySeven() throws ParseException, IOException {
		
		String url = "http://localhost:8080/baz";
		String httpRequest = "{\r\n" + 
				"	\"number\":\"28\"\r\n" + 
				"}";
		
		String response = "";
		HttpResponse res = ClientUtil.sendPost(url, httpRequest);
		
		assertEquals(res.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

			HttpEntity entity = res.getEntity();
			response = EntityUtils.toString(entity);

		Map<String, String> json = new Gson().fromJson(response, HashMap.class);
		
		assertEquals(true, json.get("multipled"));
		
		
	}	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testMutpileBySevenWrong() throws ParseException, IOException {
		
		String url = "http://localhost:8080/baz";
		String httpRequest = "{\r\n" + 
				"	\"number\":\"27\"\r\n" + 
				"}";
		
		String response = "";
		HttpResponse res = ClientUtil.sendPost(url, httpRequest);
		
		assertEquals(res.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

			HttpEntity entity = res.getEntity();
			response = EntityUtils.toString(entity);

		Map<String, String> json = new Gson().fromJson(response, HashMap.class);
		
		assertEquals(false,json.get("multipled"));
	}	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testMutpileByFive() throws ParseException, IOException {
		
		String url = "http://localhost:8080/fiz";
		String httpRequest = "{\r\n" + 
				"	\"number\":\"25\"\r\n" + 
				"}";
		
		String response = "";
		HttpResponse res = ClientUtil.sendPost(url, httpRequest);
		
		assertEquals(res.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

			HttpEntity entity = res.getEntity();
			response = EntityUtils.toString(entity);

		Map<String, String> json = new Gson().fromJson(response, HashMap.class);
		
		assertEquals(true, json.get("multipled"));
	}	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testMutpileByFiveWrong() throws ParseException, IOException {
		
		String url = "http://localhost:8080/fiz";
		String httpRequest = "{\r\n" + 
				"	\"number\":\"26\"\r\n" + 
				"}";

			
		String response = "";
		HttpResponse res = ClientUtil.sendPost(url, httpRequest);
		
		assertEquals(res.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

			HttpEntity entity = res.getEntity();
			response = EntityUtils.toString(entity);

		Map<String, String> json = new Gson().fromJson(response, HashMap.class);
		
		assertEquals(false, json.get("multipled"));
	}	
	
	@SuppressWarnings("unchecked")
	@Test
	public void testMutpileByFiveWithEmptyNumber() throws ParseException, IOException {
		
		String url = "http://localhost:8080/fiz";
		String httpRequest = "{\r\n" + 
				"	\"number\":\"\"\r\n" + 
				"}";
		
		String response = "";
		HttpResponse res = ClientUtil.sendPost(url, httpRequest);
		
		assertEquals(res.getStatusLine().getStatusCode(), HttpStatus.SC_BAD_REQUEST);

			HttpEntity entity = res.getEntity();
			response = EntityUtils.toString(entity);

		Map<String, String> json = new Gson().fromJson(response, HashMap.class);
		
		assertThat( json.get("message")).contains("number can not be empty, null or 0");		
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testMutpileBySevenWithEmptyZero() throws ParseException, IOException {
		
		String url = "http://localhost:8080/fiz";
		String httpRequest = "{\r\n" + 
				"	\"number\":0\r\n" + 
				"}";
		
		String response = "";
		HttpResponse res = ClientUtil.sendPost(url, httpRequest);
		
		assertEquals(res.getStatusLine().getStatusCode(), HttpStatus.SC_BAD_REQUEST);

			HttpEntity entity = res.getEntity();
			response = EntityUtils.toString(entity);

		Map<String, String> json = new Gson().fromJson(response, HashMap.class);
		
		assertThat( json.get("message")).contains("number can not be empty, null or 0");

	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void testMutpileBySevenWithEmptyNull() throws ParseException, IOException {
		
		String url = "http://localhost:8080/fiz";
		String httpRequest = "{\r\n" + 
				"	\"number\":null\r\n" + 
				"}";
		
		String response = "";
		HttpResponse res = ClientUtil.sendPost(url, httpRequest);
		
		assertEquals(res.getStatusLine().getStatusCode(), HttpStatus.SC_BAD_REQUEST);

			HttpEntity entity = res.getEntity();
			response = EntityUtils.toString(entity);

		Map<String, String> json = new Gson().fromJson(response, HashMap.class);
		
		assertThat( json.get("message")).contains("number can not be empty, null or 0");
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testMutpileBySevenWithFloatNumber() throws ParseException, IOException {
		
		String url = "http://localhost:8080/baz";
		String httpRequest = "{\r\n" + 
				"	\"number\":21.25\r\n" + 
				"}";
		
		String response = "";
		HttpResponse res = ClientUtil.sendPost(url, httpRequest);
		
		assertEquals(res.getStatusLine().getStatusCode(), HttpStatus.SC_BAD_REQUEST);

			HttpEntity entity = res.getEntity();
			response = EntityUtils.toString(entity);

		Map<String, String> json = new Gson().fromJson(response, HashMap.class);
		
		assertThat( json.get("message")).contains("number can not be in float");
	}
	
@SuppressWarnings("unchecked")
@Test
public void testMutpileByFiveWithNegativeNumber() throws ParseException, IOException {
	
	String url = "http://localhost:8080/baz";
	String httpRequest = "{\r\n" + 
			"	\"number\":-21\r\n" + 
			"}";
	
	String response = "";
	HttpResponse res = ClientUtil.sendPost(url, httpRequest);
	
	assertEquals(res.getStatusLine().getStatusCode(), HttpStatus.SC_OK);

		HttpEntity entity = res.getEntity();
		response = EntityUtils.toString(entity);

	Map<String, String> json = new Gson().fromJson(response, HashMap.class);
	
	assertEquals(true, json.get("multipled"));
	}

}
