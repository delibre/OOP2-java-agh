import java.net.*;
import java.util.Scanner;
import java.io.*;

public class Server{
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(4321);
        Socket cs = ss.accept();
        PrintWriter out = new PrintWriter(cs.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
        Scanner sc = new Scanner(System.in);

        Thread reader = new Thread(new Runnable() {
            String inl;
            @Override
            public void run(){
                try{
                    while((inl = in.readLine()) != null){
                        if(inl.equals("EXIT")) break;
                        System.out.println("["+cs.getInetAddress() + ":"  + cs.getPort() + "] " + inl);
                    }
                    in.close();
                    cs.close();
                    ss.close();
                    sc.close();
                } catch(Exception e){};
            }
        });
        reader.start();

        Thread sender = new Thread(new Runnable() {
            String outl;
            @Override
            public void run(){
                try{
                    out.println(">>>NEW USER " + cs.getInetAddress() + ":"  + cs.getPort());
                    System.out.println(">>>NEW USER " + cs.getInetAddress() + ":"  + cs.getPort());
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