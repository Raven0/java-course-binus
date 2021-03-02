package com.binus.models;

public class Students extends Person{

    String studentId;
    String school;

    public Students() { }

    public Students(String name, String gender, Integer age, String studentId, String school) {
        super(name, gender, age);
        this.studentId = studentId;
        this.school = school;
    }

    public String getStudentId() { return studentId; }

    public void setStudentId(String studentId) { this.studentId = studentId; }

    public String getSchool() { return school; }

    public void setSchool(String school) { this.school = school; }

    @Override
    public String toString() {
        return "Students{" +
                "studentId='" + studentId + '\'' +
                ", name='" + getName() + '\'' +
                ", gender='" + getGender() + '\'' +
                ", age='" + getAge() + '\'' +
                ", school='" + school + '\'' +
                '}';
    }

}
