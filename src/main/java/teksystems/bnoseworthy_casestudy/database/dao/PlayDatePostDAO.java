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

    public PlayDatePost findById(@Param("id") Integer id);




}
