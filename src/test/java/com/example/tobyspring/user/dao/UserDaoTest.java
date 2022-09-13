package com.example.tobyspring.user.dao;

import com.example.tobyspring.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

class UserDaoTest {

    @Test
    public void addAndGet() throws Exception {
        //given
        ApplicationContext context = new AnnotationConfigApplicationContext(DaoFactory.class);

        UserDao userDao = context.getBean("userDao", UserDao.class);
        //when
        User user = new User();
        user.setId("2342");
        user.setName("백기선");
        user.setPassword("married");

        userDao.add(user);

        //then
        User user2 = userDao.get(user.getId());
        assertThat(user2.getName()).isEqualTo(user.getName());
    }
}