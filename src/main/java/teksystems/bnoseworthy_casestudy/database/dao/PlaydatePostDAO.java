package teksystems.bnoseworthy_casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.bnoseworthy_casestudy.database.entity.PlayDatePost;

@Repository
public interface PlaydatePostDAO extends JpaRepository<PlayDatePost, Long> {

    public PlayDatePost findById(@Param("id") Integer id);
    public <List>PlayDatePost findByUserId(@Param("userId") Integer user_id);




}
