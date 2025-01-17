package org.example.manage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "coffee")
public class Coffee {
    //  resourcestr: string;
    //  resourcestr2: string;
    //  title: string;
    //  title2: string;
    //  title3: string;
    //  price: number;
    //  discountprice: number;
    //  price1: number;
    //根据上面的字段，创建对应的属性
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)

    private String resourcestr;

    @Column(nullable = false)

    private String resourcestr2;

    @Column(nullable = false)

    private String title;

    @Column(nullable = false)

    private String title2;

    @Column(nullable = false)

    private String title3;

    @Column(nullable = false)

    private double price;

    @Column(nullable = false)

    private double discountprice;

    @Column(nullable = false)

    private double price1;

    //getter and setter
    public Long getId() {
        return id;
    }

public void setId(Long id) {
        this.id = id;
    }

public String getResourcestr() {
        return resourcestr;
    }

public void setResourcestr(String resourcestr) {
        this.resourcestr = resourcestr;
    }

public String getResourcestr2() {
        return resourcestr2;
    }

public void setResourcestr2(String resourcestr2) {
        this.resourcestr2 = resourcestr2;
    }

public String getTitle() {
        return title;
    }

public void setTitle(String title) {
        this.title = title;
    }

public String getTitle2() {
        return title2;
    }

public void setTitle2(String title2) {
        this.title2 = title2;
    }

public String getTitle3() {
        return title3;
    }

public void setTitle3(String title3) {
        this.title3 = title3;
    }

public double getPrice() {
        return price;
    }

public void setPrice(double price) {
        this.price = price;
    }

public double getDiscountprice() {
        return discountprice;
    }

public void setDiscountprice(double discountprice) {
        this.discountprice = discountprice;
    }

public double getPrice1() {
        return price1;
    }

public void setPrice1(double price1) {
        this.price1 = price1;
    }








}
