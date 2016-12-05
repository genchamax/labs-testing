package stubs.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by Max on 30.11.2016.
 */
public class EmployeeStub {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public EmployeeStub() {
    }

    public EmployeeStub(Integer employeeId, String ename, String job, Integer salary, Integer commission) {
        this.employeeId = employeeId;
        this.ename = ename;
        this.job = job;
        this.salary = salary;
        this.commission = commission;
    }

    private Integer employeeId;
    private String ename;
    private String job;
    private Integer salary;
    private Integer commission;


    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    @Override
    public String toString() {
        return GSON.toJson(this);
    }
}
