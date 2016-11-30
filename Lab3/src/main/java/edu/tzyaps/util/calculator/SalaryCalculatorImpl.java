package edu.tzyaps.util.calculator;

import edu.tzyaps.util.enums.SalGrade;
import org.springframework.stereotype.Component;

/**
 * Created by Max on 30.11.2016.
 */
@Component
public class SalaryCalculatorImpl implements SalaryCalculator {
    public Integer getFullSalary(Integer salary, Integer commission) {
        if (commission == null)
            commission = 0;
        return salary + commission;
    }

    public SalGrade getSalGrade(Integer salary) {
        if (salary <= 1500)
            return SalGrade.LOW;
        else if (salary >= 3000)
            return SalGrade.HIGHT;
        else
            return SalGrade.MIDDLE;
    }
}
