package edu.tzyaps.util;

import edu.tzyaps.util.enums.SalGrade;
import org.springframework.stereotype.Component;

/**
 * Created by Max on 30.11.2016.
 */
@Component
public class SalaryQuilifierImpl implements SalaryQualifier {
    public SalGrade getSalGrade(Integer salary) {
        if (salary <= 1500)
            return SalGrade.LOW;
        else if (salary >= 3000)
            return SalGrade.HIGHT;
        else
            return SalGrade.MIDDLE;
    }
}
