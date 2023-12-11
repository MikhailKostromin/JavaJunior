package ExtraStudentTask;

/**
 *  1.Разработайте класс Student с полями
 *    String name, int age, transient double GPA (средний балл).
 *    Обеспечьте поддержку сериализации для этого класса.
 *    Создайте объект класса Student и инициализируйте его данными.
 *    Сериализуйте этот объект в файл. Десериализуйте объект обратно в программу из файла.
 *    Выведите все поля объекта, включая GPA, и обсудите,
 *    почему значение GPA не было сохранено/восстановлено.
 *
 *    Выполнить задачу 1 используя другие типы сериализаторов (в xml и json документы).
 */

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static ExtraStudentTask.StudentListApp.loadStudentsFromFile;
import static ExtraStudentTask.StudentListApp.*;


public class Program {
    public static void main(String[] args) {

        List<Student> students;
        File f = new File(FILE_JSON);
        if (f.exists() && !f.isDirectory())
            students = loadStudentsFromFile(FILE_JSON);
        else
            students = prepareStudents();

        saveStudentsToFile(FILE_JSON, students);
        saveStudentsToFile(FILE_BIN, students);
        saveStudentsToFile(FILE_XML, students);

        displayStudents(students);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Добавить студента");
//        System.out.println("2. Отметить задачу как выполненную");
            System.out.println("2. Выйти");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    addNewStudent(scanner, students);
                    break;
                case "2":
                    saveStudentsToFile(FILE_JSON, students);
                    saveStudentsToFile(FILE_BIN, students);
                    saveStudentsToFile(FILE_XML, students);
                    System.out.println("Список задач сохранен.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
                    break;
            }
            displayStudents(students);


        }

    }
    static List<Student> prepareStudents() {
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Mike", 23, 4.5));
        list.add(new Student("Bob", 33, 4.9));
        list.add(new Student("Mary", 19, 3.5));
        return list;
    }
}

