import util.Calculator;
import util.ConsoleReader;

/**
 * Created by Max on 28.09.2016.
 */
public class Main {
    public static void main(String[] args) {
        ConsoleReader reader = new ConsoleReader();

        System.out.println("Enter x:");
        double x = reader.readDouble();
        System.out.println("Enter n:");
        int n = reader.readInt();

        Calculator calculator = new Calculator();

        System.out.println(calculator.calculateMathSeries(x, n));
        System.out.println(Math.cos(x));
    }
}
