package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Customer;
import com.example.shoppingcart.repository.CustomerRepositoy;
import com.example.shoppingcart.repository.helper.ExcelHelper;
import com.example.shoppingcart.responseMessage.ResposeMessage;
import com.example.shoppingcart.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@RestController
@RequestMapping("/customer")
public class CustomerController
{
     @Autowired
    CustomerService customerService;
     @Autowired
     CustomerRepositoy customerRepositoy;

//   @PostMapping("/upload")
//    public void upload(@RequestParam("file") MultipartFile file) throws Exception
//    {
//        shoppingCartService.fileupload(file);
//    }

    @PostMapping("/upload")
    @ResponseBody
    public ResponseEntity<ResposeMessage> uploadFile(@RequestParam("file") MultipartFile file) {
        String message = " " ;
        if(ExcelHelper.hasExcelFormat(file))
        {
            try
            {
                customerService.save(file);
                message = "Uploaded the file successfully: " + file.getOriginalFilename();
                return ResponseEntity.status(HttpStatus.OK).body(new ResposeMessage(message));
            }
            catch (Exception e)
            {
                message = "Could not upload the file: " + file.getOriginalFilename() + "!";
                return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResposeMessage(message));
            }
        }
        message = "Please upload an excel file!";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResposeMessage(message));
    }
    @PostMapping("/addcustomer")
@ResponseBody
public Customer add(@RequestBody Customer customer)
{
   return customerService.CreateCustomer(customer);
}
    @GetMapping("/customer")
    public ResponseEntity<List<Customer>> getAllCustomers()
    {
        try
        {
            List<Customer> customers = customerService.getAllCustomers();
            if (customers.isEmpty())
            {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(customers, HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
