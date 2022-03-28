

class Obywatel{
    private String pesel;
    private String imie;
    private String nazwisko;
    private static int liczba = 0;

    public Obywatel(String pesel, String imie, String nazwisko){
        this.pesel = pesel;
        this.imie = imie;
        this.nazwisko = nazwisko;
        liczba++;
    }

    public static int ile(){
        return liczba;
    }
    
    public String getPesel(){
        return pesel;
    }

    public String getImie(){
        return imie;
    }

    public String getNazwisko(){
        return nazwisko;
    }

    public void print(int spaces){
        for(int i = 0 ; i < spaces ; i++){
            System.out.print(" ");
        }
        System.out.print(pesel + " " + imie + " " + nazwisko + "\n");
    }
    
}

class Node{
    private Obywatel current = null;
    private Node left = null;
    private Node right = null;

    public Node(Obywatel o){
        current = o;
    }

    public void dodaj(Obywatel o){
        if(current.getPesel().compareTo(o.getPesel()) < 0){
            if(left != null){
                left.dodaj(o);
            }
            else{
                left = new Node(o);
            }
        }
        else{
            if(right != null){
                right.dodaj(o);
            }
            else{
                right = new Node(o);
            }
        }
    }

    public Obywatel wyszukajPesel(String wartosc){
        if(current == null || current.getPesel() == wartosc){
            return current;
        }
        else if(wartosc.compareTo(current.getPesel()) < 0){
            if (left != null)
                return left.wyszukajPesel(wartosc);      
        }
        else{
            if(right != null)
                return right.wyszukajPesel(wartosc);
        }
        return null;
    }

    public Obywatel wyszukajImie(String wartosc){
        return null;
    }

    public Obywatel wyszukajNazwisko(String wartosc){
        return null;
    }


    public void wypisz(int spaces){
        current.print(spaces);
        if (right != null){
            right.wypisz(spaces+1);
        }
        if (left != null){
            left.wypisz(spaces);
        }
    }
}

class BazaLudnosci{
    Node root;

    public void dodaj(Obywatel o){
        if(root == null){
            root = new Node(o);
        }
        else root.dodaj(o);
    }

    public Obywatel wyszukaj(String klucz, String wartosc){
        Obywatel ob = null;
        if (root == null)
            return null;
        switch(klucz){
            case "PESEL": ob = root.wyszukajPesel(wartosc); break;
            case "IMIE": ob = root.wyszukajImie(wartosc); break;
            case "NAZWISKO": ob = root.wyszukajNazwisko(wartosc); break;
        }
        return ob;
    }

    public void draw(){
        if(root != null){
            root.wypisz(0);
        }
    }

}

public class Main{
    public static void main(String args[]){;
        Obywatel ob1 = new Obywatel("00000000003", "Anna", "Nowak");
        Obywatel ob2 = new Obywatel("00000000001", "Piotr", "Nowak");
        Obywatel ob3 = new Obywatel("00000000002", "Anna", "Nowak");

        BazaLudnosci baza = new BazaLudnosci();
        baza.dodaj(ob1);
        baza.dodaj(ob2);
        baza.dodaj(ob3);
        baza.draw();
        Obywatel test = baza.wyszukaj("PESEL", "00000000001");
        if (test != null){
            System.out.println("Znaleziono:");
            test.print(0);
        }
        else{
            System.out.println("Nie znaleziono");
        }

    }
}
