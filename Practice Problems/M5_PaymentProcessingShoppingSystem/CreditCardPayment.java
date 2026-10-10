public class CreditCardPayment implements PaymentMethod {
    public String getName() { return "Credit Card"; }
    public boolean processPayment(double amount) { return true; }
}
