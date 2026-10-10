import java.util.LinkedHashMap;
import java.util.Map;
public class Order {
    public enum Status { PENDING, PAID }
    private final String id;
    private final Customer customer;
    private final Map<Product, Integer> items = new LinkedHashMap<>();
    private Status status = Status.PENDING;
    public Order(String id, Customer customer) { this.id = id; this.customer = customer; }
    public void addProduct(Product product, int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Quantity must be positive.");
        items.merge(product, quantity, Integer::sum);
    }
    public double total() { return items.entrySet().stream().mapToDouble(e -> e.getKey().getPrice() * e.getValue()).sum(); }
    public void pay(PaymentMethod method) {
        if (items.isEmpty()) { System.out.println("Cannot process payment for an empty order."); return; }
        if (status == Status.PAID) { System.out.println("Order " + id + " is already Paid."); return; }
        System.out.println("Payment initiated via " + method.getName() + " for Order " + id + ".");
        boolean success = method.processPayment(total());
        if (success) { status = Status.PAID; System.out.println("Payment for Order " + id + " successful. Order status: Paid."); }
        else { System.out.println("Payment for Order " + id + " failed. Order status: Pending."); }
    }
    public Customer getCustomer() { return customer; }
}
