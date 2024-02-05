package car.rent.model;

public class LuxuryCar extends Vehicle{
    public LuxuryCar(String brand, String model, int year, double price, String plate) {
        super(brand, model, year, price, plate);
    }

    @Override
    public String convertToCSVString() {
        return "LuxuryCar;" + super.convertToCSVString();
    }
}
