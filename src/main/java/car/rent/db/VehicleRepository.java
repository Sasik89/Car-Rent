package car.rent.db;

import car.rent.authenticator.Authenticate;
import car.rent.model.*;

import java.util.Collection;
import java.util.HashMap;

public class VehicleRepository {


    private final HashMap<String, Vehicle> vehicles = new HashMap<>();

    public VehicleRepository() {
        this.vehicles.put("KR11", new Car("BMW", "2", 2020, 500.0, "KR11"));
        this.vehicles.put("KR22", new Car("Toyota", "2", 2022, 400.0, "KR22"));
        this.vehicles.put("KR33", new Car("Aud", "2", 2023, 300.0, "KR33"));
        this.vehicles.put("KR44", new Car("Honda", "2", 2021, 600.0, "KR44"));
        this.vehicles.put("KR55", new Car("Kia", "Ceed", 2022, 200.0, "KR55"));
        this.vehicles.put("KR66", new Bus("Solaris", "S2000", 2019, 1000.00, "KR66", 40, true));
        this.vehicles.put("KR77", new Bus("Mercedes", "Turbo", 2018, 400.00, "KR77", 50, false));
        this.vehicles.put("KR88", new Bus("Solaris", "GTR", 2017, 900.00, "KR88", 50, true));
        this.vehicles.put("KR99", new Truck("Jelcz", "HD500", 2012, 800.00, "KR99", 4000));
        this.vehicles.put("KR111", new Motorcycle("Honda", "GTS", 2017, 350, "KR111", true));
        this.vehicles.put("BENTLEY", new LuxuryCar("Bentley", "Continental", 2022, 5000, "BENTLEY"));
        this.vehicles.put("FERRARI", new LuxuryCar("Ferrari", "Italia", 2022, 6000, "FERRARI"));

    }

    public boolean rentVehicle(String plate) {
        Vehicle vehicle = this.vehicles.get(plate);
        if (vehicle instanceof LuxuryCar
                && !Authenticate.rola.equals("ADMIN")) {
            return false;
        }
        if (vehicle != null && !vehicle.isRent()) {
            vehicle.setRent(true);
            return true;
        }
        return false;
    }

    public boolean returnCar(String plate) {
        Vehicle vehicle = this.vehicles.get(plate);
        if (vehicle != null && vehicle.isRent()) {
            vehicle.setRent(false);
            return true;
        }
        return false;
    }


    public Collection<Vehicle> getVehicles() {
        return this.vehicles.values();
    }
}


