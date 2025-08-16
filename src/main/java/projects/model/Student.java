package projects.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Student extends Person {
    private static final int MAX_COURSES_PER_STUDENTS = 5;
    private List<Course> courses;

    public Student(String name, String email, int iq) {
        super(name, email, iq);
        this.courses = new ArrayList<>();
    }

    public List<Course> getCourses() {
        return Collections.unmodifiableList(courses);
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public int getCourseCount() {
        return courses.size();
    }

    public int getMaxCoursesPerStudents() {
        return MAX_COURSES_PER_STUDENTS;
    }

    public void enrollToCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null.");
        }
        if (courses.size() >= MAX_COURSES_PER_STUDENTS) {
            throw new IllegalStateException("Student cannot enroll in more than " + MAX_COURSES_PER_STUDENTS + " courses.");
        }
        if (courses.contains(course)) {
            throw new IllegalArgumentException("Student is already enrolled in this course.");
        }
        courses.add(course);
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("There are no courses you can have in the system. IN STUDENT CLASS");
            return;
        }
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }

    private String courseListNamePrint() {
        StringBuilder sb = new StringBuilder("[");
        for (Course course : courses) {
            sb.append(course.getName()).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void printInfo() {
        System.out.println("ID: " + getId() + " Name: " + getName() + " Email: " + getEmail());
    }

    @Override
    public String generateReport() {
        if (courses.isEmpty()) {
            return "There are no courses you can have in the system. IN STUDENT CLASS";
        }
        StringBuilder sb = new StringBuilder();
        for (Course course : courses) {
            sb.append(course.getName()).append(" ");
        }
        return sb.toString();
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Sending: " + message);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(courses, student.courses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), courses);
    }

    @Override
    public String toString() {
        return "Student ->" + super.toString() +
                " | MAX_COURSES_PER_STUDENTS: " + MAX_COURSES_PER_STUDENTS +
                " | Courses: " + courseListNamePrint() +
                " | CourseCount: " + getCourseCount();
    }
}
