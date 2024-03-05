import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {
    static int mysteryNumber;
    static int guessRemaining = 25;
    static int noMoreGuesses = 0;
    static int yourGuess;
    static int userGuessedNumber = 0;
    static boolean isPlaying = true;


    public static void main(String[] args) {
        while (true) {
            if (toPlay().equals("no")) {
                endTheGame();
            }
            mysteryNumber = chosenMysteryNumber();
            guessRemaining = 25;
            System.out.println("The Mystery Number is between 1 and 10,000! Good luck :)");
            while (guessRemaining > noMoreGuesses) {
                yourNumberGuess();
                checkingAgainstTheMysteryNumber();
                didYouWin();
                if (!isPlaying) break;
            }
        }
    }

    public static int chosenMysteryNumber() {
        int max = 10000, min = 1;
        return min + (int) (Math.random() * (max - min + 1));
    }


    public static void checkingAgainstTheMysteryNumber() {
        if (yourGuess == mysteryNumber) {
            didYouWin();
        } else if (yourGuess > mysteryNumber){
            System.out.println("The number is lower!");
        System.out.println("You have " + guessRemaining-- + " remaining");
    } else{
        System.out.println("The number is higher!");
        System.out.println("You have " + guessRemaining-- + " remaining");
    }
}





//SCANNERS
    public static String toPlay() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Do you want to play? Yes/No");
        //todo handle any input thats not yes or no
        return scan.next().toLowerCase();
    }
    public static int yourNumberGuess() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter any number : ");
        yourGuess = scan.nextInt();
        System.out.println("You typed : " + yourGuess);
        return yourGuess;
    }
//SCANNERS

//END GAME RESULTS
    public static void didYouWin() {
        if (userGuessedNumber == mysteryNumber){
            System.out.println("You won!");
        } else if(guessRemaining == 0){
            System.out.println("You're our of guesses... LOSER!!!");
        }
    }
    public static void endTheGame () {
            System.out.println("Goodbye!");
        }
    }
//END GAME RESULTS
