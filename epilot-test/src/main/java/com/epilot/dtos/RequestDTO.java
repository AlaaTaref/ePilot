package com.epilot.dtos;

import com.epilot.controller.Validable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestDTO implements Validable {

	int number;
	int multipleOf;
	
	@Override
	public boolean isValid() {
	      return number != 0 ;
	   }
	
    public void setNumber(String number) throws Exception {
        try {
        	
        	if(number == null || "".equals(number))
        	{
        		throw new Exception("number can not be empty, null or 0");
        	}
            this.number = Integer.parseInt(number);
        } catch (NumberFormatException e) {
           throw new Exception("number can not be in float");
        }
    }
}
