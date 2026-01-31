import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Login extends JFrame  implements ActionListener {
    JTextField textusername,textuserpassword;
    Login(){
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);
        //name
        JLabel labelusername= new JLabel("username");
        labelusername.setBounds(40,20,100,30);
        add(labelusername);
        textusername= new JTextField();
        textusername.setBounds(150,20,150,30);
        add(textusername);
        //pass
        JLabel labelpassword= new JLabel("password");
        labelpassword.setBounds(40,70,100,30);
        add(labelpassword);
        textuserpassword= new JTextField();
        textuserpassword.setBounds(150,70,150,30);
        add(textuserpassword);
        //Button 
        JButton login= new JButton("Login");
        login.setBounds(150,140,150,30);
        add(login);
        login.setForeground(Color.WHITE);
        login.setBackground(Color.BLACK);
        login.addActionListener(this);
        //image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(200,200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(350,0,200,200);
        add(image);
        
        
        setSize(600,300);
        setLocation(400,200);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent ae){
        try {
            String username = textusername.getText();
            String password = textuserpassword.getText();
            conn c = new conn(); 
            


            String query = "select * from login where username='"+username+"' and password='"+password+"'";
            ResultSet rs = c.s.executeQuery(query);
            if(rs.next()){
                setVisible(false);
                new Home();}
                
            else{
                JOptionPane.showMessageDialog(null, "Invalid username or password");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new Login();
    }

    
}
