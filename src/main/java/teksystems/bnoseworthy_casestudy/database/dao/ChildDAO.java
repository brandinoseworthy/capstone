package teksystems.bnoseworthy_casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.bnoseworthy_casestudy.database.entity.Child;
import teksystems.bnoseworthy_casestudy.database.entity.User;

import javax.persistence.JoinColumn;
import java.util.List;


    @Repository
    public interface ChildDAO extends JpaRepository<Child, Long> {

        public Child findById(@Param("id") Integer id);

        public List<Child> findByAge(@Param("age") Integer age);

        public List<Child> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

        public List<Child> findByFirstNameContainingIgnoreCase(@Param("firstName") String firstName);



    }


