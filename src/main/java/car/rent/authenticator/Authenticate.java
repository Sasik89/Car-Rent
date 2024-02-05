package car.rent.authenticator;

import car.rent.db.IUserRepository;
import car.rent.db.UserReository;
import car.rent.gui.GUI;
import car.rent.model.User;
import java.util.Scanner;

public class Authenticate implements IAuthenticate {

    Scanner scanner = new Scanner(System.in);
    IUserRepository userReository = UserReository.getInstance();
    GUI gui = GUI.getInstance();
    public static String rola;
    private static final Authenticate instance = new Authenticate();
    private Authenticate(){}
    @Override
    public boolean authenticate() {
        int counter = 0;
        while (counter <= 3) {
            User userFromDB = gui.readUserAndPassword(); //wywołuje raz by nie wpisywać loginu i hasła 2 razy
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
    public static Authenticate getInstance(){
        return instance;
    }
}
