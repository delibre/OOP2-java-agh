import java.io.Serializable;

public class Contact implements Comparable<Contact>, Serializable{
    String name;
    String number;
    String email;
    Contact(String name, String number, String email){
        this.name = name;
        this.number = number;
        this.email = email;
    }
    @Override
    public int compareTo(Contact o) {
        return name.compareTo(o.name);
    }
    @Override
    public String toString(){
        return name;
    }
    
}