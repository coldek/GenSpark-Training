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
