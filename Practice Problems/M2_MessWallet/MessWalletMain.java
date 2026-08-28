class MessWalletData {
    private double balance;

    public MessWalletData(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: negative opening balance. Starting at 0.");
            balance = 0;
        } else {
            balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be positive");
        } else {
            balance += amount;
            System.out.println("Balance after top-up: " + balance);
        }
    }

    public void deduct(double amount) {
        if (amount <= 0) {
            System.out.println("Deduction rejected: amount must be positive");
        } else if (amount > balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            balance -= amount;
        }
    }

    public double getBalance() {
        return balance;
    }
}

public class MessWalletMain {
    public static void main(String[] args) {
        MessWalletData wallet = new MessWalletData(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}