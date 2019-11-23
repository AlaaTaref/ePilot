package com.epilot.service;

import static org.junit.Assert.assertEquals;


import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epilot.Application;
import com.epilot.dtos.RequestDTO;
import com.epilot.dtos.ResponseDTO;

import spark.Spark;

public class MultipleOfNumberServiceTest {
	private MultipleOfNumberService service = new MultipleOfNumberService();
	
	@BeforeClass
	public static void beforeClass() {
		String[] start = { "start" };
		Application.main(start);
	}

	@AfterClass
	public static void afterClass() {
		Spark.stop();
	}
	
	@Test
	public void testNumberMultipledOfSeven()
	{
		RequestDTO testRequest = RequestDTO.builder().multipleOf(7).number(21).build();
		ResponseDTO response = service.checkMultipleOfNumber(testRequest);
		
		assertEquals(true, response.isMultipled());
		
	}
	
	@Test
	public void testNumberNotMultipledOfSeven()
	{
		RequestDTO testRequest = RequestDTO.builder().multipleOf(7).number(22).build();
		ResponseDTO response = service.checkMultipleOfNumber(testRequest);
		
		assertEquals(false, response.isMultipled());
		
	}
	
	@Test
	public void testNumberMultipledOfFive()
	{
		RequestDTO testRequest = RequestDTO.builder().multipleOf(5).number(25).build();
		ResponseDTO response = service.checkMultipleOfNumber(testRequest);
		
		assertEquals(true, response.isMultipled());
		
	}
	
	@Test
	public void testNumberNotMultipledOfFive()
	{
		RequestDTO testRequest = RequestDTO.builder().multipleOf(5).number(26).build();
		ResponseDTO response = service.checkMultipleOfNumber(testRequest);
		
		assertEquals(false, response.isMultipled());
		
	}	
	
	@Test
	public void testZeroMultipledOfFive()
	{
		RequestDTO testRequest = RequestDTO.builder().multipleOf(5).number(0).build();
		ResponseDTO response = service.checkMultipleOfNumber(testRequest);
		
		assertEquals(true, response.isMultipled());
		
	}
}
