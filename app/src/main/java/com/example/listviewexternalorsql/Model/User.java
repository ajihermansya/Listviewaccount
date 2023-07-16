package com.example.listviewexternalorsql.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class User {

    public String username;
    public String password;
    public String email;

    public User(String param1, String param2, String param3){
        this.username = param1;
        this.password = param2;
        this.email = param3;
    }
    @Override
    public String toString() {
        return "" + this.username + ";" + this.password + ";" + this.email+";";
    }

    public static List<User> toUser(String val){

        ArrayList<String> results = new ArrayList<>(Arrays.asList(val.split(";")));
        List<User> users = new ArrayList<>();
        User user;
        for(int i = 0; i < results.size(); i=i+3){
            user = new User(results.get(i), results.get(i+1), results.get(i+2));
            users.add(user);
        }

        return users;
    }

    public static boolean loginCheck(String username, String pass, List<User> users){

        boolean status = false;
        for (User user: users) {
            if(username.equalsIgnoreCase(user.username) && pass.equals(user.password)) {
                status = true;
                break;
            }
        }
        return status;

    }
}
