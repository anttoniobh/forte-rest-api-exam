package companyx.controller.advice;

import java.time.LocalDateTime;
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
public class AbsenceValidationAdvice
{

	@ResponseBody
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	
	public Map<String, Object> absenceValidationExceptionHandler(MethodArgumentNotValidException ex)
	{
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", LocalDateTime.now());
        body.put("status", HttpStatus.BAD_REQUEST.toString());
		
        Map<String, String> messages = new LinkedHashMap<>();
	    ex.getBindingResult()
	    	.getAllErrors()
	    	.forEach( (error) -> {
		        String field = ((FieldError) error).getField();
		        String msg = error.getDefaultMessage();
		        messages.put(field, msg);
	    	});
	    body.put("messages", messages);
	    
	    return body;
	}
	
}
