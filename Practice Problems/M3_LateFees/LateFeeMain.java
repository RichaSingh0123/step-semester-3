public class LateFeeMain {

    static class FeeAccount {
        private String registrationNumber;
        private double totalFee;

        public FeeAccount(String registrationNumber, double totalFee) {
            this.registrationNumber = registrationNumber;
            this.totalFee = totalFee;
        }

        public final double calculateLateFee(int daysLate) {
            return totalFee * 0.01 * daysLate;
        }

        public final void printSummary(int daysLate) {
            double lateFee = calculateLateFee(daysLate);
            System.out.println(registrationNumber + " | Total Fee: Rs "
                    + totalFee + " | Late Fee: Rs " + lateFee);
        }

        public String getRegistrationNumber() {
            return registrationNumber;
        }
    }

    public static void main(String[] args) {
        String[] registrationNumbers = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000, 150000, 180000, 220000};
        int[] daysLate = {10, 0, -2, 5};

        processLateFees(registrationNumbers, totalFees, daysLate);
    }

    private static void processLateFees(
            String[] registrationNumbers, double[] totalFees, int[] daysLate) {

        for (int index = 0; index < registrationNumbers.length; index++) {
            FeeAccount account =
                    new FeeAccount(registrationNumbers[index], totalFees[index]);

            if (daysLate[index] > 0) {
                account.printSummary(daysLate[index]);
            } else {
                System.out.println(account.getRegistrationNumber()
                        + " - On time, no late fee");
            }
        }
    }
}
