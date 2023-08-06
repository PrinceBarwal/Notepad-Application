package notepad.application;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class About extends JFrame implements ActionListener{
    
    About(){
        setSize(600 , 600);
        setLocationRelativeTo(null);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("notepad/application/icons/windows.png"));
        Image i2 = i1.getImage().getScaledInstance(400, 100 , Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image  = new JLabel(i3);
        image.setBounds(100,40,400 , 100);
        add(image);
        
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("notepad/application/icons/notepad.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50 , Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel sideimage  = new JLabel(i6);
        sideimage.setBounds(100,200,50 , 50);
        add(sideimage);
        
        
        JLabel text = new JLabel("<html>Future Coder <br> Version 0.1.0 <br> Future Coder. All rights reserved.</html>");
        text.setBounds(200 , 100 , 400 , 300);
        text.setFont(new Font("SAN_SARIF" , Font.PLAIN , 25));
        add(text);  
        
        
        JButton b1 = new JButton("OK");
        b1.setBounds(450 , 400 , 70 , 30);
//        b1.setFont(new Font("Tahoma" , Font.PLAIN , 10));
//        b1.setBackground(Color.WHITE);
//        b1.setForeground(new Color(0 , 144 , 255));
        b1.addActionListener(this);
        add(b1);
        
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
    }
    
    public static void main(String[] args){
        new About();
    }
    
}
