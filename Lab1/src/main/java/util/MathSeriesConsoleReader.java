package util;

/**
 * Created by Max on 11.10.2016.
 */
public class MathSeriesConsoleReader extends ConsoleReader {
    public int readIntWhileCorrect() {
        try {
            System.out.println("Enter n:");
            return readInt();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readIntWhileCorrect();
        }
    }

    public double readDoubleWhileCorrect() {
        try {
            System.out.println("Enter x:");
            return readDouble();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readDoubleWhileCorrect();
        }
    }
}
