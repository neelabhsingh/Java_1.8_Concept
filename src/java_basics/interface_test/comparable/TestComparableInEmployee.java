package java_basics.interface_test.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
class Employee implements Comparable<Employee>{
    String employeeName;
    int employeeId;
    double salary;
    @Override
    public int compareTo(Employee employee) {
        return Double.compare(this.salary, employee.salary);
    }

    public Employee(String employeeName, int employeeId, double salary) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.employeeName + ": Salary " + this.salary +", ";
    }
}
public class TestComparableInEmployee {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Neelabh0", 2323, 34343.56));
        employeeList.add(new Employee("Neelabh1", 2322, 34343.57));
        employeeList.add(new Employee("Neelabh2", 2321, 34343.58));
        employeeList.add(new Employee("Neelabh3", 2320, 34343.59));
        employeeList.add(new Employee("Neelabh4", 2319, 34343.60));
        Collections.sort(employeeList);
        for(Employee employee: employeeList){
            System.out.print(employee +", ");
        }
    }
}
