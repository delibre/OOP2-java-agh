import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    static ArrayList<Contact> arr = new ArrayList<>();

    static void showMenu(){
        System.out.println("1) nowy kontakt\n2) wypisz kontakty\n3) wyjdz\n4) eksport listy\n5) import list\n");
    }

    static void showSubMenu(){
        System.out.println("1) szczegoly\n2) usun kontakt\n3) powrot\n");
    }
    public static void main(String args[]){

        try{
            ObjectInputStream i = new ObjectInputStream(new FileInputStream(("contacts.data")));
            arr = (ArrayList<Contact>) i.readObject();
            i.close();
        } catch(FileNotFoundException e) {System.out.println("Nie wczytano danych - brak pliku.");}
        catch(Exception e){System.out.println("BLAD: " + e);}

        Console c = System.console();
        boolean stop = false;
        while(!stop){
            showMenu();
            String option = c.readLine("Wybierz opcje: ");
            switch(option){
                case "1":
                    String c_name = c.readLine("Nazwa: ");
                    String c_number = c.readLine("Numer: ");
                    String c_email = c.readLine("Email: ");
                    Contact temp = new Contact(c_name, c_number, c_email);
                    arr.add(temp);
                break;
                case "2":
                    Collections.sort(arr);
                    for(int i = 0 ; i < arr.size() ; i ++){
                        System.out.println(i + ": " + arr.get(i));
                    }
                
                    showSubMenu();
                    String sub_option = c.readLine("Wybierz opcje: ");
                    switch(sub_option){
                        case "1": 
                            int index1 = Integer.parseInt(c.readLine("Indeks kontaktu:"));
                            Contact tmp = arr.get(index1);
                            System.out.println("Numer: "+tmp.number);
                            System.out.println("Email: "+tmp.email);
                        break;
                        case "2":
                            int index2 = Integer.parseInt(c.readLine("Indeks kontaktu:"));
                            if(index2 >= 0 && index2 < arr.size()) arr.remove(index2);
                            break;
                        case "3":
                            break;
                    }
                break;
                case "3":
                    if(new File("contacts.data").exists()){
                        try{
                            ObjectInputStream i = new ObjectInputStream(new FileInputStream(("contacts.data")));
                            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(("contacts.data.bak")));
                            o.writeObject(i.readObject()); 
                            i.close();
                            o.close();   
                        } catch(Exception e){System.out.println("BLAD PRZY KOPII: " + e);}
                    }
                    try{
                        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(("contacts.data")));
                        o.writeObject(arr);
                        o.close();
                    } catch (Exception e){System.out.println("BLAD PRZY ZAPISIE: " + e);}
                    
                    stop = true;
                break;
                case "4":
                    try{
                        String fname = c.readLine("Podaj nazwe pliku: ");
                        FileWriter fw = new FileWriter(fname);
                        for(Contact tmp: arr){
                            fw.write(tmp.name + "," + tmp.number + "," + tmp.email + ";");
                        }
                        fw.close();
                    }catch(Exception e){System.out.println("BLAD " + e);}
                break;
                case "5":
                    try{
                        String fname = c.readLine("Podaj nazwe pliku: ");
                        Path p = Paths.get(fname);
                        Scanner s = new Scanner(p); 
                        s.useDelimiter(";");
                        while(s.hasNext()){
                            String c_text = s.next();
                            String c_arr[] = c_text.split(",");
                            Contact tmp = new Contact(c_arr[0], c_arr[1], c_arr[2]);
                            arr.add(tmp);
                        }

                    } catch(Exception e){System.out.println("BLAD IMPORTU" + e);}
                break;
            }
        }
    }
}
