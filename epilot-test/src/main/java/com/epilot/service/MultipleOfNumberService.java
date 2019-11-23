package com.epilot.service;

import com.epilot.dtos.RequestDTO;
import com.epilot.dtos.ResponseDTO;

public class MultipleOfNumberService {
	
public ResponseDTO checkMultipleOfNumber(RequestDTO requestDTO)
{
	if(requestDTO.getNumber() % requestDTO.getMultipleOf() == 0)
		{
		return new ResponseDTO(true);

		}
	return new ResponseDTO(false);
	}
}
