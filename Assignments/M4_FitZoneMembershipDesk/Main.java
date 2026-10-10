public class Main {
    public static void main(String[] args) {
        Membership asha = new Membership("Asha", new QuarterlyPlan());
        Membership ravi = new Membership("Ravi", new MonthlyPlan());
        System.out.printf("Quarterly membership created for Asha. Fee: ₹%.2f. Status: Active.%n", 2700.0);
        System.out.printf("Monthly membership created for Ravi. Fee: ₹%.2f. Status: Active.%n", 1000.0);
        asha.checkIn();
        asha.freeze();
        asha.checkIn();
        ravi.expire();
        ravi.freeze();
    }
}
