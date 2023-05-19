package org.example;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import java.util.Scanner;

public class Main {
    public static final Logger logger = Logger.getLogger("Log");
    public static boolean stop = false;
    public static Scanner input = new Scanner(System.in);
    public static SaveLoad<StudentList> loader=new SaveLoad<>();

    public static void main(String[] args) {
        BasicConfigurator.configure();
        StudentList studentList;
        studentList=(StudentList) loader.readFromFile();
        if(studentList==null) {
            studentList = new StudentList();
        }
        Menu menu=new Menu();
        while (!stop){
            menu.mainMenuText();
            menu.mainMenuFunction(studentList);
        }
        loader.writeToFile(studentList);
    }

}