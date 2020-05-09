package com.creaters.controllers;


import com.creaters.entity.Users;
import com.creaters.repositories.UserRepository;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
//Данный класс отрабатывает все запросы корректно.
@RestController
@RequestMapping("users")
public class UsersController {

    @Autowired
    private UserRepository user;

    //работает.
    @RequestMapping(value = "/create", method = RequestMethod.POST, consumes = "text/plain")
    public int createUser(@RequestBody String param){
        String name = null;
        String last_name = null;
        String email = null;
        try{
            JSONObject json = new JSONObject(param);
            name = json.getString("name");
            last_name = json.getString("last_name");
            email = json.getString("email");
        } catch (JSONException e) {
            e.getLocalizedMessage();
            return 0;
        }
        return user.createUser(name, last_name, email);
    }
    //работает.
    @RequestMapping(value = "/update", method = RequestMethod.PUT, consumes = "text/plain")
    public int updateUser(@RequestBody String param){
        Users us = new Users();
        try{
            JSONObject json = new JSONObject(param);
            us.setId(json.getInt("id"));
            us.setName(json.getString("name"));
            us.setLast_name(json.getString("last_name"));
            us.setEmail(json.getString("email"));
        } catch (JSONException e) {
            e.getLocalizedMessage();
            return 0;
        }
        return user.updateUser(us);
    }
    //работает.
    @RequestMapping(value="/delete/{id}", method=RequestMethod.DELETE)
    public int deleteUser(@PathVariable Integer id){
        return user.deleteUser(id);
    }
    //работает.
    @RequestMapping(value = "/getuser", method=RequestMethod.GET)
    public Users getUser(@RequestParam("id") Integer id){
        return user.getUser(id);
    }

    //работает.!!!!!!!!!
    @RequestMapping(value = "/getuserbyemail", method=RequestMethod.GET)
    public Users getUser(@RequestParam("email") String email){
        return user.getUserByEmail(email);
    }

    //работает.
    @RequestMapping(value = "/getusers", method=RequestMethod.GET)
    public List<Users> getPersons(){
        return user.getUsers();
    }
}
