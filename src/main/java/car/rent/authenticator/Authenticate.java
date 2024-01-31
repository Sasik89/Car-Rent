package car.rent.authenticator;

import car.rent.db.UserReository;
import car.rent.gui.GUI;
import car.rent.model.User;
import java.util.Scanner;

public class Authenticate {

    Scanner scanner = new Scanner(System.in);
    UserReository userReository = new UserReository();

    public static String rola;

    public boolean authenticate() {
        int counter = 0;
        while (counter <= 3) {
            User userFromDB = GUI.readUserAndPassword(); //wywołuje raz by nie wpisywać loginu i hasła 2 razy
            String login = userFromDB.getLogin();
            String password = userFromDB.getPassword();
            for (User user : userReository.getUsers().values()) {
                if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                    System.out.println("Zalogowany!!!");
                    rola = user.getRole().toString();
                    return true;
                }
            }
            counter++;
            System.out.println("Niepoprawny login bądź hasło");
        }
        return false;
    }
}
