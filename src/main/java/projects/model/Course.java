package projects.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Course {
    private static final int MAX_STUDENTS_PER_COURSE = 10;
    private static int nextId = 0;
    private final int id;
    private String name;
    private String category;
    private Teacher teacher;
    private List<Student> students;

    public Course(String name, String category) {
        this.id = nextId++;
        this.name = name;
        this.category = category;
        this.students = new ArrayList<>();
    }

    public int getId() {
        return id;
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

    public List<Student> getStudents() {
        return Collections.unmodifiableList(students);
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public int getStudentCount() {
        return students.size();
    }

    public void addStudent(Student student) {
        if (student == null) {
            throw new IllegalArgumentException("Student cannot be null.");
        }
        if (students.size() >= MAX_STUDENTS_PER_COURSE) {
            throw new IllegalStateException("Course cannot have more than " + MAX_STUDENTS_PER_COURSE + " students.");
        }
        if (students.contains(student)) {
            throw new IllegalArgumentException("Student is already in this course.");
        }
        students.add(student);
    }

    public int findStudentIndex(int id) {
        for (int i = 0; i < getStudentCount(); i++) {
            if (students.get(i).getId() == id) {
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
        students.remove(index);
    }

    public void printCourseInfo() {
        if (this.getTeacher() != null) {
            System.out.println("Name: " + name + " Teacher: " + teacher.getName() + " Student Count: " + getStudentCount());
        } else {
            System.out.println("Name: " + name + " Teacher is null" + " Student Count: " + getStudentCount());
        }
    }

    private String studentListNamePrint() {
        StringBuilder sb = new StringBuilder("[");
        for (Student student : students) {
            sb.append(student.getName()).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return id == course.id && Objects.equals(name, course.name) && Objects.equals(category, course.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, category);
    }

    @Override
    public String toString() {
        return "Course ->" +
                " | MAX_STUDENTS_PER_COURSE: " + MAX_STUDENTS_PER_COURSE +
                " | ID: " + id +
                " | Name: " + name +
                " | Category: " + category +
                " | Teacher: " + (teacher != null ? teacher.getName() : "N/A") +
                " | Students: " + studentListNamePrint() +
                " | StudentCount: " + getStudentCount();
    }
}
