import java.util.LinkedHashMap;
import java.util.Map;
public class Attempt {
    private final Student student;
    private final Examination exam;
    private final Map<String, String> answers = new LinkedHashMap<>();
    private boolean submitted;
    public Attempt(Student student, Examination exam) {
        this.student = student; this.exam = exam;
        System.out.println(exam.getTitle() + " started by " + student.getName() + ".");
    }
    public void answer(String questionId, String answer) {
        if (submitted) { System.out.println("Cannot change answers for a submitted examination."); return; }
        boolean exists = exam.getQuestions().stream().anyMatch(q -> q.getId().equals(questionId));
        if (!exists) { System.out.println("Unknown question: " + questionId); return; }
        answers.put(questionId, answer);
        System.out.println("Answer recorded for " + questionId + ".");
    }
    public void submit() {
        if (submitted) { System.out.println("Examination already submitted."); return; }
        submitted = true;
        int total = 0, possible = 0;
        for (Question q : exam.getQuestions()) {
            possible += q.getPoints();
            boolean correct = q.isCorrect(answers.getOrDefault(q.getId(), ""));
            int earned = correct ? q.getPoints() : 0;
            total += earned;
            System.out.println("Result: " + q.getId() + ": " + (correct ? "Correct" : "Incorrect") +
                " (" + earned + " points)");
        }
        System.out.println(exam.getTitle() + " submitted by " + student.getName() + ".");
        System.out.println("Total score: " + total + "/" + possible + ".");
    }
}
