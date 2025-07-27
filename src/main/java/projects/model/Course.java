package projects.model;

import java.util.Arrays;
import java.util.Objects;

public class Course {
    private static final int MAX_STUDENTS_PER_COURSE = 10;
    private static int nextId = 0;
    private int id;
    private String name;
    private String category;
    private Teacher teacher;
    private Student[] students;
    private int studentCount;

    public Course(String name, String category, Teacher teacher) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
        this.students = new Student[0];
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMaxStudentsPerCourse() {
        return MAX_STUDENTS_PER_COURSE;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student[] getStudents() {
        return students; //Arrays.copyOf
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getStudentCount() {
        return students.length;
    }

    public void addStudent(Student student) {
/*        if (student == null) {
            System.out.println("Value can't be null. IN COURSE CLASS");
            return;
        }
        if (getStudentCount() == MAX_STUDENTS_PER_COURSE) {
            System.out.println("You have maximum student count. IN COURSE CLASS");
            return;
        }*/
        /*for (Student s : students) {
            if (s.getId() == student.getId()) {
                return;
            }
        }*/
        Student[] temp = new Student[getStudentCount() + 1];
        for (int i = 0; i < getStudentCount(); i++) {
            temp[i] = students[i];
        }
        temp[getStudentCount()] = student;
        students = temp;
        // student.enrollToCourse(this);
        // System.out.println("Student " + student.getName() + " has been added " + this.getName()+ " course.");
    }

    public int findStudentIndex(int id) {
        for (int i = 0; i < getStudentCount(); i++) {
            if (students[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void removeStudent(int index) {
        if (index < 0 || index > getStudentCount() - 1) {
            System.out.println("Not found given index. IN COURSE CLASS");
            return;
        }
        Student[] temp = new Student[getStudentCount() - 1];
        int count = 0;
        for (int i = 0; i < getStudentCount(); i++) {
            if (i != index) {
                temp[count++] = students[i];
            }
        }
        studentCount--;
        students = temp;
    }

    public void printCourseInfo() {
        System.out.println("Name: " + name + " Teacher" + teacher.getName() + " Student Count: " + studentCount);
        if (this.getTeacher() != null) {
            System.out.println("Name: " + name + " Teacher" + teacher.getName() + " Student Count: " + getStudentCount());
        } else {
            System.out.println("Name: " + name + " Teacher is null" + " Student Count: " + getStudentCount());
        }
    }

    public String studentArrayNamePrint(Student[] students) {
        StringBuilder sb = new StringBuilder("[");
        for (Student student : students) {
            sb.append(student.getName() + " ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;
        return Objects.equals(name, course.getName()) &&
                Objects.equals(category, course.getCategory());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category);
    }

    @Override
    public String toString() {
        return "Course ->" +
                " | MAX_STUDENTS_PER_COURSE: " + MAX_STUDENTS_PER_COURSE +
                " | ID: " + id +
                " | Name: " + name +
                " | Category: " + category +
                " | Teacher: " + teacher +
                " | Students: " + studentArrayNamePrint(students) +
                " | StudentCount: " + getStudentCount();
    }
}
