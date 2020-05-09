package com.creaters.repositories;


import org.springframework.jdbc.core.RowMapper;
import com.creaters.entity.Users;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersMapper implements RowMapper<Users> {
    @Override
    public Users mapRow(ResultSet rs, int rowNum) throws SQLException {
        Users user = new Users();
        user.setId(rs.getInt("id"));
        user.setName(rs.getString("name"));
        user.setLast_name(rs.getString("last_name"));
        user.setEmail(rs.getString("email"));
        return user;
    }
}
