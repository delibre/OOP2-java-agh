import java.net.*;
import java.util.ArrayList;
import java.util.Scanner;


import java.io.*;

public class Tserver{
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(4321);
        ArrayList<Socket> clients = new ArrayList<>();

        Thread add_client = new Thread(new Runnable() {
        
            @Override
            public void run(){
                while(true){
                try{
                Socket cs = ss.accept();
                clients.add(cs);
                for(Socket soc : clients){
                    PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
                    out.println(">>>NEW USER " + soc.getInetAddress() + ":"  + soc.getPort());
                    System.out.println(">>>NEW USER " + soc.getInetAddress() + ":"  + soc.getPort());
                }
                Thread reader = new Thread(new Runnable() {
                    BufferedReader in = new BufferedReader(new InputStreamReader(cs.getInputStream()));
                    Scanner sc = new Scanner(System.in);
                        String inl;
                        @Override
                        public void run(){
                            try{
                                while((inl = in.readLine()) != null){
                                    if(inl.equals("EXIT")) break;
                                    System.out.println("["+cs.getInetAddress() + ":"  + cs.getPort() + "] " + inl);
                                    for(Socket soc : clients){
                                        PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
                                        out.println("["+soc.getInetAddress() + ":"  + cs.getPort() + "] " + inl);
                                    }
                                }
                                in.close();
                                cs.close();
                                ss.close();
                                sc.close();
                            } catch(Exception e){};
                        }
                    });
                    reader.start();
            
                    // Thread sender = new Thread(new Runnable() {
                        
                    //     Scanner sc = new Scanner(System.in);
                    //     String outl;
                    //     @Override
                    //     public void run(){
                    //         for(Socket soc : clients){
                    //         try{
                    //             PrintWriter out = new PrintWriter(soc.getOutputStream(), true);
                    //             out.println(">>>NEW USER " + soc.getInetAddress() + ":"  + soc.getLocalPort());
                    //             System.out.println(">>>NEW USER " + soc.getInetAddress() + ":"  + soc.getLocalPort());
                    //             while(true){
                    //                 outl = sc.nextLine();
                    //                 if(outl.equals("EXIT")) break;
                    //                 out.println(outl);
                    //             }
                    //             out.close();
                    //             sc.close();
                    //         }catch(Exception e){}
                    //     }
                    //     }
                    // });
                    // sender.start();
          

                }catch(Exception e){}
            }
        }
        });
        add_client.start();
    
    }
}