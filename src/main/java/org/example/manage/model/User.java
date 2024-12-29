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
    private String name;

    @Column(nullable = false, unique = true)  // 学号必须唯一
    @Getter
    @Setter
    private String studentId;

    @Column(nullable = false)  // 院系不能为空
    @Getter
    @Setter
    private String department;

    @Enumerated(EnumType.STRING)  // 角色字段，存储为字符串
    @Getter
    @Setter
    @Column(nullable = false)
    private Role role;

    // 枚举定义角色类型
    public enum Role {
        TEACHER,  // 教师
        STUDENT  // 学生
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }



}
