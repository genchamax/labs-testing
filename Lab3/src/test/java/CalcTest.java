import edu.tzyaps.util.SalaryCalculator;
import edu.tzyaps.util.SalaryCalculatorImpl;
import edu.tzyaps.util.SalaryQualifier;
import edu.tzyaps.util.SalaryQuilifierImpl;
import edu.tzyaps.util.enums.SalGrade;
import org.junit.Assert;
import org.junit.Test;
import stubs.service.EmployeeServiceStub;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 * Created by Max on 30.11.2016.
 */
public class CalcTest {

    @Test
    public void correctCalcTest() {
        SalaryCalculator calculator = new SalaryCalculatorImpl();
        Assert.assertEquals(calculator.getFullSalary(2000, 20), new Integer(2020));
    }

    @Test
    public void correctNullCalcTest() {
        SalaryCalculator calculator = new SalaryCalculatorImpl();
        Assert.assertEquals(calculator.getFullSalary(2000, null), new Integer(2000));
    }

    @Test
    public void correctSalgradeTest() {
        SalaryQualifier calculator = new SalaryQuilifierImpl();
        Assert.assertEquals(calculator.getSalGrade(2000), SalGrade.MIDDLE);
    }

    @Test
    public void employeeServiceFullSalaryCalcMockTest() {
        SalaryCalculator calculator = mock(SalaryCalculator.class);
        when(calculator.getFullSalary(2000, 10)).thenReturn(2010);

        SalaryQualifier qualifier = new SalaryQuilifierImpl();

        EmployeeServiceStub employeeService = new EmployeeServiceStub();

        Assert.assertEquals(employeeService.getFullSalgradeById(1, calculator, qualifier), SalGrade.MIDDLE);
    }

    @Test
    public void employeeServiceFullSalaryQualifierMockTest() {
        SalaryCalculator calculator = new SalaryCalculatorImpl();
        EmployeeServiceStub employeeServiceStub = new EmployeeServiceStub();

        SalaryQualifier qualifier = mock(SalaryQualifier.class);
        when(qualifier.getSalGrade(1254)).thenReturn(SalGrade.LOW);

        Assert.assertEquals(employeeServiceStub.getFullSalgradeById(2, calculator, qualifier), SalGrade.LOW);
    }

    @Test
    public void employeeServiceSalaryMockTest() {
        SalaryQualifier qualifier = mock(SalaryQualifier.class);
        when(qualifier.getSalGrade(5120)).thenReturn(SalGrade.HIGHT);
        EmployeeServiceStub employeeServiceStub = new EmployeeServiceStub();

        Assert.assertEquals(employeeServiceStub.getSalgradeById(3, qualifier), SalGrade.HIGHT);
    }

    @Test
    public void employeeServiceGetAllStubTest() {
        EmployeeServiceStub employeeServiceStub = new EmployeeServiceStub();
        Assert.assertNotNull(employeeServiceStub.getAll());
    }
}
