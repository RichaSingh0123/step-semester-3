public class PaymentMain {

    static class Payment {
        private double lastChargedAmount;

        public void pay(double amount) {
            lastChargedAmount = amount;
            System.out.println("Paid (cash): Rs " + amount);
        }

        public double getLastChargedAmount() {
            return lastChargedAmount;
        }
    }

    static class CardPayment extends Payment {
        public void payWithProcessingFee(double amount) {
            double chargedAmount = amount * 1.02;
            setLastChargedAmount(chargedAmount);
            System.out.println("Charged (card, incl. fee): Rs " + chargedAmount);
        }

        private void setLastChargedAmount(double amount) {
            super.lastChargedAmount = amount;
        }
    }

    public static void main(String[] args) {
        Payment[] payments = {
            new CardPayment(),
            new Payment(),
            new CardPayment(),
            new Payment(),
            new CardPayment()
        };

        double[] amounts = {100, 50, 200, 75, 120};

        processPayments(payments, amounts);
    }

    private static void processPayments(Payment[] payments, double[] amounts) {
        double totalCollected = 0;

        for (int index = 0; index < payments.length; index++) {
            processTransaction(payments[index], amounts[index]);
            totalCollected += payments[index].getLastChargedAmount();
        }

        System.out.println("Total Collected: Rs " + totalCollected);
    }

    private static void processTransaction(Payment payment, double amount) {
        if (payment instanceof CardPayment) {
            CardPayment cardPayment = (CardPayment) payment;
            cardPayment.payWithProcessingFee(amount);
        } else {
            payment.pay(amount);
        }
    }
}
