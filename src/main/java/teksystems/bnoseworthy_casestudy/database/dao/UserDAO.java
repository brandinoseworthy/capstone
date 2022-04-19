package teksystems.bnoseworthy_casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.bnoseworthy_casestudy.database.entity.User;
import teksystems.bnoseworthy_casestudy.database.entity.UserRole;

import java.util.List;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {

    public User findById(@Param("id") Integer id);



    @Query(value = "select * from users where email = :email", nativeQuery = true)
    public User findByEmail(@Param("email") String email);


    public List<User> findByFirstNameIgnoreCase(@Param("firstName") String firstName);



    public List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    public List<User> findByFirstNameContainingIgnoreCase(@Param("firstName") String firstName);

    // sample query
//    @Query(value = "select u from User u where u.password =: pw")
//    public List<User> getByPassword(@Param("pw") String pw);


}
