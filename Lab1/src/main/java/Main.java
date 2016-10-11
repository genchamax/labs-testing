import util.MathSeriesConsoleReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by Max on 28.09.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        MathSeriesConsoleReader reader = new MathSeriesConsoleReader();
//        ConsoleReader reader = new ConsoleReader();

//        System.out.println("Enter x:");
        double x = reader.readDoubleWhileCorrect();
//        System.out.println("Enter n:");
        int n = reader.readIntWhileCorrect();

//        Calculator calculator = new Calculator();
//        ConsoleReader ds = new ConsoleReader();
//        while (true) {
//            System.out.println(ds.read());
//        }
//        System.out.println(calculator.calculateMathSeries(x));
    }
}
