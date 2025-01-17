package org.example.manage.controller;

import org.example.manage.service.ShopCarService;
import org.example.manage.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/shop")
public class ShopCarController {
    @Autowired
    private ShopCarService shopCarService;

    @PostMapping("/save")
    public ApiResponse<String> saveShopCar(@RequestBody Map<String,String> map) {
        shopCarService.saveShopCar(map);
        return new ApiResponse<String>(200, "success", "success");
    }
}
