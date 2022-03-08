package controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public String handleException() {
		//Exception e = null;
		//System.out.println("commonExceptionHandler : ");
		//e.printStackTrace();
		return "error/errorForm";
	}
}
