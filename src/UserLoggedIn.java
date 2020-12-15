import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserLoggedIn extends JFrame {

    Database d = new Database();

    private JTextArea infoField = new JTextArea();
    private JButton login = new JButton("Logga in");
    private JTextField name = new JTextField("Ange namn");
    private JTextField password = new JTextField("Ange lösenord");
    private JButton ok = new JButton("Okej");
    private JButton information = new JButton("Information");
    private JButton courseSearch = new JButton("Sök efter kurser");
    private JButton teacherSearch = new JButton("Sök efter lärare");
    private JButton studentSearch = new JButton("Sök efter elever");
    private JButton infoButton = new JButton("Tryck för info om skolan");
    private JTextField searchField = new JTextField("Sök här");
    private JPanel bottomPanel = new JPanel();
    private JPanel northPanel = new JPanel();
    private JPanel southPanel = new JPanel();
    private JPanel centerPanel = new JPanel();
    private Teacher teacher = new Teacher();


    public UserLoggedIn(){

        bottomPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new BorderLayout());
        northPanel.setLayout(new GridLayout(2,2));
        southPanel.setLayout(new GridLayout(2, 2));
        centerPanel.setLayout(new BorderLayout());

        bottomPanel.add(northPanel, BorderLayout.NORTH);
        bottomPanel.add(southPanel, BorderLayout.SOUTH);
        bottomPanel.add(centerPanel, BorderLayout.CENTER);

        southPanel.add(teacherSearch);
        southPanel.add(studentSearch);
        southPanel.add(courseSearch);
        southPanel.add(infoButton);

        teacherSearch.setVisible(false);
        studentSearch.setVisible(false);
        courseSearch.setVisible(false);
        infoButton.setVisible(false);

        northPanel.add(login);
        northPanel.add(information);
        northPanel.setBackground(Color.WHITE);

        login.setVisible(true);
        information.setVisible(true);
        northPanel.add(name);
        northPanel.add(password);
        name.setVisible(false);
        password.setVisible(false);

        centerPanel.add(infoField, BorderLayout.NORTH);
        centerPanel.setBackground(Color.WHITE);
        southPanel.setBackground(Color.WHITE);
        infoField.setFont(new Font("Monaco", Font.PLAIN, 18));

        infoField.setEditable(false);


        add(bottomPanel);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        login.addActionListener(e ->{
            login.setVisible(false);
            information.setVisible(false);
            name.setVisible(true);
            password.setVisible(true);
            northPanel.add(name, BorderLayout.SOUTH);
            northPanel.add(password, BorderLayout.SOUTH);

            name.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    super.keyPressed(e);
                    if (name.getText().equals("Ange namn")){
                        name.setText("");
                    }
                }
            });
            password.addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    super.keyPressed(e);
                    if (password.getText().equals("Ange lösenord")){
                        password.setText("");
                    }
                }
            });
            southPanel.add(ok);
            ok.addActionListener(e1 -> {
                if (name.getText().equals(d.searchTeacher(getName())) && password.getText().equals(d.searchTeacher(teacher.getPassword())));
            });
        } );

        information.addActionListener(e -> {
            bottomPanel.setLayout(new BorderLayout());
            northPanel.setLayout(new BorderLayout());
            northPanel.setLayout(new GridLayout(2,2));
            southPanel.setLayout(new GridLayout(2, 2));
            centerPanel.setLayout(new BorderLayout());

            bottomPanel.add(northPanel, BorderLayout.NORTH);
            bottomPanel.add(southPanel, BorderLayout.SOUTH);
            bottomPanel.add(centerPanel, BorderLayout.CENTER);

            southPanel.add(teacherSearch);
            southPanel.add(studentSearch);
            southPanel.add(courseSearch);
            southPanel.add(infoButton);

            teacherSearch.setVisible(true);
            studentSearch.setVisible(true);
            courseSearch.setVisible(true);
            infoButton.setVisible(true);
            login.setVisible(false);
            information.setVisible(false);

            centerPanel.add(infoField, BorderLayout.NORTH);
            centerPanel.add(searchField, BorderLayout.SOUTH);
            centerPanel.setBackground(Color.WHITE);
            infoField.setFont(new Font("Monaco", Font.PLAIN, 18));

            infoField.setEditable(false);


            add(bottomPanel);
            setSize(500, 500);
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(EXIT_ON_CLOSE);
        });

        courseSearch.addActionListener(e->{
            if (!searchField.getText().isEmpty()) {
                Course course = d.searchCourse(searchField.getText());
                if (course == null)
                    infoField.setText("Kursen finns inte");
                else infoField.setText(d.printCourse(searchField.getText()));
            }
        });

        studentSearch.addActionListener(e->{
            if (!searchField.getText().isEmpty()) {
                Person student = d.searchStudent(searchField.getText());
                if (student == null)
                infoField.setText("Eleven finns inte");
                else infoField.setText(d.printStudent(searchField.getText()));
            }
        });

        teacherSearch.addActionListener(e->{

            if (!searchField.getText().isEmpty()) {
                Teacher teacher = d.searchTeacher(searchField.getText());
                if (teacher == null)
                infoField.setText("Läraren finns inte");
                else infoField.setText(d.printTeacher(searchField.getText()));
            }
        });

        infoButton.addActionListener(e->{
            infoField.setText("Välkommen till Noob skolan!" +
                    "\nDu kan hitta oss på Noobgatan 69" +
                    "\n------------------Kontakt------------------\n" +
                    "Telefonnummer: 0704955146\n" +
                    "Mail: n00bSkolan@n00bSchool.n00b");
        });

        searchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if (searchField.getText().equals("Sök här")){
                    searchField.setText("");
                }
            }
        });
    }
}