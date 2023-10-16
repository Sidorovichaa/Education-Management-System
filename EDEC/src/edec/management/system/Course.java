package edec.management.system;

/**
 * Created by @Sidorovich&Romanenko 2023.
 * This class is responsible for keeping
 * the track of course title, duration, number of stages, assigned lecturers.
 */

public class Course {
    protected int id;
    protected String title;
    protected int duration;
    protected int numberOfStages;
    protected Lecturer lecturer;
    protected static int cost;

    // constructor
    public Course(int id, String title, int duration, int numberOfStages, Lecturer lecturer, int cost) {
        this.id = id;
        this.title = title;
        this.numberOfStages = numberOfStages;
        this.lecturer = lecturer;
        Course.cost = cost;
    }
    // setters
    public void setTitle(String title) {
        this.title = title;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setNumberOfStages(int numberOfStages) {
        this.numberOfStages = numberOfStages;
    }

    public void setLecturer(Lecturer lecturer) {
        this.lecturer = lecturer;
    }

    public void setCost(int cost) {
        Course.cost = cost;
    }


    // getters

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getDuration() {
        return duration;
    }

    public int getNumberOfStages() {
        return numberOfStages;
    }

    public Lecturer getLecturer() {
        return lecturer;
    }

    public int getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "Course \"" + title + "\" has a duration " + duration + " months and " + numberOfStages +
                " stages. The assigned lecturer is " + Employee.name + '.';
    }
}
