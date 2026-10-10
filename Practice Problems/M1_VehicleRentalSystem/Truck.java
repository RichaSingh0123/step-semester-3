public class Truck extends Vehicle {
    public Truck(String id) { super(id); }
    public double calculateRentalCharge(int days) { return days * 120.0; }
}
