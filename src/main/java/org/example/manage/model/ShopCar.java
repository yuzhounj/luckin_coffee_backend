package org.example.manage.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "shopCar")
public class ShopCar {
    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 自增主键
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false)  // 登录用户名必须唯一
    @Getter
    @Setter
    private String resourcestr;

    @Column(nullable = false)  // 密码不能为空
    @Getter
    @Setter
    private Double price;

    @Column(nullable = false) // 姓名不能为空
    @Getter
    @Setter
    private Double price2;

    @Column(nullable = false)  // 密码不能为空
    @Getter
    @Setter
    private Long sum;

    @Column(nullable = false)  // 密码不能为空
    @Getter
    @Setter
    private String user;

    @Column(nullable = false)  // 密码不能为空
    @Getter
    @Setter
    private String title;

    @Column(nullable = false)  // 密码不能为空
    @Getter
    @Setter
    private String cupshaped;

    @Column(nullable = false)  // 密码不能为空
    @Getter
    @Setter
    private String brix;

    @Column(nullable = false)  // 密码不能为空
    @Getter
    @Setter
    private String temperature;

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getResourcestr(){
        return resourcestr;
    }
    public void setResourcestr(String resourcestr){
        this.resourcestr = resourcestr;
    }
    public Double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public Double getPrice2(){
        return price2;
    }
    public void setPrice2(Double price2){
        this.price2 = price2;
    }
    public Long getSum(){
        return sum;
    }
    public void setSum(Long sum){
        this.sum = sum;
    }
    public String getUser(){
        return user;
    }
    public void setUser(String user){
        this.user = user;
    }
    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public String getCupshaped(){
        return cupshaped;
    }
    public void setCupshaped(String cupshaped){
        this.cupshaped = cupshaped;
    }
    public String getBrix(){
        return brix;
    }
    public void setBrix(String brix){
        this.brix = brix;
    }
    public String getTemperature(){
        return temperature;
    }
    public void setTemperature(String temperature){
        this.temperature = temperature;
    }
}


