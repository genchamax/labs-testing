package edu.tzyaps.util;

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
}
