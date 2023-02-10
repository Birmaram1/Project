
import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
import java.util.jar.JarFile;
import java.awt.event.*;
import java.io.*;
import java.io.FileWriter;

public class LoginGui {
         
         
    void log(){
        try {
            File obj =new File("Login.text");
            obj.createNewFile();
        } catch (Exception e) {
            // TODO: handle exception
        }
       
        
        JFrame fram = new JFrame("login page");
        fram.setSize(500,400);
        fram.setLayout(null);
    
        JLabel jb = new JLabel("email :");
        JLabel jb1 = new JLabel("password :");
        jb.setBounds(60,40,80,30);
        jb1.setBounds(60,80,80,30);
        fram.add(jb);
        fram.add(jb1);
        
        JTextField text = new JTextField();
        JTextField text1 = new JTextField();
        
        text.setBounds(150, 45, 250, 30);
        text1.setBounds(150, 90, 250, 30);
    
        fram.add(text);
        fram.add(text1);
        
        JButton button = new JButton("login");
        button.setBounds(160, 130, 80, 25);
        fram.add(button);
        JButton button1 = new JButton("register");
        button1.setBounds(310, 130, 80, 25);
        fram.add(button1);
       
        JLabel lp = new JLabel();
                lp.setBounds(50, 165, 400, 15);
                fram.add(lp);
    
       JLabel lp1 = new JLabel();
                lp1.setBounds(70, 185, 400,15);
                fram.add(lp1);        
       
     
        ActionListener click = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String email = text.getText();
                String password = text1.getText();
               try {
                File obj = new File("Login.text");
                Scanner read = new Scanner(obj);
                int c=0,c1=0;
                while(read.hasNext()){
                    
                    
                    if( read.next().equals(email)&&read.next().equals(password)){
                         c++;  System.out.println("ram");
                    }
                  
               
                }
                if(c==1){
                    lp.setText("email seccessfully login");
                    lp1.setText("email: "+email+", password: "+password);
                }
                else{
                       lp1.setText("");
                    lp.setText("wrong entry,   TRY AGAIN");
                }

            }
                catch (Exception ep) {
                    System.out.println(e);
               }
                
                  
            }
          };
        
          button.addActionListener(click);
          fram.setVisible(true);


          ActionListener click1 = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                 button1.getText();
                 JFrame fram1 = new JFrame("register page");
                fram1.setSize(500,400);
                fram1.setLayout(null);
                 
                JLabel jb2 = new JLabel("name :");
                JLabel jb3 = new JLabel("email :");
                JLabel jb4 = new JLabel("password :");
                jb2.setBounds(60,40,80,30);
                jb3.setBounds(60,80,80,30);
                jb4.setBounds(60,120,80,30);
                fram1.add(jb2);
                fram1.add(jb3);
                fram1.add(jb4);
    
                JTextField text2 = new JTextField();
                JTextField text3 = new JTextField();
                JTextField text4 = new JTextField();
                text2.setBounds(150, 45, 250, 30);
                text3.setBounds(150, 85, 250, 30);
                text4.setBounds(150, 125, 250, 30);
                fram1.add(text2);
                fram1.add(text3);
                fram1.add(text4);

                JButton button2= new JButton("register");
                button2.setBounds(230, 165, 80, 25);
                fram1.add(button2);

                JLabel lp2 = new JLabel();
                lp2.setBounds(50, 250, 400, 15);
                fram1.add(lp2);
    
       JLabel lp3 = new JLabel();
                lp3.setBounds(70, 270, 400,15);
                fram1.add(lp3);        
       
                



                ActionListener click2 = new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                    String name1=text2.getText();
                    String email1=text3.getText();
                    String password1=text4.getText();
                    

                   try {
                    FileWriter wr = new FileWriter("Login.text",true);
                    File obj =new File("Login.text");
                    Scanner read = new Scanner(obj);
                    int i=0;

                    while(read.hasNextLine()){
                        if(read.nextLine().contains(email1)){
                         i++;
                        }
                        }
                        if(i==1){ 
                            lp2.setText("EMAIL IS ALLREADY EXISTS");
                             lp3.setText("");}
                        else{
                            if((!name1.isEmpty())&&(email1.contains("@gmail.com")) &&(password1.length()>=5))
                            {
                            wr.write(name1+" "+email1+" "+password1+"\n");
                            lp3.setText("name: "+name1+" email: "+email1+" password: "+password1);
                            lp2.setText("mail seccessfully registered");
                           }else{
                            lp2.setText("wrong entery");
                            lp3.setText("");
                           }
                        }
                 
                  
                  wr.close();
                   } catch (Exception ex) {
                    System.out.println(e);
                   } 
                    


                    }
                };    
                button2.addActionListener(click2);
                fram1.setVisible(true);
            }
            
          };
    
          button1.addActionListener(click1);  
    
    }



    public static void main(String[] args) {
        Login lo = new Login();
       
       lo.log();

    }
}  

