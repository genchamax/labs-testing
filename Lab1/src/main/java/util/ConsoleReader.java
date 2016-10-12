package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Max on 27.09.2016.
 */
public class ConsoleReader {

    private static Logger LOGGER = LoggerFactory.getLogger(ConsoleReader.class);

    public double readDouble() {
        String input = read();

        try {
            double result = Double.parseDouble(input);

            if (result == Double.POSITIVE_INFINITY) {
                LOGGER.error("Number {} is too large", input);
                throw new IllegalArgumentException("Number " + input + " is too large. Maximal value is " + Double.MAX_VALUE);
            }

            if (result == Double.NEGATIVE_INFINITY) {
                LOGGER.error("Number {} is too small", input);
                throw new IllegalArgumentException("Number " + input + " is too small. Minimal value is " + Double.MIN_VALUE);
            }

            LOGGER.info("Read number {} from console.", result);
            return result;
        } catch (NumberFormatException e) {
            LOGGER.error("String {} not a number.", input);
            throw new IllegalArgumentException("Incorrect input. String " + input + " not a number");
        }
    }

    public int readInt() {
        String input = read();

        try {
            int result = Integer.parseInt(input);
            LOGGER.info("Read number {} from console.", result);
            return result;
        } catch (NumberFormatException e) {
            LOGGER.error("String {} not a integer number.", input);
            throw new IllegalArgumentException("Incorrect input. String " + input +
                    " not a integer number ([" + Integer.MIN_VALUE + ", " + Integer.MAX_VALUE + "])");
        }
    }

    public String read() {
        String result = "";
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        LOGGER.trace("Initialize reading from console");
        try {
            result = bf.readLine();
            LOGGER.info("Read from console string {}", result);
        } catch (IOException e) {
            LOGGER.error("Can't read from console: {}", e.getMessage());
        }
        return result;
    }
}
