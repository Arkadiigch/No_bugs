package org.example.HW1.Student;

import org.example.HW1.Book.Displayable;

public class Student implements Printable {
    private String nameStudent;
    private int numberPassbook;
    private float averageGrade;

    public void setNameStudent(String nameStudent){
        this.nameStudent = nameStudent;
    }
    public String getNameStudent() {
        return this.nameStudent;
    }
    public void setNumberPassbook(int numberPassbook){
        this.numberPassbook = numberPassbook;
    }
    public int getNumberPassbook() {
        return this.numberPassbook;
    }
    public void setAverageGrade(float averageGrade){
        this.averageGrade = averageGrade;
    }
    public float getAverageGrade() {
        return this.averageGrade;
    }

    @Override
    public void print() {
        System.out.println("Имя " + this.nameStudent);
        System.out.println("Номер зачётной книжки " + this.numberPassbook);
        System.out.println("Средний балл " + this.averageGrade);
    }
}

