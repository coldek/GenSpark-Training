# GuessTheNumber

> ![Output](https://i.imgur.com/AUFtrou.png)

Main

```java
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
```

Game

```java
import java.util.Random;

public class Game {
    public static String HIGH = "Your guess is too high.\nTake a guess.";
    public static String LOW = "Your guess is too low.\nTake a guess.";
    public final int number;
    public final String name;
    private int guesses = 0;

    public Game(String name) {
        Random rand = new Random();
        this.number = rand.nextInt(19) + 1;
        this.name = name;
    }

    public boolean guess(int num) {
        this.guesses++;

        return this.number == num;
    }

    public int getGuesses() {
        return this.guesses;
    }

    public String hotCold(int guess) {
        return (guess > this.number) ? HIGH: LOW;
    }
}
```

GameTest

```java
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class GameTest {
    static Game game;

    @BeforeAll()
    static void beforeAll() {
        System.out.print("Games with: ");
    }

    @BeforeEach
    void beforeEach() {
        game = new Game("Adam");
    }

    @DisplayName("Test a guess")
    @Test
    void guess() {
        assertTrue(game.guess(game.number), "Failed correct guess");
    }

    @DisplayName("Test total guesses")
    @Test
    void getGuesses() {
        game.guess(20);
        assertEquals(1, game.getGuesses(), "Get guesses check failed");
    }

    @DisplayName("Test if hot cold is accurate")
    @Test
    void hotCold() {
        String out = game.hotCold(10);

//        Describes behavior of the method itself!
        if(10 > game.number) {
            assertEquals(Game.HIGH, out, "Failed hot cold test.");
        } else {
            assertEquals(Game.LOW, out, "Failed hot cold test.");
        }
    }

    @DisplayName("Test name")
    @Test
    void testName() {
        assertEquals("Adam", game.name, "Name check failed.");
    }

    @AfterEach
    void tearDown() {
        System.out.print(game.number + " ");
    }
}
```
