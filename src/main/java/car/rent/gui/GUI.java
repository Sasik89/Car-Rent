package car.rent.gui;

import car.rent.authenticator.Authenticate;
import car.rent.model.LuxuryCar;
import car.rent.model.User;
import car.rent.model.Vehicle;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Collection;
import java.util.Scanner;

public class GUI {

    private final static Scanner scanner = new Scanner(System.in);

    Authenticate authenticate = new Authenticate();

    public static String showMenuAndReadChoose() {
        System.out.println("1. List cars");
        System.out.println("2. Rent car");
        System.out.println("3. Return car");
        System.out.println("4. Exit");
        return scanner.nextLine();
    }

    public static void printCars(Collection<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            if(vehicle instanceof LuxuryCar && !Authenticate.rola.equals("ADMIN")){
                continue;
            }
                System.out.println(vehicle.toString());
        }
    }

    public static String readPlate() {
        System.out.println("Podaj numer tablicy");
        return scanner.nextLine();
    }

    public static void showRentResult(boolean zmienna) {
        if (zmienna) {
            System.out.println("Udało wypożyczyć się samochód");
        } else {
            System.out.println("Nieudało wypożyczyć się samochód");
        }
    }

    public static void isReturn(boolean zmienna) {
        if (zmienna) {
            System.out.println("Udało się zwrócić samochód");
        } else {
            System.out.println("Nieudało się zwrócić samochód");
        }
    }

    public static User readUserAndPassword() {
        System.out.println("Wpisz login");
        String login = scanner.nextLine();
        System.out.println("Wpisz hasło");
        return new User(login, DigestUtils.md5Hex(scanner.nextLine()));
    }
}
