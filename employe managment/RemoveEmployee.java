
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class RemoveEmployee extends JFrame implements ActionListener {

    Choice cempId;
    JLabel lblname, lblphone, lblemail;
    JButton delete, back;

    RemoveEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel labelempId = new JLabel("employe ID");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);

        JLabel labelname = new JLabel("name");
        labelname.setBounds(50, 100, 100, 30);
        add(labelname);
        lblname = new JLabel();
        lblname.setBounds(200, 100, 100, 30);
        add(lblname);

        JLabel labelphone = new JLabel("phone");
        labelphone.setBounds(50, 150, 100, 30);
        add(labelphone);
        lblphone = new JLabel();
        lblphone.setBounds(200, 150, 100, 30);
        add(lblphone);

        JLabel labelemail = new JLabel("email");
        labelemail.setBounds(50, 200, 100, 30);
        add(labelemail);
        lblemail = new JLabel();
        lblemail.setBounds(200, 200, 100, 30);
        add(lblemail);

        delete = new JButton("Delete");
        delete.setBounds(70, 300, 100, 30);
        delete.setBackground(Color.BLACK);
        delete.setForeground(Color.WHITE);
        delete.addActionListener(this);
        add(delete);
        back = new JButton("Back");
        back.setBounds(200, 300, 100, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);

        cempId = new Choice();
        cempId.setBounds(200, 50, 100, 30);
        add(cempId);
        cempId.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent ie) {
                try {
                    conn c = new conn();
                    String query = "select * from employee where empId='" + cempId.getSelectedItem() + "'";
                    ResultSet rs = c.s.executeQuery(query);
                    while (rs.next()) {
                        lblname.setText(rs.getString("name"));
                        lblphone.setText(rs.getString("phone"));
                        lblemail.setText(rs.getString("email"));
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }); 


            
        

        try {
            conn c =new conn();
            String query = "select * from employee";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                cempId.add(rs.getString("empId"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            conn c =new conn();
            String query = "select * from employee where empId='"+cempId.getSelectedItem()+"'";
            ResultSet rs = c.s.executeQuery(query);
            while(rs.next()){
                lblname.setText(rs.getString("name"));
                lblphone.setText(rs.getString("phone"));
                lblemail.setText(rs.getString("email"));
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }

   
            setSize(1000,600);
            setLocation(300,150);
            setVisible(true);
    }
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==delete){
            try {
                conn c =new conn();
                String query = "delete from employee where empId='"+cempId.getSelectedItem()+"'";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Deleted Successfully");
                setVisible(false);
                new Home();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Home();
        }

    }

    public static void main(String[] args) {
        new RemoveEmployee();
    }

}
