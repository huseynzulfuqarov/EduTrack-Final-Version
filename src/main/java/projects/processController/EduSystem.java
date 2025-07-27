package projects.processController;

import projects.model.Course;
import projects.model.Student;
import projects.model.Teacher;

public class EduSystem {
    Course[] courses = new Course[20];
    Student[] students = new Student[50];
    Teacher[] teachers = new Teacher[10];
    int courseCount, studentCount, teacherCount;
    private static final int MAX_COURSE_COUNT = 20;
    private static final int MAX_STUDENT_COUNT = 50;
    private static final int MAX_TEACHER_COUNT = 10;
        if (getCourseCount() >= MAX_COURSE_COUNT) {
        if (getStudentCount() >= MAX_STUDENT_COUNT) {
        if (getTeacherCount() >= MAX_TEACHER_COUNT) {

    public void addCourse(Course course){}


    public void addStudent(Student student) {}

    public void addTeacher(Teacher teacher){}

    public void assignTeacherToCourse(int courseId, int teacherId) {}

    public void enrollStudentToCourse(int courseId, int studentId) {}

    public void printAllCourses(){}

    public void printAllPeople(){}

}
