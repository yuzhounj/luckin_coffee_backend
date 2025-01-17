package org.example.manage.service;

import org.example.manage.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CoffeeService {
    @Autowired
    private CoffeeRepository coffeeRepository;

}
