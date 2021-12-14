package com.example.shoppingcart.Exception;

import com.example.shoppingcart.responseMessage.ResposeMessage;
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
    public ResponseEntity<ResposeMessage> handleMaxSizeException(MaxUploadSizeExceededException exc)
    {
        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResposeMessage("File too large!"));
    }
}
