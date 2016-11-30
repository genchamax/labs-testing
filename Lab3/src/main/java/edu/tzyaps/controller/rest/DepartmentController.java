package edu.tzyaps.controller.rest;

import edu.tzyaps.model.Department;
import edu.tzyaps.model.Employee;
import edu.tzyaps.service.DepartmentService;
import edu.tzyaps.util.calculator.SalaryCalculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Max on 30.11.2016.
 */
@RestController
@RequestMapping("/api/departments/")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity getAllDepartments() {
        return ResponseEntity.ok(departmentService.getAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getDepartmentById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(departmentService.getById(id));
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ResponseEntity createNewDepartment(@RequestBody Department department) {
        if (departmentService.create(department) != null) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteDepartmentById(@PathVariable("id") Integer id) {
        departmentService.deleteById(id);
        return ResponseEntity.ok().build();
    }

}
