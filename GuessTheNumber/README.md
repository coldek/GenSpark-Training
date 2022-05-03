# GuessTheNumber
>![Output](https://i.imgur.com/AUFtrou.png)
```java
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rand = new Random();

        System.out.println("Hello! What is your name?");

        String name = sc.nextLine();

        while(true) {
            System.out.printf("Well, %s, I am thinking of a number between 1 and 20.\nTake a guess.%n", name);

            int answer = rand.nextInt(20);
            int guess = 0;
            int guesses = -1;

            while (answer != guess) {
                guess = sc.nextInt();

                if (guess < answer) {
                    System.out.println("Your guess is too low.\nTake a guess.");
                } else if (guess > answer) {
                    System.out.println("Your guess is too high.\nTake a guess.");
                }

                guesses += 1;
            }

            System.out.printf("Good job, %s! You guessed my number in %s guesses!\nWould you like to play again? (y or n)\n", name, guesses);

            String isPlaying = sc.next();
            if(isPlaying.equalsIgnoreCase("n")){
                break;
            }
        }
    }
}
```
