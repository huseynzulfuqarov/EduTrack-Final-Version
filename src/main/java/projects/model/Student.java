package projects.model;

import projects.interfaces.Notifiable;
import projects.interfaces.Reportable;

public class Student extends Person implements Notifiable, Reportable {
    private static final int MAX_COURSES_PER_STUDENTS = 5;
    private Course[] courses;

    public Student(String name, String email, int iq) {
        super(name, email, iq);
        this.courses = new Course[0];
    }

    public Course[] getCourses() {
        return courses; //Arrays.copyOf
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
/*        if (course == null) {
            System.out.println("Value can't be null. IN STUDENT CLASS");
            return;
        }
        if (getCourseCount() == MAX_COURSES_PER_STUDENTS) {
            System.out.println("You have maximum course count. IN STUDENT CLASS");
            return;
        }*/
      /*  for (Course c : courses) {
            if (c.equals(course)) {
                return;
            }
        }*/
        Course[] temp = new Course[getCourseCount() + 1];
        for (int i = 0; i < getCourseCount(); i++) {
            temp[i] = courses[i];
        }
        temp[getCourseCount()] = course;
        courses = temp;
        // course.addStudent(this);
        // System.out.println("Student " + getName() + " has been added "+course.getName()+ " course.");
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

    public String courseArrayNamePrint(Course[] courses) {
        StringBuilder sb = new StringBuilder("[");
        for (Course course : courses) {
            sb.append(course.getName() + " ");
        }
        sb.append("]");
        return sb.toString();
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
        if (!(o instanceof Student student)) return false;
        if (!super.equals(o)) return false;
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public String toString() {
        return "Student ->" + super.toString() +
                " | MAX_COURSES_PER_STUDENTS: " + MAX_COURSES_PER_STUDENTS +
                " | Courses: " + courseArrayNamePrint(courses) +
                " | CourseCount: " + getCourseCount();
    }
}
