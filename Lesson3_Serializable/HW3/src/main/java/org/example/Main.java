package org.example;

import java.io.*;

public class Main {
    /*
   Разработайте класс Student с полями
   String name, int age, transient double GPA (средний балл).
   Обеспечьте поддержку сериализации для этого класса.
   Создайте объект класса Student и инициализируйте его данными.
   Сериализуйте этот объект в файл. Десериализуйте объект обратно в программу из файла.
   Выведите все поля объекта, включая GPA, и обсудите,
   почему значение GPA не было сохранено/восстановлено.

    */
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student = new Student("Mike", 23, 4.5);
        try (FileOutputStream fileOutputStream = new FileOutputStream("student.bin");
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            objectOutputStream.writeObject(student);
            System.out.println("Объект student успешно сериализован.");
        }

        try (FileInputStream fileInputStream = new FileInputStream("student.bin");
             ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
            student = (Student) objectInputStream.readObject();
        }

        System.out.println("Объект student успешно Десериализован.");
        System.out.println("Имя студента: " + student.getName());
        System.out.println("Возраст: " + student.getAge());
        System.out.println("Средний балл (должно быть null или 0.0, так как transient): " + student.getGPA());

    }
}