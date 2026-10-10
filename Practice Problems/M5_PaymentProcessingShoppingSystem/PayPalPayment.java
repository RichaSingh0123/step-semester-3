public class PayPalPayment implements PaymentMethod {
    public String getName() { return "PayPal"; }
    public boolean processPayment(double amount) { return false; }
}
