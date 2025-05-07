package schoolms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Menu extends JFrame implements ActionListener {
    JButton account, classs, exam, student, mark, teacher, logout, quit;

    public Menu() {

        setTitle("Menu Page");

        //setting Main labels
        JLabel maint = new JLabel("Main Menu");
        maint.setFont(new Font("Arial", Font.BOLD, 30));
        maint.setBounds(50, 20, 250, 30);
        maint.setForeground(new Color(118, 212, 238, 255));
        this.add(maint);

        JLabel sms = new JLabel("School Management System");
        sms.setFont(new Font("Arial", Font.BOLD, 30));
        sms.setBounds(345, 20, 450, 30);
        sms.setForeground(new Color(255, 166, 164));
        this.add(sms);

        JLabel usern = new JLabel("Username: ");
        usern.setFont(new Font("Arial", Font.BOLD, 20));
        usern.setBounds(650, 60, 150, 30);
        usern.setForeground(new Color(255, 166, 164));
        this.add(usern);

        JLabel usernt = new JLabel(login.username);
        usernt.setFont(new Font("Arial", Font.BOLD, 20));
        usernt.setBounds(750, 60, 150, 30);
        usernt.setForeground(new Color(255, 166, 164));
        this.add(usernt);

        JLabel usert = new JLabel("User type: ");
        usert.setFont(new Font("Arial", Font.BOLD, 20));
        usert.setBounds(650, 90, 150, 30);
        usert.setForeground(new Color(255, 166, 164));
        this.add(usert);

        JLabel usertt = new JLabel(login.usertype);
        usertt.setFont(new Font("Arial", Font.BOLD, 20));
        usertt.setBounds(750, 90, 150, 30);
        usertt.setForeground(new Color(255, 166, 164));
        this.add(usertt);

        ImageIcon background_image = new ImageIcon(getClass().getResource("/schoolms/pics/mainmbg.png"));
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(850, 550, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel menubg = new JLabel("", background_image, JLabel.CENTER);
        menubg.setBounds(0, 0, 850, 550);

        ImageIcon background_image1 = new ImageIcon(getClass().getResource("/schoolms/pics/menu1.png"));
        Image img1 = background_image1.getImage();
        Image temp_img1 = img1.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        background_image1 = new ImageIcon(temp_img1);
        JLabel menu1 = new JLabel("", background_image1, JLabel.CENTER);
        menu1.setBounds(8, 22, 50, 30);
        this.add(menu1);

        ImageIcon background_image2 = new ImageIcon(getClass().getResource("/schoolms/pics/school.png"));
        Image img2 = background_image2.getImage();
        Image temp_img2 = img2.getScaledInstance(350, 220, Image.SCALE_SMOOTH);
        background_image2 = new ImageIcon(temp_img2);
        JLabel schimg = new JLabel("", background_image2, JLabel.CENTER);
        schimg.setBounds(400, 200, 350, 220);
        this.add(schimg);

        //setting buttons

        account = new JButton("Account");
        account.setBounds(50, 70, 150, 35);
        account.setBackground(new Color(118, 212, 238, 255));
        account.setForeground(new Color(120, 0, 0));
        account.setFont(new Font("Arial", Font.BOLD, 20));
        account.addActionListener(this);
        this.add(account);

        classs = new JButton("Class");
        classs.setBounds(50, 120, 150, 35);
        classs.setBackground(new Color(118, 212, 238, 255));
        classs.setForeground(new Color(120, 0, 0));
        classs.setFont(new Font("Arial", Font.BOLD, 20));
        classs.addActionListener(this);
        this.add(classs);

        exam = new JButton("Exam");
        exam.setBounds(50, 170, 150, 35);
        exam.setBackground(new Color(118, 212, 238, 255));
        exam.setForeground(new Color(120, 0, 0));
        exam.setFont(new Font("Arial", Font.BOLD, 20));
        exam.addActionListener(this);
        this.add(exam);

        student = new JButton("Student");
        student.setBounds(50, 220, 150, 35);
        student.setBackground(new Color(118, 212, 238, 255));
        student.setForeground(new Color(120, 0, 0));
        student.setFont(new Font("Arial", Font.BOLD, 20));
        student.addActionListener(this);
        this.add(student);

        mark = new JButton("Mark");
        mark.setBounds(50, 270, 150, 35);
        mark.setBackground(new Color(118, 212, 238, 255));
        mark.setForeground(new Color(120, 0, 0));
        mark.setFont(new Font("Arial", Font.BOLD, 20));
        mark.addActionListener(this);
        this.add(mark);

        teacher = new JButton("Teacher");
        teacher.setBounds(50, 320, 150, 35);
        teacher.setBackground(new Color(118, 212, 238, 255));
        teacher.setForeground(new Color(120, 0, 0));
        teacher.setFont(new Font("Arial", Font.BOLD, 20));
        teacher.addActionListener(this);
        this.add(teacher);

        logout = new JButton("Logout");
        logout.setBounds(50, 370, 150, 35);
        logout.setBackground(new Color(118, 212, 238, 255));
        logout.setForeground(new Color(120, 0, 0));
        logout.setFont(new Font("Arial", Font.BOLD, 20));
        logout.addActionListener(this);
        this.add(logout);

        quit = new JButton("Quit");
        quit.setBounds(50, 420, 150, 35);
        quit.setBackground(new Color(118, 212, 238, 255));
        quit.setForeground(new Color(120, 0, 0));
        quit.setFont(new Font("Arial", Font.BOLD, 20));
        quit.addActionListener(this);
        this.add(quit);

        // setting frame
        this.setSize(850, 550);
        this.setLayout(null);
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.add(menubg);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (login.usertype.equals("Admin")) {
            if (e.getSource() == account) {
                new create();
                this.setVisible(false);
            } else if (e.getSource() == teacher) {
                new teacher();
                this.setVisible(false);
            } else if (e.getSource() == classs) {
                new classs();
                this.setVisible(false);
            } else if (e.getSource() == student) {
                new Student();
                this.setVisible(false);
            } else if (e.getSource() == exam) {
                new Subject();
                this.setVisible(false);
            } else if (e.getSource() == mark) {
                new mark();
                this.setVisible(false);
            } else if (e.getSource() == logout) {
                new login();
                this.setVisible(false);
            } else if (e.getSource() == quit) {
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Your current account permissions do not allow this action. ", "Access Denied", JOptionPane.WARNING_MESSAGE);
            }
        } else if (login.usertype.equals("Teacher")) {
            if (e.getSource() == classs) {
                new classs();
                this.setVisible(false);
            } else if (e.getSource() == teacher) {
                new teacher();
                this.setVisible(false);
            } else if (e.getSource() == student) {
                new Student();
                this.setVisible(false);
            } else if (e.getSource() == exam) {
                new Subject();
                this.setVisible(false);
            } else if (e.getSource() == mark) {
                new mark();
                this.setVisible(false);
            } else if (e.getSource() == logout) {
                new login();
                this.setVisible(false);
            } else if (e.getSource() == quit) {
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Your current account permissions do not allow this action. ", "Access Denied", JOptionPane.WARNING_MESSAGE);
            }

        } else if (login.usertype.equals("Guest")) {
            if (e.getSource() == student) {
                new Student();
                this.setVisible(false);
            } else if (e.getSource() == mark) {
                new mark();
                this.setVisible(false);
            } else if (e.getSource() == teacher) {
                new teacher();
                this.setVisible(false);
            } else if (e.getSource() == logout) {
                new login();
                this.setVisible(false);
            } else if (e.getSource() == quit) {
                this.dispose();
            } else if (e.getSource()==classs) {
                new classs();
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Your current account permissions do not allow this action. ", "Access Denied", JOptionPane.WARNING_MESSAGE);
            }

        } else if (login.usertype.equals("Student")) {
            if (e.getSource() == exam) {
                new Subject();
                this.setVisible(false);
            } else if (e.getSource() == mark) {
                new mark();
                this.setVisible(false);
            } else if (e.getSource() == logout) {
                new login();
                this.setVisible(false);
            } else if (e.getSource() == quit) {
                System.exit(0);
            } else {
                JOptionPane.showMessageDialog(this, "Your current account permissions do not allow this action. ", "Access Denied", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Your current account permissions do not allow this action. ", "Access Denied", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static void main(String[] userStrings) {
        new Menu();
    }
}
