package projects.processController;

import projects.model.Course;
import projects.model.Student;
import projects.model.Teacher;

import java.util.Arrays;

public class EduSystem {
    private static final int MAX_COURSE_COUNT = 20;
    private static final int MAX_STUDENT_COUNT = 50;
    private static final int MAX_TEACHER_COUNT = 10;
    private Course[] courses = new Course[0];
    private Student[] students = new Student[0];
    private Teacher[] teachers = new Teacher[0];

    public EduSystem() {
    }

    public int getCourseCount() {
        return courses.length;
    }

    public int getStudentCount() {
        return students.length;
    }

    public int getTeacherCount() {
        return teachers.length;
    }

/*    public Object[] addElementToArray(Object[] array,Object object, int MAX_LIMIT, String type) {
        if (object == null) {
            System.out.println(type + " can't be null");
            return array;
        }
        if (array.length >= MAX_LIMIT) {
            System.out.println("You have reached the maximum number of " + type + "! IN EDUSYSTEM CLASS");
            return array;
        }
        Object[] temp = Arrays.copyOf(array, array.length + 1);
        temp[array.length] = object;
        return temp;
    }

    public void addCourse(Course course) {
        this.courses = (Course[])addElementToArray(courses,course, MAX_COURSE_COUNT, "Course");
    }

    public void addStudent(Student student) {
        this.students = (Student[]) addElementToArray(students,student, MAX_STUDENT_COUNT, "Student");
    }

    public void addTeacher(Teacher teacher) {
        this.teachers = (Teacher[]) addElementToArray(teachers,teacher, MAX_TEACHER_COUNT, "Teacher");
    }*/

    public void addCourse(Course course) {
        if (course == null) {
            System.out.println("Course can't be null");
            return;
        }
        if (getCourseCount() >= MAX_COURSE_COUNT) {
            System.out.println("You have reached the maximum number of courses! IN EDUSYSTEM CLASS");
            return;
        }
        Course[] temp = Arrays.copyOf(courses, getCourseCount() + 1);
        temp[getCourseCount()] = course;
        courses = temp;
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
        Student[] temp = Arrays.copyOf(students, getStudentCount() + 1);
        temp[getStudentCount()] = student;
        students = temp;
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
        Teacher[] temp = Arrays.copyOf(teachers, getTeacherCount() + 1);
        temp[getTeacherCount()] = teacher;
        teachers = temp;
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
