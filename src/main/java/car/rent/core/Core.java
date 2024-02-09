package car.rent.core;

import car.rent.authenticator.IAuthenticate;
import car.rent.db.IUserRepository;
import car.rent.db.IVehicleRepository;
import car.rent.gui.IGUI;
import org.springframework.stereotype.Component;

@Component
public class Core {
    private final IVehicleRepository vehicleRepository;
    private final IAuthenticate authenticate;
    private final IUserRepository userRepository;
    private final IGUI gui;

    public Core(IVehicleRepository vehicleRepository, IAuthenticate authenticate, IUserRepository userRepository, IGUI gui) {
        this.vehicleRepository = vehicleRepository;
        this.authenticate = authenticate;
        this.userRepository = userRepository;
        this.gui = gui;
    }

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
                    userRepository.save();
                    vehicleRepository.save();
                    break;
                default:
                    System.out.println("Dokonałeś złego wyboru");
                    break;
            }
        }
    }
}
