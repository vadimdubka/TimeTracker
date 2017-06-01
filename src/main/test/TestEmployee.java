import entity.Employee;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestEmployee {
    TestEmplManagSystem testEmplManagSystem = new TestEmplManagSystem();


    @Test
    public void testToStrign() throws Exception {
        for (Employee employee : testEmplManagSystem.employees) {
            System.out.println(employee);
        }
    }

    @Test
    public void testEqualsHashCode() throws Exception {
        Employee e1 = testEmplManagSystem.employees.get(0);
        Employee e2 = testEmplManagSystem.employees.get(0);
        Employee e3 = testEmplManagSystem.employees.get(1);

        assertEquals(e1.equals(e2), true);
        assertEquals(e1.equals(e3), false);
        assertEquals(e1.hashCode() == e2.hashCode(), true);
        assertEquals(e1.hashCode() == e3.hashCode(), false);
    }
}
