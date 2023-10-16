package edec.management.system;

/**
 * Created by @Sidorovich&Romanenko 2023.
 * This class is responsible for keeping
 * the track of students' name, course, course stage and fees paid.
 */
public class Student {
    protected final int id;
    protected String name;
    protected Course course;
    protected int stage;
    protected boolean finalTaskIsPassed;
    protected int paymentPaid;
    protected int paymentTotal;
    protected static int studentCount = 0;

    public class CourceCompletion {
         boolean testIsPassed = false;
         void checkCompletion() {
            if (!testIsPassed) {
                System.out.println(name + " has not completed the course yet");
            } else System.out.println(name + " is completed the course!");
        }
    }
     // constructor for class Student
        public Student(int id, String name, Course course) {
            this.id = id;
            this.name = name;
            this.course = course;
            this.stage = 1;
            this.finalTaskIsPassed = false;
            this.paymentPaid = 0;
            this.paymentTotal = Course.cost;
            studentCount++;
    }


    // setters
    public void setCourse(Course course) {
            this.course = course;
    }

    public void setStage(int stage){
        this.stage = stage;
    }

    public void doPayment(int payment) {
        paymentPaid += payment;
        Center.updateTotalIncomes(paymentPaid);
    }

    public void taskIsPassed() {
        this.finalTaskIsPassed = true;
    }


    // getters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Course getCourse() {
        return course;
    }

    public int getStage() {
        return stage;
    }

    public boolean isFinalTaskIsPassed() {
        return finalTaskIsPassed;
    }

    public int getPaymentPaid() {
        return paymentPaid;
    }

    public int getPaymentTotal() {
        return paymentTotal;
    }

    public int getRemainingPayment() {
            return paymentTotal - paymentPaid;
    }


    // other methods
    public void info() {
        System.out.print("Student: " + name);
        System.out.print(" is taking a course \"" + course.title + "\"; ");
        System.out.println("payment balance is " + paymentPaid + " Euro out of " + paymentTotal + " Euro.");
    }

    @Override
    public String toString() {
        return "Student: " + name +
                "; course - " + course.title +
                "; stage - " + stage +
                "; total payments paid so far " + paymentPaid + " Euro" +
                " out of " + paymentTotal + " Euro."
                ;
    }
}
