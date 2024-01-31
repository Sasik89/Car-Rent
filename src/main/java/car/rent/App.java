package car.rent;
import car.rent.authenticator.Authenticate;
import car.rent.db.VehicleRepository;
import car.rent.gui.GUI;

public class App {
    public static void main(String[] args) {

        final VehicleRepository vehicleRepository = new VehicleRepository();
        final Authenticate authenticate = new Authenticate();
        final GUI gui = new GUI();
        boolean run = authenticate.authenticate();
        while (run) {
            switch (GUI.showMenuAndReadChoose()) {
                case "1":
                    GUI.printCars(vehicleRepository.getVehicles());
                    break;
                case "2":
                    GUI.showRentResult(vehicleRepository.rentVehicle(GUI.readPlate()));
                    break;
                case "3":
                    GUI.isReturn(vehicleRepository.returnCar(GUI.readPlate()));
                    break;
                case "4":
                    run = false;
                    break;
                default:
                    System.out.println("Dokonałeś złego wyboru");
                    break;
            }
        }
    }
}
