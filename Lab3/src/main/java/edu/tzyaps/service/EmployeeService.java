package edu.tzyaps.service;

import edu.tzyaps.model.Employee;
import edu.tzyaps.util.calculator.SalaryCalculator;
import edu.tzyaps.util.enums.SalGrade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Max on 30.11.2016.
 */
@Service("employeeService")
public class EmployeeService extends BasicService {
    @Autowired
    private SalaryCalculator salaryCalculator;

    public EmployeeService() {
        super(Employee.class);
    }

    public SalGrade getSalgradeById(Integer employeeId) {
        Employee employee = (Employee) getById(employeeId);
        return salaryCalculator.getSalGrade(employee.getSalary());
    }

    public SalGrade getFullSalgradeById(Integer employeeId) {
        Employee employee = (Employee) getById(employeeId);
        Integer salary = employee.getSalary();
        Integer commission = employee.getCommission();
        Integer fullSalary = salaryCalculator.getFullSalary(salary, commission);
        return salaryCalculator.getSalGrade(fullSalary);
    }
}
