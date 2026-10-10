import java.time.LocalDate;
public class Main {
    public static void main(String[] args) {
        Student asha = new Student("Asha");
        Student ravi = new Student("Ravi");
        Assignment coding = new CodingAssignment("Linked List Lab", 50, LocalDate.of(2026, 3, 10));
        Assignment written = new WrittenAssignment("Design Essay", 50, LocalDate.of(2026, 3, 12));
        Submission s1 = new Submission(asha, coding, LocalDate.of(2026, 3, 10));
        Submission s2 = new Submission(ravi, written, LocalDate.of(2026, 3, 14));
        System.out.println("Asha's submission for 'Linked List Lab' received (on time). Status: Submitted.");
        System.out.println("Ravi's submission for 'Design Essay' received (2 days late). Status: Submitted.");
        s1.grade(45);
        s2.grade(40);
        s1.resubmit(LocalDate.of(2026, 3, 11));
    }
}
