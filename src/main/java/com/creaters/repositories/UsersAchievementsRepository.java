package com.creaters.repositories;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

@Component
public class UsersAchievementsRepository {
    @Autowired
    JdbcTemplate jdbcTemplate = new JdbcTemplate();
    public int createUserAchievements(Integer user_id, Integer achievement_id) {
        return jdbcTemplate.update("INSERT INTO public.\"UsersAchievements\" (\"user_id\", \"achievement_id\") VALUES (?, ?)", user_id, achievement_id);
    }

    public int deleteUserAchievements(Integer id) {
        return jdbcTemplate.update("DELETE FROM public.\"UsersAchievements\" WHERE \"user_id\" = ?", id);
    }

    /*public UsersAchievements getUserAchievement(Integer user_id) {
        return jdbcTemplate.queryForObject("SELECT * FROM \"UsersAchievements\" WHERE\"user_id\"=?", new UsersAchievementsMapper(), user_id);
    }*/
    /*public List<UsersAchievements> getUserAchievements(){
        return jdbcTemplate.query("SELECT * FROM \"UsersAchievements\"", new UsersAchievementsMapper());
    }*/

    public JSONArray getUserAchievements(Integer user_id) {
        JSONObject json;
        JSONArray jsonArr = new JSONArray();
        try {
            Connection connect = jdbcTemplate.getDataSource().getConnection();
            Statement stmt = connect.createStatement();
            String sql = "SELECT \"Achievements\".\"id\",\"Achievements\".\"name\", \"Achievements\".\"url\" FROM \"UsersAchievements\" LEFT JOIN \"Achievements\" ON \"UsersAchievements\".\"achievement_id\" = \"Achievements\".\"id\" WHERE \"UsersAchievements\".\"user_id\" = " + user_id.toString() + ";";
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next()) {
                json = new JSONObject();
                json.put("id", rs.getInt("id"));
                json.put("name", rs.getString("name"));
                json.put("url", rs.getString("url"));
                jsonArr.put(json);
            }
        } catch (SQLException e) {
            e.getLocalizedMessage();
            return null;
        } catch (JSONException e) {
            e.getLocalizedMessage();
            return null;
        }
        return jsonArr;
    }
}
