package car.rent.authenticator;

import car.rent.db.IUserRepository;
import car.rent.gui.IGUI;
import car.rent.model.User;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Authenticate implements IAuthenticate {

    Scanner scanner = new Scanner(System.in);
    private final IUserRepository userRepository;
    private final IGUI gui;
    public static String rola;
    
    public Authenticate(IUserRepository userRepository, IGUI gui) {
        this.userRepository = userRepository;
        this.gui = gui;
    }

    @Override
    public boolean authenticate() {
        int counter = 0;
        while (counter <= 3) {
            User userFromDB = gui.readUserAndPassword(); //wywołuje raz by nie wpisywać loginu i hasła 2 razy
            String login = userFromDB.getLogin();
            String password = userFromDB.getPassword();
            for (User user : userRepository.getUsers().values()) {
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
