package teksystems.bnoseworthy_casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.bnoseworthy_casestudy.database.entity.Child;
import teksystems.bnoseworthy_casestudy.database.entity.User;

import javax.persistence.JoinColumn;
import java.util.List;


    @Repository
    public interface ChildDAO extends JpaRepository<Child, Long> {

         Child findById(@Param("id") Integer id);

         List<Child> findByAge(@Param("age") Integer age);

         List<Child> findByFirstNameAndLastNameIgnoreCase(@Param("firstName") String firstName, @Param("lastName") String lastName);


         List<Child> findByFirstNameContainingIgnoreCase(@Param("firstName") String firstName);

         Child findByUserId(@Param("user_Id") Integer userId);

         List<Child> findAllBy();

         List<Child> findChildrenByUserId(@Param("user_Id") Integer userId);

         Integer deleteById(@Param("id") Integer id);




    }


