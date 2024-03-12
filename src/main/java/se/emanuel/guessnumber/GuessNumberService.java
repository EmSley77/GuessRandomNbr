package se.emanuel.guessnumber;


import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.Random;

@Service
@SessionScope
public class GuessNumberService {
    private int randomNumber;
    private boolean active;

    public int generateNumberIfNeeded() {
        if (randomNumber == 0) {
            Random random = new Random();
            randomNumber = random.nextInt(100) + 1;
        }
        return randomNumber;
    }

    public String guessNumber(int guess) {
        int number = generateNumberIfNeeded();

        if (guess == number) {
            active = false;
            return "Correct, bra gissat!";
        } else if (guess > number) {
            return "too big";
        } else {
            return "too small";
        }
    }
}
