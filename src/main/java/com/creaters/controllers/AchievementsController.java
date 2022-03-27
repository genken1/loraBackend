package com.creaters.controllers;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.creaters.entity.Achievements;
import com.creaters.repositories.AchievementsRepository;


import java.util.List;

@RestController
@RequestMapping("achievements")
public class AchievementsController {

    @Autowired
    private AchievementsRepository achievementsRepo;

    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "text/plain")
    public int createAchievement(@RequestBody String param) {
        String name = null;
        String url = null;
        try {
            JSONObject json = new JSONObject(param);
            name = json.getString("name");
            url = json.getString("url");
        } catch (JSONException e) {
            e.getLocalizedMessage();
            return 0;
        }
        return achievementsRepo.createAchievement(name, url);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "text/plain")
    public int updateAchievement(@RequestBody String param) {
        Achievements ach = new Achievements();
        try {
            JSONObject json = new JSONObject(param);
            ach.setId(json.getInt("id"));
            ach.setName(json.getString("name"));
            ach.setUrl(json.getString("url"));
        } catch (JSONException e) {
            e.getLocalizedMessage();
            return 0;
        }
        return achievementsRepo.updateAchievement(ach);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public int deleteAchievement(@PathVariable Integer id) {
        return achievementsRepo.deleteAchievement(id);
    }

    @RequestMapping(value = "/getachievement", method = RequestMethod.GET)
    public Achievements getAchievement(@RequestParam("id") Integer id) {
        return achievementsRepo.getAchievement(id);
    }

    @RequestMapping(value = "/getachievements", method = RequestMethod.GET)
    public List<Achievements> getAchievements() {
        return achievementsRepo.getAchievements();
    }
}
