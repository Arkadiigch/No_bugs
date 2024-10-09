package org.example.HW1.Car;

public class Car implements Drivable {
    private String mark;
    private String model;
    private int year;

    public void setMark(String mark){
        this.mark = mark;
    }
    public String getMark() {
        return this.mark;
    }
    public void setModel(String model){
        this.model = model;
    }
    public String getModel() {
        return this.model;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getYear() {
        return this.year;
    }

    @Override
    public void start() {
        System.out.println("Автомобиль " + mark + " " + model + " " + year + " запущен.");
    }

    @Override
    public void stop() {
        System.out.println("Автомобиль " + mark + " " + model + " " + year + " остановлен.");
    }

    @Override
    public void drive(int distance) {
        System.out.println("Автомобиль " + mark + " " + model + " " + year + " проехал " + distance + " километров.");
    }
}
