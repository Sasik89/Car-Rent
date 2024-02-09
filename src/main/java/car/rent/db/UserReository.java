package car.rent.db;

import car.rent.model.User;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

@Component
public class UserReository implements IUserRepository {

    private final HashMap<String, User> users = new HashMap<>();

   UserReository() {
/*      this.users.put("admin", new User("Adnim", "admin", "0192023a7bbd73250516f069df18b500", User.Role.ADMIN));
        this.users.put("janusz", new User("Janusz", "janusz", "1e6f2ac43951a6721d3d26a379cc7f8b", User.Role.USER));*/
        String file = "F:\\Programowanie\\Nagrania z kursu\\IT Camp 9 FIlmiki\\Zajęcia 2023.10.22 - obejrzane\\Car rent\\car-rent\\src\\main\\resources\\user.txt";
        try{
            BufferedReader bufferedWriter = new BufferedReader(new FileReader(file));
            String lineFromFile;
            while((lineFromFile=bufferedWriter.readLine()) !=null){
                String[] userParts = lineFromFile.split(";");
                User user = new User(userParts[0],userParts[1], User.Role.valueOf(userParts[2]));
                this.users.put(user.getLogin(),user);
            }
            bufferedWriter.close();
        }catch (IOException e){
            System.out.println("Plik nie został przyczany");
        }
    }
    @Override
    public HashMap<String, User> getUsers() {
        return users;
    }
    @Override
    public void save() {
        try {
            String file = "F:\\Programowanie\\Nagrania z kursu\\IT Camp 9 FIlmiki\\Zajęcia 2023.10.22 - obejrzane\\Car rent\\car-rent\\src\\main\\resources\\user.txt";
            Collection<User> userCollection = this.users.values();
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            boolean first = true;
            for (User user : userCollection) {

                if (!first) {
                    writer.newLine();
                }
                first = false;
                writer.write(user.convertToCSVString());
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Zepsuło się");
        }
    }
}
