
package com.example.teacher.teacher.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public final class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErroeDetails> resourceNotFound(ResourceNotFoundException ex) {
		ErroeDetails errordetails = new ErroeDetails(LocalDateTime.now(),ex.getMessage(),"NOT_FOUND");
        return new ResponseEntity<>(errordetails, HttpStatus.NOT_FOUND);
	
}

}
























//
//@ExceptionHandler(ResourceAlreadyExist.class)
//public ResponseEntity<ErroeDetails> resourceAlreadyExist(ResourceAlreadyExist ex) {
//	ErroeDetails errordetails=new ErroeDetails();
//	errordetails.setDetails("CONFLICT");
//	errordetails.setMessage(ex.getMessage());
//	errordetails.setTimestamp(LocalDateTime.now());
//
//    return new ResponseEntity<ErroeDetails>(errordetails, HttpStatus.CONFLICT);
//}
//
//
//@ExceptionHandler(UnauthorizedException.class)
//public ResponseEntity<ErroeDetails> unauthorizedException(UnauthorizedException ex) {
//	ErroeDetails errordetails=new ErroeDetails();
//	errordetails.setDetails("UNAUTHORIZED");
//	errordetails.setMessage(ex.getMessage());
//	errordetails.setTimestamp(LocalDateTime.now());
//
//    return new ResponseEntity<ErroeDetails>(errordetails, HttpStatus.UNAUTHORIZED);
//}
//
//@ExceptionHandler(CustomException.class)
//public ResponseEntity<ErroeDetails> customException(CustomException ex) {
//	ErroeDetails errordetails=new ErroeDetails();
//	errordetails.setDetails("BAD_REQUEST");
//	errordetails.setMessage(ex.getMessage());
//	errordetails.setTimestamp(LocalDateTime.now());
//
//    return new ResponseEntity<ErroeDetails>(errordetails, HttpStatus.BAD_REQUEST);
//}