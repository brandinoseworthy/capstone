package teksystems.bnoseworthy_casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.bnoseworthy_casestudy.database.entity.ChildrenAttending;

import java.util.List;

@Repository
public interface ChildrenAttendingDAO extends JpaRepository<ChildrenAttending, Long> {

    public ChildrenAttending findById(@Param("id") Integer id);




}
