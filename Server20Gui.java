
    import java.io.File;
    import java.io.FileWriter;
    import java.io.PrintStream;
    import java.net.ServerSocket;
    import java.net.Socket;
    import java.util.Random;
    import java.util.Scanner;
    
    public class Server20Gui {
        public static void main(String[] args) {
            try {
                ServerSocket ss = new ServerSocket(640);
                System.out.println("server is running.....");
                File obj = new File("password.txt");
                obj.createNewFile();
                while(true){
                Socket s= ss.accept();
                Scanner sc = new Scanner(s.getInputStream());
                PrintStream ps = new PrintStream(s.getOutputStream());
                
                Random rand = new Random();
                while(true){
            
                   
                    String  name = sc.nextLine();
                   
                    String email = sc.nextLine();
                    if(!email.contains("@gmail.com")){
                        ps.println("Please fill correct email");
                        continue;
                    }
                   
                    Scanner read = new Scanner(obj);
                    int i = 0;
                    while(read.hasNextLine()){
                       
                        if(read.nextLine().contains(email)){
                        String str =    "mail is already exists";
                        ps.println(str);
                        i=1;
                        }   
                    }
                    if(i==1){break;}
                   else{
                    int pwd =rand.nextInt(5000,100000);
                    ps.println("your account successfull and password is: "+pwd);
                    FileWriter wr = new FileWriter("password.txt",true);
                    wr.write(name+" "+email+" "+pwd+"\n");
                    wr.close();
                 }
               }  
               s.close();
            }
            
         } catch (Exception e) {
                // TODO: handle exception
            }
        }
        
    }
    
