package isc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MenuPublicTest {

    @Test
    @DisplayName("getUserChoice should retry until a valid option is entered")
    void getUserChoiceRetriesUntilValid() {
        String input = "x\n4\n2\n";
        Menu menu = new Menu(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        int choice = menu.getUserChoice();

        assertEquals(2, choice);
    }

    @Test
    @DisplayName("askToPlayAgain should return true for y")
    void askToPlayAgainAcceptsYes() {
        String input = "y\n";
        Menu menu = new Menu(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        assertTrue(menu.askToPlayAgain());
    }

    @Test
    @DisplayName("askToPlayAgain should return false for n")
    void askToPlayAgainAcceptsNo() {
        String input = "n\n";
        Menu menu = new Menu(new ByteArrayInputStream(input.getBytes(StandardCharsets.UTF_8)));

        assertFalse(menu.askToPlayAgain());
    }
}
