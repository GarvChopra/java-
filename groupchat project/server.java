import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.*;
import java.util.Vector;
import javax.swing.*;

  public class server extends JFrame implements ActionListener, Runnable {
    
    Socket socket;
    
    server() {
        

        setLayout(null);

        JPanel p1 = new JPanel();
        p1.setLayout(null);   
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,500,70);
        add(p1);
        //back button

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(30,30,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5,20,30,30);
        p1.add(back);

        back.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent ae){
                System.exit(0);
            }
        });
        //profile image
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/1.png"));
        Image i5 = i4.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);

        profile.setBounds(40,10,50,50);
        p1.add(profile);
        //video call icon
        ImageIcon i7Icon = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7Icon.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);

        video.setBounds(400,20,30,30);
        p1.add(video);
        //telephone icon
        ImageIcon i10Icon = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i = i10Icon.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
        ImageIcon i11 = new ImageIcon(i);
        JLabel telephone = new JLabel(i11);

        telephone.setBounds(450,20,30,30);
        p1.add(telephone);

        //name label
        JLabel name = new JLabel("Garv");
        name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        name.setForeground(Color.WHITE);
        name.setBounds(100,15,100,20);
        p1.add(name);
        //text
        JTextField text = new JTextField();
        text.setBounds(5,600,350,40);
        text.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        add(text);
        //send button
        JButton send = new JButton("Send");
        send.setBounds(360,600,120,40);
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF",Font.PLAIN,16));  
        add(send);




        setSize(500,700);
        setVisible(true);
        setLocation(500,200);
        getContentPane().setBackground(Color.WHITE);
    }
    public static Vector clients = new Vector();

    public server (Socket socket){
        try {
            this.socket=socket;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() {
        try {
            BufferedReader br =new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            clients.add(writer);
            while (true) { 
                String data = br.readLine().trim();
                System.out.println("recieved"+data);
                
                for(int i=0;i<clients.size();i++){

                    try {
                        BufferedWriter bw = (BufferedWriter)clients.get(i);
                        bw.write(data);
                        bw.write("\r\n");
                        bw.flush();

                        
                        
                    } catch (Exception e) {
                    }
                    
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void actionPerformed(ActionEvent ae) {
    }

    public static void main(String[] args) throws Exception{
        new server();
        ServerSocket a = new ServerSocket(6001);
        while(true){
            Socket socket = a.accept();
            server s = new server(socket);
            Thread t = new Thread(s);
            t.start();


        }

    }
}
