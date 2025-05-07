package schoolms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    public static String username;
    public static String usertype = "";
    public static String url = "jdbc:mysql://localhost:3306/sms";
    public static String dbusername = "root";
    public static String dbpassword = "Lucifer";

    JComboBox<String> admin = new JComboBox<>(new String[]{"Admin", "Teacher", "Student", "Guest"});
    JLabel background;
    JTextField username_text;
    JPasswordField password_text;
    JButton submit, close;
    JLabel babckground;
    private String password;

    public login() {
        setTitle("SMS Login Page");
        username = username;
        usertype = usertype;
        this.password = password;

        // setting Additional labels
        JLabel smanag = new JLabel("School Management");
        smanag.setFont(new Font("Arial", Font.BOLD, 35));
        smanag.setBounds(10, 10, 350, 35);
        smanag.setForeground(new Color(104, 68, 67));
        this.add(smanag);

        JLabel mentsys = new JLabel("System");
        mentsys.setFont(new Font("Arial", Font.BOLD, 35));
        mentsys.setBounds(110, 45, 150, 35);
        mentsys.setForeground(new Color(104, 68, 67));
        this.add(mentsys);

        JLabel welcome = new JLabel("Welcome User");
        welcome.setFont(new Font("Arial", Font.BOLD, 28));
        welcome.setBounds(370, 305, 250, 28);
        welcome.setForeground(new Color(104, 68, 67));
        this.add(welcome);

        // images
        // setting background image
        ImageIcon background_image = new ImageIcon(getClass().getResource("/schoolms/pics/loginbg1.jpg"));
        if (background_image.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.err.println("Error loading background image.");
            return;
        }
        Image img = background_image.getImage();
        Image temp_img = img.getScaledInstance(850, 600, Image.SCALE_SMOOTH);
        background_image = new ImageIcon(temp_img);
        babckground = new JLabel("", background_image, JLabel.CENTER);
        babckground.setBounds(0, 0, 850, 600);


        ImageIcon background_image2 = new ImageIcon(getClass().getResource("/schoolms/pics/usericon.png"));
        if (background_image2.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.err.println("Error loading user icon image.");
            return;
        }
        Image img2 = background_image2.getImage();
        Image temp_img2 = img2.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        background_image2 = new ImageIcon(temp_img2);
        JLabel userimg = new JLabel("", background_image2, JLabel.CENTER);
        userimg.setBounds(300, 325, 40, 40);
        userimg.setBackground(new Color(73, 157, 203));
        this.add(userimg);

        ImageIcon background_image3 = new ImageIcon(getClass().getResource("/schoolms/pics/password.png"));
        if (background_image3.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.err.println("Error loading password icon image.");
            return;
        }
        Image img3 = background_image3.getImage();
        Image temp_img3 = img3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        background_image3 = new ImageIcon(temp_img3);
        JLabel passimg = new JLabel("", background_image3, JLabel.CENTER);
        passimg.setBounds(300, 375, 40, 40);
        passimg.setBackground(new Color(73, 157, 203));
        this.add(passimg);

        ImageIcon background_image4 = new ImageIcon(getClass().getResource("/schoolms/pics/utype.png"));
        if (background_image4.getImageLoadStatus() == MediaTracker.ERRORED) {
            System.err.println("Error loading user type icon image.");
            return;
        }
        Image img4 = background_image4.getImage();
        Image temp_img4 = img4.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        background_image4 = new ImageIcon(temp_img4);
        JLabel utypeimg = new JLabel("", background_image4, JLabel.CENTER);
        utypeimg.setBounds(300, 425, 40, 40);
        utypeimg.setBackground(new Color(73, 157, 203));
        this.add(utypeimg);

        // setting login labels and text fields
        username_text = new JTextField();
        username_text.setBounds(350, 330, 250, 30);
        username_text.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(username_text);
        username = username_text.getText();

        password_text = new JPasswordField();
        password_text.setBounds(350, 380, 250, 30);
        password_text.setFont(new Font("Arial", Font.PLAIN, 20));
        this.add(password_text);

        admin.setBounds(350, 430, 250, 30);
        admin.setFont(new Font("Arial", Font.PLAIN, 20));
        usertype = (String) admin.getSelectedItem();
        this.add(admin);

        // setting buttons
        submit = new JButton("Submit");
        submit.setFont(new Font("Arial", Font.BOLD, 20));
        submit.setBounds(500, 470, 100, 30);
        submit.setBackground(new Color(232, 231, 229));
        submit.setForeground(new Color(73, 157, 203));
        submit.addActionListener(this);
        this.add(submit);

        close = new JButton("Close");
        close.setFont(new Font("Arial", Font.BOLD, 20));
        close.setBounds(350, 470, 100, 30);
        close.setBackground(new Color(232, 231, 229));
        close.setForeground(new Color(73, 157, 203));
        close.addActionListener(this);
        this.add(close);

        // setting frame
        this.add(babckground);
        setSize(850, 550);
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        this.setResizable(true);
    }

    public static void main(String[] args) {
        new login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == close) {
            this.dispose();
        } else if (e.getSource() == submit) {
            username = username_text.getText();
            usertype = (String) admin.getSelectedItem();
            password = new String(password_text.getPassword());
            String check = "select * from Users where username = ? && password= ? && user_type = ? ;";
            try {

                Connection connection = DriverManager.getConnection(login.url, login.dbusername, login.dbpassword);
                PreparedStatement preparedStatement = connection.prepareStatement(check);
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, usertype);
                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    new Menu();
                    System.out.println("Successfully login  user with Username: " + username + "   AND Usertype: " + usertype);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                    System.out.println("Someone trying to sign in with Username :" + username + " Password: " + password + " User Type: " + usertype);
                }
                connection.close();
                preparedStatement.close();


            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }


        }
    }
}
