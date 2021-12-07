package com.example.shoppingcart.controller;

import com.example.shoppingcart.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


@RestController
public class ShoppingCartController
{
    @Autowired
    private  ShoppingCartService shoppingCartService;
    public ShoppingCartController(ShoppingCartService shoppingCartService)
    {
        this.shoppingCartService=shoppingCartService;
    }
    @PostMapping("/upload")
    public void upload(@RequestParam("file") MultipartFile file) throws Exception {
        shoppingCartService.fileupload(file);
    }
}
