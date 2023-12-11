package ExtraStudentTask;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Student implements Externalizable {

    //region Поля

    /**
     * ФИО студента
     */
    private String name;

    /**
     * Возраст студента
     */
    private int age;

    /**
     * Средний балл
     */
    private transient double GPA;

    //endregion

    //region Конструкторы

    public Student(String name, int age, double GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA;
    }

    public Student(String newTaskTitle) {
    }

    //endregion

    //region Externalizable implementation

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(name);
        out.writeObject(age);
        out.writeObject(GPA);

    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = (String) in.readObject();
        age = (int) in.readObject();
        GPA = (double) in.readObject();

    }
    //endregion

    //region Методы

    /**
     * Получить имя студента
     *
     * @return имя студента
     */
    public String getName() {
        return name;
    }

    /**
     * Получить возраст студента
     *
     * @return возраст студента
     */
    public int getAge() {
        return age;
    }

    /**
     * Получить средний балл студента
     *
     * @return средний балл студента
     */
    public double getGPA() {
        return GPA;
    }
    //endregion
}
