package com.epilot.controller;

import spark.Spark;

import org.easymock.EasyMock;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.epilot.Application;
import com.epilot.dtos.RequestDTO;
import com.epilot.dtos.ResponseDTO;
import com.epilot.exception.EmptyRequestException;
import com.epilot.service.MultipleOfNumberService;


import lombok.NoArgsConstructor;

@NoArgsConstructor
public class MultipledOfControllerTest {

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
	public void testMultipleOfSeven() throws EmptyRequestException {

		RequestDTO testRequest = RequestDTO.builder().number(21).build();

		MultipleOfNumberService service = EasyMock.createMock(MultipleOfNumberService.class);
		expect(service.checkMultipleOfNumber(testRequest)).andReturn(new ResponseDTO(false));
		replay(service);

		MultipledOfController controller = new MultipledOfController(service);

		ResponseDTO response = controller.process(testRequest, 7);
		assertEquals(response.isMultipled(), false);

		verify(service);
	}
	
	@Test
	public void testMultipleOfFive() throws EmptyRequestException {

		RequestDTO testRequest = RequestDTO.builder().number(20).build();

		MultipleOfNumberService service = EasyMock.createMock(MultipleOfNumberService.class);
		expect(service.checkMultipleOfNumber(testRequest)).andReturn(new ResponseDTO(false));
		replay(service);

		MultipledOfController controller = new MultipledOfController(service);

		ResponseDTO response = controller.process(testRequest, 5);
		assertEquals(response.isMultipled(), false);
		verify(service);
	}
	
	@Test
	public void testMultipleOfFiveByZero() {

		RequestDTO testRequest = RequestDTO.builder().number(0).build();

		
		MultipledOfController controller = new MultipledOfController(new MultipleOfNumberService());
		try {
			controller.process(testRequest, 5);
		}
		catch (EmptyRequestException e)
		{
			assertEquals( e.getMessage(),"number can not be empty, null or 0");
		}
	}
	
	@Test
	public void testMultipleOfFiveWithoutMock() throws EmptyRequestException {

		RequestDTO testRequest = RequestDTO.builder().number(20).build();


		MultipledOfController controller = new MultipledOfController(new MultipleOfNumberService());

		ResponseDTO response = controller.process(testRequest, 5);
		assertEquals(response.isMultipled(), true);
	}
	
	@Test
	public void testMultipleOfSevenWithoutMock() throws EmptyRequestException {

		RequestDTO testRequest = RequestDTO.builder().number(21).build();


		MultipledOfController controller = new MultipledOfController(new MultipleOfNumberService());

		ResponseDTO response = controller.process(testRequest, 7);
		assertEquals(response.isMultipled(), true);
	}

}
