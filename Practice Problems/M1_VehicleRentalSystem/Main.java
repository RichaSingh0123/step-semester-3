public class Main {
    public static void main(String[] args) {
        RentalService service = new RentalService();
        Vehicle sedan = new Sedan("Sedan A");
        Vehicle suv = new SUV("SUV B");
        Rental first = service.rent(sedan, new Customer("Customer 1"), 3);
        service.rent(sedan, new Customer("Customer 2"), 2);
        first.returnVehicle();
        service.rent(suv, new Customer("Customer 3"), 5);
    }
}
