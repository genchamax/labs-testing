package stubs.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Max on 30.11.2016.
 */
public class DepartmentStub {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    private Integer deptId;
    private String departmentName;
    private String location;

    public DepartmentStub(){}

    public DepartmentStub(Integer deptId, String departmentName, String location) {
        this.deptId = deptId;
        this.departmentName = departmentName;
        this.location = location;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
