package stubs.service;

import stubs.model.DepartmentStub;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Max on 30.11.2016.
 */
public class DepatrmentServiceStub {

    public List<DepartmentStub> getAll() {
        List<DepartmentStub> departments = new ArrayList<DepartmentStub>();
        departments.add(new DepartmentStub(1, "INSPECTOR", "KIEV"));
        departments.add(new DepartmentStub(2, "OPERATOR", "NEW YORK"));
        departments.add(new DepartmentStub(3, "SECURITY", "LONDON"));

        return departments;
    }

    public DepartmentStub getById(Integer id) {
        if (id.equals(1)) {
            return new DepartmentStub(1, "INSPECTOR", "KIEV");
        } else if (id.equals(2)) {
            return new DepartmentStub(2, "OPERATOR", "NEW YORK");
        } else if (id.equals(3)) {
            return new DepartmentStub(3, "SECURITY", "LONDON");
        } else
            return new DepartmentStub(4, "TEST", "ZHMERINKI");
    }
}
