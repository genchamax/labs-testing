package edu.tzyaps.util.calculator;

import edu.tzyaps.util.enums.SalGrade;

/**
 * Created by Max on 30.11.2016.
 */
public interface SalaryCalculator {

    Integer getFullSalary(Integer salary, Integer commission);

    SalGrade getSalGrade(Integer salary);
}
