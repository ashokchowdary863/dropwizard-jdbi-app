package com.ashok.dao;

import com.ashok.entity.User;
import org.jdbi.v3.sqlobject.config.RegisterBeanMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.config.RegisterRowMappers;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

public interface UserDAO {
    @SqlUpdate("INSERT INTO users(user_id,name) VALUES (:userId, :name)")
    void createUser(@BindBean User user);

    @SqlUpdate("UPDATE users SET name=:name WHERE user_id=:userId")
    void updateUser(@BindBean User user);

    @SqlUpdate("DELETE FROM users WHERE user_id=:userId")
    void deleteUser(@Bind("userId") String userId);

    @RegisterRowMapper(UserMapper.class)
    @SqlQuery("SELECT * FROM users WHERE user_id=:userId")
    User getUser(@Bind("userId") String userId);

    @RegisterRowMapper(UserMapper.class)
    @SqlQuery("SELECT * FROM users")
    List<User> getUsers();






}
