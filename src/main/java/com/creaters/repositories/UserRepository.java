package com.creaters.repositories;

import com.creaters.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //new parameter(email)
    public int createUser(String name, String last_name, String email) {
        return jdbcTemplate.update("INSERT INTO public.\"Users\" (\"name\", \"last_name\", \"email\") VALUES (?, ?, ?)", name, last_name, email);
    }

    //new parameter(email)
    public int updateUser(Users user) {
        return jdbcTemplate.update("UPDATE public.\"Users\" SET \"name\"=?, \"last_name\"=?, \"email\"=? WHERE \"id\" = ?", user.getName(), user.getLastName(), user.getEmail(), user.getId());
    }

    public int deleteUser(Integer id) {
        return jdbcTemplate.update("DELETE FROM public.\"Users\" WHERE \"id\" = ?", id);
    }

    public Users getUser(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM public.\"Users\" WHERE\"id\"=?", new UsersMapper(), id);
    }

    public Users getUserByEmail(String email) {
        return jdbcTemplate.queryForObject("SELECT * FROM public.\"Users\" WHERE\"email\"=?", new UsersMapper(), email);
    }

    public List<Users> getUsers() {
        return jdbcTemplate.query("SELECT * FROM public.\"Users\"", new UsersMapper());
    }

}
