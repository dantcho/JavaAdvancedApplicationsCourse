package _01_JavaAdvancedJavaSyntaxHomework;


import java.util.Scanner;

public class _11_GameofNames {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int numberOfPlayers = scanner.nextInt();
        String[] players = new String[numberOfPlayers];
        int[] playerScore = new int[numberOfPlayers];
        scanner.nextLine();
        for (int i = 0; i < numberOfPlayers; i++) {
            players[i] = scanner.nextLine();
            playerScore[i] = scanner.nextInt();
            scanner.nextLine();
        }
        for (int i = 0; i < numberOfPlayers; i++) {
            int calculatedScore = scoreCalculate(players[i]);
            playerScore[i]+=calculatedScore;
        }
        int winner= findWinner(playerScore);
        System.out.printf("The winner is %s - %d points",players[winner],playerScore[winner]);
    }

    private static int findWinner(int[] playerScore) {
        int index=0;
        int biggest = new Integer(Integer.MIN_VALUE);
        for (int i = 0; i < playerScore.length; i++) {
            if (playerScore[i]>biggest){
                index=i;
                biggest=playerScore[i];
            }
        }
        return index;
    }

    private static int scoreCalculate(String playerName) {
        int playerLen = playerName.length();
        int sum = 0;
        for (int i = 0; i < playerLen; i++) {
            int number = playerName.charAt(i);
            if (number%2!=0){
                number*=-1;
            }
            sum+=number;
        }
        return sum;
    }
}


