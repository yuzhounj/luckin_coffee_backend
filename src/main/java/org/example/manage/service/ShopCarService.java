package org.example.manage.service;

import org.example.manage.model.ShopCar;
import org.example.manage.repository.ShopCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ShopCarService {
    @Autowired
    private ShopCarRepository shopCarRepository;

    public void saveShopCar(Map<String,String> map) {
        ShopCar s = new ShopCar();
        s.setResourcestr(map.get("resourcestr"));
        s.setTitle(map.get("title"));
        s.setPrice(Double.parseDouble(map.get("price")));
        s.setPrice2(Double.parseDouble(map.get("price2")));
        s.setUser(map.get("user"));
        s.setSum(Integer.parseInt(map.get("sum")));
        s.setCupshaped(map.get("cupshaped"));
        s.setBrix(map.get("brix"));
        s.setTemperature(map.get("temperature"));
        shopCarRepository.save(s);
    }
}
