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
@Table(name = "users")  // 对应数据库中的表名
public class User {

    // Getters and Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // 自增主键
    @Getter
    @Setter
    private Long id;

    @Column(nullable = false, unique = true)  // 登录用户名必须唯一
    @Getter
    @Setter
    private String username;

    @Column(nullable = false)  // 密码不能为空
    @Getter
    @Setter
    private String password;

    @Column(nullable = false)  // 姓名不能为空
    @Getter
    @Setter
    private String phone;


    @Enumerated(EnumType.STRING)  // 角色字段，存储为字符串
    @Getter
    @Setter
    @Column(nullable = false)
    private Role role;

    // 枚举定义角色类型
    public enum Role {
        ADMIN, CUSTOMER
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



}
