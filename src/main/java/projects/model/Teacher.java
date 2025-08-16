package projects.model;

import projects.interfaces.Schedulable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Teacher extends Person implements Schedulable {
    private static final int MAX_COURSES_PER_TEACHER = 3;
    private List<Course> assignedCourses;
    private List<String> schedule;

    public Teacher(String name, String email, int IQ) {
        super(name, email, IQ);
        this.assignedCourses = new ArrayList<>();
        this.schedule = new ArrayList<>();
    }

    public List<Course> getAssignedCourses() {
        return Collections.unmodifiableList(assignedCourses);
    }

    public void setAssignedCourses(List<Course> assignedCourses) {
        this.assignedCourses = assignedCourses;
    }

    public int getMaxCoursesPerTeacher() {
        return MAX_COURSES_PER_TEACHER;
    }

    public int getCourseCount() {
        return assignedCourses.size();
    }

    public List<String> getSchedule() {
        return Collections.unmodifiableList(schedule);
    }

    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
    }

    public void assignCourse(Course course) {
        if (course == null) {
            throw new IllegalArgumentException("Course cannot be null.");
        }
        if (assignedCourses.size() >= MAX_COURSES_PER_TEACHER) {
            throw new IllegalStateException("Teacher cannot be assigned to more than " + MAX_COURSES_PER_TEACHER + " courses.");
        }
        if (assignedCourses.contains(course)) {
            throw new IllegalArgumentException("Teacher is already assigned to this course.");
        }
        assignedCourses.add(course);
    }

    public void listAssignedCourses() {
        for (Course c : assignedCourses) {
            System.out.println(c.getName());
        }
    }

    @Override
    public void assignSchedule(String[] days) {
        Collections.addAll(this.schedule, days);
    }

    @Override
    public void viewSchedule() {
        if (schedule.isEmpty()) {
            System.out.println("Schedule is Empty");
        } else {
            for (String day : schedule) {
                System.out.println(day);
            }
        }
    }

    @Override
    public String generateReport() {
        StringBuilder report = new StringBuilder();
        report.append("Teacher ").append(getName());
        report.append("\nAssigned Courses: ").append(getCourseNames());

        if (!assignedCourses.isEmpty()) {
            for (Course c : assignedCourses) {
                report.append("\nStudents of ").append(c.getName()).append(" course ").append(studentListNamePrint(c.getStudents()));
            }
        }
        return report.toString();
    }

    private String studentListNamePrint(List<Student> students) {
        StringBuilder sb = new StringBuilder("[");
        for (Student student : students) {
            sb.append(student.getName()).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Helper Method for generateReport...
    public String getCourseNames() {
        if (assignedCourses.isEmpty()) {
            return "No Courses Assigned. IN TEACHER CLASS";
        }
        StringBuilder sb = new StringBuilder();
        for (Course c : assignedCourses) {
            sb.append(c.getName()).append(" ");
        }
        return sb.toString();
    }

    private String courseListNamePrint() {
        StringBuilder sb = new StringBuilder("[");
        for (Course c : assignedCourses) {
            sb.append(c.getName()).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("Message: " + message);
    }

    @Override
    public void printInfo() {
        System.out.println("Teacher info: ");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("IQ: " + getIQ());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(assignedCourses, teacher.assignedCourses) && Objects.equals(schedule, teacher.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), assignedCourses, schedule);
    }

    @Override
    public String toString() {
        return "Teacher ->" + super.toString() +
                " | MAX_COURSES_PER_TEACHER: " + MAX_COURSES_PER_TEACHER +
                " | AssignedCourses=" + courseListNamePrint() +
                " | CourseCount=" + getCourseCount() +
                " | Schedule=" + schedule;
    }
}
