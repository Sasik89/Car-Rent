package car.rent.core;

import car.rent.authenticator.Authenticate;
import car.rent.db.IUserRepository;
import car.rent.db.UserReository;
import car.rent.db.VehicleRepository;
import car.rent.gui.GUI;

public class Core {

    final VehicleRepository vehicleRepository = VehicleRepository.getInstance();
    final Authenticate authenticate = Authenticate.getInstance();
    final IUserRepository userReository = UserReository.getInstance();
    final GUI gui = GUI.getInstance();
    private final static Core instance = new Core();
    private Core(){}

    public void start(){
        boolean run = authenticate.authenticate();
        while (run) {
            switch (gui.showMenuAndReadChoose()) {
                case "1":
                    gui.printCars(vehicleRepository.getVehicles());
                    break;
                case "2":
                    gui.showRentResult(vehicleRepository.rentVehicle(gui.readPlate()));
                    break;
                case "3":
                    gui.isReturn(vehicleRepository.returnCar(gui.readPlate()));
                    break;
                case "4":
                    run = false;
                    userReository.save();
                    vehicleRepository.save();
                    break;
                default:
                    System.out.println("Dokonałeś złego wyboru");
                    break;
            }
        }
    }
    public static Core getInstance(){
        return instance;
    }
}
