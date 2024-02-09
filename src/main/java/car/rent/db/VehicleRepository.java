package car.rent.db;

import car.rent.authenticator.Authenticate;
import car.rent.model.*;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.Collection;
import java.util.HashMap;

@Component
public class VehicleRepository implements IVehicleRepository{

    private final HashMap<String, Vehicle> vehicles = new HashMap<>();
    VehicleRepository() {
/*        this.vehicles.put("KR11", new Car("BMW", "2", 2020, 500.0, "KR11"));
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
        this.vehicles.put("FERRARI", new LuxuryCar("Ferrari", "Italia", 2022, 6000, "FERRARI"));*/

        String file = "F:\\Programowanie\\Nagrania z kursu\\IT Camp 9 FIlmiki\\Zajęcia 2023.10.22 - obejrzane\\Car rent\\car-rent\\src\\main\\resources\\vehicle.txt";
        try {
            BufferedReader bufferedWriter = new BufferedReader(new FileReader(file));
            String lineFromFile;
            while ((lineFromFile = bufferedWriter.readLine()) != null) {
                String[] vehicleParts = lineFromFile.split(";");
                if (vehicleParts[0].equals("Car")) {
                    Car car = new Car(vehicleParts[1], vehicleParts[2], Integer.parseInt(vehicleParts[3]), Double.parseDouble(vehicleParts[4]), vehicleParts[5]);
                    this.vehicles.put(vehicleParts[5], car);
                }
                if (vehicleParts[0].equals("Bus")) {
                    Bus bus = new Bus(vehicleParts[1], vehicleParts[2], Integer.parseInt(vehicleParts[3]), Double.parseDouble(vehicleParts[4]), vehicleParts[5], Integer.parseInt(vehicleParts[7]), Boolean.parseBoolean(vehicleParts[7]));
                    this.vehicles.put(vehicleParts[5], bus);
                }
                if (vehicleParts[0].equals("Truck")) {
                    Truck truck = new Truck(vehicleParts[1], vehicleParts[2], Integer.parseInt(vehicleParts[3]), Double.parseDouble(vehicleParts[4]), vehicleParts[5], Integer.parseInt(vehicleParts[7]));
                    this.vehicles.put(vehicleParts[5], truck);
                }
                if (vehicleParts[0].equals("LuxuryCar")) {
                    LuxuryCar luxuryCar = new LuxuryCar(vehicleParts[1], vehicleParts[2], Integer.parseInt(vehicleParts[3]), Double.parseDouble(vehicleParts[4]), vehicleParts[5]);
                    this.vehicles.put(vehicleParts[5], luxuryCar);
                }
                if (vehicleParts[0].equals("Motorcycle")) {
                    Motorcycle motorcycle = new Motorcycle(vehicleParts[1], vehicleParts[2], Integer.parseInt(vehicleParts[3]), Double.parseDouble(vehicleParts[4]), vehicleParts[5], Boolean.parseBoolean(vehicleParts[7]));
                    this.vehicles.put(vehicleParts[5], motorcycle);
                }
            }
                bufferedWriter.close();
            } catch(IOException e){
                System.out.println("Plik nie został przeczytany");
            }
        }
        @Override
        public boolean rentVehicle (String plate){
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
        @Override
        public boolean returnCar (String plate){
            Vehicle vehicle = this.vehicles.get(plate);
            if (vehicle != null && vehicle.isRent()) {
                vehicle.setRent(false);
                return true;
            }
            return false;
        }
        @Override
        public Collection<Vehicle> getVehicles () {
            return this.vehicles.values();
        }
        @Override
        public void save () {
            try {
                String file = "F:\\Programowanie\\Nagrania z kursu\\IT Camp 9 FIlmiki\\Zajęcia 2023.10.22 - obejrzane\\Car rent\\car-rent\\src\\main\\resources\\vehicle.txt";
                Collection<Vehicle> userCollection = this.vehicles.values();
                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                boolean first = true;
                for (Vehicle vehicle : userCollection) {

                    if (!first) {
                        writer.newLine();
                    }
                    first = false;
                    writer.write(vehicle.convertToCSVString());
                }
                writer.close();
            } catch (IOException e) {
                System.out.println("Zepsuło się");
            }
        }
    }


