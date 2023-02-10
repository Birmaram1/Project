import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class NotesGui {
    public static void main(String[] args) {
        JFrame fram = new JFrame("notes");
        fram.getContentPane().setBackground(Color.lightGray);
        fram.setSize(400,550);
        fram.setLayout(null);

        JLabel label = new JLabel("File Name:-");
        label.setBounds(05,20,100,20);
        fram.add(label);
        JTextField filename = new JTextField();
        filename.setBounds(05,45,375,30);
        fram.add(filename);
        JLabel label1 = new JLabel("Heading:-");
        label1.setBounds(05,80,100,20);
        fram.add(label1);
        JTextField heading = new JTextField();
        heading.setBounds(05,105,375,30);
        fram.add(heading);
        JTextArea notes = new JTextArea();
        notes.setBounds(05,150,375,230);
        fram.add(notes);
        JButton button = new JButton("Submit");
        button.setBounds(20,390,90,25);
        fram.add(button);
        JLabel label2 = new JLabel("");
        label2.setBounds(10,445,200,20);
        fram.add(label2);

        ActionListener click = new ActionListener(){
            public void actionPerformed(ActionEvent e){
                try {
                    
                    if(!filename.getText().isEmpty()){
                        File file = new File(filename.getText()+".txt");
                         FileWriter wr = new FileWriter(file,true);
                         wr.write(heading.getText()+":-\n"+notes.getText());
                         wr.close();
                         label2.setForeground(Color.green);
                         label2.setText("data secsessfully saved");
                    }
                    else{
                        label2.setForeground(Color.red);
                        label2.setText("Please enter file name");
                    }
                } catch (Exception ep) {
                     System.out.println(ep);
                }
            }
        };
        button.addActionListener(click);


        fram.setVisible(true);
    }
    
}
