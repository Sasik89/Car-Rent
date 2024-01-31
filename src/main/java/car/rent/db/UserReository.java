package car.rent.db;

import car.rent.model.User;

import java.util.HashMap;

public class UserReository {


    private final HashMap<String, User> users = new HashMap<>();

    public UserReository(){
        this.users.put("admin",new User("Adnim","admin","0192023a7bbd73250516f069df18b500", User.Role.ADMIN));
        this.users.put("janusz",new User("Janusz","janusz", "1e6f2ac43951a6721d3d26a379cc7f8b", User.Role.USER));
    }


    public HashMap<String, User> getUsers() {
        return users;
    }

}
