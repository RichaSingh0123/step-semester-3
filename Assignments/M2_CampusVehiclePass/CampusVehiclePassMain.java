import java.util.*;

public class CampusVehiclePassMain {
    interface Chargeable {
        boolean bookChargingBay();
    }

    static abstract class Vehicle {
        String passNumber, owner;
        Vehicle(String passNumber, String owner) {
            this.passNumber = passNumber;
            this.owner = owner;
        }
        abstract String typeName();
        abstract int passFee();
        String passOutput() {
            return passNumber + " (" + typeName() + ") pass fee " + passFee();
        }
    }

    static class Bike extends Vehicle {
        Bike(String pass, String owner) { super(pass, owner); }
        String typeName() { return "Bike"; }
        int passFee() { return 300; }
    }

    static class Car extends Vehicle {
        Car(String pass, String owner) { super(pass, owner); }
        String typeName() { return "Car"; }
        int passFee() { return 1000; }
    }

    static class EBike extends Vehicle implements Chargeable {
        EBike(String pass, String owner) { super(pass, owner); }
        String typeName() { return "EBike"; }
        int passFee() { return 300; }
        public boolean bookChargingBay() { return true; }
    }

    static class ECar extends Vehicle implements Chargeable {
        ECar(String pass, String owner) { super(pass, owner); }
        String typeName() { return "ECar"; }
        int passFee() { return 1000; }
        public boolean bookChargingBay() { return true; }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;
            String[] p = line.split("\\s+");
            if (p[0].equals("PASS") && p.length >= 4) {
                String type = p[1], pass = p[2];
                String owner = String.join(" ", Arrays.copyOfRange(p, 3, p.length));
                Vehicle v;
                switch (type.toLowerCase(Locale.ROOT)) {
                    case "bike": v = new Bike(pass, owner); break;
                    case "car": v = new Car(pass, owner); break;
                    case "ebike": v = new EBike(pass, owner); break;
                    case "ecar": v = new ECar(pass, owner); break;
                    default:
                        System.out.println("Invalid vehicle type");
                        continue;
                }
                vehicles.put(pass, v);
                System.out.println(v.passOutput());
            } else if (p[0].equals("CHARGE") && p.length == 2) {
                Vehicle v = vehicles.get(p[1]);
                if (v == null) System.out.println("Vehicle not found");
                else if (v instanceof Chargeable) System.out.println(v.passNumber + " charging bay allotted");
                else System.out.println(v.passNumber + " rejected: charging unsupported");
            } else {
                System.out.println("Invalid operation");
            }
        }
        sc.close();
    }
}
