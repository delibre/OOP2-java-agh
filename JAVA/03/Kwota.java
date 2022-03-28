
/**
 * Klasa przechowujaca ilosc pieniedzy
 */
public class Kwota {
    /**Prywatne pole - kwota w groszach */
    private int gr;
    /**
     * Konstruktor dwuparametrowy
     * @param zl ilosc zlotych
     * @param gr ilsoc groszy
     */
    public Kwota(int zl, int gr)
    {
        this.gr = 100*zl + gr;
    }
    static public Kwota dodaj(Kwota k1, Kwota k2)
    {
        int gr = k1.gr + k2.gr;
        Kwota k = new Kwota(gr/100, gr%100);
        return k;
    } 
    /**
     * Statyczna metoda odejmujaca kwoty
     * @param k1 pierwsza kwota
     * @param k2 druga kwota
     * @return roznica kwot
     */
    static public Kwota odejmij(Kwota k1, Kwota k2)
    {
        int gr = k1.gr - k2.gr;
        Kwota k = new Kwota(gr/100, gr%100);
        return k;
    }
    /**
     * Metoda pozwalajaca na zmiane kwoty
     * @param zl ilosc zlotych
     * @param gr ilosc groszy
     */
    public void set(int zl, int gr)
    {
        this.gr = 100*zl + gr;
    }
    /**
     * Metoda pomocnicza pozwalajaca na uzyskanie kwoty
     * @return ilosc pieniedzy w groszach
     */
    public int get()
    {
        return gr;
    }
    /** Metoda pozwalajaca na wypisanie Kwoty w odpowiednim formacie */
    public String toString()
    {
        return gr/100 + "zl " + gr%100 + "gr"; 
    }

}
