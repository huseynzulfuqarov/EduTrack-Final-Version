package projects.processController;

import projects.model.Course;
import projects.model.Student;
import projects.model.Teacher;

import java.util.ArrayList;
import java.util.List;

public class EduSystem {
    private static final int MAX_COURSE_COUNT = 20;
    private static final int MAX_STUDENT_COUNT = 50;
    private static final int MAX_TEACHER_COUNT = 10;
    private final List<Course> courses;
    private final List<Student> students;
    private final List<Teacher> teachers;

    public EduSystem() {
        this.courses = new ArrayList<>();
        this.students = new ArrayList<>();
        this.teachers = new ArrayList<>();
    }

    public int getCourseCount() {
        return courses.size();
    }

    public int getStudentCount() {
        return students.size();
    }

    public int getTeacherCount() {
        return teachers.size();
    }

    public void addCourse(Course course) {
        if (course == null) {
            System.out.println("Course can't be null");
            return;
        }
        if (getCourseCount() >= MAX_COURSE_COUNT) {
            System.out.println("You have reached the maximum number of courses! IN EDUSYSTEM CLASS");
            return;
        }
        courses.add(course);
    }

    public void addStudent(Student student) {
        if (student == null) {
            System.out.println("Student can't be null");
            return;
        }
        if (getStudentCount() >= MAX_STUDENT_COUNT) {
            System.out.println("You have reached the maximum number of students! IN EDUSYSTEM CLASS");
            return;
        }
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        if (teacher == null) {
            System.out.println("Teacher can't be null");
            return;
        }
        if (getTeacherCount() >= MAX_TEACHER_COUNT) {
            System.out.println("You have reached the maximum number of teachers! IN EDUSYSTEM CLASS");
            return;
        }
        teachers.add(teacher);
    }

    public void assignTeacherToCourse(int courseId, int teacherId) {
        Course course = findCourseById(courseId);

        if (course == null) {
            System.out.println("There is no course with ID " + courseId + " in the system.");
            return;
        }

        Teacher teacher = findTeacherById(teacherId);

        if (teacher == null) {
            System.out.println("There is no teacher with ID " + teacherId + " in the system.");
            return;
        }
        if (teacher.getCourseCount() >= teacher.getMaxCoursesPerTeacher()) {
            System.out.println("Teacher have reached the maximum number of courses! IN EDUSYSTEM CLASS");
            return;
        }

        teacher.assignCourse(course);
        course.setTeacher(teacher);
        System.out.println("Teacher " + teacher.getName() + " has been assigned to the " + course.getName() + " course!");
    }

    public void enrollStudentToCourse(int courseId, int studentId) {
        Student student = findStudentById(studentId);

        if (student == null) {
            System.out.println("There is no student with ID " + studentId + " in the system.");
            return;
        }

        Course course = findCourseById(courseId);

        if (course == null) {
            System.out.println("There is no course with ID " + courseId + " in the system.");
            return;
        }
        if (student.getCourseCount() >= student.getMaxCoursesPerStudents()) {
            System.out.println("You have reached the maximum number of courses! IN EDUSYSTEM CLASS");
            return;
        }
        if (course.getStudentCount() >= course.getMaxStudentsPerCourse()) {
            System.out.println("You have reached the maximum number of students! IN EDUSYSTEM CLASS");
            return;
        }
        for (Student checkStudentInCourses : course.getStudents()) {
            if (checkStudentInCourses.getId() == studentId) {
                System.out.println("This course has been enrolled this student!");
                return;
            }
        }
        for (Course checkCourseInStudents : student.getCourses()) {
            if (checkCourseInStudents.getId() == courseId) {
                System.out.println("This student has been enrolled this course!");
                return;
            }
        }
        student.enrollToCourse(course);
        course.addStudent(student);
    }

    public Course findCourseById(int courseId) {
        for (Course course : courses) {
            if (course.getId() == courseId) {
                return course;
            }
        }
        return null;
    }

    public Student findStudentById(int studentId) {
        for (Student student : students) {
            if (student.getId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public Teacher findTeacherById(int teacherId) {
        for (Teacher teacher : teachers) {
            if (teacher.getId() == teacherId) {
                return teacher;
            }
        }
        return null;
    }

    public void printAllCourses() {
        for (Course course : courses) {
            System.out.println(course.toString());
        }
    }

    public void printAllPeople() {
        System.out.println("------------- All people in the system.---------------\n");
        System.out.println("------------- All students in the system ---------------\n");
        for (Student student : students) {
            System.out.println(student.toString());
        }
        System.out.println("------------- All teachers in the system ---------------\n");
        for (Teacher teacher : teachers) {
            System.out.println(teacher.toString());
        }
        System.out.println("-------------------------------\n");
    }
}
