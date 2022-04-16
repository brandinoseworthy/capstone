package teksystems.bnoseworthy_casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.bnoseworthy_casestudy.database.entity.Child;
import teksystems.bnoseworthy_casestudy.database.entity.ChildrenAttending;
import teksystems.bnoseworthy_casestudy.database.entity.PlayDatePost;
import teksystems.bnoseworthy_casestudy.database.entity.User;

import java.util.List;

@Repository
public interface ChildrenAttendingDAO extends JpaRepository<ChildrenAttending, Long> {


    ChildrenAttending findById(@Param("id") Integer id);

    ChildrenAttending findByPlaydatePostIdAndChildId(@Param("playdatePostId") Integer playdatePostId, @Param("childId") Integer childId);

    @Query("Select ca from ChildrenAttending ca where ca.playdatePostId = :playdatePostId and ca.childId = :childId")
    List<ChildrenAttending> findAll(@Param("playdatePostId") Integer playdatePostId, @Param("childId") Integer childId);




}
