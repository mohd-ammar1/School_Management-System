package schoolms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class mark extends JFrame implements ActionListener {
    JMenuBar menub = new JMenuBar();
    JMenuItem mmenu, create, classs, subject, exam, student, mark, teacher, logout, quit;
    JTextField text_id, text_sname, text_marks;
    String classes[] = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
    String term1[] = {"", "First Term", "Second Term", "Final Term"};
    JComboBox combo_class = new JComboBox(classes);
    JComboBox combo_term = new JComboBox(term1);
    JButton save, delete, edit, clear, search, out, refresh;
    JLabel uname_txt, type_txt;

    public mark() {
        ImageIcon bgimg = new ImageIcon(getClass().getResource("/schoolms/pics/grediant.jpg"));
        Image temp_bgimg = bgimg.getImage().getScaledInstance(800, 640, Image.SCALE_SMOOTH);
        bgimg = new ImageIcon(temp_bgimg);
        JLabel mbg = new JLabel("", bgimg, JLabel.CENTER);
        mbg.setBounds(0, 0, 800, 640);

        ImageIcon brd = new ImageIcon(getClass().getResource("/schoolms/pics/mrkbrd1.png"));
        Image temp_brd = brd.getImage().getScaledInstance(300, 600, Image.SCALE_SMOOTH);
        brd = new ImageIcon(temp_brd);
        JLabel jbrd = new JLabel("", brd, JLabel.CENTER);
        jbrd.setBounds(0, 0, 300, 600);

        ImageIcon outimg = new ImageIcon(getClass().getResource("/schoolms/pics/logouticon.png"));
        Image temp_img1 = outimg.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        outimg = new ImageIcon(temp_img1);

        ImageIcon refreshimg = new ImageIcon(getClass().getResource("/schoolms/pics/refreshpng.png"));
        Image refresh1 = refreshimg.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        refreshimg = new ImageIcon(refresh1);

        //Setting navigation

        menub.setLayout(new BoxLayout(menub, BoxLayout.X_AXIS));
        this.setJMenuBar(menub);
        JMenu menu = new JMenu("Hyperlinks");
        menub.add(menu);
        menu.setForeground(new Color(13, 177, 240));
        menu.setFont(new Font("Arial", Font.BOLD, 20));
        mmenu = new JMenuItem("Main Menu");
        mmenu.setForeground(new Color(13, 177, 240));
        mmenu.setFont(new Font("Arial", Font.BOLD, 17));
        mmenu.addActionListener(this);

        create = new JMenuItem("create Account");
        create.setForeground(new Color(13, 177, 240));
        create.setFont(new Font("Arial", Font.BOLD, 17));
        create.addActionListener(this);

        classs = new JMenuItem("Class");
        classs.setForeground(new Color(13, 177, 240));
        classs.setFont(new Font("Arial", Font.BOLD, 17));
        classs.addActionListener(this);

        subject = new JMenuItem("Subject");
        subject.setForeground(new Color(13, 177, 240));
        subject.setFont(new Font("Arial", Font.BOLD, 17));
        subject.addActionListener(this);

        exam = new JMenuItem("Exam");
        exam.setForeground(new Color(13, 177, 240));
        exam.setFont(new Font("Arial", Font.BOLD, 17));
        exam.addActionListener(this);

        student = new JMenuItem("Student");
        student.setForeground(new Color(13, 177, 240));
        student.setFont(new Font("Arial", Font.BOLD, 17));
        student.addActionListener(this);

        mark = new JMenuItem("Mark");
        mark.setForeground(new Color(13, 177, 240));
        mark.setFont(new Font("Arial", Font.BOLD, 17));
        mark.addActionListener(this);

        teacher = new JMenuItem("Teacher");
        teacher.setForeground(new Color(13, 177, 240));
        teacher.setFont(new Font("Arial", Font.BOLD, 17));
        teacher.addActionListener(this);

        logout = new JMenuItem("Logout!");
        logout.setForeground(new Color(13, 177, 240));
        logout.setFont(new Font("Arial", Font.BOLD, 17));
        logout.addActionListener(this);

        quit = new JMenuItem("Quit");
        quit.setForeground(new Color(13, 177, 240));
        quit.setFont(new Font("Arial", Font.BOLD, 17));
        quit.addActionListener(this);

        menu.add(mmenu);
        menu.add(create);
        menu.add(classs);
        menu.add(subject);
        menu.add(exam);
        menu.add(student);
        menu.add(mark);
        menu.add(teacher);
        menu.add(logout);
        menu.add(quit);

        //Setting Jpanel

        JPanel jp = new JPanel(null);
        jp.setBounds(300, 0, 500, 80);
        this.add(jp);

        out = new JButton((Icon) outimg);
        jp.add(out);
        out.setBounds(430, 8, 40, 30);
        out.setBackground(new Color(255, 255, 255));
        out.addActionListener(this);

        refresh = new JButton((Icon) refreshimg);
        jp.add(refresh);
        refresh.setBounds(430, 45, 40, 30);
        refresh.setBackground(new Color(255, 255, 255));
        refresh.addActionListener(this);

        JLabel uname = new JLabel("Username:");
        uname.setBounds(10, 15, 120, 22);
        uname.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        uname.setForeground(new Color(13, 177, 240));
        jp.add(uname);

        uname_txt = new JLabel(login.username);
        uname_txt.setBounds(130, 15, 120, 22);
        uname_txt.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        uname_txt.setForeground(new Color(13, 177, 240));
        jp.add(uname_txt);

        JLabel type = new JLabel("User type:");
        type.setBounds(10, 50, 120, 22);
        type.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        type.setForeground(new Color(13, 177, 240));
        jp.add(type);

        type_txt = new JLabel(login.usertype);
        type_txt.setBounds(130, 50, 120, 22);
        type_txt.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        type_txt.setForeground(new Color(13, 177, 240));
        jp.add(type_txt);

        //Setting greenboard items

        JLabel mAIn = new JLabel("MARK DETAILS");
        mAIn.setBounds(25, 30, 300, 30);
        mAIn.setFont(new Font("Arial", Font.BOLD, 35));
        mAIn.setForeground(new Color(13, 177, 240));
        this.add(mAIn);

        JLabel sid = new JLabel("Student id");
        sid.setBounds(25, 70, 120, 30);
        sid.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        sid.setForeground(new Color(13, 177, 240));
        this.add(sid);

        text_id = new JTextField();
        text_id.setBounds(25, 100, 250, 30);
        text_id.setFont(new Font("Arial", Font.PLAIN, 20));
        text_id.setForeground(new Color(13, 177, 240));
        this.add(text_id);

        JLabel sname = new JLabel("Student Name");
        sname.setBounds(25, 140, 150, 30);
        sname.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        sname.setForeground(new Color(13, 177, 240));
        this.add(sname);

        text_sname = new JTextField();
        text_sname.setBounds(25, 170, 250, 30);
        text_sname.setFont(new Font("Arial", Font.PLAIN, 20));
        text_sname.setForeground(new Color(13, 177, 240));
        this.add(text_sname);

        JLabel clas = new JLabel("Class");
        clas.setBounds(25, 210, 120, 30);
        clas.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        clas.setForeground(new Color(13, 177, 240));
        this.add(clas);

        combo_class.setBounds(25, 240, 250, 30);
        combo_class.setFont(new Font("Arial", Font.PLAIN, 20));
        combo_class.setForeground(new Color(13, 177, 240));
        this.add(combo_class);

        JLabel term = new JLabel("Term");
        term.setBounds(25, 280, 150, 30);
        term.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        term.setForeground(new Color(13, 177, 240));
        this.add(term);

        combo_term.setBounds(25, 310, 250, 30);
        combo_term.setFont(new Font("Arial", Font.PLAIN, 20));
        combo_term.setForeground(new Color(13, 177, 240));
        this.add(combo_term);

        JLabel mark = new JLabel("Marks");
        mark.setBounds(25, 350, 150, 30);
        mark.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        mark.setForeground(new Color(13, 177, 240));
        this.add(mark);

        text_marks = new JTextField();
        text_marks.setBounds(25, 380, 250, 30);
        text_marks.setFont(new Font("Arial", Font.PLAIN, 20));
        text_marks.setForeground(new Color(13, 177, 240));
        this.add(text_marks);

        save = new JButton("Save");
        save.setBounds(165, 430, 110, 30);
        save.setFont(new Font("Arial", Font.PLAIN, 20));
        save.setForeground(new Color(13, 177, 240));
        save.addActionListener(this);
        this.add(save);

        edit = new JButton("Edit");
        edit.setBounds(25, 430, 110, 30);
        edit.setFont(new Font("Arial", Font.PLAIN, 20));
        edit.setForeground(new Color(13, 177, 240));
        edit.addActionListener(this);
        this.add(edit);

        delete = new JButton("Delete");
        delete.setBounds(25, 470, 110, 30);
        delete.setFont(new Font("Arial", Font.PLAIN, 20));
        delete.setForeground(new Color(13, 177, 240));
        delete.addActionListener(this);
        this.add(delete);

        clear = new JButton("Clear");
        clear.setBounds(165, 470, 110, 30);
        clear.setFont(new Font("Arial", Font.PLAIN, 20));
        clear.setForeground(new Color(13, 177, 240));
        clear.addActionListener(this);
        this.add(clear);

        search = new JButton("Search");
        search.setBounds(50, 510, 200, 30);
        search.setFont(new Font("Arial", Font.PLAIN, 20));
        search.setForeground(new Color(13, 177, 240));
        search.addActionListener(this);
        this.add(search);


        add(jbrd);
        add(mbg);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setSize(800, 650);
    }

    public static void main(String[] args) {
        new mark();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==mmenu)
        {
            new Menu();
            this.setVisible(false);
        }
    }
}
