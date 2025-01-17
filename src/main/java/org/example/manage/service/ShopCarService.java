package org.example.manage.service;

import org.example.manage.model.SecurityUser;
import org.example.manage.model.ShopCar;
import org.example.manage.model.User;
import org.example.manage.repository.ShopCarRepository;
import org.example.manage.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopCarService {
    @Autowired
    ShopCarRepository shopCarRepository;

    @Autowired
    UserRepository userRepository;

    public boolean saveShopCar(ShopCar shopCar) {
        shopCar.setId(null);
        if(shopCarRepository.findByTitle(shopCar.getTitle()) != null) {
            ShopCar shopCar1 = shopCarRepository.findByTitle(shopCar.getTitle());
            shopCar1.setSum(shopCar1.getSum()+shopCar.getSum());
            shopCarRepository.save(shopCar1);
        }else{
            shopCarRepository.save(shopCar);
        }
        return true;
    }

    public List<ShopCar> getShopCar() {
        return shopCarRepository.findAll();
    }

    public boolean subShopCar(Long id,Long sum) {
        ShopCar shopCar = shopCarRepository.findById(id).get();
        shopCar.setSum(shopCar.getSum()-sum);
        shopCarRepository.save(shopCar);
        return true;

    }

    public boolean addShopCar(Long id,Long sum) {
        ShopCar shopCar = shopCarRepository.findById(id).get();
        shopCar.setSum(shopCar.getSum()+sum);
        shopCarRepository.save(shopCar);
        return true;
    }

}
