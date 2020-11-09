package com.example.campaign.api;

import com.example.campaign.models.ErrorDetail;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.Objects;

/**
 * This method handles any validation error response
 *
 * The response message are formatted in the ErrorDetail entity model
 * Messages will be taking from the model Entities validation constrain
 *
 */
@ControllerAdvice
@RestController
public class DetailResponseExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {

        ErrorDetail errorDetails = new ErrorDetail(new Date(), "Validation Failed", Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
        return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
    }
}
