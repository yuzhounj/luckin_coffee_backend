package org.example.manage.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.manage.model.ShopCar;
import org.example.manage.model.User;

import java.util.ArrayList;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @date 2024/9/20 11:30
 */

@Aspect
public class ShopCarAspect {

    private List<ShopCar> cars = new ArrayList<>();

    @Around("execution(* org.example.manage.service.ShopCarService.getShopCar())")
    public List<ShopCar> getAll(ProceedingJoinPoint joinPoint) throws Throwable {
        if (cars.isEmpty()) {
            cars = (List<ShopCar>) joinPoint.proceed();
        }
        System.out.println("CacheAspect.getAll()...");
        return cars;
    }

    @After("execution(* org.example.manage.service.ShopCarService.saveShopCar*(..)) || " +
            "execution(* org.example.manage.service.UserService.subShopCar*(..)) || " +
            "execution(* org.example.manage.service.UserService.addShopCar*(..))")
    public void refreshCache() {
        // 清空缓存
        cars = new ArrayList<>();
        System.out.println("Cache cleared due to data change...");
    }
}