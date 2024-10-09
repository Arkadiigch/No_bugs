package org.example;

import org.example.HW1.Book.Book;
import org.example.HW1.Car.Car;
import org.example.HW1.Clock.Clock;
import org.example.HW1.Point.Point;
import org.example.HW1.Student.Student;

public class Main {
    public static void main(String[] args) {
        Book book = new Book();
        book.setNameBook("Отцы и Дети");
        book.setNameAuthor("И.С.Тургенев");
        book.setPublishDate(1860);
        book.display();

        System.out.println();

        Student student = new Student();
        student.setNameStudent("А.А.Иванов");
        student.setNumberPassbook(2);
        student.setAverageGrade(3.4f);
        student.print();

        System.out.println();

        Point point = new Point();
        point.setCoordinateX(5.54f);
        point.setCoordinateY(1.23f);
        System.out.println("Исходные координаты: (" + point.getCoordinateX() + ", " + point.getCoordinateY() + ")");
        point.moveUp();
        point.moveRight();
        System.out.println("Координаты после перемещения: (" + point.getCoordinateX() + ", " + point.getCoordinateY() + ")");

        System.out.println();

        Clock clock = new Clock();
        clock.setHours(32);
        clock.setMinutes(23);
        clock.setSeconds(42);
        clock.readTime();
        clock.tick();
        clock.readTime();

        System.out.println();

        Car car = new Car();
        car.setMark("Toyota");
        car.setModel("Crown2");
        car.setYear(1999);
        car.start();
        car.drive(50);
        car.stop();
    }
}