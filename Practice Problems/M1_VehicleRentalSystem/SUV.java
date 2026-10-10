public class SUV extends Vehicle {
    public SUV(String id) { super(id); }
    public double calculateRentalCharge(int days) { return days * 80.0; }
}
