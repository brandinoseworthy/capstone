package teksystems.bnoseworthy_casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.bnoseworthy_casestudy.database.entity.PlayDatePost;

import java.util.List;
import java.util.Set;

@Repository
public interface PlaydatePostDAO extends JpaRepository<PlayDatePost, Long> {

     PlayDatePost findById(@Param("id") Integer id);


    //find all play date posts by userId
     List<PlayDatePost> findUserPlaydatePostsByUserId(@Param("userId") Integer user_id);

     List<PlayDatePost> findPlaydatePostsByLocation(@Param("location") String location);

    List<PlayDatePost> findPlaydatePostsByLocationContainsOrderByPlaydateDateDesc(@Param("location") String location);








}
