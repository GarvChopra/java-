import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JDateChooser;
import java.util.*;

public class AddEmployee extends JFrame implements ActionListener {
    JButton back,add;
    JTextField tfname,tffname,tsalary,tadress,tphone,temail,tdesignation,tadhar;
    JDateChooser dateChooser;
    JComboBox cedu;
    JLabel labelempid, tempid;

    Random ran = new Random();
    int number = ran.nextInt(999999);
    AddEmployee() {
        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        JLabel heading = new JLabel("Add new employee");
        heading.setBounds(350, 20, 400, 30);
        heading.setFont(new Font("Tahoma", Font.BOLD, 25));
        add(heading);

        //name
        JLabel labelname= new JLabel("Name");
        labelname.setBounds(50,150,150,30);
        labelname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelname);
        tfname =  new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);
        //father name
        JLabel labelfname= new JLabel("Fathers Name");
        labelfname.setBounds(400,150,150,30);
        labelfname.setFont(new Font("serif",Font.PLAIN,20));
        add(labelfname);
        tffname =  new JTextField();
        tffname.setBounds(550,150,150,30);
        add(tffname);
        //dob
        JLabel labelDob= new JLabel("DOB");
        labelDob.setBounds(50,250,150,30);
        labelDob.setFont(new Font("serif",Font.PLAIN,20));
        add(labelDob);
        dateChooser = new JDateChooser();
        dateChooser.setBounds(200,250,150,30);
        add(dateChooser);
        //salary
        JLabel labelsalary= new JLabel("Salary");
        labelsalary.setBounds(400,250,150,30);
        labelsalary.setFont(new Font("serif",Font.PLAIN,20));
        add(labelsalary);
        tsalary =  new JTextField();
        tsalary.setBounds(550,250,150,30);
        add(tsalary);
        //adress
        JLabel labelAdress= new JLabel("Adress");
        labelAdress.setBounds(50,350,150,30);
        labelAdress.setFont(new Font("serif",Font.PLAIN,20));
        add(labelAdress);
        tadress =  new JTextField();
        tadress.setBounds(200,350,150,30);
        add(tadress);
        //phone no
        JLabel labelphoneno = new JLabel("Phone No");
        labelphoneno.setBounds(400,350,150,30);
        labelphoneno.setFont(new Font("serif",Font.PLAIN,20));
        add(labelphoneno);
        tphone =  new JTextField();
        tphone.setBounds(550,350,150,30);
        add(tphone);
        //email
        JLabel labelemail = new JLabel("Email");
        labelemail.setBounds(50,450,150,30);
        labelemail.setFont(new Font("serif",Font.PLAIN,20));
        add(labelemail);
        temail =  new JTextField();
        temail.setBounds(200,450,150,30);
        add(temail);
        //education
        JLabel labelEducation = new JLabel("Education");
        labelEducation.setBounds(400,450,150,30);
        labelEducation.setFont(new Font("serif",Font.PLAIN,20));
        add(labelEducation);
        String courses[]= {"B.Tech","M.Tech","BBA","MBA","BSC","MSC","BCOM","MCOM","PHD"};
        cedu = new JComboBox(courses);
        cedu.setBounds(550,450,150,30);
        add(cedu);

        JLabel labeldesignation= new JLabel("Designation");
        labeldesignation.setBounds(50,550,150,30);
        labeldesignation.setFont(new Font("serif",Font.PLAIN,20));
        add(labeldesignation);
        tdesignation =  new JTextField();
        tdesignation.setBounds(200,550,150,30);
        add(tdesignation);
       //adhar no 
        JLabel labeladhar = new JLabel("Adhar No");
        labeladhar.setBounds(400,550,150,30);
        labeladhar.setFont(new Font("serif",Font.PLAIN,20));
        add(labeladhar);
        tadhar =  new JTextField();
        tadhar.setBounds(550,550,150,30);
        add(tadhar);

        //emp id
        
        labelempid = new JLabel("Employee ID");
        labelempid.setBounds(50,650,150,30);
        labelempid.setFont(new Font("serif",Font.PLAIN,20));
        add(labelempid);
        tempid =  new JLabel(""+number);
        tempid.setBounds(200,650,150,30);
        add(tempid);

        //back button
        back = new JButton("Back");
        back.setBounds(250,750,150,40);
        back.addActionListener(this);
        add(back);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);

        // add button
        add = new JButton("Add Employee");
        add.setBounds(450,750,150,40);
        add.addActionListener(this);
        add(add);
        add.setBackground(Color.BLACK);
        add.setForeground(Color.WHITE);

        setSize(900,900);
        setLocation(300,100);
        setVisible(true);
      

    }

    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource()==back){

            setVisible(false);
            new Home();
        }else if(ae.getSource()==add){
            String name =tfname.getText();
            String fname =tffname.getText();
            String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
            String salary = tsalary.getText();
            String adress = tadress.getText();
            String phone = tphone.getText();
            String email = temail.getText();
            String education = (String)cedu.getSelectedItem();
            String designation = tdesignation.getText();
            String adhar = tadhar.getText();
            String empid = tempid.getText();


            try {
                conn conn =new conn();
                String query="insert into employee values('"+name+"','"+fname+"','"+dob+"','"+salary+"','"+adress+"','"+phone+"','"+email+"','"+education+"','"+designation+"','"+adhar+"','"+empid+"')";
                conn.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "Employee Added Successfully");
                setVisible(false);
            } catch (Exception e) {
                e.printStackTrace();
            }

             


        }

        
        
    }

    public static void main(String[] args) {
        new AddEmployee();
    }
}