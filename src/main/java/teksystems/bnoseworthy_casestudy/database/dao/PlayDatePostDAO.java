package teksystems.bnoseworthy_casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.bnoseworthy_casestudy.database.entity.PlayDatePost;
import teksystems.bnoseworthy_casestudy.database.entity.User;

import java.util.List;

@Repository
public interface PlayDatePostDAO extends JpaRepository<PlayDatePost, Long> {

    public User findById(@Param("id") Integer id);





    public List<User> findByFirstNameAndLastName(@Param("firstName") String firstName, @Param("lastName") String lastName);

    public List<User> findByFirstNameContainingIgnoreCase(@Param("firstName") String firstName);

    // sample query
//    @Query(value = "select u from User u where u.password =: pw")
//    public List<User> getByPassword(@Param("pw") String pw);
}
