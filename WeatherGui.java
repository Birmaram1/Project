import java.util.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
 

import org.json.*;
import java.net.*;
import org.json.simple.*;
import java.io.*;
import org.json.simple.parser.JSONParser;
import java.awt.event.*;
public class WeatherGui {

    void weather(){
        
            JFrame fram = new JFrame("Weather");
            fram.setSize(400,400);
            fram.setLayout(null);

            JLabel label1 = new JLabel("Enter city name");
            label1.setBounds(50,30,150,30);
            fram.add(label1);
            
            JTextField textField = new JTextField();
            textField.setBounds(50,65,200,30);
            fram.add(textField);

            JButton button = new JButton("GET WEATHER REPORT");
            button.setBounds(50,150,200,25);
            fram.add(button);

            JLabel label2 = new JLabel();
            label2.setBounds(10,180,380,20);
            fram.add(label2);
            JLabel label3 = new JLabel();
            label3.setBounds(10,230,380,20);
            fram.add(label3);
           

            JLabel label4 = new JLabel();
            label4.setBounds(10,270,380,20);
            fram.add(label4);
            JLabel label5 = new JLabel();
            label5.setBounds(10,290,380,20);
            fram.add(label5);
            
            ActionListener click = new ActionListener(){
               public void actionPerformed(ActionEvent e){
                  try {
                    
                   String city=textField.getText();
                   
                    
                    URL url = new URL("http://api.openweathermap.org/geo/1.0/direct?q="+city+",IN&limit=1&appid=91c43fa9323152d56151041df9dba603");
                    HttpURLConnection htt =  (HttpURLConnection) url.openConnection(); 
              htt.setRequestMethod("GET");
              InputStreamReader in = new InputStreamReader(htt.getInputStream());
              
               Scanner bf=new Scanner(in);
               double lon, lat;
            
                String st ="";
              while(bf.hasNextLine()){
                st = bf.nextLine(); 
            }
            //System.out.println(st);
            bf.close();
            JSONParser par=new JSONParser();
            JSONArray arr=(JSONArray) par.parse(st);
            JSONObject obj=(JSONObject)arr.get(0);
 
                //System.out.println(obj.get("lon")); 
               // System.out.println(obj.get("lat"));
                 lon=(Double) obj.get("lon");
                 lat=(double)obj.get("lat"); 
                
                label2.setText(String.valueOf("longigute : "+lon+" & latitude : "+lat+","));
                label3.setText("Weather Report:-");

                URL uuu = new URL("https://api.openweathermap.org/data/2.5/weather?lat="+lat+"&lon="+lon+"&appid=91c43fa9323152d56151041df9dba603");
          HttpURLConnection up =  (HttpURLConnection) uuu.openConnection(); 

          Scanner sc5 = new Scanner(up.getInputStream()); 
          String str1 ="";
          while(sc5.hasNextLine()){
            str1+=sc5.nextLine();
           
          }
         // System.out.println(str1); 
         sc5.close();

         JSONParser par1=new JSONParser();
         JSONObject ob = (JSONObject)par1.parse(str1);
         JSONObject ob1=(JSONObject)ob.get("main");
          
         JSONArray arr1= (JSONArray)ob.get("weather");
         JSONObject ob2= (JSONObject)arr1.get(0);
       //  System.out.println(ob2.get("description"));
     
         double temp = (Double) ob1.get("temp")-273;
          

         
         label4.setText(String.valueOf("temp: "+String.format("%.0f",temp)+", humidity : "+(ob1.get("humidity"))+","));
         label5.setText(String.valueOf("pressure : "+(ob1.get("pressure"))+", sky : "+(ob2.get("description"))));
         
                  } catch (Exception ep) {
                    System.out.println(e);
                  } 
               
               }

            };
            button.addActionListener(click);
           
            textField.setText("");
    fram.setVisible(true);
    
    }
    public static void main(String[] args) {
        WeatherGui wr=new WeatherGui();
        wr.weather();

    }
    
}
