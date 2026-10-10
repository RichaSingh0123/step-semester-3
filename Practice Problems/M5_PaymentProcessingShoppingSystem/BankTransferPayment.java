public class BankTransferPayment implements PaymentMethod {
    public String getName() { return "Bank Transfer"; }
    public boolean processPayment(double amount) { return true; }
}
