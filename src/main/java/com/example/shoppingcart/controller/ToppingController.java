package com.example.shoppingcart.controller;

import com.example.shoppingcart.model.Topping;
import com.example.shoppingcart.repository.ToppingRepository;
import com.example.shoppingcart.repository.helper.ToppingHelper;
import com.example.shoppingcart.responseMessage.ResposeMessage;
import com.example.shoppingcart.service.ToppingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/Topping")
public class ToppingController
{

    @Autowired
    ToppingService toppingService;

    @Autowired
    ToppingRepository toppingRepository;

    @PostMapping("/uploadtopping")
    @ResponseBody
    public ResponseEntity<ResposeMessage> uploadFile(@Valid @RequestParam("toppings") MultipartFile file) {
        String message = " ";
        if (ToppingHelper.hasExcelFormat(file))
        {
            try
            {
                toppingService.save(file);
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



    @GetMapping("/alltoppings")
    public ResponseEntity<List<Topping>> getAllPizza() {
        try {
            List<Topping> toppings= toppingService.getAllToppings();

            if (toppings.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(toppings,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @GetMapping("/topping/{name}")
//    public ResponseEntity<List<Topping>> getToppingByName(@PathVariable String name)
//    {
//        return new ResponseEntity<List<Topping>>((List<Topping>) toppingRepository.findByToppingName(name), HttpStatus.OK);
//    }
}
