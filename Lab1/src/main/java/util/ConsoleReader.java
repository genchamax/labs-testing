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
            LOGGER.info("Read number {} from console.", result);
            return result;
        } catch (NumberFormatException e) {
            LOGGER.error("String {} not a number.", input);
            throw new IllegalArgumentException("Incorrect input. String " + input + "not a number");
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
            throw new IllegalArgumentException("Incorrect input. String " + input + "not a integer number");
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
