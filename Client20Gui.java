

import java.io.PrintStream;
import java.io.ObjectInputStream.GetField;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
   
    public class Client20Gui {
       
        static Socket s;
        static  PrintStream ps;
        static Scanner sc1;



        public static void main(String[] args) {

            try {
                
                Socket s= new Socket("localhost",640);
                System.out.println("connected to server....");
                PrintStream ps = new PrintStream(s.getOutputStream());
                Scanner sc1 = new Scanner(s.getInputStream());

           
            JFrame fram = new JFrame("Password Generater");
            fram.setSize(400,400);
            fram.setLayout(null);

            JLabel label = new JLabel(" Password Generate Page");
            label.setBounds(140,30,150,20);
            fram.add(label);
            JLabel label1 = new JLabel("Name:");
            label1.setBounds(40,100,70,30);
            fram.add(label1);
            JLabel label2 = new JLabel("Email:");
            label2.setBounds(40,140,70,30);
            fram.add(label2);
            
            JTextField textField = new JTextField();
            textField.setBounds(120,100,200,30);
            fram.add(textField);
            JTextField textField1 = new JTextField();
            textField1.setBounds(120,140,200,30);
            fram.add(textField1);
 
            JButton button = new JButton("Get Password");
            button.setBounds(140,200,150,50);
            fram.add(button);

            JLabel label3 = new JLabel();
            label3.setBounds(40,320,300,30);
            fram.add(label3);
            
            ActionListener click = new ActionListener(){
                public void actionPerformed(ActionEvent e){
       
                    String name=textField.getText();
                    String email=textField1.getText();
                    ps.println(name);
                    ps.println(email);
                    label3.setText(sc1.nextLine());
              
                    textField.setText("");
                    textField1.setText("");

                }
            };
            button.addActionListener(click);
            fram.setVisible(true);
           
        
                        
            
        }catch (Exception ep) {
                // TODO: handle exception
            }
        }
        
    }
    