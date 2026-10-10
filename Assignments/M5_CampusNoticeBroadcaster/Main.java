import java.util.List;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        Student asha = new Student("Asha", "CSE", List.of(new EmailChannel(), new AppChannel()));
        Student ravi = new Student("Ravi", "ECE", List.of(new SmsChannel()));
        NoticeBoard board = new NoticeBoard(List.of(asha, ravi));
        board.post(new Notice("Lab Closed Tomorrow", Set.of("CSE")));
        board.post(new Notice("Fee Deadline Extended", Set.of("CSE", "ECE")));
        try {
            board.post(new Notice("Sports Day", Set.of()));
        } catch (IllegalArgumentException ex) {
            System.out.println("Cannot post notice: " + ex.getMessage());
        }
    }
}
