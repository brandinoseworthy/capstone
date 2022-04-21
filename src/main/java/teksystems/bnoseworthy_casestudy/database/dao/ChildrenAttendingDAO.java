package teksystems.bnoseworthy_casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.bnoseworthy_casestudy.database.entity.ChildrenAttending;

import java.util.List;

@Repository
public interface ChildrenAttendingDAO extends JpaRepository<ChildrenAttending, Long> {


    ChildrenAttending findById(@Param("id") Integer id);

    @Query("Select ca from ChildrenAttending ca where ca.playdatePost = :playdatePostId")
    List<ChildrenAttending> findAll(@Param("playdatePostId") Integer playdatePostId);

    List<ChildrenAttending> findByPlaydatePostId(@Param("playdatePostId") Integer playdatePostId);

//    @Query("Select ca from ChildrenAttending ca where ca.playdatePost = :playdatePostId and ca.child = :childId")
//    List<ChildrenAttending> findAll(@Param("playdatePostId") Integer playdatePostId, @Param("childId") Integer childId);


}
