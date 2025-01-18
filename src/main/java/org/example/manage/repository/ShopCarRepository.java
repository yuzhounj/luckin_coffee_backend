package org.example.manage.repository;

import org.example.manage.model.ShopCar;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShopCarRepository extends JpaRepository<ShopCar, Long> {
    ShopCar findByTitle(String title);

    List<ShopCar> findAllByUser(String user);
    List<ShopCar> findAll();
}
