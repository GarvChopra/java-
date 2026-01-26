import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class cargame  extends JPanel implements ActionListener {
    private int carX = 100;
    private int carY = 200;
    private int carWidth = 50;
    private int carHeight = 30;
    private int speedX = 5;
    private Timer timer;
    private int roadX = 0;
    public cargame(){
        timer = new Timer(10, this);
        timer.start();
        addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    carX-=5;
                } else if (e.getKeyCode()==KeyEvent.VK_RIGHT){
                    carX+=5;

                }
            }
        };

    }
    public void obstacle(){
        //obstacle logic
    }

    
}
