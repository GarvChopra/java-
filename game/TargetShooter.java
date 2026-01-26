import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TargetShooter extends JPanel implements ActionListener {
    private int targetX = 0;
    private int targetY = 150;
    private int targetSize = 50;
    private int speedX = 5;
    private int score = 0;
    private Timer timer;

    public TargetShooter() {
        timer = new Timer(10, this);
        timer.start();

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                checkHit(e.getX(), e.getY());
            }
        });
    }

    private void checkHit(int mouseX, int mouseY) {
        double distance = Math.sqrt(Math.pow(mouseX - (targetX + targetSize/2), 2) + 
                                   Math.pow(mouseY - (targetY + targetSize/2), 2));
        
        if (distance <= targetSize / 2) {
            score++;
            resetTarget();
        }
    }

    private void resetTarget() {
        targetX = -targetSize;
        targetY = (int) (Math.random() * 300) + 50;
        speedX += 1;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 20, 30);

        g.setColor(Color.RED);
        g.fillOval(targetX, targetY, targetSize, targetSize);
        g.setColor(Color.WHITE);
        g.drawOval(targetX + 10, targetY + 10, targetSize - 20, targetSize - 20);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        targetX += speedX;

       
        if (targetX > getWidth()) {
            resetTarget();
            score = 0;
            speedX = 5; 
        }

        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Simple Target Shooter");
        TargetShooter game = new TargetShooter();
        frame.add(game);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}