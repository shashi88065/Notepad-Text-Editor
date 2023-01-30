package notepadapp;
import javax.swing.*;
import java.awt.*;


public class about extends JFrame {
    
    about(){
        setTitle("about");
        setBounds(700,150,400,200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon=new ImageIcon(getClass().getResource("image1.png"));
        setIconImage(icon.getImage());  
        setLayout(null);
       
        JLabel iconLable = new JLabel(new ImageIcon(getClass().getResource("image1.png")));
        Image i =icon.getImage();
        Image new_img = i.getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        icon =new ImageIcon(new_img);
        iconLable.setBounds(50, 30, 80,30);
         add(iconLable);
        /*
         ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("image1.png"));
         JLabel image2 = new JLabel(i1);
         image2.setBounds(50, 30, 100, 50);
         add(image2);*/
          
        JLabel textLable=new JLabel("<html>Welcome to notepad<br>This text editor is a simple text editor for microsoft windows and a basic text editing program which enables user to create documents<br>All rights reserved@sktechnology</html>");
        textLable.setBounds(50, 60,300,100);
        add(textLable);
    }
    
    
     public static void main(String[] args) {
         
       new about().setVisible(true);
    }
}
