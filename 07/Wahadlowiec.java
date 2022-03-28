public class Wahadlowiec implements PojazdKosmiczny, Jezdzi{
    String name;

    Wahadlowiec(String n){
        name = n;
    }
    public String toString(){
        return "Wahadlowiec " + name;
    }
    public void ustawCiag(int i){};
    public void startuj(){};
    public void skrecKola(){};
}
