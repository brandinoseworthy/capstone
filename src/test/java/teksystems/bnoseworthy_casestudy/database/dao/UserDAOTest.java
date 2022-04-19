package teksystems.bnoseworthy_casestudy.database.dao;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import teksystems.bnoseworthy_casestudy.database.entity.User;
import java.util.List;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTest {

    @Autowired
    private UserDAO userDao;


    @Test
    @Order(1)
    public void findByEmail(){ //test passed

        User user =userDao.findByEmail("blnoseworthy@gmail.com");
        Assertions.assertThat(user.getEmail()).isEqualTo("blnoseworthy@gmail.com");

    }
    @Test
    @Order(2)
    public void findById(){ //test passed
        User user =userDao.findById(1);
        Assertions.assertThat(user.getId()).isEqualTo(1);
    }
    @Test
    @Order(3)
    public void findByFirstNameContainingIgnoreCase(){ //test passed

        List <User>  users = userDao.findByFirstNameContainingIgnoreCase("brandi");
        Assertions.assertThat(users.size()).isGreaterThanOrEqualTo(1);

    }
}
