package teksystems.bnoseworthy_casestudy.database.controller;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import teksystems.bnoseworthy_casestudy.database.dao.ChildDAO;
import teksystems.bnoseworthy_casestudy.database.dao.UserDAO;
import teksystems.bnoseworthy_casestudy.database.entity.Child;
import teksystems.bnoseworthy_casestudy.database.entity.User;

import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ChildDAOTest {

    @Autowired
    private ChildDAO childDao;


    @Test
    @Order(1) //test passed
    public void createChildTest(){

        Child expected = new Child ();

        expected.setFirstName("Alaina");
        expected.setLastName("Marie");
        expected.setAge(12);
        expected.setUserId(3);

        childDao.save(expected);

        Assertions.assertTrue(expected.getId()>0);

    }

    @Test
    @Order(2)
    public void getChildTest(){ //test passed

        Child expected = new Child();
        expected.setId(3);

        Child actual = childDao.findById(3);

        Assertions.assertEquals(expected.getId(), actual.getId());

    }

    @Test
    @Order(3)
    public void updateChildTest(){ //test passed

        String expected = "Alagna";

        Child actual = childDao.findById(3);
        actual.setFirstName("Alagna");

        childDao.save(actual);

        Assertions.assertEquals(expected, actual.getFirstName());

    }

    @Test
    @Order(4)       //test passed
    public void deleteChildTest(){

        Child actual = new Child ();

        actual.setFirstName("Alaina");
        actual.setLastName("Marie");
        actual.setAge(12);
        actual.setUserId(3);

        childDao.save(actual);

        childDao.delete(actual);

        Assertions.assertNull(childDao.findById(actual.getId()));

    }

}
