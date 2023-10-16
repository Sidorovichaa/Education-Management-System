package edec.management.system;

/**
 * Created by @Sidorovich&Romanenko 2023.
 * This class is responsible for keeping
 * the track of budgeting, all students and lecturers in the EDEC.
 */

import java.util.List;

import static edec.management.system.Employee.employeeCount;
import static edec.management.system.Student.studentCount;

public class Center {
    public List<Employee> employees;
    public List<Student> students;
    private static int totalIncomes;
    private static int totalExpenses;

    protected int finalBalance;

    // constructor
    public Center(List<Employee> employees, List<Student> students) {
        this.employees = employees;
        this.students = students;
        this.totalIncomes = 0;
        this.totalExpenses = 0;
        this.finalBalance = 0;
    }


    // setters
    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void addStudents(Student student) {
        students.add(student);
    }

    public static void updateTotalIncomes(int income) {
        totalIncomes += income;
    }

    public static void updateTotalExpenses(int expense) {
        totalExpenses += expense;
    }


    // getters
    public List<Employee> getEmployees() {
        return employees;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getTotalIncomes() {
        return totalIncomes;
    }

    public int getTotalExpenses() {
        return totalExpenses;
    }

    public int getFinalBalance() {
        return totalIncomes - totalExpenses;
    }

    // other methods
    public void showBalance(){
        System.out.println("EDEC has earned " + getFinalBalance() + " Euro.");
    }

    static int calculateAvgSalary(int...nums) {
        int sum = 0;
        for (int i: nums) {
            sum += i;
        }
        return sum / nums.length;
    }

    @Override
    public String toString() {
        if (employeeCount == 0 & studentCount == 0) {
            return "EDEC does not have any employees and students.";
        } else if (employeeCount == 1 & studentCount == 0) {
            return "EDEC has 1 employee and does not have students.";
        } else if (employeeCount > 1 & studentCount == 0) {
            return "EDEC has " + employeeCount + " employees and does not have students.";
        } else if (employeeCount > 1 & studentCount == 1) {
            return "EDEC has " + employeeCount + " employees and 1 student.";
        } else if (employeeCount == 0 & studentCount == 1) {
            return "EDEC has 1 student and does not have employees.";
        } else if (employeeCount == 0 & studentCount > 1) {
            return "EDEC has " + studentCount + " students and does not have employees.";
        } else if (employeeCount == 1 & studentCount > 1) {
            return "EDEC has " + studentCount + " students and 1 employee.";
        } else {
            return "EDEC has " + employeeCount + " employees and " + studentCount + " students.";
        }
    }
}


