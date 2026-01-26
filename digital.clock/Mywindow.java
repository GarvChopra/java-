import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.Date;
import javax.swing.*;

public class Mywindow extends JFrame {
    
    private JLabel heading;
    private JLabel clockLabel;
    
    private Font font = new Font("Arial", Font.BOLD, 20);
    
    Mywindow() {
        super.setTitle("My clock");
        super.setSize(400, 400);
        super.setLocationRelativeTo(null);

    
        setUndecorated(true);

       
        setShape(new Ellipse2D.Double(0, 0, 400, 400));

        createGui(); 
        startClock();
        
        super.setVisible(true);
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void createGui() {
        heading = new JLabel("My Clock", SwingConstants.CENTER);
        clockLabel = new JLabel("clock", SwingConstants.CENTER);
        
        heading.setFont(font);
        clockLabel.setFont(font);
        
        this.setLayout(new GridLayout(2, 1));
        this.add(heading);
        this.add(clockLabel);

       
        getContentPane().setBackground(Color.BLACK);
        heading.setForeground(Color.WHITE);
        clockLabel.setForeground(Color.CYAN);
    }

    public void startClock() {
        Timer timer = new Timer(1000, e -> {
            String dateTime = new Date().toString();
            clockLabel.setText(dateTime);
        });
        timer.start();
    }
}
