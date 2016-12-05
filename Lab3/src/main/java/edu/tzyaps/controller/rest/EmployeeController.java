package edu.tzyaps.controller.rest;

import edu.tzyaps.model.Department;
import edu.tzyaps.service.EmployeeService;
import edu.tzyaps.util.SalaryCalculator;
import edu.tzyaps.util.SalaryQualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Max on 30.11.2016.
 */
@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private SalaryCalculator salaryCalculator;

    @Autowired
    private SalaryQualifier salaryQualifier;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getEmployeeById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.getById(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity createNewEmployee(@RequestBody Department department) {
        if (employeeService.create(department) != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteEmployeeById(@PathVariable("id") Integer id) {
        employeeService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @RequestMapping(value = "/salgrade/{id}", method = RequestMethod.GET)
    public ResponseEntity getSalgradeById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.getSalgradeById(id, salaryQualifier));
    }

    @RequestMapping(value = "/salgrade/full/{id}", method = RequestMethod.GET)
    public ResponseEntity getFullSalgradeById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(employeeService.getFullSalgradeById(id, salaryCalculator, salaryQualifier));
    }


}
