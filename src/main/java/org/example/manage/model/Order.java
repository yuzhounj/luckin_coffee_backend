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
@Table(name = "orders")
public class Order {
    //  id:number
    //  resourcestr:string
    //  title:string
    //  price:number
    //  user:string
    //  sum:number
    //  cupshaped:string
    //  brix:string
    //  temperature:string
    //  money:number
    //  address:string
    //  time:string

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

    private String user;

    @Column(nullable = false)

    private int sum;

    @Column(nullable = false)
    private String cupshaped;

    @Column(nullable = false)

    private String brix;

    @Column(nullable = false)

    private String temperature;

    @Column(nullable = false)

    private double money;

    @Column(nullable = false)

    private String address;

    @Column(nullable = false)

    private String time;

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

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


}
