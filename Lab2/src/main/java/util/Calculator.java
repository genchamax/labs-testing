package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 23.11.2016.
 */
public class Calculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Calculator.class);
    private ConsoleReader reader = new ConsoleReader();

    public int add(String numbers) {
        int result = 0;

        if (numbers.isEmpty()) {
            LOGGER.warn("String is empty");
            return 0;
        }

        List<Integer> numbersList = getNumberListFromString(numbers);

        for (int number :
                numbersList) {
            result += number;
        }

        return result;
    }

    public int addWithConsoleInput() {
        int result = 0;
        String input;
        while (!(input = reader.read()).equalsIgnoreCase("end")) {
            result += add(input);
        }

        return result;
    }

    private List<Integer> getNumberListFromString(String numbers) {
        LOGGER.trace("Input string {}", numbers);

        List<Integer> result = new ArrayList<>();

        String[] splitedNumbers = numbers.split("[\\p{Space},]+");

        for (String number :
                splitedNumbers) {
            try {
                result.add(
                        Integer.parseInt(number)
                );
            } catch (NumberFormatException e) {
                LOGGER.error("{} not a number", number);
                throw new IllegalArgumentException(number + " not a number");
            }
        }

        return result;
    }


}
