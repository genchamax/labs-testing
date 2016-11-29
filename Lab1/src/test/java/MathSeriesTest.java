import org.junit.Assert;
import org.junit.Test;
import util.Calculator;

/**
 * Created by Max on 28.09.2016.
 */

public class MathSeriesTest extends Assert {

    private Calculator calculator = new Calculator();

    @Test(expected = IllegalArgumentException.class)
    public void testPrecision() {
        calculator.calculateMathSeries(12, -1);
    }

    @Test
    public void testCorrectCalc1() {
        double x = 50.11641;
        int n = 100;
        assertEquals(Math.cos(x), calculator.calculateMathSeries(x, n).doubleValue(), 0.000001);
    }

    @Test
    public void testCorrectCalc2() {
        double x = 0;
        int n = 0;
        assertEquals(Math.cos(x), calculator.calculateMathSeries(x, n).doubleValue(), 0.000000000000000000000001);
    }

    @Test
    public void testCorrectCalc3() {
        assertEquals(1, calculator.calculateMathSeries(0, 1).doubleValue(), 0.0001);
    }
}
