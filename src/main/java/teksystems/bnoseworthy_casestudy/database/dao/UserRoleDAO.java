package teksystems.bnoseworthy_casestudy.database.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import teksystems.bnoseworthy_casestudy.database.entity.User;
import teksystems.bnoseworthy_casestudy.database.entity.UserRole;

import java.util.List;

@Repository
public interface UserRoleDAO extends JpaRepository<UserRole, Long> {

    List<UserRole> findByUserId(@Param("userId") Integer userId);


    //I have a native query elsewhere - so try to make this work with Spring Query
    @Query(value =" select *  from users u join user_roles ur  on u.id = ur.user_id  where ur.user_role = 'USER' ",
            nativeQuery = true)
    List<UserRole> findByUserRole();



}
