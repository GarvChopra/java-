
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Splash extends JFrame implements ActionListener  {

    Splash() {
        setLayout(null);
        setSize(1170, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/front.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1170, 700, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 1170, 700);
        add(image);

        JButton clickhere = new JButton("CLICK HERE TO CONTINUE");
        clickhere.setBounds(400, 500, 300, 70);
        image.add(clickhere);
        clickhere.setBackground(Color.WHITE);
        clickhere.addActionListener(this);


        
        
        JLabel heading = new JLabel("Employe management system");
        heading.setBounds(400, 1, 1500, 70);
        heading.setFont(new Font("serif", Font.PLAIN, 40));
        heading.setForeground(Color.BLACK);
        image.add(heading);
        setVisible(true);

       
            
        }
        public void actionPerformed(ActionEvent ae){
            setVisible(false);
            new Login();

    }

    public static void main(String[] args) {
        new Splash();
    }
}
