public class Sedan extends Vehicle {
    public Sedan(String id) { super(id); }
    public double calculateRentalCharge(int days) { return days * 50.0; }
}
