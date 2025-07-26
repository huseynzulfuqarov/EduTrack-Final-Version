package projects.model;

import projects.interfaces.Reportable;
import projects.interfaces.Schedulable;

import java.util.Arrays;
import java.util.Objects;

public class Teacher extends Person implements Schedulable, Reportable {
    private Course[] assignedCourses = new Course[3];
    private int courseCount = 0;
    private String[] schedule = new string[7];

    public Teacher(Course[] assignedCourses, int courseCount, String[] schedule) {
        this.assignedCourses = assignedCourses;
        this.courseCount = courseCount;
        this.schedule = schedule;
    }

    public Course[] getAssignedCourses() {
        return assignedCourses;
    }

    public void setAssignedCourses(Course[] assignedCourses) {
        this.assignedCourses = assignedCourses;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public String[] getSchedule() {
        return schedule;
    }

    public void setSchedule(String[] schedule) {
        this.schedule = schedule;
    }

    public void assignCourse(Course course) {
        if (courseCount<=3){
            assignedCourses[courseCount] = course;
            courseCount++;
        }
        else {
            System.out.println("Array limiti kecibdir!");
        }
    }

    public void listAssignedCourses() {
        if (courseCount==0){
            System.out.println("Kurs yoxdur!");
            return;
        }
        for (int i = 0; i < courseCount; i++){
            if (assignedCourses[i] !=null){
                System.out.println(" "+assignedCourses[i].getName());
            }

        }

    }

    public void assignSchedule(String[] days) {


    }

    public void viewSchedule() {

    }

    public void  generateReport() {
        System.out.println();
    }

    public void sendNotification(String message) {
        System.out.println("Message" + name()+":"+ message);
    }

    public void printInfo() {
        System.out.println("Teacher info: ");
        System.out.println("ID: " + getId);
        System.out.println("Name: " + getName);
        System.out.println("Email: " + getEmail);
        System.out.println("IQ: " + getIq);
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
        return "Teacher{" +
                "assignedCourses=" + Arrays.toString(assignedCourses) +
                ", courseCount=" + courseCount +
                ", schedule=" + Arrays.toString(schedule) +
                '}';
    }
}
