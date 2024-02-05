package car.rent.db;

import car.rent.model.Vehicle;

import java.util.Collection;

public interface IVehicleRepository {

    public boolean rentVehicle (String plate);
    public boolean returnCar (String plate);
    public Collection<Vehicle> getVehicles ();

    public void save ();
}
