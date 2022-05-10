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