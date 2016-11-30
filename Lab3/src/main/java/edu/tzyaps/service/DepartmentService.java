package edu.tzyaps.service;

import edu.tzyaps.model.Department;
import org.springframework.stereotype.Service;

/**
 * Created by Max on 30.11.2016.
 */
@Service("departmentService")
public class DepartmentService extends BasicService {
    public DepartmentService() {
        super(Department.class);
    }
}