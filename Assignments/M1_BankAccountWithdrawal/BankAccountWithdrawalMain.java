import java.util.*;

public class BankAccountWithdrawalMain {
    private static class Account {
        String id, type;
        long balance;

        Account(String id, String type, long balance) {
            this.id = id;
            this.type = type;
            this.balance = balance;
        }

        String withdraw(long amount) {
            if (amount <= 0) return id + " rejected: amount must be positive";
            if (type.equals("Savings")) {
                if (balance - amount < 1000) return id + " rejected: minimum balance 1000";
            } else {
                if (balance - amount < -5000) return id + " rejected: overdraft limit 5000";
            }
            balance -= amount;
            return id + " balance " + balance;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Account> accounts = new LinkedHashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\\s+");

            try {
                if ((p[0].equals("Savings") || p[0].equals("Current")) && p.length == 3) {
                    accounts.put(p[1], new Account(p[1], p[0], Long.parseLong(p[2])));
                } else if (p[0].equals("WITHDRAW") && p.length == 3) {
                    Account account = accounts.get(p[1]);
                    if (account == null) System.out.println("Account not found");
                    else System.out.println(account.withdraw(Long.parseLong(p[2])));
                } else {
                    System.out.println("Invalid operation");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid numeric value");
            }
        }
        sc.close();
    }
}
