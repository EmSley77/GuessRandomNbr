package se.emanuel.guessnumber;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.util.InputMismatchException;
import java.util.Random;
//Emanuel sleyman
// 2024-03-16
@Service
@SessionScope
public class GuessNumberService {

    private int randomNumber;
    private boolean active = true;
    private int count = 0;
    private final Random random = new Random();

    public int generateNumber() {
        if (randomNumber == 0) {
            randomNumber = random.nextInt(100) + 1;
        }
        return randomNumber;
    }

    public void resetGame() {
        randomNumber = 0;
        count = 0;
        generateNumber();
    }

    public String guessNumber(int guess) {
            try {
                int number = generateNumber();
                if (guess == number) {
                    count++;
                    return "Correct, you got it right!!. Amount of tries:" + count;
                }
                else if (guess > number) {
                    count++;
                    return "Lower";
                }
                else {
                    count++;
                    return "Higher";
                }
            } catch (InputMismatchException e) {
                 throw new InputMismatchException("You must input numbers, not letters or other types!!");
            }
    }
}
