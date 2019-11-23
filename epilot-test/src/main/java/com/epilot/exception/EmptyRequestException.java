package com.epilot.exception;

import lombok.Getter;

@Getter
public class EmptyRequestException extends Exception {
	
	private static final long serialVersionUID = 9136358545521180511L;

	public EmptyRequestException(String message)
    {
		super(message);
    }
}
