package org.example.manage.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.example.manage.model.User;

import java.util.ArrayList;

import java.util.List;

/**
 * @author Administrator
 * @version 1.0
 * @date 2024/9/20 11:30
 */

@Aspect
public class UserAspect {

    private List<User> users = new ArrayList<>();

    @Around("execution(* org.example.manage.service.UserService.getAllStudent(..))")
    public List<User> getAll(ProceedingJoinPoint joinPoint) throws Throwable {
        if (users.isEmpty()) {
            users = (List<User>) joinPoint.proceed();
        }
        System.out.println("CacheAspect.getAll()...");
        return users;
    }

    // 监听数据变更方法：update、delete、register
    @After("execution(* org.example.manage.service.UserService.update*(..)) || " +
            "execution(* org.example.manage.service.UserService.delete*(..)) || " +
            "execution(* org.example.manage.service.UserService.register*(..))")
    public void refreshCache() {
        // 清空缓存
        users = new ArrayList<>();
        System.out.println("Cache cleared due to data change...");
    }
}