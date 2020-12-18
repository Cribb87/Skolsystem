import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christoffer Grännby
 * Date: 2020-12-18
 * Time: 13:39
 * Project: Skolsystem
 * Copyright: MIT
 */
public class Database {

    private List <Student> studentsList = new ArrayList<>();
    private List <Teacher> teacherList = new ArrayList<>();
    private List<Course> courseList = new ArrayList<>();

    public void addCourse(Course course){
        courseList.add(course);
    }

    public void addStudent(Student student){ studentsList.add(student); }

    public void addTeacher(Teacher teacher){
        teacherList.add(teacher);
    }

    public Course searchCourse(String string){
        for (Course course : courseList) {
            if (string.equalsIgnoreCase(course.getName())){
                return course;
            }
        }
        return null;
    }
    public Teacher searchTeacher(String string){
        for (Teacher teacher : teacherList) {
            if (string.equalsIgnoreCase(teacher.getName())){
                return teacher;
            }
        }
        return null;
    }

    public Student searchStudent(String string){
        for (Student person : studentsList) {
            if (string.equalsIgnoreCase(person.getName())){
                return person;
            }
        }
        return null;
    }
    public String printCourse(String courseToSearchAndPrint) {
        Course courseToPrint = searchCourse(courseToSearchAndPrint);

        String textToPrint = "Kurs: " + courseToPrint.getName() + "\n" + "Lärare: " + courseToPrint.getTeacher().getName() + "\n" + "Studenter: ";

        for (Student p : courseToPrint.getCourseStudentList()) {
            textToPrint += "\n" + p.getName();
        }

        return textToPrint;
    }

    public String printTeacher(String teacherToSearchAndPrint) {
        Teacher teacher = searchTeacher(teacherToSearchAndPrint);

        String textToPrint = "Namn: " + teacher.getName() + "\n" + "Ålder: " + teacher.getAge() + "\n" + "Mail: " + teacher.getMail() + "\n" + "Telefonnummer: " + teacher.getNumber() + "\n" + teacher.getName() + " utbildar de här kurserna: ";


        for (Course findCourse : teacher.getCourses()){
            textToPrint += "\n" + findCourse.getName();
        }


        textToPrint += "\n" + teacher.getName() + " är lärare över de här eleverna: ";

        for (Course courseStudents : teacher.getCourses()){
            for (Student studentInClass : courseStudents.getCourseStudentList()){
                if (!textToPrint.contains(studentInClass.getName())){
                    textToPrint += "\n" + studentInClass.getName();
                }
            }
        }


        return textToPrint;
    }

    public String printStudent(String studentToSearchAndPrint) {
        Student studentName = searchStudent(studentToSearchAndPrint);

        String textToPrint = "Namn: " + studentName.getName() + "\n" + "Ålder: " + studentName.getAge() + "\n" + "Mail: " + studentName.getMail() + "\n" + "Telefonnummer: " + studentName.getNumber() + "\n" + studentName.getName() + " går på dom här kurserna: ";

        for (Course coursesStudentIsIn : studentName.getCourses()){
            textToPrint += "\n" + coursesStudentIsIn.getName();
        }

        textToPrint += "\n" + studentName.getName() + " blir utbildad av de här lärarna: ";

        for (Course coursesStudentHas : studentName.getCourses()){
            textToPrint += "\n" + coursesStudentHas.getTeacher().getName();
        }


        return textToPrint;
    }

    public Database(){

        Teacher teacherOne = new Teacher("Steffe", "40","Steffe@mail.com","0737856513");
        Teacher teacherTwo = new Teacher("Cribb", "65", "Cribb@cribb.net", "8844556644");
        Teacher teacherThree = new Teacher("Anders", "51", "Anders@mail.com","0735654655");
        Teacher teacherFour = new Teacher("Lars", "30","Lars@mail.com","073565465");

        Course courseOne = new Course("Sexualkunskap", teacherThree);
        Course courseTwo = new Course("Java",teacherFour);
        Course courseThree = new Course("Matematik", teacherTwo);
        Course courseFour = new Course("Idrott", teacherOne);

        Student studentOne = new Student("Lily", "14", "lily@mail.com","0723221354");
        Student studentTwo = new Student("Simon","12","simon_kool@mail.com", "0756516516");
        Student studentThree = new Student("Daniel", "13", "daniel_small@mail.com","98446512");
        Student studentFour = new Student("Kalle", "15" , "kalle@mail.com", "654165131");
        Student studentFive = new Student("Sossen", "14","sosse@sosse.se", "6541321321");

        teacherOne.addCourses(courseFour);
        teacherTwo.addCourses(courseThree);
        teacherThree.addCourses(courseOne);
        teacherFour.addCourses(courseTwo);

        studentOne.addCourses(courseOne);
        studentOne.addCourses(courseFour);
        studentOne.addCourses(courseThree);

        studentTwo.addCourses(courseOne);

        studentThree.addCourses(courseOne);
        studentThree.addCourses(courseTwo);

        studentFour.addCourses(courseFour);

        studentFive.addCourses(courseTwo);
        studentFive.addCourses(courseThree);
        studentFive.addCourses(courseFour);

        addCourse(courseOne);
        addCourse(courseTwo);
        addCourse(courseThree);
        addCourse(courseFour);

        addStudent(studentOne);
        addStudent(studentTwo);
        addStudent(studentThree);
        addStudent(studentFour);
        addStudent(studentFive);

        addTeacher(teacherOne);
        addTeacher(teacherThree);
        addTeacher(teacherTwo);
        addTeacher(teacherFour);

        courseOne.addStudent(studentOne);
        courseOne.addStudent(studentTwo);
        courseOne.addStudent(studentThree);

        courseTwo.addStudent(studentThree);
        courseTwo.addStudent(studentFive);

        courseThree.addStudent(studentOne);
        courseThree.addStudent(studentFive);

        courseFour.addStudent(studentFour);
        courseFour.addStudent(studentFive);
        courseFour.addStudent(studentOne);
    }
}
