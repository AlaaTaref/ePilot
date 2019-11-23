package com.epilot.controller;

import spark.Request;
import spark.Response;

import com.epilot.dtos.RequestDTO;
import com.epilot.dtos.ResponseDTO;
import com.epilot.exception.EmptyRequestException;
import com.epilot.exception.ResponseError;
import com.epilot.service.MultipleOfNumberService;
import com.epilot.util.JsonUtil;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class MultipledOfController {

	private static final int HTTP_BAD_REQUEST = 400;
	private MultipleOfNumberService service;

	public MultipledOfController(MultipleOfNumberService service){
		super();
		this.service = service;
	}
	
	
	public Object checkMultipledbyNumber(Request request, Response response) throws Exception {
		String uri = request.uri();
		response.type("application/json");

		try {
			ObjectMapper mapper = new ObjectMapper();
			RequestDTO myRequest = mapper.readValue(request.body(), RequestDTO.class);
			if ("/baz".equals(uri)) {
				return JsonUtil.toJson(process(myRequest, 7));
			}

			else if ("/fiz".equals(uri)) {
				return JsonUtil.toJson(process(myRequest, 5));
			}

			else {
				response.status(HTTP_BAD_REQUEST);
				return JsonUtil.toJson(new ResponseError("Wrong Request"));
			}
			
		} catch (JsonProcessingException |EmptyRequestException e) {
			System.out.println(e.getMessage());
			response.status(HTTP_BAD_REQUEST);
			return JsonUtil.toJson(new ResponseError(e));
		}

	}

	protected ResponseDTO process(RequestDTO request, int multipleOfNumber)
			throws EmptyRequestException {

		if (!request.isValid()) {
			throw new EmptyRequestException("number can not be empty, null or 0");
		}
		request.setMultipleOf(multipleOfNumber);
				
		return service.checkMultipleOfNumber(request);
	}

}
