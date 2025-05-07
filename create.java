package schoolms;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class create extends JFrame implements ActionListener {
    JMenuBar menub = new JMenuBar();
    JMenuItem mmenu, create, classs, subject, student, mark, teacher, logout, quit;
    JButton save, edit, delete, clear, out, refresh;
    JTextField name_txt, phn_txt, add_txt, user_txt, pass_txt;
    JComboBox<String> utype_txt = new JComboBox<>(new String[]{"Admin", "Teacher", "Student", "Guest"});
    JLabel uname_txt, type_txt;
    JTable crtable;
    DefaultTableModel model;
    JScrollPane sp;
    int s_row, tcr_ID, std_ID, usr_ID;

    public create() {
        ImageIcon background_image = new ImageIcon(getClass().getResource("/schoolms/pics/greenboard0.jpg"));
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(310, 610, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel greenbrd = new JLabel("", background_image, JLabel.CENTER);
        greenbrd.setBounds(0, 0, 310, 610);

        ImageIcon background_image2 = new ImageIcon(getClass().getResource("/schoolms/pics/paper.jpg"));
        Image img2 = background_image2.getImage();
        Image temp_img2 = img2.getScaledInstance(850, 600, Image.SCALE_SMOOTH);
        background_image2 = new ImageIcon(temp_img2);
        JLabel paper = new JLabel("", background_image2, JLabel.CENTER);
        paper.setBounds(0, 0, 850, 600);

        ImageIcon childs = new ImageIcon(getClass().getResource("/schoolms/pics/createbottom1.png"));
        Image child1 = childs.getImage().getScaledInstance(530, 300, Image.SCALE_SMOOTH);
        childs = new ImageIcon(child1);
        JLabel child = new JLabel("", childs, JLabel.CENTER);
        child.setBounds(310, 390, 530, 280);
        add(child);

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

        subject = new JMenuItem("Subject");
        subject.setForeground(new Color(13, 177, 240));
        subject.setFont(new Font("Arial", Font.BOLD, 17));
        subject.setBackground(new Color(248, 232, 209));
        subject.addActionListener(this);

        student = new JMenuItem("Student");
        student.setForeground(new Color(13, 177, 240));
        student.setFont(new Font("Arial", Font.BOLD, 17));
        student.setBackground(new Color(248, 232, 209));
        student.addActionListener(this);

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
        menu.add(subject);
        menu.add(student);
        menu.add(mark);
        menu.add(teacher);
        menu.add(logout);
        menu.add(quit);

        JLabel cracc = new JLabel("Create Account");
        cracc.setBounds(35, 20, 300, 30);
        cracc.setFont(new Font("Arial", Font.BOLD, 35));
        cracc.setForeground(new Color(13, 177, 240));
        this.add(cracc);

        JLabel name = new JLabel("Name");
        name.setBounds(55, 55, 120, 30);
        name.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        name.setForeground(new Color(13, 177, 240));
        this.add(name);

        name_txt = new JTextField();
        name_txt.setBounds(35, 85, 250, 30);
        name_txt.setFont(new Font("Arial", Font.PLAIN, 20));
        name_txt.setForeground(new Color(13, 177, 240));
        this.add(name_txt);

        JLabel phn = new JLabel("Phone No");
        phn.setBounds(35, 130, 120, 30);
        phn.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        phn.setForeground(new Color(13, 177, 240));
        this.add(phn);

        phn_txt = new JTextField();
        phn_txt.setBounds(35, 160, 250, 30);
        phn_txt.setFont(new Font("Arial", Font.PLAIN, 20));
        phn_txt.setForeground(new Color(13, 177, 240));
        this.add(phn_txt);

        JLabel add1 = new JLabel("Address");
        add1.setBounds(35, 205, 120, 30);
        add1.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        add1.setForeground(new Color(13, 177, 240));
        this.add(add1);

        add_txt = new JTextField();
        add_txt.setBounds(35, 235, 250, 30);
        add_txt.setFont(new Font("Arial", Font.PLAIN, 20));
        add_txt.setForeground(new Color(13, 177, 240));
        this.add(add_txt);

        JLabel user = new JLabel("Username");
        user.setBounds(35, 280, 120, 30);
        user.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        user.setForeground(new Color(13, 177, 240));
        this.add(user);

        user_txt = new JTextField();
        user_txt.setBounds(35, 320, 250, 30);
        user_txt.setFont(new Font("Arial", Font.PLAIN, 20));
        user_txt.setForeground(new Color(13, 177, 240));
        this.add(user_txt);

        JLabel pass = new JLabel("Password");
        pass.setBounds(35, 355, 120, 30);
        pass.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        pass.setForeground(new Color(13, 177, 240));
        this.add(pass);

        pass_txt = new JTextField();
        pass_txt.setBounds(35, 385, 250, 30);
        pass_txt.setFont(new Font("Arial", Font.PLAIN, 20));
        pass_txt.setForeground(new Color(13, 177, 240));
        this.add(pass_txt);

        JLabel ustype = new JLabel("User Type");
        ustype.setBounds(35, 430, 120, 30);
        ustype.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        ustype.setForeground(new Color(13, 177, 240));
        this.add(ustype);

        utype_txt.setBounds(35, 460, 250, 30);
        utype_txt.setFont(new Font("Arial", Font.PLAIN, 20));
        utype_txt.setForeground(new Color(13, 177, 240));
        this.add(utype_txt);

        save = new JButton("Save");
        save.setBounds(175, 505, 110, 30);
        save.setFont(new Font("Arial", Font.PLAIN, 20));
        save.setBackground(new Color(248, 232, 209));
        save.setForeground(new Color(13, 177, 240));
        save.addActionListener(this);
        this.add(save);

        edit = new JButton("Edit");
        edit.setBounds(35, 505, 110, 30);
        edit.setFont(new Font("Arial", Font.PLAIN, 20));
        edit.setBackground(new Color(248, 232, 209));
        edit.setForeground(new Color(13, 177, 240));
        edit.addActionListener(this);
        this.add(edit);

        delete = new JButton("Delete");
        delete.setBounds(35, 550, 110, 30);
        delete.setFont(new Font("Arial", Font.PLAIN, 20));
        delete.setBackground(new Color(248, 232, 209));
        delete.setForeground(new Color(13, 177, 240));
        delete.addActionListener(this);
        this.add(delete);

        clear = new JButton("Clear");
        clear.setBounds(175, 550, 110, 30);
        clear.setFont(new Font("Arial", Font.PLAIN, 20));
        clear.setBackground(new Color(248, 232, 209));
        clear.setForeground(new Color(13, 177, 240));
        clear.addActionListener(this);
        this.add(clear);

        JPanel jp = new JPanel(null);
        jp.setBounds(310, 0, 525, 80);
        this.add(jp);

        out = new JButton((Icon) outimg);
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
        jp.add(Jpbg);

        //Setting Table
        Object[] clm = {"ID", "Name", "Phone no", "Address", "Username", "Usertype"};
        model = new DefaultTableModel(clm, 0);
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword);) {
            String tbquery = "select * from Users";
            PreparedStatement preparedStatement = connection.prepareStatement(tbquery);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Object[] tbdata = {resultSet.getInt("ID"), resultSet.getString("Name"), resultSet.getString("Phone_no"), resultSet.getString("Address"), resultSet.getString("Username"), resultSet.getString("User_type")};
                model.addRow(tbdata);
            }
            crtable = new JTable(model);
            crtable.setBounds(310, 80, 530, 310);
            sp = new JScrollPane(crtable);
            sp.setBounds(310, 80, 530, 310);
            this.add(sp);

            Border border = BorderFactory.createLineBorder(new Color(200, 200, 200),2);
            crtable.setBorder(border);
            crtable.getTableHeader().setBackground(new Color(34, 45, 67));
            crtable.getTableHeader().setForeground(new Color(13, 177, 240));
            crtable.getTableHeader().setFont(new Font("Arial", Font.BOLD, 15));
            sp.getViewport().setBackground(new Color(248, 232, 209));
            crtable.setBackground(new Color(71, 180, 223, 255));
            crtable.setSelectionBackground(new Color(5, 232, 142));
            crtable.setFont(new Font("Arial", Font.BOLD, 12));
            crtable.setDefaultEditor(Object.class, null);
        } catch (SQLException se1) {
            System.out.println(se1.getMessage());
            JOptionPane.showMessageDialog(null, "Unable to Fetch data from Database");
        }

        crtable.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                s_row = crtable.getSelectedRow();
                name_txt.setText(String.valueOf(model.getValueAt(s_row, 1)));
                phn_txt.setText(String.valueOf(model.getValueAt(s_row, 2)));
                add_txt.setText(String.valueOf(model.getValueAt(s_row, 3)));
                user_txt.setText(String.valueOf(model.getValueAt(s_row, 4)));
                utype_txt.setSelectedItem(String.valueOf(model.getValueAt(s_row, 5)));
                //Fetching Student id
                try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                    PreparedStatement preparedStatement = connection.prepareStatement("select Second_id from users where ID = ?");
                    preparedStatement.setInt(1, (Integer) model.getValueAt(s_row, 0));
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        if (model.getValueAt(s_row, 5).equals("Student")) {
                            std_ID = resultSet.getInt(1);
                            System.out.println("Student ID: " + std_ID);
                        } else if (model.getValueAt(s_row, 5).equals("Teacher")) {
                            tcr_ID = resultSet.getInt(1);
                            System.out.println("Teacher ID: " + tcr_ID);
                        }
                    }
                    usr_ID = (int) model.getValueAt(s_row, 0);
                    System.out.println("User ID: " + usr_ID);
                } catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        this.add(greenbrd);
        this.add(paper);

        //Setting jframe
        setTitle("Account");
        setLayout(null);
        setSize(850, 680);
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new create();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == mmenu) {
            new Menu();
            this.setVisible(false);
        } else if (e.getSource() == create) {
            int choice = JOptionPane.showConfirmDialog(this, "Already in Create window want to reload", "Refresh", JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                new create();
                this.setVisible(false);
            }
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
        } else if (e.getSource() == quit) {//jmenuitem
            this.dispose();
        } else if (e.getSource() == refresh) {
            new create();
            this.setVisible(false);

        } else if (e.getSource() == out) {//button on panel
            new login();
            this.setVisible(false);
        } else if (e.getSource() == save) {
            addUser();
            refreshtable();
        } else if (e.getSource() == edit) {
            editdata();
            refreshtable();
        } else if (e.getSource() == delete) {
            String usrtype = (String) utype_txt.getSelectedItem();
            if (usrtype.equals("Student")) {
                deleteStudent();
            } else if (usrtype.equals("Teacher")) {
                deleteTeacher();
            } else {
                deleterow();
            }
            refreshtable();
        } else if (e.getSource() == clear) {
            name_txt.setText("");
            phn_txt.setText("");
            add_txt.setText("");
            user_txt.setText("");
            pass_txt.setText("");
        }
    }


    //  <======Function to refresh table======>
    private void refreshtable() {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword);) {
            String tbquery = "select * from Users";
            PreparedStatement preparedStatement = connection.prepareStatement(tbquery);
            ResultSet resultSet = preparedStatement.executeQuery();
            Object[] clm = {"ID", "Name", "Phone no", "Address", "Username", "Usertype"};
            model.setRowCount(0);
            while (resultSet.next()) {
                Object[] tbdata = {resultSet.getInt("ID"), resultSet.getString("Name"), resultSet.getString("Phone_no"), resultSet.getString("Address"), resultSet.getString("Username"), resultSet.getString("User_type")};
                model.addRow(tbdata);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            JOptionPane.showMessageDialog(this, "Unable to show data" + sqlException.getMessage(), "Error: Show table", JOptionPane.ERROR_MESSAGE);

        }
    }

    //  <======Function to delete table Row======>
    private void deleteStudent() {
        int confirm = JOptionPane.showConfirmDialog(this, """
                Action: Remove login permissions only - Yes
                Action: Completely remove the student profile - No""", "Confirm Deletion", JOptionPane.YES_NO_CANCEL_OPTION);
        if (confirm == 0 || confirm == 1) {
            try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                String query = "delete from Users where ID = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setInt(1, (int) model.getValueAt(s_row, 0));
                int result = preparedStatement.executeUpdate();
                if (confirm == 0) {
                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "Successfully deleted selected row  ", "Deletion Successfull", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Unable to delete selected row", "Deletion ", JOptionPane.WARNING_MESSAGE);
                    }
                }
                if (confirm == 1) {
                    PreparedStatement preparedStatement1 = connection.prepareStatement("delete from student where ID = ?");
                    preparedStatement1.setInt(1, std_ID);
                    int rlt = preparedStatement1.executeUpdate();
                    if (rlt > 0) {
                        System.out.println("deleted from student with id :" + std_ID);
                    } else {
                        System.out.println("Unable to delete from student");
                    }
                }
            } catch (SQLException sq) {
                System.out.println(sq.getMessage());
            }
        } else if (confirm == 2) {
            JOptionPane.showMessageDialog(this, "Operation Canceled by " + login.username, "Deletion Aborted", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Delete Teacher
    private void deleteTeacher() {
        int confirm = JOptionPane.showConfirmDialog(this, """
                Action: Remove login permissions only - Yes
                Action: Completely remove the Teacher profile - No""", "Confirm Deletion", JOptionPane.YES_NO_CANCEL_OPTION);
        if (confirm == 0 || confirm == 1) {
            try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from Users where ID = ?");
                preparedStatement.setInt(1, usr_ID);
                int res = preparedStatement.executeUpdate();
                if (res > 0) {
                    if (confirm == 1) {
                        System.out.println("Teacher ID:" + tcr_ID);
                        PreparedStatement preparedStatement1 = connection.prepareStatement("delete from teacher where ID = ?");
                        preparedStatement1.setInt(1, tcr_ID);
                        int res1 = preparedStatement1.executeUpdate();
                        if (res1 > 0) {
                            JOptionPane.showMessageDialog(this, "Teacher Details deleted Successfully", "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(this, "Failed to delete Teacher Details ", "Deletion Failed", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "Teacher Details deleted Successfully", "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    System.out.println("Unable to delete from users");
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        } else if (confirm == 2) {
            JOptionPane.showMessageDialog(this, "Operation Cancelled By User", "Operation Aborted", JOptionPane.WARNING_MESSAGE);
        }
    }

    //Delete Others
    private void deleterow() {
        int confirm = JOptionPane.showConfirmDialog(this, "Are you really want to delete user with \n User ID: " + usr_ID, "Deletion Confirmation", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {
            try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                PreparedStatement preparedStatement = connection.prepareStatement("delete from Users where ID = ?");
                preparedStatement.setInt(1, usr_ID);
                int res = preparedStatement.executeUpdate();
                if (res > 0) {
                    JOptionPane.showMessageDialog(this, "User Details deleted Successfully", "Deletion Successful", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(this, "User Details deleted Successfully", "Deletion Failed", JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    //  <======Function to Edit table Data======>
    private void editdata() {
        int confirm = JOptionPane.showConfirmDialog(this, "Do you also want to change the password?", "Change password", JOptionPane.YES_NO_OPTION);
        if (confirm == 0) {//yes
            if (!name_txt.getText().isEmpty() && !phn_txt.getText().isEmpty() && !add_txt.getText().isEmpty() && !user_txt.getText().isEmpty() && !pass_txt.getText().isEmpty()) {
                try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                    String query = "update Users set Name = ?,Phone_no = ?,Address= ?,Username= ?,Password= ?,User_type=? where ID = ?;";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    String id = String.valueOf(model.getValueAt(s_row, 0));
                    preparedStatement.setString(1, name_txt.getText());
                    preparedStatement.setString(2, phn_txt.getText());
                    preparedStatement.setString(3, add_txt.getText());
                    preparedStatement.setString(4, user_txt.getText());
                    preparedStatement.setString(5, pass_txt.getText());
                    preparedStatement.setString(6, (String) utype_txt.getSelectedItem());
                    preparedStatement.setString(7, id);
                    System.out.println(id);
                    int result = preparedStatement.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "The user's details have been successfully updated", "Update Successful", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Unable to update the user's information. Please try again.", "Update Failed", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException sq) {
                    System.out.println(sq.getMessage());
                }
            } else {
                JOptionPane.showMessageDialog(this, "Please fill in all the required fields before proceeding.", "Incomplete Form", JOptionPane.WARNING_MESSAGE);
            }
        } else if (confirm == 1) { //NO
            if (!name_txt.getText().isEmpty() && !phn_txt.getText().isEmpty() && !add_txt.getText().isEmpty() && !user_txt.getText().isEmpty()) {
                try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                    String name1 = name_txt.getText();
                    String phone1 = phn_txt.getText();
                    String address1 = add_txt.getText();
                    String Username1 = user_txt.getText();
                    String usert1 = (String) utype_txt.getSelectedItem();
                    String query = "update Users set Name = ?,Phone_no = ?,Address= ?,Username= ?,User_type=? where ID = ?";
                    PreparedStatement preparedStatement = connection.prepareStatement(query);
                    String id = String.valueOf(model.getValueAt(s_row, 0));
                    preparedStatement.setString(1, name1);
                    preparedStatement.setString(2, phone1);
                    preparedStatement.setString(3, address1);
                    preparedStatement.setString(4, Username1);
                    preparedStatement.setString(5, usert1);
                    preparedStatement.setString(6, id);
                    System.out.println(id);
                    int result = preparedStatement.executeUpdate();
                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "User details have been updated successfully.", "Update Successful", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(this, "Unable to update the details. Please check the input fields and try again.", "Update Failed", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException sq) {
                    System.out.println(sq.getMessage());
                    JOptionPane.showMessageDialog(this, "Unable to update due to :" + sq.getMessage(), "Update Failed", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(this, "\"Please fill in all fields except the Password field to proceed", "incomplete Form", JOptionPane.WARNING_MESSAGE);
            }
        }
        if (utype_txt.getSelectedItem().equals("Student")) {
            try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update student set Name = ?,Mob_No =? where ID = ? ");
                preparedStatement.setString(1, name_txt.getText());
                preparedStatement.setString(2, phn_txt.getText());
                preparedStatement.setInt(3, std_ID);
                int res = preparedStatement.executeUpdate();
                if (res > 0) {
                    System.out.println("successfully updated in Student Table ");
                } else {
                    System.out.println("Unable to update in student");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else if (utype_txt.getSelectedItem().equals("Teacher")) {
            try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
                PreparedStatement preparedStatement = connection.prepareStatement("update teacher set Name = ?,phn_num = ?,Address= ?where ID = ? ");
                preparedStatement.setString(1, name_txt.getText());
                preparedStatement.setString(2, phn_txt.getText());
                preparedStatement.setString(3, add_txt.getText());
                preparedStatement.setInt(4, tcr_ID);
                int res = preparedStatement.executeUpdate();
                if (res > 0) {
                    System.out.println("successfully updated  Teacher Table ");
                } else {
                    System.out.println("Unable to update Teacher Table");
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    //  <======Function to save data======>
    private void addUser() {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword);) {

            PreparedStatement check = connection.prepareStatement("select * from Users where Username = ? and User_type =?");
            check.setString(1, user_txt.getText());
            check.setString(2, (String) utype_txt.getSelectedItem());

            ResultSet rs = check.executeQuery();
            if (rs.next()) {
                JOptionPane.showMessageDialog(null, "Unable to add user(Duplicate Entry Detected)", "Error: Duplicate Entry", JOptionPane.ERROR_MESSAGE);
            } else {
                try {
                    PreparedStatement preparedStatement = connection.prepareStatement("insert into Users(Name,Phone_no,Address,Username,Password,User_type) values(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                    preparedStatement.setString(1, name_txt.getText());
                    preparedStatement.setString(2, phn_txt.getText());
                    preparedStatement.setString(3, add_txt.getText());
                    preparedStatement.setString(4, user_txt.getText());
                    preparedStatement.setString(5, pass_txt.getText());
                    preparedStatement.setString(6, String.valueOf(utype_txt.getSelectedItem()));
                    int result = preparedStatement.executeUpdate();
                    ResultSet resultSet = preparedStatement.getGeneratedKeys();
                    if (resultSet.next()) {
                        usr_ID = resultSet.getInt(1);
                    } else {
                        System.out.println("unable to fetch gid in create");
                    }
                    if (result > 0) {
                        JOptionPane.showMessageDialog(this, "The user has been successfully added to the system.", "User Added Successfully", JOptionPane.INFORMATION_MESSAGE);
                        if (String.valueOf(utype_txt.getSelectedItem()).equals("Student")) {
                            transferToStudent();
                        }
                        if (String.valueOf(utype_txt.getSelectedItem()).equals("Teacher")) {
                            registerNewTeacher();
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "The system encountered an issue while attempting to add the user", "Unable to Add User", JOptionPane.ERROR_MESSAGE);
                    }


                } catch (SQLException se) {
                    System.out.println(se.getMessage());
                    JOptionPane.showMessageDialog(this, "Unable to add user due to :-" + se.getMessage(), "Unable to Add User", JOptionPane.ERROR_MESSAGE);
                }
            }
        } catch (SQLException se) {
            System.out.println(se.getMessage());
            JOptionPane.showMessageDialog(this, "Unable to add user due to :-" + se.getMessage(), "Unable to Add User", JOptionPane.ERROR_MESSAGE);

        }
        System.out.println(std_ID);
    }

    private void transferToStudent() {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into student(Name,Mob_No,Second_id) values(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name_txt.getText());
            preparedStatement.setString(2, phn_txt.getText());
            preparedStatement.setInt(3, usr_ID);
            int res = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                std_ID = resultSet.getInt(1);
            }
            if (res > 0) {
                int ch = JOptionPane.showConfirmDialog(this, "Action: Want to enter Additional Details Now : yes \n Action : Want to transfer to Teacher : NO ");
                if (ch == 0) {
                    new Student();
                    this.setVisible(false);
                }
                PreparedStatement preparedStatement1 = connection.prepareStatement("update Users set Second_id = ? where ID = ?");
                preparedStatement1.setInt(1, std_ID);
                preparedStatement1.setInt(2, usr_ID);
                int res1 = preparedStatement1.executeUpdate();
                if (res1 > 0) {
                    JOptionPane.showMessageDialog(this, "Student ID: " + std_ID + "\nUser ID" + usr_ID + "\nPassword: " + pass_txt.getText(), "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    System.out.println("std id transferred to user table");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void registerNewTeacher() {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("insert into teacher (Name,phn_num,Address,second_id) values(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, name_txt.getText());
            preparedStatement.setString(2, phn_txt.getText());
            preparedStatement.setString(3, add_txt.getText());
            preparedStatement.setInt(4, usr_ID);
            int res = preparedStatement.executeUpdate();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            while (resultSet.next()) {
                tcr_ID = resultSet.getInt(1);
            }
            if (res > 0) {
                PreparedStatement preparedStatement1 = connection.prepareStatement("update Users set Second_id = ? where ID = ?");
                preparedStatement1.setInt(1, tcr_ID);
                preparedStatement1.setInt(2, usr_ID);
                int res1 = preparedStatement1.executeUpdate();
                if (res1 > 0) {
                    JOptionPane.showMessageDialog(this, "Teacher ID: " + tcr_ID + "\nUser ID: " + usr_ID + "\nPassword: " + pass_txt.getText(), "", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    System.out.println("Teacher id transferred to user table");
                }
                int ch = JOptionPane.showConfirmDialog(this, "Action: Want to enter Additional Details Now : yes \n Action : Want to transfer to Teacher : NO ", "Transfer Confirmation", JOptionPane.YES_NO_OPTION);
                if (ch == 0) {
                    new teacher();
                    this.setVisible(false);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}