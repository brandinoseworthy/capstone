package teksystems.bnoseworthy_casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.bnoseworthy_casestudy.database.entity.PlayDatePost;

import java.util.List;
import java.util.Set;

@Repository
public interface PlaydatePostDAO extends JpaRepository<PlayDatePost, Long> {

    public PlayDatePost findById(@Param("id") Integer id);


    //find all play date posts by userId
    public List<PlayDatePost> findUserPlaydatePostsByUserId(@Param("userId") Integer user_id);

    public List<PlayDatePost> findPlaydatePostsByLocation(@Param("location") String location);





}
