package edec.management.system;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by @Sidorovich&Romanenko 2023.
 * This class is responsible for keeping
 * the track of lectures' name, assigned courses and salary.
 */

public class Employee {
    protected final int id;
    protected static String name;
    protected String position;
    protected int salary;
    protected int salaryTotal;
    protected static int employeeCount = 0;

    // constructor
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
        this.salary = 0;
        this.salaryTotal = 0;
        employeeCount++;

    }

    // setters

    public void setName(String name) {
        this.name = name;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

     //getters

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public String getPosition() {
        return position;
    }

    public int getSalary() {
        return salary;
    }

    public int getSalaryTotal() {
        return salaryTotal;
    }

    // other methods

    public void receiveSalary() {
        salaryTotal+=salary;
        Center.updateTotalExpenses(salaryTotal);
    }
    public void info() {
        System.out.print("Employee: " + name);
        System.out.print(" holds the position of " + position);
        System.out.println(" with a salary " + salary + " Euro.");
    }

    @Override
    public String toString() {
        return "Employee: " + name +
                "; position: " + position +
                "; basic salary " + salary + " per a month" +
                ". Total earned salary in EDEC is " + salaryTotal +
                '.';
    }
}


/**
 * Child Classes -
 * Director
 * Accountant
 * Lecturer
 * TechnicalAssistant
 */

class Director extends Employee{
    protected int salary;

    // constructor
    public Director(int id, String name){
        super(id, name);
        position = "Director";
        employeeCount++;
    }
}


class Accountant extends Employee{
    protected int salary;

    // constructor
    public Accountant(int id, String name){
        super(id, name);
        position = "Accountant";
        employeeCount++;
    }
}

class Lecturer extends Employee{
    protected int salary;
    protected List<Course> assignedCourses = new ArrayList<>();

    // constructor
    public Lecturer(int id, String name){
        super(id, name);
        position = "Lecturer";
        employeeCount++;
    }

    // setters
    public void addAssignedCourses(Course course) {
        assignedCourses.add(course);
    }

    // getters
    public List<Course> getAssignedCourses() {
        return assignedCourses;
    }
}

class TechnicalAssistant extends Employee{
    protected int salary;

    // constructor
    public TechnicalAssistant(int id, String name){
        super(id, name);
        position = "TechnicalAssistant";
        employeeCount++;
    }
}
