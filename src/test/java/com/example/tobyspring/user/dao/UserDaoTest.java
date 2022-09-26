package com.example.tobyspring.user.dao;

import com.example.tobyspring.user.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class UserDaoTest {
    @Autowired
    private UserDao userDao;

    @Test
    public void addAndGet() throws Exception {

        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        //when
        User user = new User();
        user.setId("1");
        user.setName("이규원");
        user.setPassword("springno1");
        System.out.println("user = " + user);
        userDao.add(user);

        //then
        User user2 = userDao.get(user.getId());
        assertThat(user2.getName()).isEqualTo(user.getName());
        assertThat(user2.getPassword()).isEqualTo(user.getPassword());
    }

    @Test
    public void count() throws SQLException {

        User user1 = new User("gyumee", "박성철", "springno1");
        User user2 = new User("leegw700", "이길원", "springno2");
        User user3 = new User("bumjin", "박범진", "springno3");

        userDao.deleteAll();
        assertThat(userDao.getCount()).isEqualTo(0);

        userDao.add(user1);
        assertThat(userDao.getCount()).isEqualTo(1);

        userDao.add(user2);
        assertThat(userDao.getCount()).isEqualTo(2);

        userDao.add(user3);
        assertThat(userDao.getCount()).isEqualTo(3);
    }
}
