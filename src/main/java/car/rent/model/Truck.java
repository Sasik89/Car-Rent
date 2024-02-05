package car.rent.model;

public class Truck extends Vehicle{

    private int capacity;

    public Truck(String brand, String model, int year, double price, String plate, int capacity) {
        super(brand, model, year, price, plate);
        this.capacity = capacity;
    }

    @Override
    public String getBrand() {
        return super.getBrand();
    }
    @Override
    public void setBrand(String brand) {
        super.setBrand(brand);
    }
    @Override
    public String getModel() {
        return super.getModel();
    }
    @Override
    public void setModel(String model) {
        super.setModel(model);
    }
    @Override
    public int getYear() {
        return super.getYear();
    }
    @Override
    public void setYear(int year) {
        super.setYear(year);
    }
    @Override
    public double getPrice() {
        return super.getPrice();
    }
    @Override
    public void setPrice(double price) {
        super.setPrice(price);
    }
    @Override
    public String getPlate() {
        return super.getPlate();
    }
    @Override
    public void setPlate(String plate) {
        super.setPlate(plate);
    }
    @Override
    public boolean isRent() {
        return super.isRent();
    }
    @Override
    public void setRent(boolean rent) {
        super.setRent(rent);
    }
    @Override
    public String toString() {
        return super.toString() +
                ", Capacity = " + capacity;
    }
    @Override
    public String convertToCSVString() {
        return "Truck;" +  super.convertToCSVString() + ";" + this.capacity;
    }
}
