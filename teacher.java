package schoolms;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;

public class teacher extends JFrame implements ActionListener {

    int S_row, tech_ID, usr_ID, confirm;
    JLabel uname_txt, type_txt;
    JTextField text_tname, text_qual, text_salary, text_mob, text_mail, text_address;
    JMenuBar menub;
    JMenuItem mmenu, create, classs, subject, exam, student, mark, teacher, logout, quit;
    JButton save, delete, edit, clear, out, refresh;
    JTable tch_table;
    DefaultTableModel tch_model;
    JScrollPane sp;

    public teacher() {
        //Setting Images
        ImageIcon brd = new ImageIcon(getClass().getResource("/schoolms/pics/mrkbrd1.png"));
        Image temp_brd = brd.getImage().getScaledInstance(300, 635, Image.SCALE_SMOOTH);
        brd = new ImageIcon(temp_brd);
        JLabel jbrd = new JLabel("", brd, JLabel.CENTER);
        jbrd.setBounds(0, 0, 300, 635);

        ImageIcon teachicon = new ImageIcon(getClass().getResource("/schoolms/pics/teachericon.png"));
        Image temp_teachicon = teachicon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        teachicon = new ImageIcon(temp_teachicon);
        JLabel ticon = new JLabel("", teachicon, JLabel.CENTER);
        ticon.setBounds(10, 25, 40, 40);
        add(ticon);

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

        ImageIcon tbottom = new ImageIcon(getClass().getResource("/schoolms/pics/teachersgreet.png"));
        Image temp_tbottom = tbottom.getImage().getScaledInstance(595, 290, Image.SCALE_SMOOTH);
        tbottom = new ImageIcon(temp_tbottom);
        JLabel tGreet = new JLabel("", tbottom, JLabel.CENTER);
        tGreet.setBounds(270, 335, 590, 290);
        add(tGreet);
        //Setting Form

        JLabel heading = new JLabel("Teacher Details");
        heading.setBounds(55, 30, 240, 30);
        heading.setFont(new Font("Arial", Font.BOLD, 30));
        heading.setForeground(new Color(13, 177, 240));
        add(heading);

        JLabel tname = new JLabel("Teacher Name");
        tname.setBounds(20, 80, 200, 30);
        tname.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        tname.setForeground(new Color(13, 177, 240));
        this.add(tname);

        text_tname = new JTextField();
        text_tname.setBounds(20, 110, 250, 30);
        text_tname.setFont(new Font("Arial", Font.PLAIN, 20));
        text_tname.setForeground(new Color(13, 177, 240));
        this.add(text_tname);

        JLabel qual = new JLabel("Qualification");
        qual.setBounds(20, 150, 200, 30);
        qual.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        qual.setForeground(new Color(13, 177, 240));
        this.add(qual);

        text_qual = new JTextField();
        text_qual.setBounds(20, 180, 250, 30);
        text_qual.setFont(new Font("Arial", Font.PLAIN, 20));
        text_qual.setForeground(new Color(13, 177, 240));
        this.add(text_qual);

        JLabel salary = new JLabel("Salary");
        salary.setBounds(20, 220, 200, 30);
        salary.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        salary.setForeground(new Color(13, 177, 240));
        this.add(salary);

        text_salary = new JTextField();
        text_salary.setBounds(20, 250, 250, 30);
        text_salary.setFont(new Font("Arial", Font.PLAIN, 20));
        text_salary.setForeground(new Color(13, 177, 240));
        this.add(text_salary);

        JLabel mob = new JLabel("Mobile Number");
        mob.setBounds(20, 290, 200, 30);
        mob.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        mob.setForeground(new Color(13, 177, 240));
        this.add(mob);

        text_mob = new JTextField();
        text_mob.setBounds(20, 320, 250, 30);
        text_mob.setFont(new Font("Arial", Font.PLAIN, 20));
        text_mob.setForeground(new Color(13, 177, 240));
        this.add(text_mob);

        JLabel mail = new JLabel("Email");
        mail.setBounds(20, 360, 200, 30);
        mail.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        mail.setForeground(new Color(13, 177, 240));
        this.add(mail);

        text_mail = new JTextField();
        text_mail.setBounds(20, 390, 250, 30);
        text_mail.setFont(new Font("Arial", Font.PLAIN, 20));
        text_mail.setForeground(new Color(13, 177, 240));
        this.add(text_mail);

        JLabel address = new JLabel("Address");
        address.setBounds(20, 430, 200, 30);
        address.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        address.setForeground(new Color(13, 177, 240));
        this.add(address);

        text_address = new JTextField();
        text_address.setBounds(20, 460, 250, 30);
        text_address.setFont(new Font("Arial", Font.PLAIN, 20));
        text_address.setForeground(new Color(13, 177, 240));
        this.add(text_address);

        //Setting navigation
        menub = new JMenuBar();
        menub.setLayout(new BoxLayout(menub, BoxLayout.X_AXIS));
        this.setJMenuBar(menub);
        JMenu menu = new JMenu("Hyperlinks");
        menub.setBackground(new Color(248, 232, 209));
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
        create.setEnabled(false);
        if (login.usertype.equals("Admin")) {
            create.setEnabled(true);
        }
        menu.add(classs);
        menu.add(subject);
        menu.add(student);
        menu.add(mark);
        menu.add(teacher);
        menu.add(logout);
        menu.add(quit);

        //Setting Jpanel

        JPanel jp = new JPanel(null);
        jp.setBounds(300, 0, 535, 80);
        this.add(jp);

        out = new JButton(outimg);
        jp.add(out);
        out.setBounds(480, 8, 40, 30);
        out.setBackground(new Color(255, 255, 255));
        out.addActionListener(this);

        refresh = new JButton(refreshimg);
        jp.add(refresh);
        refresh.setBounds(480, 45, 40, 30);
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


        //Setting Buttons

        save = new JButton("Save");
        save.setBounds(160, 500, 110, 30);
        save.setFont(new Font("Arial", Font.PLAIN, 20));
        save.setBackground(new Color(248, 232, 209));
        save.setForeground(new Color(13, 177, 240));
        save.addActionListener(this);
        save.setEnabled(false);
        this.add(save);

        edit = new JButton("Edit");
        edit.setBounds(20, 500, 110, 30);
        edit.setFont(new Font("Arial", Font.PLAIN, 20));
        edit.setBackground(new Color(248, 232, 209));
        edit.setForeground(new Color(13, 177, 240));
        edit.addActionListener(this);
        edit.setEnabled(false);
        this.add(edit);

        delete = new JButton("Delete");
        delete.setBounds(20, 540, 110, 30);
        delete.setFont(new Font("Arial", Font.PLAIN, 20));
        delete.setBackground(new Color(248, 232, 209));
        delete.setForeground(new Color(13, 177, 240));
        delete.addActionListener(this);
        delete.setEnabled(false);
        this.add(delete);

        clear = new JButton("Clear");
        clear.setBounds(160, 540, 110, 30);
        clear.setFont(new Font("Arial", Font.PLAIN, 20));
        clear.setBackground(new Color(248, 232, 209));
        clear.setForeground(new Color(13, 177, 240));
        clear.addActionListener(this);
        clear.setEnabled(false);
        this.add(clear);

        if (login.usertype.equals("Admin") || login.usertype.equals("Teacher") || login.usertype.equals("Guest")) {
            clear.setEnabled(true);
            if (login.usertype.equals("Admin") || login.usertype.equals("Teacher")) {
                edit.setEnabled(true);
                if (login.usertype.equals("Admin")) {
                    save.setEnabled(true);
                    delete.setEnabled(true);
                }
            }
        }

        //Setting Table
        Object[] colmn = {"ID", "Name", "Qualification", "Salary", "Phone Number", "Email", "Address"};
        tch_model = new DefaultTableModel(colmn, 0);
        tch_table = new JTable(tch_model);
        tch_table.setBounds(300, 80, 535, 270);
        sp = new JScrollPane(tch_table);
        sp.setBounds(300, 80, 535, 270);
        sp.getViewport().setBackground(new Color(248, 232, 209));
        tch_table.getTableHeader().setBackground(new Color(188, 148, 106));
        tch_table.getTableHeader().setForeground(new Color(0, 0, 0));
        this.add(sp);
        tch_table.setBackground(new Color(5, 232, 142, 255));
        tch_table.setSelectionBackground(new Color(4, 205, 232, 255));
        tch_table.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
        tch_table.setFont(new Font("Arial", Font.BOLD, 12));
        tch_table.setDefaultEditor(Object.class, null);

        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("select ID, Name,Qualification ,Salary,phn_num,Email,Address from teacher");
            ResultSet resultSet = preparedStatement.executeQuery();
            if (type_txt.getText().equals("Admin")) {
                while (resultSet.next()) {
                    Object[] row = {resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)};
                    tch_model.addRow(row);
                }
            } else {
                while (resultSet.next()) {
                    Object[] row = {resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), "**************", resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)};
                    tch_model.addRow(row);
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        tch_table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                S_row = tch_table.getSelectedRow();
                text_tname.setText((String) tch_model.getValueAt(S_row, 1));
                text_qual.setText((String) tch_model.getValueAt(S_row, 2));
                text_salary.setText(tch_model.getValueAt(S_row, 3).toString());
                text_mob.setText((String) tch_model.getValueAt(S_row, 4));
                text_mail.setText((String) tch_model.getValueAt(S_row, 5));
                text_address.setText((String) tch_model.getValueAt(S_row, 6));
                tech_ID = (int) tch_model.getValueAt(S_row, 0);//teacher id

