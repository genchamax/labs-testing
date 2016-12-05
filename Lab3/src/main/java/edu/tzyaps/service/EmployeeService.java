package edu.tzyaps.service;

import edu.tzyaps.model.Employee;
import edu.tzyaps.util.SalaryCalculator;
import edu.tzyaps.util.SalaryQualifier;
import edu.tzyaps.util.enums.SalGrade;
import org.springframework.stereotype.Service;

/**
 * Created by Max on 30.11.2016.
 */
@Service("employeeService")
public class EmployeeService extends BasicService {

    public EmployeeService() {
        super(Employee.class);
    }

    public SalGrade getSalgradeById(Integer employeeId, SalaryQualifier qualifier) {
        Employee employee = (Employee) getById(employeeId);
        return qualifier.getSalGrade(employee.getSalary());
    }

    public SalGrade getFullSalgradeById(Integer employeeId, SalaryCalculator calculator, SalaryQualifier qualifier) {
        Employee employee = (Employee) getById(employeeId);
        Integer salary = employee.getSalary();
        Integer commission = employee.getCommission();
        Integer fullSalary = calculator.getFullSalary(salary, commission);
        return qualifier.getSalGrade(fullSalary);
    }
}
