package org.example.manage.service;

import org.example.manage.model.ShopCar;
import org.example.manage.repository.OrderRepository;
import org.example.manage.repository.ShopCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

}
