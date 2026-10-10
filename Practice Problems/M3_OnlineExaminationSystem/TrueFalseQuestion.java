public class TrueFalseQuestion extends Question {
    private final boolean correct;
    public TrueFalseQuestion(String id, String prompt, int points, boolean correct) {
        super(id, prompt, points); this.correct = correct;
    }
    public boolean isCorrect(String answer) { return Boolean.toString(correct).equalsIgnoreCase(answer); }
}
