package companyx.controller.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import companyx.controller.exception.AbsenceTypeNotFoundException;


@ControllerAdvice
public class AbsenceTypeNotFoundAdvice
{

	@ResponseBody
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(AbsenceTypeNotFoundException.class)
	
	public Map<String, String> absenceTypeNotFoundExceptionHandler(AbsenceTypeNotFoundException ex)
	{
		Map<String, String> error = new HashMap<>();
		error.put("message", ex.getMessage());
		
		return error;
	}
	
}
