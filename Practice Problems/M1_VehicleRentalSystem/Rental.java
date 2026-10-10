public class Rental {
    private final Vehicle vehicle;
    private final Customer customer;
    private final int days;
    private boolean active = true;
    public Rental(Vehicle vehicle, Customer customer, int days) {
        this.vehicle = vehicle; this.customer = customer; this.days = days;
    }
    public Vehicle getVehicle() { return vehicle; }
    public Customer getCustomer() { return customer; }
    public boolean isActive() { return active; }
    public void returnVehicle() {
        if (!active) return;
        active = false; vehicle.setAvailable(true);
        System.out.println(vehicle.getId() + " returned by " + customer.getName() + ".");
    }
}
