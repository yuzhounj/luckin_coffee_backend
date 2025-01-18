package org.example.manage.controller;

import org.example.manage.model.ShopCar;
import org.example.manage.service.ShopCarService;
import org.example.manage.utils.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ShopCarControllor {
    @Autowired
    ShopCarService shopCarService;

    @PostMapping("/saveLuckinShopcar")
    public ApiResponse<String> saveLuckinShopcar(@RequestBody ShopCar shopCar) {
        ApiResponse<String> res = new ApiResponse<>();
        if(shopCarService.saveShopCar(shopCar)){
            res.setCode(200);
            res.setMsg("加入购物车成功");
            res.setData("ok");
        }else{
            res.setCode(400);
            res.setMsg("加入购物车失败");
            res.setData("no");
        }
        return res;
    }

    @GetMapping("/getLuckinShopcarList")
    public ApiResponse<List<ShopCar>> getLuckinShopcarList() {
        ApiResponse<List<ShopCar>> res = new ApiResponse<>();
        List<ShopCar> shopCarList = shopCarService.getShopCar();
        if(shopCarList != null){
            res.setCode(200);
            res.setData(shopCarList);
            res.setMsg("ok");
            return res;
        }else{
            res.setCode(400);
            res.setData(null);
            res.setMsg("no");
            return res;
        }
    }

    @PostMapping("/SubLuckinShopcar/{id}/{sum}")
    public ApiResponse<String> SubLuckinShopcar(@PathVariable Long id,@PathVariable Long sum) {
        ApiResponse<String> res = new ApiResponse<>();
        if (shopCarService.subShopCar(id, sum)) {
            res.setCode(200);
            res.setMsg("ok");
            res.setData("ok");
            return res;
        } else {
            res.setCode(400);
            res.setMsg("no");
            res.setData("no");
            return res;
        }
    }

    @PostMapping("/AddLuckinShopcar/{id}/{sum}")
    public ApiResponse<String> AddLuckinShopcar(@PathVariable Long id,@PathVariable Long sum) {
        ApiResponse<String> res = new ApiResponse<>();
        if (shopCarService.addShopCar(id, sum)) {
            res.setCode(200);
            res.setMsg("ok");
            res.setData("ok");
            return res;
        } else {
            res.setCode(400);
            res.setMsg("no");
            res.setData("no");
            return res;
        }

    }
}
