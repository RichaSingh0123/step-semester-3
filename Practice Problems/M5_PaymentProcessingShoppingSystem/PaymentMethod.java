public interface PaymentMethod {
    String getName();
    boolean processPayment(double amount);
}
