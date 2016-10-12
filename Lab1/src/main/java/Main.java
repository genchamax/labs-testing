import util.Calculator;
import util.MathSeriesConsoleReader;

import java.io.IOException;

/**
 * Created by Max on 28.09.2016.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        MathSeriesConsoleReader reader = new MathSeriesConsoleReader();
        Calculator calculator = new Calculator();

        double x = reader.readDoubleWhileCorrect();
        int n = reader.readIntWhileCorrect();

        System.out.println(calculator.calculateMathSeries(x, n));
    }
}

