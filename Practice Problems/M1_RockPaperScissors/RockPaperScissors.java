import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static String generateComputerMove(Random random) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        return moves[random.nextInt(moves.length)];
    }

    public static String normalizeMove(String move) {
        if (move.equalsIgnoreCase("rock")) {
            return "Rock";
        }
        if (move.equalsIgnoreCase("paper")) {
            return "Paper";
        }
        if (move.equalsIgnoreCase("scissors")) {
            return "Scissors";
        }
        return "";
    }

    public static void printSummary(int wins, int losses, int draws, int rounds) {
        double winPercentage = (wins * 100.0) / rounds;

        System.out.println("\nFinal Summary");
        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win %% = %.1f%%%n", winPercentage);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Enter number of rounds: ");
        int rounds = scanner.nextInt();
        scanner.nextLine();

        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.println("\nRound | Player Move | Computer Move | Result");

        for (int round = 1; round <= rounds; round++) {
            String playerMove;

            do {
                System.out.print("Round " + round + " - Enter Rock/Paper/Scissors: ");
                playerMove = normalizeMove(scanner.nextLine());
            } while (playerMove.isEmpty());

            String computerMove = generateComputerMove(random);
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.printf(
                "%d | %s | %s | %s%n",
                round, playerMove, computerMove, result
            );
        }

        printSummary(wins, losses, draws, rounds);
        scanner.close();
    }
}
