public class RentalService {
    public Rental rent(Vehicle vehicle, Customer customer, int days) {
        if (!vehicle.isAvailable()) {
            System.out.println(vehicle.getId() + " is currently unavailable.");
            return null;
        }
        if (days <= 0) throw new IllegalArgumentException("Rental days must be positive.");
        vehicle.setAvailable(false);
        System.out.println(vehicle.getId() + " rented successfully by " + customer.getName() + ".");
        System.out.printf("Rental charge: $%.2f.%n", vehicle.calculateRentalCharge(days));
        return new Rental(vehicle, customer, days);
    }
}
