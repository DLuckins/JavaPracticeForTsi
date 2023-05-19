package org.example;

import java.io.*;
import java.util.List;

public class SaveLoad<T> {
    public void writeToFile(T t) {

        try {

            FileOutputStream fileOut = new FileOutputStream("studentSaveFile.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(t);
            objectOut.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    public void createAReport(StudentList studentList){
        List<Student> students=studentList.getStudentList();
        try {
            FileWriter myWriter = new FileWriter("studentReport.txt");
            for (Student student :
                    students) {
                myWriter.write(student.toString());
                myWriter.write("\n");

            }
            myWriter.close();
        }
        catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    public Object readFromFile() {

        try {

            FileInputStream fileIn = new FileInputStream("myFile.txt");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);

            Object list = objectIn.readObject();

            objectIn.close();
            return list;

        } catch (Exception ex) {
            Main.logger.info("Student list not found creating a new one!");
            return null;
        }
    }
}
