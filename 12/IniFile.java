import java.util.ArrayList;
import java.util.*;
import java.nio.file.*;

public class IniFile{
    ArrayList<Section> sections = new ArrayList<>();
    String filename;
    IniFile(String filename){
        this.filename = filename;
        Path path = Paths.get(filename);
        try{
            Scanner s = new Scanner(path);
            while(s.hasNextLine()){
                String sec_name = "";
                String sec_text = "";     
                String line = s.nextLine();
                if(!line.equals("")){
                    if(line.charAt(0) == '['){
                        sec_name = line;
                    }
                    else{
                        sec_name = "[unnamed]";
                        sec_text = line;
                    }
                    while(s.hasNextLine()){
                        line = s.nextLine();
                        if(line.equals("")) break;
                        else{
                            sec_text += line;
                            sec_text += "\n";
                        }
                    }
                }
                if(!sec_text.equals("")) sections.add(new Section(sec_name, sec_text));
            }
        }
        catch(Exception e){
            System.out.println("Blad");
        }
    }
    public String toString(){
        Path path = Paths.get(filename);
        String text = "";
        try{
            Scanner s = new Scanner(path);
            while(s.hasNextLine()){
                text += s.nextLine();
                text += "\n";
            }
        }
        catch(Exception e){
            System.out.println("Blad");
        }
        return text;
    }
    Section[] getSections(){
        Section[] arr = new Section[sections.size()];
        for(int i = 0 ; i < sections.size() ; i++){
            arr[i] = sections.get(i);
        }
        return arr;
    }
    Section getSection(String name) throws NoSuchIniSectionException{
        Section res = null;
        for(Section el: sections){
            if(el.name.equals("["+name+"]")){
                res = el;
                break;
            }
        }
        if(res == null) throw new NoSuchIniSectionException();
        return res;
    }
    public static void main(String[] args){
        IniFile file = new IniFile("file.ini");
        try{
            Section e1 = file.getSection("unnamed");
            System.out.println(e1);
            Section e = file.getSection("Earth");
            Section e2 = file.getSections()[0];
            System.out.println(e2);
            System.out.println(e.getComments()[0]);
            System.out.println(e.getComments()[1]);
            System.out.println(e.getParameter("mass"));
            System.out.println(e.getParameters()[0].getKey());
            System.out.println(e.getParameters()[0].getValue());
        }
        catch(Exception e){}
    }
    
}