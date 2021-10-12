package companyx.controller.advice;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


@ControllerAdvice
public class AbsenceTypeValidationAdvice
{

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public Map<String, Object> absenceTypeNotFoundExceptionHandler(MethodArgumentNotValidException ex)
	{
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
        body.put("status", HttpStatus.BAD_REQUEST.toString());
		
        Map<String, String> errors = new LinkedHashMap<>();
	    ex.getBindingResult()
	    	.getAllErrors()
	    	.forEach( (error) -> {
		        String field = ((FieldError) error).getField();
		        String message = error.getDefaultMessage();
		        errors.put(field, message);
	    	});
	    body.put("errors", errors);
	    
	    return body;
	}

}
