package teksystems.bnoseworthy_casestudy.database.controller;


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import teksystems.bnoseworthy_casestudy.database.dao.ChildDAO;
import teksystems.bnoseworthy_casestudy.database.dao.PlaydatePostDAO;
import teksystems.bnoseworthy_casestudy.database.entity.Child;
import teksystems.bnoseworthy_casestudy.database.entity.PlayDatePost;

import java.util.Date;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PlaydatePostDAOTest {


    @Autowired
    private PlaydatePostDAO playdatePostDao;


    @Test
    @Order(1) //test passed
    public void createPlaydatePostTest(){

        PlayDatePost expected = new PlayDatePost ();

        expected.setCreateAt((new Date()));
        expected.setPostMessage("Taking kids to the ice rink");
        expected.setLocation("Danvers, MA");
        expected.setPlaydateTime("2022-04-14");
        expected.setPlaydateDate("07:49");
        expected.setUserId(3);

        playdatePostDao.save(expected);

        Assertions.assertTrue(expected.getId()>0);

    }

    @Test
    @Order(2)
    public void getPlaydatePostTest(){ //test passed

        PlayDatePost expected = new PlayDatePost ();
        expected.setId(3);

        PlayDatePost actual = playdatePostDao.findById(3);

        Assertions.assertEquals(expected.getId(), actual.getId());

    }

    @Test
    @Order(3)
    public void updatePlaydatePostTest(){ //test passed

        String expected = "Going to get slushies";

        PlayDatePost actual = playdatePostDao.findById(3);
        actual.setPostMessage("Going to get slushies");

        playdatePostDao.save(actual);

        Assertions.assertEquals(expected, actual.getPostMessage());

    }

    @Test
    @Order(4)       //test passed
    public void deleteChildTest(){

        PlayDatePost actual = new PlayDatePost ();

        actual.setCreateAt((new Date()));
        actual.setPostMessage("Taking kids to the ice rink");
        actual.setLocation("Danvers, MA");
        actual.setPlaydateTime("2022-04-14");
        actual.setPlaydateDate("07:49");
        actual.setUserId(3);

        playdatePostDao.save(actual);

        playdatePostDao.delete(actual);

        Assertions.assertNull(playdatePostDao.findById(actual.getId()));

    }

}
