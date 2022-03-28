import java.util.ArrayList;
import java.util.Scanner;

public class Section {
    String name = "";
    String text = "";
    ArrayList<String> comments = new ArrayList<>();
    ArrayList<Parameter> parameters = new ArrayList<>();
    Section(String name, String text){
        this.name = name;
        this.text = text;
        Scanner s = new Scanner(text);
        while(s.hasNextLine()){
            String line = s.nextLine();
            if(line.charAt(0) == ';'){
                comments.add(line);
            }
            else{
                Parameter par = new Parameter();
                String[] arr = line.split("=");
                par.key = arr[0].trim();
                par.value = arr[1].trim();
                parameters.add(par);
            }
        }
    }
    public String toString(){
        return "Name: " + name + "\n" + "Text:\n" + text;
    }
    String getName(){
        return name;
    }
    String[] getComments(){
        String[] arr = new String[comments.size()];
        for(int i = 0 ; i < comments.size() ; i++){
            arr[i] = comments.get(i);
        }
        return arr;
    }
    Parameter[] getParameters(){
        Parameter[] arr = new Parameter[parameters.size()];
        for(int i = 0 ; i < comments.size() ; i++){
            arr[i] = parameters.get(i);
        }
        return arr;
    }
    Parameter getParameter(String name) throws NoSuchIniParameterException{
        Parameter res = null;
        for(Parameter el: parameters){
            if(el.key.equals(name)){
                res = el;
                break;
            }
        }
        if(res == null) throw new NoSuchIniParameterException();
        return res;
    }

}
