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
@Table(name = "shopcar")
public class ShopCar {
    //id: number;
    //  resourcestr: string;
    //  title: string;
    //  price: number;
    //  price2: number;
    //  user: string;
    //  sum: number;
    //  cupshaped: string;
    //  brix: string;
    //  temperature: string;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(nullable = false)
    private String resourcestr;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private double price2;

    @Column(nullable = false)
    private String user;

    @Column(nullable = false)
    private int sum;

    @Column(nullable = false)
    private String cupshaped;

    @Column(nullable = false)
    private String brix;

    @Column(nullable = false)
    private String temperature;

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

    public String getTitle() {
        return title;
    }



    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice2() {
        return price2;
    }

    public void setPrice2(double price2) {
        this.price2 = price2;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public String getCupshaped() {
        return cupshaped;
    }

    public void setCupshaped(String cupshaped) {
        this.cupshaped = cupshaped;
    }

    public String getBrix() {
        return brix;
    }

    public void setBrix(String brix) {
        this.brix = brix;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }





}
