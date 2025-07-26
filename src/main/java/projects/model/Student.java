package projects.model;

import projects.interfaces.Notifiable;
import projects.interfaces.Reportable;

import java.util.Arrays;
import java.util.Objects;

public class Student extends Person implements Notifiable, Reportable {
    private final int MAX_COURSE_COUNT = 5;
    private Course[] courses = new Course[MAX_COURSE_COUNT];
    private int courseCount;

    public Student(String name, String email, int iq, Course[] courses, int courseCount) {
        super(name, email, iq);
        this.courses = courses;
        this.courseCount = courseCount;
    }

    public Course[] getCourses() {
        return Arrays.copyOf(courses, MAX_COURSE_COUNT);
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void enrollToCourse(Course course) {
        if (courseCount < MAX_COURSE_COUNT) {
            courses[courseCount] = course;
            courseCount++;
        } else {
            System.out.println("There is a maximum number of courses you can have in the system.");
        }
    }

    public void listCourses() {
        if (courseCount == 0) {
            System.out.println("There are no courses you can have in the system.");
            return;
        }
        for (int i = 0; i < courseCount; i++) {
            System.out.println(courses[i].toString());
        }
    }

    @Override
    public void printInfo() {
        System.out.println("ID: " + getId() + "Name: " + getName() + "Email: " + getEmail());
    }

    @Override
    public String generateReport() {
        if (courseCount == 0) {
            return "There are no courses you can have in the system.";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < courseCount; i++) {
            sb.append(courses[i].getName() + " ");
        }
        return sb.toString();
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending: " + message);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return courseCount == student.courseCount && Objects.deepEquals(courses, student.courses); //check super equals
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(courses), courseCount);
    }

    @Override
    public String toString() {
        return "Student -> " + super.toString() +
                " | Courses: " + Arrays.toString(Arrays.copyOf(courses, courseCount)) +
                " | CourseCount: " + courseCount;
    }
}
