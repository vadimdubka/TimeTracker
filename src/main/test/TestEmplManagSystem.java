import service.EmplManagSystem;
import entity.Employee;
import org.junit.Test;

import java.text.ParseException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;


//import static org.junit.Assert.assertEquals;

public class TestEmplManagSystem {
    public EmplManagSystem managSystem;
    public ArrayList<Employee> employees;
    Employee newEmpl;

    {
        newEmpl = new Employee();
        newEmpl.setSurName("Пушкин");
        newEmpl.setFirstName("Александр");
        newEmpl.setPatronymic("Сергеевич");
        try {
            newEmpl.setDateOfBirth(newEmpl.getDateFormat().parse("1989-11-12"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        newEmpl.setSex("M");
        newEmpl.setEmail("pushkin@mail.vs");
        newEmpl.setPhone("+9874");
        newEmpl.setPost("поэт");
        newEmpl.setWageRate(5.1f);
        newEmpl.setLogin("pushka");
        newEmpl.setPassword("9643");
    }

    public TestEmplManagSystem() {
        testGetInstance();
    }

    @Test
    public void testGetInstance() {
        managSystem = EmplManagSystem.getInstance();
        employees = managSystem.getEmployees();
    }

    @Test
    public void testLoadandGetEmployeesFromDB() {
        assertEquals(employees.size() >= 6, true);
    }


    @Test
    public void testInsertEmpl() {
        int starSize = employees.size();

        managSystem.insertEmployeeInDB(newEmpl);
        managSystem.loadEmployeesFromDB();
        System.out.println("Insert new Employee");
        System.out.println(newEmpl);
        assertEquals(employees.size() == starSize + 1, true);
    }


    @Test
    public void testDeleteEmpl() throws Exception {
        managSystem.insertEmployeeInDB(newEmpl);
        managSystem.loadEmployeesFromDB();
        int beforeDelete = employees.size();
        System.out.println("beforeDelete" + beforeDelete);
        for (Employee employee : employees) {
            System.out.println(employee);
        }

        managSystem.deleteEmployeeInDB(employees.get(employees.size() - 1));
        managSystem.loadEmployeesFromDB();
        int afteDelete = employees.size();
        System.out.println("afteDelete" + afteDelete);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
        System.out.println();
        assertEquals(beforeDelete == afteDelete + 1, true);
    }

    @Test
    public void testUpdateEmpl() throws Exception {
        managSystem.insertEmployeeInDB(newEmpl);
        managSystem.loadEmployeesFromDB();
        Employee startEmpl = employees.get(employees.size() - 1);
        System.out.println("before Update");
        System.out.println(startEmpl);
        startEmpl.setSurName("Update");
        startEmpl.setFirstName("Update");
        startEmpl.setPatronymic("Update");
        try {
            startEmpl.setDateOfBirth(newEmpl.getDateFormat().parse("2000-12-31"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        startEmpl.setSex("W");
        startEmpl.setEmail("Update@mail.vs");
        startEmpl.setPhone("+0000");
        startEmpl.setPost("Update");
        startEmpl.setWageRate(0.1f);
        startEmpl.setLogin("Update");
        startEmpl.setPassword("Update");
        managSystem.updateEmployeeInDB(startEmpl);
        managSystem.loadEmployeesFromDB();
        startEmpl = employees.get(employees.size() - 1);
        System.out.println("after Update");
        System.out.println(startEmpl);
    }
}
