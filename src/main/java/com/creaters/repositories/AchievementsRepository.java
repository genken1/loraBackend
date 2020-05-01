package com.creaters.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import com.creaters.entity.Achievements;

import java.util.List;

@Component
public class AchievementsRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public int createAchievement(String name) {
        return jdbcTemplate.update("INSERT INTO public.\"Achievements\" (\"name\") VALUES (?)", name);
    }
    public int updateAchievement(Achievements achiv) {
        return jdbcTemplate.update("UPDATE public.\"Achievements\" SET \"name\"=? WHERE \"id\" = ?", achiv.getName(), achiv.getId());
    }
    public int deleteAchievement(Integer id) {
        return jdbcTemplate.update("DELETE FROM public.\"Achievements\" WHERE \"id\" = ?", id);
    }
    public Achievements getAchievement(Integer id) {
        return jdbcTemplate.queryForObject("SELECT * FROM public.\"Achievements\" WHERE\"id\"=?", new AchievementsMapper(), id);
    }
    public List<Achievements> getAchievements() {
        return jdbcTemplate.query("SELECT * FROM public.\"Achievements\"", new AchievementsMapper());
    }
}
