import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Tclient{
    public static void main(String[] args) throws Exception {
        Socket s = new Socket(args[0], 4321);
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        Scanner sc = new Scanner(System.in);

        Thread reader = new Thread(new Runnable() {
            String inl;
            @Override
            public void run(){
                try{
                    while((inl = in.readLine()) != null){
                        if(inl.equals("EXIT")) break;
                        System.out.println(inl);
                    }
                    sc.close();
                    in.close();
                    s.close();
                } catch(Exception e){};
            }
        });
        reader.start();

        Thread sender = new Thread(new Runnable() {
            String outl;
            @Override
            public void run(){
                try{
                    while(true){
                        outl = sc.nextLine();
                        if(outl.equals("EXIT")) break;
                        out.println(outl);
                    }
                    out.close();
                }catch(Exception e){}
            }
        });
        sender.start();

       
    }
}