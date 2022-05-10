import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        System.out.println("Hello! What is your name?");

        // Assign name.
        String name = "John Doe";
        try {
            name = sc.nextLine();
        } catch (Exception e) {
            return;
        }

        // Game loop
        while(true) {
            System.out.printf("Well, %s, I am thinking of a number between 1 and 20.\nTake a guess.\n", name);

            // Game instance
            Game game = new Game(name);

            int guess = 0;
            do {
                try {
                    guess = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Please pick a number between 1 and 20. Try again.");
                    sc.nextLine();
                    continue;
                }

                if(guess != game.number) System.out.println(game.hotCold(guess));
            } while (!game.guess(guess));

            System.out.printf("Good job, %s! You guessed my number in %s guesses!\nWould you like to play again? (y or n)\n", name, game.getGuesses());
            try {
                String isPlaying = sc.next();
                if(isPlaying.equalsIgnoreCase("n")){
                    break;
                }
            } catch (Exception e) {
                break;
            }

        }
    }
}