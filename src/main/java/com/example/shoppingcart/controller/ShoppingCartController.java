package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Customer;
import com.example.shoppingcart.repository.helper.ExcelHelper;
import com.example.shoppingcart.responceMessage.ResponceMessage;
import com.example.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
public class ShoppingCartController
{
    @Autowired
    private  ShoppingCartService shoppingCartService;
    public ShoppingCartController(ShoppingCartService shoppingCartService)
    {
        this.shoppingCartService=shoppingCartService;
    }
//    @PostMapping("/upload")
//    public void upload(@RequestParam("file") MultipartFile file) throws Exception {
//        shoppingCartService.fileupload(file);
//    }
    @PostMapping("/upload")
    public ResponseEntity<ResponceMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = "";

        if (ExcelHelper.hasExcelFormat(file)) {
            try {
                shoppingCartService.save(file);

                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResponceMessage(message));
            } catch (Exception e) {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponceMessage(message));
            }
        }

        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponceMessage(message));
    }

    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllTutorials() {
        try {
            List<Customer> customers = shoppingCartService.getAllTutorials();

            if (customers.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(customers, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
