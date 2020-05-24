package com.creaters.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.creaters.repositories.UsersAchievementsRepository;

//Данный класс отрабатывает все запросы корректно.
@RestController
@RequestMapping("userachievements")
public class UsersAchievementsController {

    @Autowired
    private UsersAchievementsRepository userAchievements;
    //Работает.
    @RequestMapping(value = "/create", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public int createUserAchievements(@RequestBody String param) {
        Integer userId = null;
        Integer achievementId = null;
        try {
            JSONObject json = new JSONObject(param);
            userId = json.getInt("user_id");
            achievementId = json.getInt("achievement_id");
        } catch (JSONException e) {
            e.getLocalizedMessage();
            return 0;
        }
        return userAchievements.createUserAchievements(userId, achievementId);
    }
    //Работает.
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public int deleteUserAchievements(@PathVariable Integer id) {
        return userAchievements.deleteUserAchievements(id);
    }
    //работает.
    @RequestMapping(value = "/getuserachievements", method = RequestMethod.GET)
    public String getUserAchievements(@RequestParam("id") Integer id) {
        return userAchievements.getUserAchievements(id).toString();
    }
}