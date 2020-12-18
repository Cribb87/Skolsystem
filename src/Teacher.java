import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christoffer Grännby
 * Date: 2020-12-18
 * Time: 13:39
 * Project: Skolsystem
 * Copyright: MIT
 */
public class Teacher extends Person {

    String password = "1234";

    public Teacher(String name, String age, String mail, String number){
        super.name = name;
        super.age = age;
        super.mail = mail;
        super.number = number;
    }

    private List<Teacher> teacherList = new ArrayList<>();

    public Teacher() {

    }

    public List<Teacher> getTeachers(){
        return teacherList;
    }

    public String getPassword() {
        return password;
    }
}
