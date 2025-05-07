package schoolms;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class classs extends JFrame implements ActionListener {
    JComboBox<String> bclass = new JComboBox<>(new String[]{"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"});
    JComboBox<String> bsec = new JComboBox<>(new String[]{"", "A", "B", "C"});
    JButton save, edit, delete, clear, out, refresh;
    JTextField tstdstr;
    JLabel uname_txt, type_txt;
    JMenuBar menub = new JMenuBar();
    JMenuItem mmenu,create, classs, subject, exam, student, mark, teacher, logout, quit;
    String usertype, user1;
    JTable cltable;
    DefaultTableModel model;


    public classs() {
        login.usertype="Guest";

        ImageIcon background_image = new ImageIcon(getClass().getResource("/schoolms/pics/mainmbg.png"));
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(850, 550, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel menubg = new JLabel("", background_image, JLabel.CENTER);
        menubg.setBounds(0, 0, 850, 550);

        ImageIcon brd = new ImageIcon(getClass().getResource("/schoolms/pics/mrkbrd1.png"));
        Image temp_brd = brd.getImage().getScaledInstance(260, 400, Image.SCALE_SMOOTH);
        brd = new ImageIcon(temp_brd);
        JLabel jbrd = new JLabel("", brd, JLabel.CENTER);
        jbrd.setBounds(0, 0, 260, 400);

        ImageIcon clasicon = new ImageIcon(getClass().getResource("/schoolms/pics/clasicon.png"));
        Image temp_clasicon = clasicon.getImage().getScaledInstance(40,40,Image.SCALE_SMOOTH);
        clasicon = new ImageIcon(temp_clasicon);
        JLabel cicon = new JLabel("",clasicon,JLabel.CENTER);
        cicon.setBounds(10,20,40,40);
        add(cicon);

        ImageIcon jpbg = new ImageIcon(getClass().getResource("/schoolms/pics/lwood.jpg"));
        Image temp_jpbg = jpbg.getImage().getScaledInstance(545,80,Image.SCALE_SMOOTH);
        jpbg = new ImageIcon(temp_jpbg);
        JLabel Jpbg = new JLabel("",jpbg,JLabel.CENTER);
        Jpbg.setBounds(0,0,545,80);


        ImageIcon background_image1 = new ImageIcon(getClass().getResource("/schoolms/pics/logouticon.png"));
        Image temp_img1 = background_image1.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        background_image1 = new ImageIcon(temp_img1);

        ImageIcon refreshimg = new ImageIcon(getClass().getResource("/schoolms/pics/refreshpng.png"));
        Image refresh1 = refreshimg.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        refreshimg = new ImageIcon(refresh1);

        ImageIcon child = new ImageIcon(getClass().getResource("/schoolms/pics/childs1.jpg"));
        Image temp_child = child.getImage().getScaledInstance(525, 80, Image.SCALE_SMOOTH);
        child = new ImageIcon(temp_child);
        JLabel Child = new JLabel("",child,JLabel.CENTER);
        Child.setBounds(260,300,525,100);
        add(Child);



        JLabel head = new JLabel("Class Details");
        head.setBounds(55, 20, 250, 40);
        head.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 30));
        head.setForeground(new Color(114, 213, 237, 255));
        this.add(head);

        JLabel cname = new JLabel("Class Name:");
        cname.setBounds(10, 90, 150, 25);
        cname.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 25));
        cname.setForeground(new Color(114, 213, 237, 255));
        this.add(cname);

        bclass.setBounds(30, 115, 200, 30);
        bclass.setFont(new Font("Arial", Font.PLAIN, 20));
        bclass.setForeground(new Color(13, 177, 240));
        this.add(bclass);

        JLabel sec = new JLabel("Section:");
        sec.setBounds(10, 155, 150, 25);
        sec.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 25));
        sec.setForeground(new Color(114, 213, 237, 255));
        this.add(sec);

        bsec.setBounds(30, 180, 200, 30);
        bsec.setFont(new Font("Arial", Font.PLAIN, 20));
        bsec.setForeground(new Color(13, 177, 240));
        this.add(bsec);

        JLabel stdstr = new JLabel("Student Strength:");
        stdstr.setBounds(10, 220, 250, 25);
        stdstr.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 25));
        stdstr.setForeground(new Color(114, 213, 237, 255));
        this.add(stdstr);

        tstdstr = new JTextField();
        tstdstr.setBounds(30, 245, 200, 30);
        tstdstr.setFont(new Font("Arial", Font.PLAIN, 20));
        tstdstr.setForeground(new Color(13, 177, 240));
        this.add(tstdstr);

        JPanel jp = new JPanel(null);
        jp.setBounds(260, 0, 525, 80);
        this.add(jp);

        out = new JButton((Icon) background_image1);
        jp.add(out);
        out.setBounds(470, 8, 40, 30);
        out.setBackground(new Color(255, 255, 255));
        out.addActionListener(this);

        refresh = new JButton((Icon) refreshimg);
        jp.add(refresh);
        refresh.setBounds(470, 45, 40, 30);
        refresh.setBackground(new Color(255, 255, 255));
        refresh.addActionListener(this);


        JLabel uname = new JLabel("Username:");
        uname.setBounds(10, 15, 120, 22);
        uname.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        uname.setForeground(new Color(255, 166, 164, 255));
        jp.add(uname);

        uname_txt = new JLabel(login.username);
        uname_txt.setBounds(130, 15, 120, 22);
        uname_txt.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        uname_txt.setForeground(new Color(255, 166, 164, 255));
        jp.add(uname_txt);


        JLabel type = new JLabel("User type:");
        type.setBounds(10, 50, 120, 22);
        type.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        type.setForeground(new Color(255, 166, 164, 255));
        jp.add(type);

        type_txt = new JLabel(login.usertype);
        type_txt.setBounds(130, 50, 120, 22);
        type_txt.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        type_txt.setForeground(new Color(255, 166, 164, 255));
        jp.add(type_txt);
        jp.add(Jpbg);

        this.setJMenuBar(menub);
        menub.setBackground(new Color(248, 232, 209));
        JMenu menu = new JMenu("Hyperlinks");
        menub.add(menu);
        menu.setForeground(new Color(13, 177, 240));
        menu.setFont(new Font("Arial", Font.BOLD, 20));


        mmenu = new JMenuItem("Main Menu");
        mmenu.setForeground(new Color(13, 177, 240));
        mmenu.setBackground(new Color(248, 232, 209));
        mmenu.setFont(new Font("Arial", Font.BOLD, 17));
        mmenu.addActionListener(this);

        create = new JMenuItem("create Account");
        create.setForeground(new Color(13, 177, 240));
        create.setBackground(new Color(248, 232, 209));
        create.setFont(new Font("Arial", Font.BOLD, 17));
        create.addActionListener(this);

        classs = new JMenuItem("Class");
        classs.setForeground(new Color(13, 177, 240));
        classs.setBackground(new Color(248, 232, 209));
        classs.setFont(new Font("Arial", Font.BOLD, 17));
        classs.addActionListener(this);

        subject = new JMenuItem("Subject");
        subject.setForeground(new Color(13, 177, 240));
        subject.setBackground(new Color(248, 232, 209));
        subject.setFont(new Font("Arial", Font.BOLD, 17));
        subject.addActionListener(this);

        exam = new JMenuItem("Exam");
        exam.setForeground(new Color(13, 177, 240));
        exam.setBackground(new Color(248, 232, 209));
        exam.setFont(new Font("Arial", Font.BOLD, 17));
        exam.addActionListener(this);

        student = new JMenuItem("Student");
        student.setForeground(new Color(13, 177, 240));
        student.setBackground(new Color(248, 232, 209));
        student.setFont(new Font("Arial", Font.BOLD, 17));
        student.addActionListener(this);

        mark = new JMenuItem("Mark");
        mark.setForeground(new Color(13, 177, 240));
        mark.setBackground(new Color(248, 232, 209));
        mark.setFont(new Font("Arial", Font.BOLD, 17));
        mark.addActionListener(this);

        teacher = new JMenuItem("Teacher");
        teacher.setForeground(new Color(13, 177, 240));
        teacher.setBackground(new Color(248, 232, 209));
        teacher.setFont(new Font("Arial", Font.BOLD, 17));
        teacher.addActionListener(this);

        logout = new JMenuItem("Logout!");
        logout.setForeground(new Color(13, 177, 240));
        logout.setBackground(new Color(248, 232, 209));
        logout.setFont(new Font("Arial", Font.BOLD, 17));
        logout.addActionListener(this);

        quit = new JMenuItem("Quit");
        quit.setForeground(new Color(13, 177, 240));
        quit.setBackground(new Color(248, 232, 209));
        quit.setFont(new Font("Arial", Font.BOLD, 17));
        quit.addActionListener(this);

        menu.add(mmenu);
        menu.add(create);
        menu.add(classs);
        menu.add(exam);
        menu.add(student);
        menu.add(mark);
        menu.add(teacher);
        menu.add(logout);
        menu.add(quit);

        save = new JButton("Save");
        save.setBounds(30, 290, 90, 30);
        save.setFont(new Font("Arial", Font.BOLD, 15));
        save.setForeground(new Color(13, 177, 240));
        save.addActionListener(this);
        this.add(save);

        edit = new JButton("Edit");
        edit.setBounds(145, 290, 90, 30);
        edit.setFont(new Font("Arial", Font.BOLD, 15));
        edit.setForeground(new Color(13, 177, 240));
        edit.addActionListener(this);
        this.add(edit);

        delete = new JButton("Delete");
        delete.setBounds(30, 330, 90, 30);
        delete.setFont(new Font("Arial", Font.BOLD, 15));
        delete.setForeground(new Color(13, 177, 240));
        delete.addActionListener(this);
        this.add(delete);

        clear = new JButton("Clear");
        clear.setBounds(145, 330, 90, 30);
        clear.setFont(new Font("Arial", Font.BOLD, 15));
        clear.setForeground(new Color(13, 177, 240));
        clear.addActionListener(this);
        this.add(clear);

        Object col[] = {"Date", "Class", "Section", "Student Straight"};
        model = new DefaultTableModel(col, 0);
        cltable = new JTable(model);
        add(cltable);
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from class;");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Date date = resultSet.getDate("Date");
                String Classs = resultSet.getString("class");
                String Section = resultSet.getString("section");
                String strength = resultSet.getString("strength");
                Object data[] = {date, Classs, Section, strength};
                model.addRow(data);
            }
            cltable.setBounds(180, 80, 620, 450);
            JScrollPane scrollPane = new JScrollPane(cltable);
            scrollPane.setBounds(260, 80, 525, 230);
            this.add(scrollPane);
            cltable.setBackground(new Color(114, 213, 237, 255));
            scrollPane.setBackground(new Color(114, 213, 237, 255));
            cltable.setFont(new Font("Arial", Font.BOLD, 12));
            cltable.setSelectionBackground(new Color(8, 53, 36, 63));
            cltable.getTableHeader().setBackground(new Color(34, 45, 67));
            cltable.getTableHeader().setForeground(new Color(13, 177, 240));
            cltable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
            cltable.setDefaultEditor(Object.class, null);
            scrollPane.getViewport().setBackground(new Color(248, 232, 209));


        } catch (SQLException se) {
            System.out.println(se.getMessage());
        }

        cltable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int s_row = cltable.getSelectedRow();
                bclass.setSelectedItem(model.getValueAt(s_row, 1));
                bsec.setSelectedItem(model.getValueAt(s_row, 2));
                tstdstr.setText((String) model.getValueAt(s_row, 3));
            }
        });


        this.add(jbrd);
        this.add(menubg);
        setResizable(false);
        this.setSize(800, 460);
        this.setTitle("Class Details");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if (type_txt.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,"Unable To Fetch Usertype","Null Usertype",JOptionPane.WARNING_MESSAGE);
            new login();
            setVisible(false);
        }else {
            setVisible(true);
            if (type_txt.getText().equals("Guest") || type_txt.getText().equals("Teacher")) {
                create.setEnabled(false);
                if (type_txt.getText().equals("Guest")) {
                    exam.setEnabled(false);
                    classs.setEnabled(false);
                    save.setEnabled(false);
                    edit.setEnabled(false);
                    delete.setEnabled(false);
                }
            }
        }


    }

    public static void main(String[] args) {
        new classs();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            bclass.setSelectedIndex(0);
            bsec.setSelectedIndex(0);
            tstdstr.setText(" ");
        } else if (e.getSource() == mmenu) {
            new Menu();
            this.setVisible(false);
        } else if (e.getSource() == logout) {
            new login();
            this.setVisible(false);
        } else if (e.getSource() == quit) {
            this.dispose();

        } else if (e.getSource() == classs) {
            int choice = JOptionPane.showConfirmDialog(null, "Already in Create window want to reload", "Refresh", JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                new classs();
                this.setVisible(false);
            }
        } else if (e.getSource() == out) {
            new login();
            this.setVisible(false);
        } else if (e.getSource() == subject) {
            new Subject();
        } else if (e.getSource() == refresh) {
            new classs();
            this.setVisible(false);
        } else if (e.getSource() == quit) {
            new login();
            this.dispose();
        } else if (e.getSource() == clear) {
            bclass.setSelectedIndex(0);
            bsec.setSelectedItem(0);
            tstdstr.setText("");
        } else if (e.getSource() == save) {
         savadata();
         refreshtable();
        } else if (e.getSource() == edit) {
         editdata();
         refreshtable();
        } else if (e.getSource() == delete) {
            deletedata();
            refreshtable();

        }
    }

    private void deletedata() {
        if (!(bclass.getSelectedIndex() == 0) && !(bsec.getSelectedIndex() == 0)) {
            try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                String query = "delete from class where class =?And section =?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, String.valueOf(bclass.getSelectedItem()));
                preparedStatement.setString(2, String.valueOf(bsec.getSelectedItem()));
                int result = preparedStatement.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(this, "Data Deleted Successfully ","Delete Status",1);
                } else {
                    JOptionPane.showMessageDialog(this, "unable to Delete data( Please Select Row you want to delete )","Delete Error",0);
                }
            } catch (SQLException sq) {
                System.out.println(sq.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please fill all information","Delete Error",0);
        }
    }


    private void refreshtable() {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword);) {
            String tbquery = "select * from class";
            PreparedStatement preparedStatement = connection.prepareStatement(tbquery);
            ResultSet resultSet = preparedStatement.executeQuery();
            model.setRowCount(0);
            while (resultSet.next()) {
                Object tbdata[] = {resultSet.getDate("Date"), resultSet.getString("class"), resultSet.getString("section"), resultSet.getString("strength")};
                model.addRow(tbdata);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            JOptionPane.showMessageDialog(this, "Unable to show data" + sqlException.getMessage(), "Error: Show table", JOptionPane.ERROR_MESSAGE);

        }
    }

    private void editdata()
    {
        if (!(bclass.getSelectedIndex() == 0) && !(bsec.getSelectedIndex() == 0) && !(tstdstr.getText().isEmpty())) {
            try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                String query = "update  class set strength = ?,date = now() where class = ? And section =?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1, tstdstr.getText());
                preparedStatement.setString(2, String.valueOf(bclass.getSelectedItem()));
                preparedStatement.setString(3, String.valueOf(bsec.getSelectedItem()));
                int result = preparedStatement.executeUpdate();
                if (result > 0) {
                    JOptionPane.showMessageDialog(null, "Data Updated Successfully!","Update Status",JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, " Unable to update data. Please try again later.","Update Error",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException sq) {
                System.out.println(sq.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Unable to update data. Please fill all information","Update Error",0);
        }
    }

    private void savadata()
    {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            String query = "insert into class (class,section,strength) values (?,?,?);";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, String.valueOf(bclass.getSelectedItem()));
            preparedStatement.setString(2, String.valueOf(bsec.getSelectedItem()));
            preparedStatement.setString(3, tstdstr.getText());
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Data Uploaded successfully!","Data Uploading Status",JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Unable to upload data. Please try again later.","Upload Error",JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException sq) {
            System.out.println(sq.getMessage());
            JOptionPane.showMessageDialog(null, "Unable to insert data, Duplicate data found.","Duplicate Data Error",JOptionPane.ERROR_MESSAGE);
        }
    }
}








