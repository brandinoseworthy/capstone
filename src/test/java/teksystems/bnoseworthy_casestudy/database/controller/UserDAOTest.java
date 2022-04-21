package teksystems.bnoseworthy_casestudy.database.controller;


import org.junit.jupiter.api.*;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import teksystems.bnoseworthy_casestudy.database.dao.UserDAO;
import teksystems.bnoseworthy_casestudy.database.entity.User;

import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDao;


    @Test
    @Order(1) //test passed
    public void createUserTest(){

        User expected = new User ();
        expected.setEmail("hello1@gmail.com");
        expected.setFirstName("test");
        expected.setLastName("test");
        expected.setPassword("root");
        expected.setTownState("02152");
        expected.setDescription("123");
        expected.setFavoritePlaceForPlaydates("Park");
        expected.setCreateDate(new Date());

        userDao.save(expected);

       Assertions.assertTrue(expected.getId()>0);

    }

    @Test
    @Order(2)
    public void getUserTest(){ //test passed

        User expected = new User();
        expected.setId(3);

        User actual = userDao.findById(3);

        org.junit.jupiter.api.Assertions.assertEquals(expected.getId(), actual.getId());

    }
    @ParameterizedTest
    @CsvSource({"1,Brandi Lee", "2,Kaci", "3,bee"}) // 1 and 2 will pass 3 will fail.
    public void testJUnit5CsvParameters(int id, String firstName) {
        User expected = new User();
        expected.setId(id);
        expected.setFirstName(firstName);

        User actual = userDao.findById(id);

        Assertions.assertEquals(expected.getFirstName(),actual.getFirstName());

    }

    @Test
    @Order(3)
    public void updateUserTest(){ //test passed

        String expected = "Update";

        User actual = userDao.findById(3);
        actual.setFirstName("Update");

        userDao.save(actual);

        Assertions.assertEquals(expected, actual.getFirstName());

    }

    @Test
    @Order(4)       //test passed
    public void deleteUserTest(){

        User actual = new User ();
        actual.setEmail("hello1@gmail.com");
        actual.setFirstName("test");
        actual.setLastName("test");
        actual.setPassword("root");
        actual.setTownState("02152");
        actual.setDescription("123");
        actual.setFavoritePlaceForPlaydates("Park");
        actual.setCreateDate(new Date());


        userDao.save(actual);

        userDao.delete(actual);

        Assertions.assertNull(userDao.findById(actual.getId()));

    }

}
