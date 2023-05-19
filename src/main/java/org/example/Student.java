package org.example;

import java.io.Serializable;
import java.time.LocalDate;

public class Student implements Serializable {
    private String name;
    private String studentID;
    private String email;
    private LocalDate dateOfBirth;

    public Student(String name, String studentID, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.studentID = studentID;
        this.email = email;
        this.dateOfBirth = dateOfBirth;
    }
    public Student() {
    }
    @Override
    public String toString(){
        return "Name: "+this.name+"\nID: "+this.studentID+"\nEmail: "+this.email+"\nDateOfBirth: "+this.dateOfBirth;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
