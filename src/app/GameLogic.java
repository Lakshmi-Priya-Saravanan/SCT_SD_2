package app;

import java.util.Random;

public class GameLogic {

    private int randomNumber;

    public GameLogic() {
        generateNumber();
    }

    public void generateNumber() {
        randomNumber = new Random().nextInt(100) + 1;
    }

    public String checkGuess(int guess) {
        if (guess > randomNumber) {
            return "Too High!";
        } else if (guess < randomNumber) {
            return "Too Low!";
        } else {
            return "Correct! You guessed it!";
        }
    }
}

