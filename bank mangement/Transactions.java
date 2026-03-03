import javax.swing.*;

public class Transactions extends JFrame {
    Transactions(String cardno) {
        JLabel label = new JLabel("Transactions for Card No: " + cardno);
        label.setBounds(100, 100, 200, 30);
        add(label);
        setSize(400, 400);
        setLocation(500, 200);
        setVisible(true);

    }
    
    
}
