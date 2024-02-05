package car.rent.model;

public class Bus extends Vehicle {

    private int seats;
    boolean ticketMachine;

    public Bus(String brand, String model, int year, double price, String plate, int seats, boolean ticketMachine) {
        super(brand, model, year, price, plate);
        this.seats = seats;
        this.ticketMachine = ticketMachine;
    }

    public int getSeats() {
        return seats;
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public boolean isTicketMachine() {
        return ticketMachine;
    }

    public void setTicketMachine(boolean ticketMachine) {
        this.ticketMachine = ticketMachine;
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
        return super.toString() + ", seats = " + seats +
                ", ticketMachine = " + ticketMachine;
    }

    @Override
    public String convertToCSVString() {
        return "Bus;" + super.convertToCSVString() + ";" + this.seats + ";" + this.ticketMachine;
    }
}
