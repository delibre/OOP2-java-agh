import java.io.*;
import java.util.*;;

public class Main{

    public static void main(String args[]){
        String filename = args[0];
               
        ArrayList<String> line_list = new ArrayList<String>();
        ArrayList<String> word_list = new ArrayList<String>();

        try{
            BufferedReader f = new BufferedReader(new FileReader(filename));
            String s, p3, p2, p1;
            p3 = p2 = p1 = "";
            for(int i = 0 ; i < 3 ; i ++){
                s = f.readLine();
                System.out.println(s);
            }
            while((s = f.readLine()) != null){
                p3 = p2; p2 = p1; p1 = s;
            };
            System.out.println(p3);
            System.out.println(p2);
            System.out.println(p1);
            f.close();

            f = new BufferedReader(new FileReader(filename));
            while((s = f.readLine()) != null){
                if(s.length() > 0){
                    line_list.add(s);
                }
            }
            f.close();
        }
        catch (Throwable e){
            System.out.println("Blad odczytu");
        }

        System.out.println("Liczba linii: " + line_list.size());
        
        int[] w_count = new int[line_list.size()];
        for (int i = 0 ; i < line_list.size(); i++){
            String s = line_list.get(i);
            String[] words = s.split(" |,");
            
            int count = 0;
            for (String word : words) {
                if (word != ""){
                    word_list.add(word);
                    count ++;
                }
            }   
            w_count[i] = count;
        }
        double av = 0;
        for (int i = 0 ; i < line_list.size() ; i ++){
            av += w_count[i];
        }
        av /= line_list.size();

        System.out.println("Liczba slow: " + word_list.size());
        System.out.println("Srednia: " + av);

        // int words_count[] = new int[word_list.size()];
        // for(int i = 0 ; i < word_list.size() ; i++){
        //     for (int j = i; j < word_list.size() ; j++){
        //         if(word_list.get(i).equals(word_list.get(j))){
        //            words_count[i] ++; 
        //         }
        //     }
        // }        

        Console c = System.console();
        String s = c.readLine("Prosze podac liczbe slow: ");
        int n = Integer.parseInt(s);
        System.out.println("Wypisuje " + n + " slow");

        // String[] sorted = new String[word_list.size()];
        // Arrays.sort(sorted);    
        // System.out.print(Arrays.toString(sorted));

    }

    
}


