
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Signup  extends JFrame implements ActionListener{
    JTextField nameField, emailField, fnameField, dobField, addressField, cityField, stateField, pincodeField, panField, aadharField;
    JComboBox<String> gendercom, occupationcom;

    Signup(){
        setTitle("Bank Management System - Sign Up");
        setLayout(null);

        JLabel label = new JLabel("Create a New Account");
        label.setBounds(300,10,200,30);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        add(label);

        //name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100,70,100,30);
        add(nameLabel);
        nameField = new JTextField();
        nameField.setBounds(200,70,200,30);
        add(nameField);
        //email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100,120,100,30);
        add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(200,120,200,30);
        add(emailField);
        //fname

        JLabel fnameLabel = new JLabel("Father's Name:");
        fnameLabel.setBounds(100,170,100,30);
        add(fnameLabel);
        fnameField = new JTextField();
        fnameField.setBounds(200,170,200,30);
        add(fnameField);

        //dob
        JLabel dobLabel = new JLabel("Date of Birth:");
        dobLabel.setBounds(100,220,100,30);
        add(dobLabel);
        dobField = new JTextField();
        dobField.setBounds(200,220,200,30);
        add(dobField);

        //gender
        JLabel genderLabel = new JLabel("Gender:");
        genderLabel.setBounds(100,270,100,30);
        add(genderLabel);
        String[] genderOptions = {"Male", "Female", "Other"};
        gendercom = new JComboBox<>(genderOptions);
        gendercom.setBounds(200,270,200,30);
        add(gendercom);

        //adress
        JLabel addressLabel = new JLabel("Address:");
        addressLabel.setBounds(100,320,100,30);
        add(addressLabel);
        addressField = new JTextField();
        addressField.setBounds(200,320,200,30);
        add(addressField);
        //city
        JLabel cityLabel = new JLabel("City:");
        cityLabel.setBounds(100,370,100,30);
        add(cityLabel);
        cityField = new JTextField();
        cityField.setBounds(200,370,200,30);
        add(cityField);

        //state
        JLabel stateLabel = new JLabel("State:");
        stateLabel.setBounds(100,420,100,30);
        add(stateLabel);
        stateField = new JTextField();
        stateField.setBounds(200,420,200,30);
        add(stateField);

        //pincode 
        JLabel pincodeLabel = new JLabel("Pincode:");
        pincodeLabel.setBounds(100,470,100,30);
        add(pincodeLabel);
        pincodeField = new JTextField();
        pincodeField.setBounds(200,470,200,30);
        add(pincodeField);
        //occupation
        JLabel occupationLabel = new JLabel("Occupation:");
        occupationLabel.setBounds(100,520,100,30);
        add(occupationLabel);
        String[] occupationOptions = {"Salaried", "Self-Employed", "Business"};
        occupationcom = new JComboBox<>(occupationOptions);
        occupationcom.setBounds(200,520,200,30);
        add(occupationcom);
        //pan
         JLabel panLabel = new JLabel("PAN Number:");
        panLabel.setBounds(100,570,100,30);
        add(panLabel);
        panField = new JTextField();
        panField.setBounds(200,570,200,30);
        add(panField);
        //aadhar
        JLabel aadharLabel = new JLabel("Aadhar Number:");  
        aadharLabel.setBounds(100,620,100,30);
        add(aadharLabel);
        aadharField = new JTextField();
        aadharField.setBounds(200,620,200,30);
        add(aadharField);
        //submit
        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(300,700,100,30);
        add(submitButton);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.BLACK);
        submitButton.addActionListener(this);
       
        

        setSize(800,800);
        setLocation(500,200);
        setVisible(true);
    }   
    public void actionPerformed(ActionEvent ae){

        String name = nameField.getText().trim();
        String email = emailField.getText().trim();
        String fname = fnameField.getText().trim();
        String dob = dobField.getText().trim();
        String gender = (String) gendercom.getSelectedItem();
        String address = addressField.getText().trim();
        String city = cityField.getText().trim();
        String state = stateField.getText().trim();
        String pincode = pincodeField.getText().trim();
        String occupation = (String) occupationcom.getSelectedItem();
        String pan = panField.getText().trim();
        String aadhar = aadharField.getText().trim();

        try {
            conn1 c = new conn1();
            String query = "insert into signup(name, email, fname, dob, gender, address, city, state, pincode, occupation, pan, aadhar) values('"+name+"', '"+email+"', '"+fname+"', '"+dob+"', '"+gender+"', '"+address+"', '"+city+"', '"+state+"', '"+pincode+"', '"+occupation+"', '"+pan+"', '"+aadhar+"')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Account Created Successfully");
            setVisible(false);
        } catch (Exception e) {
            e.printStackTrace();
        }


            
        
    }
    public static void main(String[] args) {
        new Signup();
    } 
}
