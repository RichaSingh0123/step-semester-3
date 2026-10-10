public abstract class Vehicle {
    private final String id;
    private boolean available = true;
    public Vehicle(String id) { this.id = id; }
    public String getId() { return id; }
    public boolean isAvailable() { return available; }
    void setAvailable(boolean available) { this.available = available; }
    public abstract double calculateRentalCharge(int days);
}
