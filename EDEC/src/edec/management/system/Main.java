package edec.management.system;

import java.util.ArrayList;
import java.util.List;

import static edec.management.system.Center.calculateAvgSalary;

/**
 * Created by @Sidorovich&Romanenko 2023.
 * This class is responsible for keeping
 * the track of budgeting, all students and lecturers in the EDEC.
 */

public class Main {
    public static void main(String[] args) {

        // Create list of Employees
        Director rafael = new Director(1, "Rafael Bartet");
        Lecturer nina = new Lecturer(2, "Nina Voronova");
        Lecturer victoria = new Lecturer(3, "Victoria Golovenchik");

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(rafael);
        employeeList.add(nina);
        employeeList.add(victoria);

        // Create Courses
        Course edf = new Course(1, "Eating Disorder Fundamentals", 3, 3, nina, 3000);
        Course peda = new Course(2, "Prevention of Eating Disorders in Adolescents", 4, 4, victoria, 4000);

        // add courses to lecturers
        nina.addAssignedCourses(edf);
        victoria.addAssignedCourses(peda);


        // Create list of Students
        Student olga = new Student(1, "Olga Reshetova", edf);
        Student victor = new Student(2, "Victor Gasso", peda);
        Student ivan = new Student(3, "Ivan Mulin", edf);

        List<Student> studentList = new ArrayList<>();
        studentList.add(olga);
        studentList.add(victor);
        studentList.add(ivan);


        // Create the Center
        Center edec = new Center(employeeList, studentList);


        // add a new Employee to EDEC
        Accountant maria = new Accountant(4, "Maria Zvanets");
        edec.addEmployee(maria);


        // students doing payments
        olga.doPayment(1000);
        victor.doPayment(1000);
        ivan.doPayment(3000);


        // pay salaries to employees
        rafael.setSalary(2500);
        nina.setSalary(1500);
        victoria.setSalary(1000);

        rafael.receiveSalary();

        // check a student info
        ivan.info();
        System.out.println(victor);

        // course completion info
        Student.CourceCompletion courceCompletionOlga = olga.new CourceCompletion();
        Student.CourceCompletion courceCompletionIvan = ivan.new CourceCompletion();
        courceCompletionOlga.testIsPassed = true;
        courceCompletionOlga.checkCompletion();
        courceCompletionIvan.checkCompletion();


        // check a lecturer info
        victoria.info();
        System.out.println(rafael);


        // check the budget balance
        edec.showBalance();

        // check EDEC info about employees and students
        System.out.println(edec);


        // check a course info
        System.out.println(edf);

        // calculate average salary
        System.out.println("Average salary between 1200 and 2500 EURO is "
                + calculateAvgSalary(1200,2500) + " EURO.");
        System.out.println("Average salary between 1200, 2500 and 2000 EURO is "
                + calculateAvgSalary(1200,2500,2000) + " EURO.");

        // Arrays of students
        Student[] students = new Student[3];
        students[0] = olga;
        students[1] = victor;
        students[2] = ivan;
        for (int i = 0; i < 3; i++) {
            System.out.println(students[i]);
        }
       // or get students from list in class Center
        System.out.println(edec.getStudents());

    }
}
