import java.util.*;

public class PayrollRegisterMain {
    static class Payslip {
        String name, type;
        long pay;
        Payslip(String name, String type, long pay) {
            this.name = name; this.type = type; this.pay = pay;
        }
        @Override public String toString() {
            return "Payslip[name=" + name + ", type=" + type + ", pay=" + pay + "]";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Payslip> payslips = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\\s+");
            try {
                switch (p[0]) {
                    case "FullTime":
                        if (p.length == 3) payslips.add(new Payslip(p[1], "FullTime", Long.parseLong(p[2])));
                        else System.out.println("Invalid FullTime record");
                        break;
                    case "PartTime":
                        if (p.length == 4) payslips.add(new Payslip(p[1], "PartTime",
                            Long.parseLong(p[2]) * Long.parseLong(p[3])));
                        else System.out.println("Invalid PartTime record");
                        break;
                    case "Intern":
                        if (p.length == 3) payslips.add(new Payslip(p[1], "Intern", Long.parseLong(p[2])));
                        else System.out.println("Invalid Intern record");
                        break;
                    default: System.out.println("Invalid staff type");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Invalid numeric value");
            }
        }

        long total = 0;
        Payslip topEarner = null;
        for (Payslip p : payslips) {
            System.out.println(p);
            total += p.pay;
            if (topEarner == null || p.pay > topEarner.pay) topEarner = p;
        }
        System.out.println("Total " + total);
        if (topEarner != null) System.out.println("top earner " + topEarner.name);
        sc.close();
    }
}
