/**
 * Klasa reprezentujaca bank, przehowujaca liste kont
 */
public class Bank {
    /** Zmienna przechowujaca referencje pierwszego konta na liscie */
    Konto first = null;
    /**
     * Metoda pomocnicza zwracajaca referencje do konta o okreslonym id
     * @param id numer konta
     * @return znalezione konto
     */
    public Konto znajdzKonto(String id)
    {
        Konto temp = first;
        while(temp != null){
            if(temp.id.equals(id)) return temp;
            else temp = temp.next;
        }
        return null;
    }
    /**
     * Metoda pozwalajaca na stworzenie nowego konta w banku
     * @param id id konta
     */
    public void utworzKonto(String id)
    {
        if(first == null){
            first = new Konto(id, new Kwota(0,0));
        }
        else{
            Konto temp = first;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = new Konto(id, new Kwota(0,0));
        }
    }
    /**
     * Metoda pozwalajaca na wplate okreslonej kwoty na konto
     * @param id id konta
     * @param k wplacana kwota
     */
    public void wplataNaKonto(String id, Kwota k)
    {
        Konto temp = znajdzKonto(id);
        temp.setStan(Kwota.dodaj(temp.getStan(), k));
    }
    /**
     * Metoda pozwalajaca na wyplate okreslonej kwoty na konto
     * @param id id konta
     * @param k wyplacana kwota
     */
    public void wyplataZKonta(String id, Kwota k)
    {
        Konto temp = znajdzKonto(id);
        temp.setStan(Kwota.odejmij(temp.getStan(), k));
    }
    /**
     * Metoda zwracajaca stan konta o okreslonym id
     * @param id id konta
     * @return stan znalezionego konta
     */
    public Kwota stanKonta(String id)
    {
        Konto temp = znajdzKonto(id);
        return temp.getStan();
    }
    /**
     * Metoda pozwalajaca na wypisanie obiektu Bank w odpowiednim formacie
     */
    public String toString()
    {
        String info = "";
        Konto temp = first;
        while(temp != null){
            info += temp.toString() + " ; ";
            temp = temp.next;
        } 
        return info;
    }
}
