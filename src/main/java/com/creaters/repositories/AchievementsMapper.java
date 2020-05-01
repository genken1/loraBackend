package com.creaters.repositories;

import org.springframework.jdbc.core.RowMapper;
import com.creaters.entity.Achievements;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AchievementsMapper implements RowMapper<Achievements> {

    @Override
    public Achievements mapRow(ResultSet resultSet, int i) throws SQLException {
        Achievements achievement = new Achievements();
        achievement.setId(resultSet.getInt("id"));
        achievement.setName(resultSet.getString("name"));
        return achievement;
    }
}
