package projects.model;

import projects.interfaces.Notifiable;
import projects.interfaces.Reportable;
import java.util.Arrays;
import java.util.Objects;

public class Student extends Person implements Notifiable, Reportable {
    private static final int MAX_COURSES_PER_STUDENTS = 5;
    private Course[] courses;
    private int courseCount;

    public Student(String name, String email, int iq) {
        super(name, email, iq);
        this.courses = null;
        this.courseCount = 0;
    }

    public Course[] getCourses() {
        return courses;
    }

    public void setCourses(Course[] courses) {
        this.courses = courses;
    }

    public int getCourseCount() {
        return courses.length;
    }

    public int getMaxCoursesPerStudents() {
        return MAX_COURSES_PER_STUDENTS;
    }

    public void enrollToCourse(Course course) {
        if (course == null) {
            System.out.println("Value can't be null.");
            return;
        }
        if (courseCount == MAX_COURSE_COUNT) {
            System.out.println("You have maximum course count.");
            return;
        }
        Course[] temp = new Course[++courseCount];
        for (int i = 0; i < courseCount - 1; i++) {
        Course[] temp = new Course[getCourseCount() + 1];
        for (int i = 0; i < getCourseCount(); i++) {
            temp[i] = courses[i];
        }
        temp[getCourseCount()] = course;
        courses = temp;
    }

    public void listCourses() {
        if (getCourseCount() == 0) {
            System.out.println("There are no courses you can have in the system. IN STUDENT CLASS");
            return;
        }
        for (int i = 0; i < getCourseCount(); i++) {
            System.out.println(courses[i].getName());
        }
    }

    @Override
    public void printInfo() {
        System.out.println("ID: " + getId() + "Name: " + getName() + "Email: " + getEmail());
    }

    @Override
    public String generateReport() {
        if (getCourseCount() == 0) {
            return "There are no courses you can have in the system. IN STUDENT CLASS";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getCourseCount(); i++) {
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
        return "Student ->" + super.toString() +
                " | MAX_COURSES_PER_STUDENTS: " + MAX_COURSES_PER_STUDENTS +
                " | Courses: " + courseArrayNamePrint(courses) +
                " | CourseCount: " + getCourseCount();
    }
}
