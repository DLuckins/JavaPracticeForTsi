package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
    public void mainMenuText(){
        System.out.println("Welcome to Student Management System! What do you want to do?");
        System.out.println("1.Add Student");
        System.out.println("2.Remove Student");
        System.out.println("3.Search Student");
        System.out.println("4.Generate Students report");
        System.out.println("5.Exit");
    }
    public void mainMenuFunction(StudentList studentList){
        String input;
        List<String> possibleInputs=Arrays.asList("1", "2", "3", "4","5");
        Main.input=new Scanner(System.in);
        while(true) {
            input = Main.input.nextLine();
            if ((possibleInputs.contains(input))) {
                break;
            }
            else{
             System.out.println("Incorrect input, please enter a number from 1 to 5");
            }
        }
        switch (input){
            case "1":
                studentList.add();
                break;
            case "2":
                studentList.remove();
                break;
            case "3":
                studentList.searchAndShowStudent();
                break;
            case "4":
                Main.loader.createAReport(studentList);
                break;
            case "5":
                Main.stop=true;
                break;

        }
    }
}
