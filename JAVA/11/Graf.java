import java.util.ArrayList;

public class Graf<T, K> {
    ArrayList<Wierzcholek<T>> wList = new ArrayList<>();
    ArrayList<Krawedz<T>> kList = new ArrayList<>();
    public int rzad(){
        return wList.size();
    }
    public int rozmiar(){
        return kList.size();
    }
    public void dodajWierzcholek(Wierzcholek<T> w) throws WierzcholekJuzIstniejeException {
        for (Wierzcholek<T> el : wList) {
            if (el.getId() == w.getId()) throw new WierzcholekJuzIstniejeException();
        }
        wList.add(w);
    }
    public void dodajKrawedz(Krawedz<T> k) throws KrawedzJuzIstniejeException {
        for (Krawedz<T> el : kList) {
            if (el.getA() == k.getA() && el.getB() == k.getB()) throw new KrawedzJuzIstniejeException();
        }
        kList.add(k);
    }
    public void dodajKrawedz(T x, T y) {
        dodajKrawedz(new Krawedz<T>(x,y));
    }
    public String toString(){
        String str = "";
        for(Wierzcholek<T> wEl: wList) {
            str += "\n";
            str += wEl.getId();
            str += " --";
            for(Krawedz<T> kEl: kList){
                if(kEl.getA() == wEl.getId()){
                    str += " "+kEl.getB();
                }
                if(kEl.getB() == wEl.getId()){
                    str += " "+kEl.getA();
                }
            }
        }
        if(str != "") str += "\n";
        return str;
    }


}
