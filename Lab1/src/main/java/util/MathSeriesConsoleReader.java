package util;

/**
 * Created by Max on 11.10.2016.
 */
public class MathSeriesConsoleReader extends ConsoleReader {
    public int readIntWhileCorrect() {
        try {
            System.out.println("Enter precision:");
            int precision = readInt();
            if (!doesUserAgreeToContinue(precision))
                throw new IllegalArgumentException("Aborting by user");
            return precision;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readIntWhileCorrect();
        }
    }

    public double readDoubleWhileCorrect() {
        try {
            System.out.println("Enter variable:");
            return readDouble();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readDoubleWhileCorrect();
        }
    }

    private boolean doesUserAgreeToContinue(int precision) {
        if (precision >= 1000) {
            System.out.println("The calculation will take long time. Continue calculation ? (Yes/No)");
            String userAnswer = read();

            if (userAnswer.equalsIgnoreCase("yes"))
                return true;
            else if (userAnswer.equalsIgnoreCase("no")) {
                return false;
            } else {
                System.out.println("Wrong input " + userAnswer + ". Please type \"Yes\" or \"No\" (in any case)");
                return doesUserAgreeToContinue(precision);
            }
        }
        return true;
    }
}