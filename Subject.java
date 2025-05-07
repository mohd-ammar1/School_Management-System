package schoolms;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Subject extends JFrame implements ActionListener {
    JButton save, edit, delete, clear;
    JTextField subcode, subname;
    JLabel uname_txt, type_txt;
    JMenuBar menub = new JMenuBar();
    JMenuItem mmenu, create, classs, subject, exam, student, mark, teacher, logout, quit;
    String usertype, user1;
    JButton out, refresh;
    DefaultTableModel submodel;
    int S_row;

    public Subject() {


        ImageIcon background_image = new ImageIcon(getClass().getResource("/schoolms/pics/mainmbg.png"));
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(850, 550, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        JLabel menubg = new JLabel("", background_image, JLabel.CENTER);
        menubg.setBounds(0, 0, 850, 550);

        ImageIcon refreshimg = new ImageIcon(getClass().getResource("/schoolms/pics/refreshpng.png"));
        Image refresh1 = refreshimg.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
        refreshimg = new ImageIcon(refresh1);

        ImageIcon background_imageo = new ImageIcon(getClass().getResource("/schoolms/pics/logouticon.png"));
        Image imgo = background_imageo.getImage();
        Image temp_imgo = imgo.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
        background_imageo = new ImageIcon(temp_imgo);

        JPanel jp = new JPanel(null);
        jp.setBounds(260, 0, 525, 80);
        jp.setBackground(new Color(114, 213, 237, 255));
        this.add(jp);

        out = new JButton((Icon) background_imageo);
        jp.add(out);
        out.setBounds(470, 8, 40, 35);
        out.setBackground(new Color(255, 255, 255));
        out.addActionListener(this);

        refresh = new JButton((Icon) refreshimg);
        jp.add(refresh);
        refresh.setBounds(470, 45, 40, 30);
        refresh.setBackground(new Color(255, 255, 255));
        refresh.addActionListener(this);


        JLabel urname = new JLabel("Username:");
        urname.setBounds(10, 15, 120, 22);
        urname.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        urname.setForeground(new Color(255, 166, 164, 255));
        jp.add(urname);

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


        JLabel head = new JLabel("Subject Details:");
        head.setBounds(10, 30, 250, 40);
        head.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 30));
        head.setForeground(new Color(13, 177, 240));
        this.add(head);

        JLabel cname = new JLabel("Subject Code:");
        cname.setBounds(10, 100, 250, 25);
        cname.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 25));
        cname.setForeground(new Color(13, 177, 240));
        this.add(cname);

        subcode = new JTextField();
        subcode.setBounds(30, 130, 200, 30);
        subcode.setFont(new Font("Arial", Font.PLAIN, 25));
        subcode.setForeground(new Color(13, 177, 240));
        this.add(subcode);

        JLabel sec = new JLabel("Subject Name:");
        sec.setBounds(10, 170, 250, 25);
        sec.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 25));
        sec.setForeground(new Color(13, 177, 240));
        this.add(sec);

        subname = new JTextField();
        subname.setBounds(30, 210, 200, 30);
        subname.setFont(new Font("Arial", Font.PLAIN, 25));
        subname.setForeground(new Color(13, 177, 240));
        this.add(subname);

        save = new JButton("Save");
        save.setBounds(30, 270, 80, 30);
        save.setFont(new Font("Arial", Font.PLAIN, 20));
        save.setForeground(new Color(13, 177, 240));
        save.addActionListener(this);
        this.add(save);

        edit = new JButton("Edit");
        edit.setBounds(150, 270, 80, 30);
        edit.setFont(new Font("Arial", Font.PLAIN, 20));
        edit.setForeground(new Color(13, 177, 240));
        edit.addActionListener(this);
        this.add(edit);

        delete = new JButton("Delete");
        delete.setBounds(30, 320, 80, 30);
        delete.setFont(new Font("Arial", Font.BOLD, 14));
        delete.setForeground(new Color(13, 177, 240));
        delete.addActionListener(this);
        this.add(delete);

        clear = new JButton("Clear");
        clear.setBounds(150, 320, 80, 30);
        clear.setFont(new Font("Arial", Font.BOLD, 14));
        clear.setForeground(new Color(13, 177, 240));
        clear.addActionListener(this);
        this.add(clear);


        JLabel usname = new JLabel("Username:");
        usname.setBounds(270, 15, 120, 22);
        usname.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        usname.setForeground(new Color(0, 0, 0));
        this.add(usname);

        uname_txt = new JLabel(user1);
        uname_txt.setBounds(400, 15, 120, 22);
        uname_txt.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        uname_txt.setForeground(new Color(0, 0, 0));
        this.add(uname_txt);


        JLabel urtype = new JLabel("User type:");
        urtype.setBounds(270, 50, 120, 22);
        urtype.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        urtype.setForeground(new Color(0, 0, 0));
        this.add(urtype);

        type_txt = new JLabel(usertype);
        type_txt.setBounds(400, 50, 120, 22);
        type_txt.setFont(new Font("Arial", Font.ITALIC | Font.BOLD, 22));
        type_txt.setForeground(new Color(0, 0, 0));
        this.add(type_txt);

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
        menu.add(classs);
        menu.add(create);
        menu.add(subject);
        menu.add(exam);
        menu.add(student);
        menu.add(mark);
        menu.add(teacher);
        menu.add(logout);
        menu.add(quit);


        Object Col[] = {"ID", "Subject code", "Subject Name"};
        submodel = new DefaultTableModel(Col, 0);
        JTable subtable = new JTable(submodel);

        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("Select * from subject");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Object subdata[] = {resultSet.getInt("ID"), resultSet.getString("Subject_code"), resultSet.getString("Subject_Name")};
                submodel.addRow(subdata);
            }

            JScrollPane scrollPane = new JScrollPane(subtable);
            scrollPane.setBounds(270, 100, 500, 300); // Adjust dimensions as needed
            subtable.setBackground(new Color(114, 213, 237, 255));
            scrollPane.setBackground(new Color(114, 213, 237, 255));
            subtable.setFont(new Font("Arial", Font.BOLD, 12));
            subtable.setSelectionBackground(new Color(0xC02E7E5E, true));
            this.add(scrollPane);

            subtable.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    S_row = subtable.getSelectedRow();
                    subname.setText((String) submodel.getValueAt(S_row, 1));
                    subcode.setText((String) submodel.getValueAt(S_row, 2));
                }
            });


        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
        }

        this.add(menubg);
        this.setVisible(true);
        this.setSize(800, 450);
        this.setTitle("Subject Details");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        new Subject();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            subcode.setText("");
            subname.setText("");
        } else if (e.getSource() == mmenu) {
            new Menu();
            this.setVisible(false);
        } else if (e.getSource() == logout) {
            new login();
            this.setVisible(false);
        } else if (e.getSource() == quit) {
            this.dispose();

        } else if (e.getSource() == classs) {
            new classs();
            this.setVisible(false);
        } else if (e.getSource() == out) {
            new login();
            this.setVisible(false);
        } else if (e.getSource() == subject) {
            int choice = JOptionPane.showConfirmDialog(null, "Already in Subject window want to reload", "Refresh", JOptionPane.YES_NO_OPTION);
            if (choice == 0) {
                new Subject();
                this.setVisible(false);
            }
        } else if (e.getSource() == create) {
            new create();
            this.setVisible(false);
        } else if (e.getSource() == clear) {
            subname.setText("");
            subcode.setText("");
        } else if (e.getSource() == refresh) {
            new Subject();
            this.setVisible(false);
        } else if (e.getSource() == out) {
            new login();
            this.setVisible(false);
        } else if (e.getSource() == save) {
            if (!(subname.getText().equals("")) && !(subcode.getText().equals(""))) {
                saveData();
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(null, "Please fill all Fields","Empty Fields",0);
            }
        } else if (e.getSource() == edit) {
            if (!(subname.getText().equals("")) && !(subcode.getText().equals(""))) {
                editData();
                refreshTable();
            } else {
                JOptionPane.showMessageDialog(null, "Please Fill all Fields","Empty Fields",0);
            }
        } else if (e.getSource() == delete) {
            deleteData();
            refreshTable();
        }
    }

    private void refreshTable() {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword);) {
            String tbquery = "select * from subject";
            PreparedStatement preparedStatement = connection.prepareStatement(tbquery);
            ResultSet resultSet = preparedStatement.executeQuery();
            Object clm[] = {"ID", "Name"};
            submodel.setRowCount(0);
            while (resultSet.next()) {
                Object subdata[] = {resultSet.getInt("ID"), resultSet.getString("Subject_code"), resultSet.getString("Subject_Name")};
                submodel.addRow(subdata);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            JOptionPane.showMessageDialog(this, "Unable to show data" + sqlException.getMessage(), "Error: Show table", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void saveData() {
        String query = "insert into subject (Subject_Name ,Subject_code) values (?,?)";
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, subname.getText());
            preparedStatement.setString(2, subcode.getText());
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Data Uploaded Successfully","Upload Status",1);
            } else {
                JOptionPane.showMessageDialog(null, "Unable to insert data","Upload Error",0);
            }
        } catch (SQLException sq) {
            System.out.println(sq.getMessage());
            JOptionPane.showMessageDialog(null, "Unable to insert data: "+sq.getMessage(),"Upload Error",0);
        }
    }

    private void editData() {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {
            PreparedStatement preparedStatement = connection.prepareStatement("update  subject set Subject_Name= ?,Subject_code =? where ID=?");
            preparedStatement.setString(1, subname.getText());
            preparedStatement.setString(2, subcode.getText());
            preparedStatement.setInt(3, (int) submodel.getValueAt(S_row, 0));
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Data Updated Successfully! ","Updtae Status",1);
            } else {
                JOptionPane.showMessageDialog(null, "Unable to Update data","Update Error",0);
            }
        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            JOptionPane.showMessageDialog(null, "Unable to Update data :"+sqlException.getMessage(),"Update Error",0);
        }
    }

    private void deleteData() {
        try (Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword)) {

            PreparedStatement preparedStatement = connection.prepareStatement("delete from subject where ID = ?");
            preparedStatement.setInt(1, (int) submodel.getValueAt(S_row, 0));
            int result = preparedStatement.executeUpdate();
            if (result > 0) {
                JOptionPane.showMessageDialog(null, "Select row deleted Successfully","Delete Status",1);
            } else {
                JOptionPane.showMessageDialog(null, "Unable to  deleted Selected row","Delete Error",0);
            }

        } catch (SQLException sqlException) {
            System.out.println(sqlException.getMessage());
            JOptionPane.showMessageDialog(null, "Unable to  deleted Selected row: "+sqlException.getMessage() ,"Delete Error",0);
        }
    }
}
