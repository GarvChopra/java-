import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;


public class Loginbank extends JFrame implements ActionListener{
    JTextField textcardno;
    JPasswordField textpassword;
    JButton login, signup;
    Loginbank() {
        setTitle("Bank Management System - Login");
        setLayout(null);

        JLabel label = new JLabel("Welcome to ATM");
        label.setBounds(300,10,200,30);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label);
        
        //card no

        JLabel labelcardno= new JLabel("Card No");
        labelcardno.setBounds(150,70,140,30);

        add(labelcardno);
        textcardno= new JTextField();
        textcardno.setBounds(250,70,150,30);
        add(textcardno);
        //pass
        JLabel labelpassword= new JLabel("Password");
        labelpassword.setBounds(150,120,100,30);
        add(labelpassword);
        textpassword= new JPasswordField();
        textpassword.setBounds(250,120,150,30);
        add(textpassword);

        //login
        login= new JButton("Login");
        login.setBounds(300,250,150,30);
        add(login);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);
        
        //signup
        signup= new JButton("Sign Up");
        signup.setBounds(300,300,150,30);
        add(signup);
        signup.setForeground(Color.WHITE);
        signup.setBackground(Color.BLACK);
        signup.addActionListener(this);

        setSize(800,400);
        setLocation(500,200);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        try {
            String cardno = textcardno.getText().trim();
            String password = new String(textpassword.getPassword()).trim();
            conn1 c = new conn1();
            String query = "select * from login where cardno = '"+cardno+"' and password = '"+password+"'";
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Transactions(cardno);
               
            }else if(ae.getActionCommand().equals("Sign Up")){
                setVisible(false);
               
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect Card Number or Password");
            }

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Loginbank();
    }
    
}
