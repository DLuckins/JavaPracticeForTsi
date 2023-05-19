package org.example;

import java.io.Serializable;
import java.time.DateTimeException;
import java.util.ArrayList;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

public class StudentList implements Serializable {
    private List<Student> studentList=new ArrayList<>();
    public void add(){
            Student student=new Student();
            System.out.println("Please add student info");
            System.out.println("name:");
            student.setName(Main.input.nextLine());
            System.out.println("ID:");
            student.setStudentID(Main.input.nextLine());
            System.out.println("email:");
            student.setEmail(Main.input.nextLine());
            System.out.println("Date of birth:");
            try {
                System.out.println("YEAR:");
                int year = Main.input.nextInt();
                System.out.println("MONTH:");
                int month = Main.input.nextInt();
                System.out.println("DAY:");
                int day=Main.input.nextInt();
                student.setDateOfBirth(LocalDate.of(year,month,day));
                studentList.add(student);
                Main.logger.info("Student added!");
            }
            catch (DateTimeException e){
                Main.logger.info("Incorrect date");
            }
            catch (InputMismatchException e){
                Main.logger.info("Incorrect input");
            }
    }



    public void remove(){
        System.out.println("Please enter ID of student that you need to remove");
        String id=Main.input.nextLine();
        try {
            Student foundStudent=search(id).get();
            studentList.remove(foundStudent);
            Main.logger.info("Student removed!");
        }
        catch (Exception e){
            Main.logger.info(e.getMessage());
        }

    }
    public Optional<Student> search(String id){
        return studentList.stream().filter(student -> student.getStudentID().equals(id)).findAny();
    }
    public void searchAndShowStudent(){
        System.out.println("Please enter ID of student that you need to find");
        String id=Main.input.nextLine();
        try {
            Student foundStudent=search(id).get();
            System.out.println(foundStudent);
        }
        catch (Exception e){
            Main.logger.info(e.getMessage());
        }
    }
    public List<Student> getStudentList() {
        return studentList;
    }
}
