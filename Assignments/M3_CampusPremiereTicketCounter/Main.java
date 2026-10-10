import java.util.List;
public class Main {
    public static void main(String[] args) {
        Show show = new Show("7 PM");
        Customer asha = new Customer("Asha"), ravi = new Customer("Ravi"), neha = new Customer("Neha");
        Booking a = new Booking(asha, show, List.of(new RegularSeat("A1"), new RegularSeat("A2"), new PremiumSeat("F5")));
        a.confirm();
        new Booking(ravi, show, List.of(new RegularSeat("A2"))).confirm();
        new Booking(ravi, show, List.of(new ReclinerSeat("R1"))).confirm();
        a.cancel();
        new Booking(neha, show, List.of(new RegularSeat("A2"))).confirm();
    }
}
