package com.creaters.repositories;



import org.springframework.jdbc.core.RowMapper;
import com.creaters.entity.UsersAchievements;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsersAchievementsMapper implements RowMapper<UsersAchievements> {

    @Override
    public UsersAchievements mapRow(ResultSet resultSet, int i) throws SQLException {
        UsersAchievements UsAch = new UsersAchievements();
        UsAch.setAchievementId(resultSet.getInt("achievement_id"));
        UsAch.setUserId(resultSet.getInt("user_id"));
        return null;
    }
}
