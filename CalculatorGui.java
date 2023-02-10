
    import javax.swing.*;
import java.awt.*; 
import java.awt.event.*;
public class CalculatorGui {
    public static void main(String[] args) {
        JFrame fram = new JFrame("calculator");
        fram.setSize(400,400);
        
        JTextField jb = new JTextField();
        jb.setBounds(30, 30, 330, 40);
        fram.add(jb);
        
        JPanel pm = new JPanel();
        pm.setBounds(30, 90, 330,260);
        fram.add(pm);
        pm.setLayout(new GridLayout(4,4,2,2));
 
         
          String x[] = {"1","2","3","+","4","5","6","-","7","8","9","*","00",".","0","/"};
           

          for(String s : x){
            JButton bt = new JButton(s);
            pm.add(bt);
          }
        
        fram.setLayout (null);
        fram.setVisible(true);
    }
    
}   

