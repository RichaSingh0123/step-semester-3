import java.time.LocalDate;
public class Submission {
    public enum Status { SUBMITTED, GRADED }
    private final Student student;
    private final Assignment assignment;
    private final LocalDate submissionDate;
    private Status status = Status.SUBMITTED;
    private Double finalMarks;

    public Submission(Student student, Assignment assignment, LocalDate submissionDate) {
        this.student = student; this.assignment = assignment; this.submissionDate = submissionDate;
    }
    public Status getStatus() { return status; }
    public void grade(double awardedMarks) {
        if (status == Status.GRADED) {
            System.out.println("Cannot grade/resubmit: '" + assignment.getTitle() + "' has already been graded.");
            return;
        }
        if (awardedMarks < 0 || awardedMarks > assignment.getMaxMarks()) {
            throw new IllegalArgumentException("Awarded marks must be between 0 and maximum marks.");
        }
        long lateDays = Math.max(0, java.time.temporal.ChronoUnit.DAYS.between(
            assignment.getDueDate(), submissionDate));
        finalMarks = assignment.applyLatePenalty(awardedMarks, lateDays);
        status = Status.GRADED;
        if (lateDays == 0) {
            System.out.printf("%s graded: %.0f/%.0f.%n", student.getName(), finalMarks, assignment.getMaxMarks());
        } else {
            System.out.printf("%s graded: %.0f/%.0f after %.0f%% late penalty.%n",
                student.getName(), finalMarks, assignment.getMaxMarks(),
                Math.min(100, (assignment instanceof CodingAssignment ? 10 : 20) * lateDays));
        }
        System.out.println("Status: Graded.");
    }
    public void resubmit(LocalDate newDate) {
        if (status == Status.GRADED) {
            System.out.println("Cannot resubmit: '" + assignment.getTitle() + "' has already been graded.");
        } else {
            System.out.println("Resubmission recorded for " + assignment.getTitle() + ".");
        }
    }
}
