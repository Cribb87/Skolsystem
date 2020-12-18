import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christoffer Grännby
 * Date: 2020-12-18
 * Time: 13:39
 * Project: Skolsystem
 * Copyright: MIT
 */
public class Student extends Person{

    public Student(String name, String age, String mail, String number){
        super.name = name;
        super.age = age;
        super.mail = mail;
        super.number = number;
    }

    private List<Student> studentList = new ArrayList<>();

    public Student() {
    }

    public List<Student> getStudents(){
        return studentList;
    }
}
