package car.rent.gui;

import car.rent.authenticator.Authenticate;
import car.rent.model.LuxuryCar;
import car.rent.model.User;
import car.rent.model.Vehicle;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Collection;

public interface IGUI {

    public String showMenuAndReadChoose();
    public void printCars(Collection<Vehicle> vehicles);
    public String readPlate();
    public void showRentResult(boolean zmienna);
    public void isReturn(boolean zmienna);
    public User readUserAndPassword();

}
