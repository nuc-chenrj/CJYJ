package com.group.javaee.Pojo;

public class StudentAndGradeAndCourse  {
    private Integer studentId;
    private String studentName;
    private Integer grade;
    private String courseName;

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "StudentAndGradeAndCourse{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", grade=" + grade +
                ", courseName=" + courseName +
                '}';
    }
}
