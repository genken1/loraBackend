package com.creaters.entity;

public class UsersAchievements {
    private Integer user_id;

    private Integer achievement_id;

    public void setUserId(Integer user_id) {
        this.user_id = user_id;
    }

    public void setAchievementId(Integer achievement_id) {
        this.achievement_id = achievement_id;
    }

    public Integer getUserId() {
        return user_id;
    }

    public Integer getAchievementId() {
        return achievement_id;
    }
}
