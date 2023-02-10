//================currency converter=========
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.text.DecimalFormat;

public class CurrencyConveerter {
   static double d;
  
    public static void main(String[] args) {
        JFrame fram = new JFrame("currency converter");
        fram.setSize(400,400);
        fram.setLayout(null);

        String currency[]={"INR","USD","EURO","YEN"};
        JComboBox comboBox1 = new JComboBox<>(currency);
        comboBox1.setBounds(50,50,100, 20);
        fram.add(comboBox1);

        JComboBox comboBox2 = new JComboBox<>(currency);
        comboBox2.setBounds(50,150,100,20);
        fram.add(comboBox2);

        JTextField textField1 = new JTextField();
        textField1.setBounds(200,50,100,20);
        fram.add(textField1);

        JTextField textField2 = new JTextField();
        textField2.setBounds(200,150,100,20);
        fram.add(textField2);

        JButton button = new JButton("convert");
        button.setBounds(150,250,80,30);
        fram.add(button);

      ActionListener click = new ActionListener(){
        public void actionPerformed(ActionEvent e){
            
           if (comboBox1.getSelectedIndex()==0){
               
              if(comboBox2.getSelectedIndex()==0){ 
                     textField2.setText(textField1.getText());
               }
              else if(comboBox2.getSelectedIndex()==1){
                    d=Double.parseDouble(textField1.getText());
                    d/=80;
                     
                     textField2.setText(String.valueOf(String.format("%.3f",d)));
               }
              else if(comboBox2.getSelectedIndex()==2){
                    d=Double.parseDouble(textField1.getText());
                    d/=88;
                    textField2.setText(String.valueOf(String.format("%.3f",d)));
               }
              else if(comboBox2.getSelectedIndex()==3){
                    d=Double.parseDouble(textField1.getText());
                    d*=1.5;           
                    textField2.setText(String.valueOf(String.format("%.3f",d)));
               }
           }
           
         else if(comboBox1.getSelectedIndex()==1){

              if(comboBox2.getSelectedIndex()==0){
                    d=Double.parseDouble(textField1.getText());
                    d*=80;
                    textField2.setText(String.valueOf(String.format("%.3f",d)));
               }
              else if(comboBox2.getSelectedIndex()==1){      
                    textField2.setText(textField1.getText());
               }
              else if(comboBox2.getSelectedIndex()==2){
                    d=Double.parseDouble(textField1.getText());
                    d/=1.08;        
                    textField2.setText(String.valueOf(String.format("%.3f",d)));
               }
              else if(comboBox2.getSelectedIndex()==3){
                    d=Double.parseDouble(textField1.getText());
                    d*=130;        
                    textField2.setText(String.valueOf(String.format("%.3f",d)));
               }
           }

         else if(comboBox1.getSelectedIndex()==2){

              if(comboBox2.getSelectedIndex()==0){
                    d=Double.parseDouble(textField1.getText());
                    d*=88;        
                    textField2.setText(String.valueOf(String.format("%.3f",d)));
               }
              else if(comboBox2.getSelectedIndex()==1){
                    d=Double.parseDouble(textField1.getText());
                    d*=1.08;     
                    textField2.setText(String.valueOf(String.format("%.3f",d)));
               }
              else if(comboBox2.getSelectedIndex()==2){
                    textField2.setText(textField1.getText());
               }
              else if(comboBox2.getSelectedIndex()==3){
                    d=Double.parseDouble(textField1.getText());
                    d*=141;   
                    textField2.setText(String.valueOf(String.format("%.3f",d)));
               }
           }
         else if(comboBox1.getSelectedIndex()==3){

              if(comboBox2.getSelectedIndex()==0){
                    d=Double.parseDouble(textField1.getText());
                    d/=1.5;        
                    textField2.setText(String.valueOf(String.format("%.3f",d)));
               }
              else if(comboBox2.getSelectedIndex()==1){
                    d=Double.parseDouble(textField1.getText());
                    d/=130;
                    textField2.setText(String.valueOf(String.format("%.3f",d)));
               }
              else if(comboBox2.getSelectedIndex()==2){
                    d=Double.parseDouble(textField1.getText());
                    d/=141;
                    textField2.setText(String.valueOf(String.format("%.3f",d)));
               }
              else if(comboBox2.getSelectedIndex()==3){
                    textField2.setText(textField1.getText());
               }
           }

         }
      };
      button.addActionListener(click);

        fram.setVisible(true);
    }
}
