/**
 * Klasa przechowujaca informacje o koncie
 */
public class Konto {
    /** Zmienna tekstowa przechowujaca numer konta */
    String id;
    /** Zmienna przhowujaca kwote */
    Kwota k;
    /** Zmienna pozwalajaca na stworzenie listy, przechowujaca referencje do kolejnego konta */
    Konto next = null;
    /**
     * Konstruktor dwuelementowy
     * @param id numer konta
     * @param k kwota na koncie
     */
    public Konto(String id, Kwota k)
    {
        this.id = id;
        this.k = new Kwota(0, k.get());
    }
    /**
     * Metoda pozwalajaca na zmiane stanu konta
     */
    public void setStan(Kwota k)
    {
        this.k.set(0, k.get());
    }
    /**
     * Metoda pozwalajaca na uzyskanie stanu konta
     * @return stan konta w postaci obiektu Kwota
     */
    public Kwota getStan()
    {
        Kwota temp = new Kwota(0, k.get());
        return temp;
    }
    /** Metoda pozwalajaca na wypisanie Konta w odpowiednim formacie */
    public String toString()
    {
        return "[" + id + "] " + k; 
    }
}
