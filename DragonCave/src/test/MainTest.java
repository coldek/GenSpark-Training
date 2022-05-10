import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class MainTest {

    @BeforeAll
    static void setUp() {
        System.out.println("Setting up test");
    }

    @DisplayName("Test win state")
    @Test
    void testWin() {
        assertTrue(Main.rightCave(Main.answer), "Failed win state");
    }

    @DisplayName("Test lose state")
    @Test
    void testLose() {
        // Logically, this will always be wrong if the function is working correctly.
        assertFalse(Main.rightCave(Main.answer + 1), "Failed lose state");
    }

    @AfterEach
    void tearDown() {
    }
}