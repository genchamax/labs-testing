package util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Max on 27.09.2016.
 */
public class Calculator {

    private static final Logger LOGGER = LoggerFactory.getLogger(Calculator.class);

    public BigDecimal calculateMathSeries(double variable, int precision) {

        if (precision < 0) {
            LOGGER.error("Precision less than zero: {}", precision);
            throw new IllegalArgumentException("Precision should be greater than zero");
        }

        BigDecimal result = new BigDecimal(0);

        for (int i = 0; i <= precision; i++) {

            BigDecimal firstOperand = BigDecimal.valueOf((Math.pow(-1, i)));
            BigDecimal secondOperand = new BigDecimal(variable).pow(2 * i);
            BigDecimal thirdOperand = fact(2 * i);

            LOGGER.trace("===================== {} =====================", i);
            LOGGER.trace("First operand: {}", firstOperand);
            LOGGER.trace("Second operand: {}", secondOperand);
            LOGGER.trace("Third operand (factorial(2*i)): {}", thirdOperand);

            result = result.add(firstOperand.multiply(secondOperand).divide(thirdOperand, 20, RoundingMode.HALF_UP));
            LOGGER.trace("Interim results: {}", result);
            LOGGER.trace("=============================================");

        }
        return result;
    }

    private BigDecimal fact(int number) {
        if (number < 2)
            return new BigDecimal(1);

        BigDecimal result = new BigDecimal(number);
        BigDecimal temp = new BigDecimal(number);

        for (int i = number - 1; i > 0; i--) {
            result = result.multiply(temp.subtract(BigDecimal.valueOf(i)));
        }

        return result;
    }
}