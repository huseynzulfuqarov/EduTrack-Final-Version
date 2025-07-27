package projects.model;

import projects.interfaces.Reportable;
import projects.interfaces.Schedulable;

import java.util.Arrays;
import java.util.Objects;

public class Teacher extends Person implements Schedulable, Reportable {
    private static final int MAX_COURSES_PER_TEACHER = 3;
    private Course[] assignedCourses;
    private int courseCount = 0;
    private String[] schedule;

    public Teacher(String name, String email, int IQ) {
        super(name, email, IQ);
        this.assignedCourses = new Course[0];
    }

    public Course[] getAssignedCourses() {
        return assignedCourses;
    }

    public void setAssignedCourses(Course[] assignedCourses) {
        this.assignedCourses = assignedCourses;
    }

    public int getMaxCoursesPerTeacher() {
        return MAX_COURSES_PER_TEACHER;
    }

    public int getCourseCount() {
        return assignedCourses.length;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public String[] getSchedule() {
        return schedule; //Arrays.copyOf
    }

    public void setSchedule(String[] schedule) {
        this.schedule = schedule; //Arrays.copyOf
    }

    public void assignCourse(Course course) {
        /*if (course == null) {
            System.out.println("Course can't be null. IN TEACHER CLASS");
            return;
        }
        if (getCourseCount() >=  MAX_COURSES_PER_TEACHER) {
            System.out.println("No More Course Can Be Assigned. IN TEACHER CLASS");
        }*/
        Course[] temp = new Course[getCourseCount() + 1];
        int tempIndex = 0;
        for (Course c : assignedCourses) {
            temp[tempIndex] = c;
            tempIndex++;
        }
        temp[tempIndex] = course;
        assignedCourses = temp;
    }

    public void listAssignedCourses() {
        for (Course c : assignedCourses) {
            System.out.println(c.getName());
        }
    }

    @Override
    public void assignSchedule(String[] days) {
        schedule = days;
    }

    @Override
    public void viewSchedule() {
        if (schedule == null || schedule.length == 0) {
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
        report.append("Teacher " + getName());
        report.append("\nAssigned Courses: " + getCourseNames());

        if (getCourseCount() > 0) {
            for (Course c : assignedCourses) {
                report.append("\nStudents of " + c.getName() + " course " + Arrays.toString(c.getStudents()));
            }
        }
        return report.toString();
    }

    // Helper Method for generateReport...
    public String getCourseNames() {

        if (assignedCourses == null || assignedCourses.length == 0) {
            return "No Courses Assigned. IN TEACHER CLASS";
        }
        StringBuilder sb = new StringBuilder();

        for (Course c : assignedCourses) {
            sb.append(c.getName() + " ");
        }
        return sb.toString();
    }

    private String courseArrayNamePrint(Course[] courses) {
        StringBuilder sb = new StringBuilder("[");
        for (Course c : courses) {
            sb.append(c.getName() + " ");
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
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return courseCount == teacher.courseCount && Objects.deepEquals(assignedCourses, teacher.assignedCourses) && Objects.deepEquals(schedule, teacher.schedule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Arrays.hashCode(assignedCourses), courseCount, Arrays.hashCode(schedule));
    }

    @Override
    public String toString() {
        return "Teacher ->" + super.toString() +
                " | MAX_COURSES_PER_TEACHER: " + MAX_COURSES_PER_TEACHER +
                " | AssignedCourses=" + courseArrayNamePrint(assignedCourses) +
                " | CourseCount=" + getCourseCount() +
                " | Schedule=" + Arrays.toString(schedule);
    }
}
