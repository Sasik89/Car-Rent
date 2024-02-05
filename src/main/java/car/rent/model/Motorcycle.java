package car.rent.model;

public class Motorcycle extends Vehicle{

    private boolean additionalSeats;

    public Motorcycle(String brand, String model, int year, double price, String plate, boolean additionalSeats) {
        super(brand, model, year, price, plate);
        this.additionalSeats = additionalSeats;
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

    public boolean isAdditionalSeats() {
        return additionalSeats;
    }

    public void setAdditionalSeats(boolean additionalSeats) {
        this.additionalSeats = additionalSeats;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", additionalSeats = " + additionalSeats;
    }

    @Override
    public String convertToCSVString() {
        return "Motorcycle;" + super.convertToCSVString() + ";" + this.additionalSeats;
    }
}
