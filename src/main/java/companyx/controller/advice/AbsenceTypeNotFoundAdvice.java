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
	@ExceptionHandler(AbsenceTypeNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	
	public Map<String, String> handler(AbsenceTypeNotFoundException ex)
	{
		Map<String, String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		
		return map;
	}
	
}
