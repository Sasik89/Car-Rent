package car.rent.model;

public class Vehicle {
    private String brand;
    private String model;
    private int year;
    private double price;
    private String plate;
    private boolean isRent;

    public Vehicle(String brand, String model, int year, double price, String plate) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.price = price;
        this.plate = plate;
        this.isRent = false;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public boolean isRent() {
        return isRent;
    }

    public void setRent(boolean rent) {
        isRent = rent;
    }

    @Override
    public String toString() {
        return new StringBuilder().append(this.getBrand())
                .append(" ")
                .append(this.getModel())
                .append(", Year: ")
                .append(this.getYear())
                .append(", Price: ")
                .append(this.getPrice())
                .append(", Plate: ")
                .append(this.getPlate())
                .append(", Is Rent: ")
                .append(this.isRent())
                .toString();
    }
}
