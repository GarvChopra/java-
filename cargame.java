import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class cargame extends JPanel implements ActionListener {
    private Rectangle car;
    private Rectangle obstacle;
    private int carX = 175;
    private int carY = 300;
    private int carWidth = 50;
    private int carHeight = 70;

    private int obstacleX = 200;
    private int obstacleY = -50;
    private int obstacleWidth = 50;
    private int obstacleHeight = 50;

    private Timer timer;
    private int roadOffset = 0;

    public cargame() {
        car = new Rectangle(carX, carY, carWidth, carHeight);
        obstacle = new Rectangle(obstacleX, obstacleY, obstacleWidth, obstacleHeight);

        timer = new Timer(15, this); 
        timer.start();

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_LEFT && carX > 0) {
                    carX -= 15;
                } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && carX < getWidth() - carWidth) {
                    carX += 15;
                }
            }
        });
    }

    public void obstacle() {
        obstacleY += 7;
        
        if (obstacleY > getHeight()) {
            resetTarget();
        }
        
        obstacle.setBounds(obstacleX, obstacleY, obstacleWidth, obstacleHeight);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        g.setColor(Color.DARK_GRAY);
        g.fillRect(0, 0, getWidth(), getHeight());

        g.setColor(Color.WHITE);
        roadOffset += 7;
        if (roadOffset > 40) roadOffset = 0;
        
        for (int i = -40; i < getHeight(); i += 40) {
            g.fillRect(getWidth() / 2 - 5, i + roadOffset, 10, 20);
        }

        g.setColor(Color.BLUE);
        car.setBounds(carX, carY, carWidth, carHeight);
        g.fillRect(car.x, car.y, car.width, car.height);

        g.setColor(Color.RED);
        g.fillRect(obstacle.x, obstacle.y, obstacle.width, obstacle.height);
    }

    public void checkHit() {
        if (car.intersects(obstacle)) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "Game Over!");
        }
    }

    public void resetTarget() {
        obstacleY = -50;
        obstacleX = (int) (Math.random() * (getWidth() - obstacleWidth));
        if (obstacleX < 0) obstacleX = 0;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        obstacle();
        checkHit();
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Car Game");
        cargame gamePanel = new cargame();
        frame.add(gamePanel);
        frame.setSize(400, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
        
        gamePanel.setFocusable(true);
        gamePanel.requestFocusInWindow();
    }
}