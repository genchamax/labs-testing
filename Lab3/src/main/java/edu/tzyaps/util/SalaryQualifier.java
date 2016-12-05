package edu.tzyaps.util;

import edu.tzyaps.util.enums.SalGrade;

/**
 * Created by Max on 30.11.2016.
 */
public interface SalaryQualifier {
    SalGrade getSalGrade(Integer salary);
}
