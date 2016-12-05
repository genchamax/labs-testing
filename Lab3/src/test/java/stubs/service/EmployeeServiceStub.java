package stubs.service;

import edu.tzyaps.util.SalaryCalculator;
import edu.tzyaps.util.SalaryQualifier;
import edu.tzyaps.util.enums.SalGrade;
import org.springframework.beans.factory.annotation.Autowired;
import stubs.model.EmployeeStub;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 30.11.2016.
 */
public class EmployeeServiceStub {

    @Autowired
    private SalaryCalculator salaryCalculator;

    public List<EmployeeStub> getAll() {
        List<EmployeeStub> employeeStubs = new ArrayList<EmployeeStub>();
        employeeStubs.add(new EmployeeStub(1, "MAX", "CLERK", 2000, 10));
        employeeStubs.add(new EmployeeStub(2, "FFF", "JOB", 1254, 0));
        employeeStubs.add(new EmployeeStub(3, "DONALD", "PRESIDENT", 5120, 200));

        return employeeStubs;
    }

    public EmployeeStub getById(Integer id) {
        if (id.equals(1)) {
            return new EmployeeStub(1, "MAX", "CLERK", 2000, 10);
        } else if (id.equals(2)) {
            return new EmployeeStub(2, "FFF", "JOB", 1254, 0);
        } else if (id.equals(3)) {
            return new EmployeeStub(3, "DONALD", "PRESIDENT", 5120, 200);
        } else
            return new EmployeeStub(4, "TEST", "TEST_JOB", 1254, 500);
    }

    public SalGrade getSalgradeById(Integer employeeId, SalaryQualifier qualifier) {
        EmployeeStub employee = (EmployeeStub) getById(employeeId);
        return qualifier.getSalGrade(employee.getSalary());
    }

    public SalGrade getFullSalgradeById(Integer employeeId, SalaryCalculator calculator, SalaryQualifier qualifier) {
        EmployeeStub employee = (EmployeeStub) getById(employeeId);
        Integer salary = employee.getSalary();
        Integer commission = employee.getCommission();
        Integer fullSalary = calculator.getFullSalary(salary, commission);
        return qualifier.getSalGrade(fullSalary);
    }
}
