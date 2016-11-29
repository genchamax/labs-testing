import org.junit.Assert;
import org.junit.Test;
import util.Calculator;

/**
 * Created by Max on 23.11.2016.
 */
public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    public void emptyStringTest() {
        Assert.assertEquals(0, calculator.add(""));
    }

    @Test
    public void oneArgumentComaTest() {
        Assert.assertEquals(42, calculator.add("42"));
    }

    @Test
    public void twoArgumentComaTest() {
        Assert.assertEquals(4, calculator.add("2, 2"));
    }

    @Test
    public void argumentWithNewLineSeparateTest() {
        Assert.assertEquals(4, calculator.add("1 \n 2\n 1\n"));
    }

    @Test
    public void fewArgumentsTest() {
        Assert.assertEquals(5, calculator.add("1, 2, 1, 1"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void wrongInputTest() {
        Assert.assertEquals(1, calculator.add("1,fdfd,6"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void notIntegerNumber() {
        Assert.assertEquals(1, calculator.add("1.2, 3"));
    }

    @Test
    public void underZeroTest() {
        Assert.assertEquals(-2, calculator.add("-1 \n -1"));
    }

    @Test
    public void redTest() {
        Assert.assertNotEquals(4, calculator.add("1, 1, \n 3"));
    }

    @Test
    public void redTest2() {
        Assert.assertNotEquals(3, "2, 2");
    }
}
