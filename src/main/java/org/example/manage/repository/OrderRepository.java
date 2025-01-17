package org.example.manage.repository;

import org.example.manage.model.Order;
import org.example.manage.model.ShopCar;
import org.example.manage.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
