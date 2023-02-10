//==========multithreading with Gui(server me)==========

import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import javax.swing.*;
import java.awt.event.*;
 import java.awt.*;

public class Server30Gui {
    
   static String str="",str1="";
    static Scanner sc = new Scanner(System.in);
    static Scanner clnt;
    static PrintStream ps;
     static ServerSocket ss;
    static Socket s;
    static JTextField textField;
    static JLabel label;


    

    static void reader(){
        Thread tr = new Thread(()->{
          while(true){
            try {
                str= clnt.nextLine();
                label.setText(str);
               if(str.equals("bye")){break;}
            } catch (Exception e) {
                // TODO: handle exception
            }
          }
    });
    tr.start();

        } 
        static void writer(){
            Thread tw = new Thread(()->{
                try {
                        str1=textField.getText();
                        ps.println(str1);
                        textField.setText("");
                       // if(str1.equals("bye")){break;}
                } catch (Exception e) {
                    // TODO: handle exception
                }
            
        });
        tw.start();
        }
    public static void main(String[] args) {
        try {
 
              JFrame fram;
              JButton button;
        
    fram = new JFrame("SERVER CHAT");
    fram.setSize(400,400);
    fram.setLayout(null);

     textField = new JTextField();
    textField.setBounds(5,330,300,30);
    fram.add(textField);

    button = new JButton("send");
    button.setBounds(310,330,65,30);
    fram.add(button);

    label=new JLabel();
    label.setBounds(5,280,300,30);
    fram.add(label);
    fram.setVisible(true);

    
    ss = new ServerSocket(1000);
    System.out.println("Listening");
      s= ss.accept();
    System.out.println("connected");
     clnt = new Scanner(s.getInputStream());
    ps = new PrintStream(s.getOutputStream());

    reader();
    ActionListener click = new ActionListener(){  
        public void actionPerformed(ActionEvent e){
            if(!(textField.getText().equals(""))){
            writer();
        }
        }
    };button.addActionListener(click);

        } catch (Exception e) {
            // TODO: handle exception
        }
    }
    
}
