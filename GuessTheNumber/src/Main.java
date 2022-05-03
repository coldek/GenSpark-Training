import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Hello! What is your name?");

        String name = "John Doe";
        try {
            name = sc.nextLine();
        } catch (Exception e) {
            return;
        }

        while(true) {
            System.out.printf("Well, %s, I am thinking of a number between 1 and 20.\nTake a guess.%n", name);

            int answer = rand.nextInt(20);
            int guess = 0;
            int guesses = -1;

            while (answer != guess) {
                guess = 1;
                try {
                    guess = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Please pick a number between 1 and 20. Try again.");
                    sc.nextLine();
                    continue;
                }

                if (guess < answer) {
                    System.out.println("Your guess is too low.\nTake a guess.");
                } else if (guess > answer) {
                    System.out.println("Your guess is too high.\nTake a guess.");
                }

                guesses++;
            }

            System.out.printf("Good job, %s! You guessed my number in %s guesses!\nWould you like to play again? (y or n)\n", name, guesses);

            String isPlaying = sc.next();
            if(isPlaying.equalsIgnoreCase("n")){
                break;
            }
        }
    }
}