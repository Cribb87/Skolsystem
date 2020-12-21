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

    protected final String password = "1234";

    private List<Teacher> teacherList = new ArrayList<>();

    public Teacher(String name, String age, String mail, String number){
        super.name = name;
        super.age = age;
        super.mail = mail;
        super.number = number;
    }

    public Teacher() {
    }

    public List<Teacher> getTeachers(){
        return teacherList;
    }

    public String getPassword() {
        return password;
    }
}
