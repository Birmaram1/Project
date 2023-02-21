
import org.json.simple.parser.JSONParser;
import org.json.simple.*;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Quiz implements ActionListener {
    JRadioButton r1,r2,r3,r4;
     static JFrame fram;
      
     static JLabel label;
     static JLabel rightAnswer;
     static ButtonGroup bg;
     static JButton button,submit,goBack;
     static JSONParser par;
     static JSONArray arr1,option;
     static JSONObject ob;

    static int i=0,correct1=0,wrong1=0,a=0;
    
    Quiz(){ 
        try {  
             par = new JSONParser();
              arr1=(JSONArray)par.parse(new FileReader("Quis.json"));
             ob=(JSONObject)arr1.get(0);
           //System.out.println(ob.get("Q"));
             option=(JSONArray)ob.get("option");
          // System.out.println(option.get(0));
     
           fram = new JFrame("test quiz");
           fram.setSize(600,400);

           fram.setLayout(null);
           
             label = new JLabel("Quiz:- "+ob.get("Q"));
            label.setBounds(20,60,550,20);
            label.setForeground(Color.red);
            fram.add(label);
    
              r1=new JRadioButton(option.get(0).toString());
               r2=new JRadioButton(option.get(1).toString());
               r3=new JRadioButton(option.get(2).toString());
               r4=new JRadioButton(option.get(3).toString());
               
            r1.setBounds(30,90,200,20);
            r2.setBounds(30,115,200,20);
            r3.setBounds(30,140,200,20);
            r4.setBounds(30,165,200,20);
             bg = new ButtonGroup();
            bg.add(r1);bg.add(r2); bg.add(r3); bg.add(r4);
            fram.add(r1);
            fram.add(r2);
            fram.add(r3);
            fram.add(r4);
            r1.addActionListener(this);
            r2.addActionListener(this);
            r3.addActionListener(this);
            r4.addActionListener(this);
    
             button = new JButton("next");
             button.setBounds(200,200,60,20);
             fram.add(button);
            submit = new JButton("Submit");
            submit.setBounds(50,200,80,20);
            submit.setBackground(Color.green);
            fram.add(submit);
            button.addActionListener(this);
            submit.addActionListener(this);
             rightAnswer = new JLabel();
            rightAnswer.setBounds(20,270,400,20);
            fram.add(rightAnswer);
    
            fram.setVisible(true);
    
            
            
        } catch (Exception ep) {
            System.out.println(ep);
        }
    }
        public static void main(String[] args) {
       
          new Quiz();
          
         
        }
        
          public void actionPerformed(ActionEvent e){
           
            if(e.getSource()==button){
                a=0;
                i++;
                if(i<arr1.size()){ob=(JSONObject)arr1.get(i);
                    label.setText("Quiz:- "+ob.get("Q"));
                    
                    option=(JSONArray)ob.get("option");
                    r1.setText(option.get(0).toString());
                    r2.setText(option.get(1).toString());
                    r3.setText(option.get(2).toString());
                    r4.setText(option.get(3).toString());
                    bg.clearSelection();
                    rightAnswer.setText("");
                }
                else{ 
                            JFrame fram = new JFrame("result page");
                            fram.setSize(600,400);
                            fram.setLayout(null);
                            JLabel question = new JLabel("Total Quiz Is:-   "+arr1.size());
                            question.setBounds(100,100,300,20);
                            fram.add(question);
                            JLabel correct= new JLabel("Corrrect Answer Is:-   "+correct1);
                            correct.setBounds(100,120,300,20);
                            fram.add(correct);
                            JLabel wrong= new JLabel("Wrong Answer Is:-   "+wrong1);
                            wrong.setBounds(100,140,300,20);
                            fram.add(wrong);
                            JLabel skeep= new JLabel("Skeep Quiz Is:-   "+(arr1.size()-(correct1+wrong1)));
                            skeep.setBounds(100,160,300,20);
                            fram.add(skeep);
                            goBack=new JButton("GO_Back");
                            goBack.setBounds(170,190,100,20);
                             fram.add(goBack);
                             goBack.addActionListener(this);
                            i=-1;
                            correct1=0;
                            wrong1=0;
                            fram.setVisible(true);                           
                    }          
            }
           
            if(e.getSource()==submit){
                a++;
                String answer="";
                if(r1.isSelected()){
                    answer=r1.getText();
                }
                if(r2.isSelected()){
                    answer=r2.getText();
                }
                if(r3.isSelected()){
                    answer=r3.getText();
                }
                if(r4.isSelected()){
                    answer=r4.getText();
                }
                 
                if(bg.isSelected(null)); 

               else if((option.get(4).toString()).equals(answer)){
                   if(a==1) {correct1++;}
                    rightAnswer.setText(" Congratulation! Your Answer Is Correct");
                    rightAnswer.setForeground(Color.blue);
                     
                }
                else{   if(a==1){wrong1++;}
                    rightAnswer.setText("Answer Is Wrong & Correct Answer Is:-   "+option.get(4));
                    rightAnswer.setForeground(Color.red);
                }

            }

           if(e.getSource()==goBack){ new Quiz();
            correct1=0;
            wrong1=0;}
        }

    }

        
   
  
 
       
    