                try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                    PreparedStatement preparedStatement = connection.prepareStatement("select Second_id from teacher where ID = ?");
                    preparedStatement.setInt(1, tech_ID);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        usr_ID = resultSet.getInt(1);
                    }
                } catch (SQLException e1) {
                    System.out.println(e1.getMessage());
                }

            }

        });
        add(jbrd);
        setTitle("Teacher Details");
        setResizable(false);
        setSize(850, 680);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        new teacher();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mmenu) {
            new Menu();
            this.setVisible(false);
        } else if (e.getSource() == create) {
            new create();
            this.setVisible(false);
        } else if (e.getSource() == classs) {
            new classs();
            this.setVisible(false);
        } else if (e.getSource() == subject) {
            new Subject();
            this.setVisible(false);
        } else if (e.getSource() == student) {
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
            System.exit(0);
        } else if (e.getSource() == refresh) {
            new teacher();
            this.setVisible(false);
        } else if (e.getSource() == out) {
            System.exit(0);
        } else if (e.getSource() == edit) {
            editData();
            refreshTable();
        } else if (e.getSource() == delete) {
            confirm = JOptionPane.showConfirmDialog(this, "Are you want to Delete Data \n Teacher ID: " + tech_ID + "\n User ID: " + usr_ID + "Action: Remove login permissions only - Yes" + "\n" + "Action: Completely remove the Teacher profile - No", "Confirm Deletion", JOptionPane.YES_NO_CANCEL_OPTION);
            deleteData();
            refreshTable();
        } else if (e.getSource() == save) {
            if (type_txt.getText().equals("Admin")) {
                saveData();
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(this, "Your current account permissions do not allow this action. ", "Access Denied", JOptionPane.WARNING_MESSAGE);
            }
        } else if (e.getSource() == clear) {
            text_tname.setText(null);
            text_qual.setText(null);
            text_salary.setText(null);
            text_mob.setText(null);
            text_mail.setText(null);
            text_address.setText(null);
        }

    }

    //Refresh Table
    private void refreshTable() {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("select ID, Name,Qualification ,Salary,phn_num,Email,Address from teacher");
            ResultSet resultSet = preparedStatement.executeQuery();
            tch_model.setRowCount(0);
            if (type_txt.getText().equals("Admin")) {
                while (resultSet.next()) {
                    Object[] row1 = {resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), resultSet.getInt(4), resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)};
                    tch_model.addRow(row1);
                }
            } else {
                while (resultSet.next()) {
                    Object[] row1 = {resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), "**************", resultSet.getString(5), resultSet.getString(6), resultSet.getString(7)};
                    tch_model.addRow(row1);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            System.out.println("from refresh");
        }
    }

    //Save Data
    private void saveData() {

        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Users (Name, Phone_no, Address, Username, Password, User_type) VALUES (?,?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, text_tname.getText());
            preparedStatement.setString(2, text_mob.getText());
            preparedStatement.setString(3, text_address.getText());
            preparedStatement.setString(4, text_tname.getText());
            preparedStatement.setString(5, text_mob.getText());
            preparedStatement.setString(6, "Teacher");
            int res = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                usr_ID = resultSet.getInt(1);
            }
            if (res > 0) {
                PreparedStatement preparedStatement1 = connection.prepareStatement("insert into teacher (Name,Qualification ,Salary,phn_num,Email,Address,second_id) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                preparedStatement1.setString(1, text_tname.getText());
                preparedStatement1.setString(2, text_qual.getText());
                preparedStatement1.setInt(3, Integer.parseInt(text_salary.getText()));
                preparedStatement1.setString(4, text_mob.getText());
                preparedStatement1.setString(5, text_mail.getText());
                preparedStatement1.setString(6, text_address.getText());
                preparedStatement1.setInt(7, usr_ID);
                int res1 = preparedStatement1.executeUpdate();
                ResultSet resultSet1 = preparedStatement1.getGeneratedKeys();
                while (resultSet1.next()) {
                    tech_ID = resultSet1.getInt(1);
                }
                if (res1 > 0) {
                    JOptionPane.showMessageDialog(this, "Data Successfully Saved \nTeacher ID: " + tech_ID + "\nUsers ID: " + usr_ID + "\nPassword: " + text_mob.getText() + "\n Contact Admin to change Username Or Password ", "Operation Successful", JOptionPane.INFORMATION_MESSAGE);

                    PreparedStatement preparedStatement2 = connection.prepareStatement("update users set Second_id =? where ID =? ");
                    preparedStatement2.setInt(1, tech_ID);
                    preparedStatement2.setInt(2, usr_ID);
                    int res2 = preparedStatement2.executeUpdate();
                    if (res2 > 0) {
                        System.out.println("tech id transferred to users table");
                    } else {
                        System.out.println("Unable to transfer tech id");
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Unable to Save Data", "Operation Failed", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.out.println("Unable to transfer Data into users");
            }


        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(this, "Unable to Save Data Due to :" + e.getMessage(), "Operation Failed", JOptionPane.ERROR_MESSAGE);
        }

    }

    //Edit Data
    private void editData() {

        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {

            PreparedStatement preparedStatement = connection.prepareStatement("update Users set Name = ?,Phone_no = ?,Address= ? where ID = ?");
            preparedStatement.setString(1, text_tname.getText());
            preparedStatement.setString(2, text_mob.getText());
            preparedStatement.setString(3, text_address.getText());
            preparedStatement.setInt(4, usr_ID);
            int res = preparedStatement.executeUpdate();
            if (res > 0) {
                PreparedStatement preparedStatement1 = connection.prepareStatement("update teacher set Name=?,Qualification=?,phn_num=?,Email=?,Address=?where ID = ?");
                preparedStatement1.setString(1, text_tname.getText());
                preparedStatement1.setString(2, text_qual.getText());
                preparedStatement1.setString(3, text_mob.getText());
                preparedStatement1.setString(4, text_mail.getText());
                preparedStatement1.setString(5, text_address.getText());
                preparedStatement1.setInt(6, tech_ID);
                int res1 = preparedStatement1.executeUpdate();
                if (res1 > 0) {
                    JOptionPane.showMessageDialog(this, "Teacher details have been updated successfully.", "Update Successful", JOptionPane.INFORMATION_MESSAGE);
                    if (type_txt.getText().equals("Admin")) {
                        PreparedStatement preparedStatement2 = connection.prepareStatement("update teacher set Salary = ? where ID = ? ");
                        preparedStatement2.setString(1, text_salary.getText());
                        preparedStatement2.setInt(2, tech_ID);
                        int res2 = preparedStatement2.executeUpdate();
                        System.out.println("Entered in Admin");
                        if (res2 > 0) {
                            JOptionPane.showMessageDialog(this, "Salary  have been updated successfully.", "Update Successful", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Unable to update salary details.", "Update Failed", JOptionPane.ERROR_MESSAGE);
                        }

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Unable to update the details. Please check the input fields and try again.", "Update Failed", JOptionPane.ERROR_MESSAGE);
                }

            } else {
                System.out.println("failed to update ");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    //Delete Data
    private void deleteData() {
        if (confirm == 0) {
            try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from users where ID = ?");
                preparedStatement.setInt(1, usr_ID);
                int res = preparedStatement.executeUpdate();
                if (res > 0) {
                    JOptionPane.showMessageDialog(this, "Deletion Successful", "Operation Successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "Unable to delete", "Operation Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else if (confirm == 1) {
            try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from users where ID = ?");
                preparedStatement.setInt(1, usr_ID);
                int res = preparedStatement.executeUpdate();
                if (res > 0) {
                    PreparedStatement preparedStatement1 = connection.prepareStatement("delete from teacher where ID = ?");
                    preparedStatement1.setInt(1, tech_ID);
                    int res1 = preparedStatement1.executeUpdate();
                    if (res1 > 0) {
                        JOptionPane.showMessageDialog(this, "Deletion Successful", "Operation Successful", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Unable to delete", "Operation Failed", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    System.out.println("Unable to delete from users table");
                    PreparedStatement preparedStatement2 = connection.prepareStatement("delete from teacher where ID = ?");
                    preparedStatement2.setInt(1, tech_ID);
                    int res2 = preparedStatement2.executeUpdate();
                    if (res2 > 0) {
                        JOptionPane.showMessageDialog(this, "Deletion Successful", "Operation Successful", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Unable to delete", "Operation Failed", JOptionPane.ERROR_MESSAGE);
                    }

                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
                JOptionPane.showMessageDialog(this, "Unable to delete Due to :" + e.getMessage(), "Operation Failed", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Operation Cancelled By User", "Operation Cancelled", JOptionPane.ERROR_MESSAGE);

        }
    }
}
