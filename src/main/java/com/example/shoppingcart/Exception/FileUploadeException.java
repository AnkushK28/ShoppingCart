package com.example.shoppingcart.Exception;

import com.example.shoppingcart.responceMessage.ResponceMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class FileUploadeException extends ResponseEntityExceptionHandler
{
    @ExceptionHandler(MaxUploadSizeExceededException.class)
    public ResponseEntity<ResponceMessage> handleMaxSizeException(MaxUploadSizeExceededException exc)
    {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponceMessage("File too large!"));
    }
}
