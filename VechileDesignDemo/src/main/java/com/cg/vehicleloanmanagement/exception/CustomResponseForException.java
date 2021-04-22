package com.cg.vehicleloanmanagement.exception;

import java.util.Date;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class CustomResponseForException extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({LoanApplicationException.class})
	public final ResponseEntity<Object> handleLoanApplNotFoundException(LoanApplicationException lanf, WebRequest rq){
		ExceptionResponse expResp = new ExceptionResponse(lanf.getMessage(),
				"The Loan_application cannot be processed please check Your information", new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler({UserException.class})
	public final ResponseEntity<Object> handleUserException(UserException lanf, WebRequest rq){
		ExceptionResponse expResp = new ExceptionResponse(lanf.getMessage(),
				"The User details cannot be processed please check Your information", new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	@ExceptionHandler({ApprovedLoanException.class})
	public final ResponseEntity<Object> handleApprovedLoanNotFoundException(ApprovedLoanException alnf, WebRequest rq){
		ExceptionResponse expResp = new ExceptionResponse(alnf.getMessage(),
				"The approved_loan details cannot be processed please check your information", new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler({PendingLoanException.class})
	public final ResponseEntity<Object> handlePendingException(PendingLoanException ple, WebRequest rq){
		ExceptionResponse expResp = new ExceptionResponse(ple.getMessage(),
				"The Loan application hasn't approved yet, It is still in pending state", new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.NOT_FOUND);
		
	}
	@ExceptionHandler({LoanApplicationStatusException.class})
	public final ResponseEntity<Object> handleApplicationStatusNotFoundException(LoanApplicationStatusException appstatus, WebRequest rq){
		ExceptionResponse expResp = new ExceptionResponse(appstatus.getMessage(),
				"The Application details cannot be processed please check your information", new Date());
		return new ResponseEntity<Object>(expResp, HttpStatus.NOT_FOUND);
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatus status,
            WebRequest request)
	{
		   ExceptionResponse expResp = new ExceptionResponse(ex.getBindingResult().getFieldError().getDefaultMessage(),
					"Validation Error", new Date()); 
		   return new ResponseEntity<>(expResp,HttpStatus.BAD_REQUEST);
	    } 
//	
//	@Override
//    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
//            HttpStatus status, WebRequest request) {
//        System.out.println("Inside handleTypeMismatch()");
//        ExceptionResponse expRes = new ExceptionResponse( "Input type mismatch",ex.getMessage() ,new Date());
//        return new ResponseEntity<Object>(expRes, HttpStatus.BAD_REQUEST); // 400
//    }
	
	@Override
	protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		ExceptionResponse expRes = new ExceptionResponse("Invalid Argument has been passed", ex.getMessage(), new Date());
		return new ResponseEntity<Object>(expRes, HttpStatus.BAD_REQUEST); // 400
	}
}
