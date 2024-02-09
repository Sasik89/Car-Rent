package car.rent.db;

import car.rent.model.User;
import org.springframework.stereotype.Component;

import java.util.HashMap;

public interface IUserRepository {

    public void save();
    public HashMap<String, User> getUsers();
}
