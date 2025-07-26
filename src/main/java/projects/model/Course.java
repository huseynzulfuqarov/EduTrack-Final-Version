package projects.model;

import java.util.Arrays;
import java.util.Objects;

public class Course {
    private final int MAX_STUDENT_COUNT = 10;
    private static int nextId = 0;
    private int id;
    private String name;
    private String category;
    private Teacher teacher;
    private Student[] students = new Student[MAX_STUDENT_COUNT];
    private int studentCount = 0;

    public Course(String name, String category, Teacher teacher) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
        this.teacher = teacher;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        return students;
    }

    public void setStudents(Student[] students) {
        this.students = students;
    }

    public int getStudentCount() {
        return studentCount;
    }

    public void setStudentCount(int studentCount) {
        this.studentCount = studentCount;
    }

    public void addStudent(Student student) {
        if (studentCount < MAX_STUDENT_COUNT) {
            students[studentCount] = student;
            studentCount++;
        } else {
            System.out.println("No enough space in the system");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && studentCount == course.studentCount && Objects.equals(name, course.name) && Objects.equals(category, course.category) && Objects.equals(teacher, course.teacher) && Objects.deepEquals(students, course.students);
    }

    public void removeStudent(int index) {
        for (int i = index; i < studentCount - 1; i++) {
            students[i] = students[i + 1];
        }
        students[studentCount - 1] = null;
        studentCount--;
    }

    public int findStudentIndex(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                return i;
            }
        }
        return -1;
    }

    public void printCourseInfo() {
        System.out.println("Name: " + name + " Teacher" + teacher.getName() + " Student Count: " + studentCount);
    }


    @Override
    public int hashCode() {
        return Objects.hash(MAX_STUDENT_COUNT, id, name, category, teacher, Arrays.hashCode(students), studentCount);
    }

    @Override
    public String toString() {
        return "Course -> " +
                " | MAX_STUDENT_COUNT: " + MAX_STUDENT_COUNT +
                " | ID: " + id +
                " | Name: " + name +
                " | Category: " + category +
                " | Teacher: " + teacher +
                " | Students: " + Arrays.toString(students) +
                " | StudentCount: " + studentCount;
    }
}
