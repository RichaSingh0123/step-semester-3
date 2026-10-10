public class ShortAnswerQuestion extends Question {
    private final String correct;
    public ShortAnswerQuestion(String id, String prompt, int points, String correct) {
        super(id, prompt, points); this.correct = correct;
    }
    public boolean isCorrect(String answer) { return correct.equalsIgnoreCase(answer.trim()); }
}
