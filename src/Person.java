import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christoffer Grännby
 * Date: 2020-12-18
 * Time: 13:39
 * Project: Skolsystem
 * Copyright: MIT
 */
public class Person {

    protected String name;
    protected String age;
    protected String mail;
    protected String number;

    private List<Course> courseList = new ArrayList<>();

    public Person(){}

    public Person(String name, String age, String mail, String number) {
        this.name = name;
        this.age = age;
        this.mail = mail;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getMail() {
        return mail;
    }

    public String getNumber() {
        return number;
    }

    public void addCourses(Course course){
        courseList.add(course);
    }

    public List<Course> getCourses(){
        return courseList;
    }
}