package models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void getCapitalizeName() {
        Employee employee = new Employee("bob", 1, 12, new Address("address 1", "city"));

        String name = employee.getCapitalizeName();

        assertEquals("Bob", name);
    }

}