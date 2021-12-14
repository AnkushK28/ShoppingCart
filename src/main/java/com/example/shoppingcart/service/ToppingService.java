package com.example.shoppingcart.service;

import com.example.shoppingcart.model.Pizza;
import com.example.shoppingcart.model.Topping;
import com.example.shoppingcart.repository.ToppingRepository;
import com.example.shoppingcart.repository.helper.ToppingHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
@Service
public class ToppingService
{
    @Autowired
    ToppingRepository toppingRepository;
    public void save(MultipartFile file)
    {
        try {
            List<Topping>toppings= ToppingHelper.excelToToppings(file.getInputStream());

            toppingRepository.saveAll(toppings);

        } catch (IOException e)
        {
            throw new RuntimeException("fail to store excel data: " + e.getMessage());
        }
    }
    public List<Topping> getAllToppings() {
        return toppingRepository.findAll();
    }
}
