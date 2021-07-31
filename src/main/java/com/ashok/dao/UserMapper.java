package com.ashok.dao;

import com.ashok.entity.User;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UserMapper implements RowMapper<User> {
    @Override
    public User map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new User.UserBuilder().userId(rs.getString("user_id"))
                .name(rs.getString("name")).build();
    }
}
