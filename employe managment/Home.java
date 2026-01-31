import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Home extends JFrame implements ActionListener {
    JButton add, view, remove, update;

    Home() {
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/home.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1120, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1120, 600);
        add(image);
        JLabel heading = new JLabel("EMPLOYEE MANAGEMENT SYSTEM");
        heading.setBounds(300, 10, 600, 30);
        heading.setFont(new Font("TOHOMA", Font.BOLD, 30));
        image.add(heading);

        add = new JButton("ADD EMPLOYEE");
        add.setBounds(700, 130, 200, 40);
        image.add(add);
        add.addActionListener(this);
        view = new JButton("VIEW EMPLOYEE");
        view.setBounds(700, 300, 200, 40);
        image.add(view);
        view.addActionListener(this);
        remove = new JButton("REMOVE EMPLOYEE");
        remove.setBounds(100, 130, 200, 40);
        image.add(remove);
        remove.addActionListener(this);
        update = new JButton("UPDATE EMPLOYEE");
        update.setBounds(100, 300, 200, 40);
        image.add(update);
        update.addActionListener(this);

        setTitle("Home Page");
        setSize(1120, 600);
        setLocation(400, 200);
        setVisible(true);
    
}
public void actionPerformed(ActionEvent ae) {
    if(ae.getSource()==add){
        setVisible(false);
        new AddEmployee();
    }
    else if(ae.getSource()==view){
        setVisible(false);
        new ViewEmployee();
       

    }
    else if(ae.getSource()==update){
        setVisible(false);
        new ViewEmployee();
           

       

    }
    else if(ae.getSource()==remove){
        setVisible(false);
       

    }

    
}

public static void main(String[] args) {
    new Home();
}
}