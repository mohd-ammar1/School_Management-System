package schoolms;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

import com.toedter.calendar.JDateChooser;


public class Student extends JFrame implements ActionListener {

    int id, s_row, cid, std_ID, usr_ID;
    JMenuBar menub = new JMenuBar();
    JMenuItem mmenu, create, classs, exam, mark, teacher, logout, quit;
    JTextField text_sname, text_pname, text_mobNo;
    JDateChooser dob;
    JComboBox text_gender, text_clas, text_sec;
    JButton save, delete, edit, clear, out, refresh;
    JLabel uname_txt, type_txt;
    Date rdate;
    JTable stable;
    DefaultTableModel smodel;
    JScrollPane Scrollpane;

    Student() {
        //Setting Images
        ImageIcon bg = new ImageIcon(getClass().getResource("/schoolms/pics/stdbg.jpg"));
        Image temp_bg = bg.getImage().getScaledInstance(850, 700, Image.SCALE_SMOOTH);
        bg = new ImageIcon(temp_bg);
        JLabel backgd = new JLabel("", bg, JLabel.CENTER);
        backgd.setBounds(0, 0, 850, 700);

        ImageIcon brd = new ImageIcon(getClass().getResource("/schoolms/pics/mrkbrd1.png"));
        Image temp_brd = brd.getImage().getScaledInstance(295, 700, Image.SCALE_SMOOTH);
        brd = new ImageIcon(temp_brd);
        JLabel jbrd = new JLabel("", brd, JLabel.CENTER);
        jbrd.setBounds(0, 0, 295, 700);

        ImageIcon stdicon = new ImageIcon(getClass().getResource("/schoolms/pics/stdicon.png"));
        Image temp_stdicon = stdicon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        stdicon = new ImageIcon(temp_stdicon);
        JLabel sicon = new JLabel("", stdicon, JLabel.CENTER);
        sicon.setBounds(10, 20, 40, 40);
        add(sicon);

        ImageIcon outimg = new ImageIcon(getClass().getResource("/schoolms/pics/logouticon.png"));
        Image temp_img1 = outimg.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        outimg = new ImageIcon(temp_img1);

        ImageIcon refreshimg = new ImageIcon(getClass().getResource("/schoolms/pics/refreshpng.png"));
        Image refresh1 = refreshimg.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        refreshimg = new ImageIcon(refresh1);

        ImageIcon jpbg = new ImageIcon(getClass().getResource("/schoolms/pics/lwood.jpg"));
        Image temp_jpbg = jpbg.getImage().getScaledInstance(545, 80, Image.SCALE_SMOOTH);
        jpbg = new ImageIcon(temp_jpbg);
        JLabel Jpbg = new JLabel("", jpbg, JLabel.CENTER);
        Jpbg.setBounds(0, 0, 545, 80);

        ImageIcon bottom = new ImageIcon(getClass().getResource("/schoolms/pics/stdbottom.jpg"));
        Image temp_bottom = bottom.getImage().getScaledInstance(550,290,Image.SCALE_SMOOTH);
        bottom = new ImageIcon(temp_bottom);
        JLabel std_bottom = new JLabel("",bottom,JLabel.CENTER);
        std_bottom.setBounds(295, 380, 550, 290);
        add(std_bottom);

        //Setting Menubar
        menub.setLayout(new BoxLayout(menub, BoxLayout.X_AXIS));
        menub.setBackground(new Color(248, 232, 209));
        this.setJMenuBar(menub);
        JMenu menu = new JMenu("Hyperlinks");
        menub.add(menu);
        menu.setForeground(new Color(13, 177, 240));
        menu.setFont(new Font("Arial", Font.BOLD, 20));
        mmenu = new JMenuItem("Main Menu");
        mmenu.setForeground(new Color(13, 177, 240));
        mmenu.setFont(new Font("Arial", Font.BOLD, 17));
        mmenu.setBackground(new Color(248, 232, 209));
        mmenu.addActionListener(this);

        create = new JMenuItem("create Account");
        create.setForeground(new Color(13, 177, 240));
        create.setFont(new Font("Arial", Font.BOLD, 17));
        create.setBackground(new Color(248, 232, 209));
        create.addActionListener(this);

        classs = new JMenuItem("Class");
        classs.setForeground(new Color(13, 177, 240));
        classs.setFont(new Font("Arial", Font.BOLD, 17));
        classs.setBackground(new Color(248, 232, 209));
        classs.addActionListener(this);

        exam = new JMenuItem("Exam");
        exam.setForeground(new Color(13, 177, 240));
        exam.setFont(new Font("Arial", Font.BOLD, 17));
        exam.setBackground(new Color(248, 232, 209));
        exam.addActionListener(this);

        mark = new JMenuItem("Mark");
        mark.setForeground(new Color(13, 177, 240));
        mark.setFont(new Font("Arial", Font.BOLD, 17));
        mark.setBackground(new Color(248, 232, 209));
        mark.addActionListener(this);

        teacher = new JMenuItem("Teacher");
        teacher.setForeground(new Color(13, 177, 240));
        teacher.setFont(new Font("Arial", Font.BOLD, 17));
        teacher.setBackground(new Color(248, 232, 209));
        teacher.addActionListener(this);

        logout = new JMenuItem("Logout!");
        logout.setForeground(new Color(13, 177, 240));
        logout.setFont(new Font("Arial", Font.BOLD, 17));
        logout.setBackground(new Color(248, 232, 209));
        logout.addActionListener(this);

        quit = new JMenuItem("Quit");
        quit.setForeground(new Color(13, 177, 240));
        quit.setFont(new Font("Arial", Font.BOLD, 17));
        quit.setBackground(new Color(248, 232, 209));
        quit.addActionListener(this);


        menu.add(mmenu);
        menu.add(create);
        menu.add(classs);
        menu.add(exam);
        menu.add(mark);
        menu.add(teacher);
        menu.add(logout);
        menu.add(quit);

        //Setting Jpanel

        JPanel jp = new JPanel(null);
        jp.setBounds(295, 0, 545, 80);
        this.add(jp);

        out = new JButton((Icon) outimg);
        jp.add(out);
        out.setBounds(495, 8, 40, 30);
        out.setBackground(new Color(255, 255, 255));
        out.addActionListener(this);

        refresh = new JButton((Icon) refreshimg);
        jp.add(refresh);
        refresh.setBounds(495, 45, 40, 30);
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


        JLabel heading = new JLabel("Student Details:");
        heading.setBounds(50, 30, 240, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(new Color(13, 177, 240));
        add(heading);

        JLabel sname = new JLabel("Student Name");
        sname.setBounds(20, 70, 200, 30);
        sname.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        sname.setForeground(new Color(13, 177, 240));
        this.add(sname);

        text_sname = new JTextField();
        text_sname.setBounds(20, 100, 250, 30);
        text_sname.setFont(new Font("Arial", Font.PLAIN, 20));
        text_sname.setForeground(new Color(13, 177, 240));
        this.add(text_sname);

        JLabel pname = new JLabel("Parent Name");
        pname.setBounds(20, 140, 200, 30);
        pname.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        pname.setForeground(new Color(13, 177, 240));
        this.add(pname);

        text_pname = new JTextField();
        text_pname.setBounds(20, 170, 250, 30);
        text_pname.setFont(new Font("Arial", Font.PLAIN, 20));
        text_pname.setForeground(new Color(13, 177, 240));
        this.add(text_pname);

        JLabel sdob = new JLabel("Date of Birth");
        sdob.setBounds(20, 210, 200, 30);
        sdob.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        sdob.setForeground(new Color(13, 177, 240));
        this.add(sdob);

        dob = new JDateChooser();
        dob.setBounds(20, 240, 250, 30);
        dob.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(dob);

        JLabel gender = new JLabel("Gender");
        gender.setBounds(20, 280, 200, 30);
        gender.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        gender.setForeground(new Color(13, 177, 240));
        this.add(gender);

        String opt_gender[] = {"", "Male", "Female", "Prefer not to say"};
        text_gender = new JComboBox(opt_gender);
        text_gender.setBounds(20, 310, 250, 30);
        text_gender.setFont(new Font("Arial", Font.PLAIN, 20));
        text_gender.setForeground(new Color(13, 177, 240));
        this.add(text_gender);

        JLabel mob_NO = new JLabel("Mobile Number");
        mob_NO.setBounds(20, 350, 200, 30);
        mob_NO.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        mob_NO.setForeground(new Color(13, 177, 240));
        this.add(mob_NO);

        text_mobNo = new JTextField();
        text_mobNo.setBounds(20, 380, 250, 30);
        text_mobNo.setFont(new Font("Arial", Font.PLAIN, 20));
        text_mobNo.setForeground(new Color(13, 177, 240));
        this.add(text_mobNo);

        JLabel clas = new JLabel("Class");
        clas.setBounds(20, 420, 200, 30);
        clas.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        clas.setForeground(new Color(13, 177, 240));
        this.add(clas);

        String classs[] = {"", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12"};
        text_clas = new JComboBox(classs);
        text_clas.setBounds(20, 450, 250, 30);
        text_clas.setFont(new Font("Arial", Font.PLAIN, 20));
        text_clas.setForeground(new Color(13, 177, 240));
        this.add(text_clas);

        JLabel sec = new JLabel("Section");
        sec.setBounds(20, 490, 200, 30);
        sec.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        sec.setForeground(new Color(13, 177, 240));
        this.add(sec);

        String section[] = {"", "A", "B", "C"};
        text_sec = new JComboBox(section);
        text_sec.setBounds(20, 520, 250, 30);
        text_sec.setFont(new Font("Arial", Font.PLAIN, 20));
        text_sec.setForeground(new Color(13, 177, 240));
        this.add(text_sec);

        //Setting Buttons

        save = new JButton("Save");
        save.setBounds(160, 570, 110, 30);
        save.setFont(new Font("Arial", Font.PLAIN, 20));
        save.setBackground(new Color(248, 232, 209));
        save.setForeground(new Color(13, 177, 240));
        save.addActionListener(this);
        this.add(save);

        edit = new JButton("Edit");
        edit.setBounds(20, 570, 110, 30);
        edit.setFont(new Font("Arial", Font.PLAIN, 20));
        edit.setBackground(new Color(248, 232, 209));
        edit.setForeground(new Color(13, 177, 240));
        edit.addActionListener(this);
        this.add(edit);

        delete = new JButton("Delete");
        delete.setBounds(20, 610, 110, 30);
        delete.setFont(new Font("Arial", Font.PLAIN, 20));
        delete.setBackground(new Color(248, 232, 209));
        delete.setForeground(new Color(13, 177, 240));
        delete.addActionListener(this);
        this.add(delete);

        clear = new JButton("Clear");
        clear.setBounds(160, 610, 110, 30);
        clear.setFont(new Font("Arial", Font.PLAIN, 20));
        clear.setBackground(new Color(248, 232, 209));
        clear.setForeground(new Color(13, 177, 240));
        clear.addActionListener(this);
        this.add(clear);

        Object[] clm = {"ID", "Name", "Parent Name", "DOB", "Gender", "Mob_No", "Class", "section"};
        smodel = new DefaultTableModel(clm, 0);
        stable = new JTable(smodel);
        Scrollpane = new JScrollPane(stable);
        Scrollpane.setBounds(295, 80, 550, 300);
        Scrollpane.getViewport().setBackground(new Color(248, 232, 209));
        stable.getTableHeader().setBackground(new Color(34, 45, 67));
        stable.getTableHeader().setForeground(new Color(13, 177, 240));
        stable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        stable.setBackground(new Color(71, 180, 223, 255));
        stable.setSelectionBackground(new Color(5, 232, 142));
        stable.setFont(new Font("Arial", Font.BOLD, 12));
        stable.setDefaultEditor(Object.class, null);
        this.add(Scrollpane);
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            PreparedStatement pst = connection.prepareStatement("select ID from Users where Username = ?");
            pst.setString(1, text_sname.getText());
            ResultSet rs1 = pst.executeQuery();
            if (rs1.next()) {
                cid = rs1.getInt("ID");
            } else {
                System.out.println("Unable to fetch UID");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        stable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                s_row = stable.getSelectedRow();
                id = (int) smodel.getValueAt(s_row, 0);
                text_sname.setText(String.valueOf(smodel.getValueAt(s_row, 1)));
                text_pname.setText(String.valueOf(smodel.getValueAt(s_row, 2)));
                dob.setDate((Date) smodel.getValueAt(s_row, 3)); // Retrieve the value
                text_gender.setSelectedItem(String.valueOf(smodel.getValueAt(s_row, 4)));
                text_mobNo.setText(String.valueOf(smodel.getValueAt(s_row, 5)));
                text_clas.setSelectedItem(String.valueOf(smodel.getValueAt(s_row, 6)));
                text_sec.setSelectedItem(String.valueOf(smodel.getValueAt(s_row, 7)));

                try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                    PreparedStatement preparedStatement = connection.prepareStatement("select Second_id from student where ID = ?");
                    preparedStatement.setInt(1, (Integer) smodel.getValueAt(s_row, 0));
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        usr_ID = resultSet.getInt(1);
                    }
                    std_ID = (int) smodel.getValueAt(s_row, 0);
                    System.out.println("std_id :"+std_ID+"\n usr_id :"+usr_ID);
                } catch (SQLException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        refreshTable();
        add(jbrd);
        add(backgd);
        setSize(850, 730);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Student Details");
    }

    public static void main(String[] args) {
        new Student();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mmenu) {
            new Menu();
            this.setVisible(false);
        } else if (e.getSource() == create) {
            new create();
            setVisible(false);
        } else if (e.getSource() == classs) {
            new classs();
            setVisible(false);
        } else if (e.getSource() == exam) {
            new Subject();
        } else if (e.getSource() == mark) {
            new mark();
            setVisible(false);
        } else if (e.getSource() == teacher) {
            new teacher();
            setVisible(false);
        } else if (e.getSource() == logout) {
            new login();
            setVisible(false);
        } else if (e.getSource() == quit) {
            dispose();
        } else if (e.getSource() == quit) {
            new login();
            setVisible(false);
        } else if (e.getSource() == refresh) {
            new Student();
            setVisible(false);
        } else if (e.getSource() == clear) {
            text_sname.setText(null);
            text_pname.setText(null);
            text_mobNo.setText(null);
            text_gender.setSelectedIndex(0);
            text_clas.setSelectedIndex(0);
            text_sec.setSelectedIndex(0);
            dob.setDate(null);
        } else if (e.getSource() == save) {
            Date sdate = dob.getDate();
            rdate = new java.sql.Date(sdate.getTime());
            int cls = text_clas.getSelectedIndex();
            int sec = text_sec.getSelectedIndex();
            int gn = text_gender.getSelectedIndex();

            if (!text_sname.getText().isEmpty() && !text_pname.getText().isEmpty() && !text_mobNo.getText().isEmpty() && cls != 0 && sec != 0 && gn != 0) {
                savedata();
            } else {
                JOptionPane.showMessageDialog(this, "Please Fill All Fields", "Empty Fields", 0);
            }
        } else if (e.getSource() == edit) {
            Date sdate = dob.getDate();
            rdate = new java.sql.Date(sdate.getTime());
            int cls = text_clas.getSelectedIndex();
            int sec = text_sec.getSelectedIndex();
            int gn = text_gender.getSelectedIndex();
            if (!text_sname.getText().isEmpty() && !text_pname.getText().isEmpty() && !text_mobNo.getText().isEmpty() && cls != 0 && sec != 0 && gn != 0) {
                editdata();
            } else {
                JOptionPane.showMessageDialog(this, "Please Fill All Fields", "Empty Fields", 0);
            }
        } else if (e.getSource() == delete) {
//            JOptionPane.showConfirmDialog(this,"Are You Really want to DELETE Data With \n Student ID : "+smodel.getValueAt(s_row,0)+"\nUser ID : "+usr_ID,"",JOptionPane.YES_NO_OPTION);
            deleterow();
            refreshTable();
        }
    }

    private void savedata() {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            String query = "insert into student(Name,Parent_Name,DOB,Gender,Mob_No,Class,Section) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, text_sname.getText());
            preparedStatement.setString(2, text_pname.getText());
            preparedStatement.setString(3, String.valueOf(rdate));
            preparedStatement.setString(4, String.valueOf(text_gender.getSelectedItem()));
            preparedStatement.setString(5, text_mobNo.getText());
            preparedStatement.setString(6, String.valueOf(text_clas.getSelectedItem()));
            preparedStatement.setString(7, String.valueOf(text_sec.getSelectedItem()));
            int rowsInserted = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                std_ID = resultSet.getInt(1);
                System.out.println(std_ID);
            } else {
                System.out.println("unable to fetch gid");
            }
            if (rowsInserted > 0) {
                System.out.println("Data saved successfully!");
            } else {
                System.out.println("No data was inserted.");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        transferToUser();
        refreshTable();
    }

    private void refreshTable() {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("select * from student");
            ResultSet resultSet = preparedStatement.executeQuery();
            smodel.setRowCount(0);
            while (resultSet.next()) {
                Object[] s_row = {resultSet.getInt("ID"), resultSet.getString("Name"), resultSet.getString("Parent_Name"), resultSet.getDate("DOB"), resultSet.getString("Gender"), resultSet.getString("Mob_No"), resultSet.getString("Class"), resultSet.getString("Section")};
                smodel.addRow(s_row);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }
    }

    private void editdata() {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("update student set Name= ? ,Parent_Name = ?, DOB =? ,Gender= ? ,Mob_No= ? ,Class= ? ,Section= ? where ID= ?");
            preparedStatement.setString(1, text_sname.getText());
            preparedStatement.setString(2, text_pname.getText());
            preparedStatement.setString(3, String.valueOf(rdate));
            preparedStatement.setString(4, String.valueOf(text_gender.getSelectedItem()));
            preparedStatement.setString(5, text_mobNo.getText());
            preparedStatement.setString(6, String.valueOf(text_clas.getSelectedItem()));
            preparedStatement.setString(7, String.valueOf(text_sec.getSelectedItem()));
            preparedStatement.setInt(8, std_ID);
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(this, "The user's details have been successfully updated", "Update Successful", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(this, "Unable to update the user's information. Please try again.", "Update Failed", JOptionPane.ERROR_MESSAGE);
            }
            PreparedStatement preparedStatement1 = connection.prepareStatement("update users set Name = ?, Phone_no = ? where ID = ? ");
            preparedStatement1.setString(1, text_sname.getText());
            preparedStatement1.setString(2, text_mobNo.getText());
            preparedStatement1.setInt(3, usr_ID);
            int res1 = preparedStatement1.executeUpdate();
            if (res1 > 0) {
                System.out.println("Details successfully Updated in Users Table ");
            } else {
                System.out.println("Unable to update data in users table");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        refreshTable();
    }

    private void transferToUser() {
        int prmn = JOptionPane.showConfirmDialog(this, "Do you want to grant login permission to this student", "Login Permission", JOptionPane.YES_NO_OPTION);
        if (prmn == 0) {
            try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword);) {

                PreparedStatement check = connection.prepareStatement("select * from Users where Username = ? and User_type =?");
                check.setString(1, text_sname.getText());
                check.setString(2, "Student");
                ResultSet rs = check.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Unable to add user(duplicate entry detected)", "Error: duplicate entry", JOptionPane.ERROR_MESSAGE);
                } else {

                    PreparedStatement preparedStatement1 = connection.prepareStatement("insert into Users(Name,Phone_no,Username,Password,User_type,Second_id) values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    preparedStatement1.setString(1, text_sname.getText());
                    preparedStatement1.setString(2, text_mobNo.getText());
                    preparedStatement1.setString(3, text_sname.getText());
                    preparedStatement1.setString(4, text_pname.getText());
                    preparedStatement1.setString(5, "Student");
                    preparedStatement1.setInt(6, std_ID);

                    int result = preparedStatement1.executeUpdate();
                    ResultSet resultSet = preparedStatement1.getGeneratedKeys();
                    if (resultSet.next()) {
                        usr_ID = resultSet.getInt(1);
                    } else {
                        System.out.println("unable to fetch User id");
                    }
                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "The user has been successfully Authorized with .\nUser ID :" + usr_ID + " \nUsername :" + text_sname.getText() + "\nPassword :" + text_pname.getText() + "\nContact to Admin ASAP to change Username And password and to add Address Also ", "User Added Successfully", JOptionPane.INFORMATION_MESSAGE);
                        PreparedStatement preparedStatement = connection.prepareStatement("update student set Second_id = ? where ID = ?");
                        preparedStatement.setString(1, String.valueOf(usr_ID));
                        preparedStatement.setInt(2, std_ID);
                        int res = preparedStatement.executeUpdate();
                        if (res > 0) {
                            System.out.println("gid1 transferred to student");
                        } else {
                            System.out.println("unable to call from user");
                        }

                    } else {
                        JOptionPane.showMessageDialog(this, "Unable to Authorize user ", "User Authorization Failed", JOptionPane.ERROR_MESSAGE);
                    }

                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    //  <======Function to transfer data into marks table ======>

    private void transferToMark(){
        try( Connection connection = DriverManager.getConnection(login.url,login.dbusername,login.dbpassword) ){
            PreparedStatement preparedStatement = connection.prepareStatement("insert into Mark");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    //  <======Function to delete table Row======>
    private void deleterow() {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("delete from student where ID = ?");
            preparedStatement.setInt(1, std_ID);
            int res = preparedStatement.executeUpdate();
            if (res > 0) {
                PreparedStatement preparedStatement1 = connection.prepareStatement("delete from Users where ID = ?");
                preparedStatement1.setInt(1, usr_ID);
                int res1 = preparedStatement1.executeUpdate();
                if (res1 > 0) {
                    JOptionPane.showMessageDialog(this, "Data Deleted Successfully", "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Unable to Delete Row", "Deletion Failed", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "Unable to Delete Row fromm student table", "Deletion Failed", JOptionPane.ERROR_MESSAGE);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Unable to Delete Row Due to:" + e.getMessage(), "Deletion Failed", JOptionPane.ERROR_MESSAGE);
        }
    }
}