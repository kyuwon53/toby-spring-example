package com.example.tobyspring.user.dao;

import com.example.tobyspring.user.domain.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;

public class UserDaoTest {
    public static void main(String[] args) throws SQLException {

        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);
        UserDao userDao = context.getBean("userDao", UserDao.class);

        User user = new User();
        user.setId("56756756");
        user.setName("백기선");
        user.setPassword("married");

        userDao.add(user);

        System.out.println("등록 성공 Id = " + user.getId());

        User user2 = userDao.get(user.getId());
        System.out.println("Name = " + user2.getName());
        System.out.println("password = " + user2.getPassword());
        System.out.println("조회 성공: " + user2.getId());

    }
}
