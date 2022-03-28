public class LiczbaWymierna implements Liczba{
    int l;
    int m;
    public LiczbaWymierna(int a, int b){
        l = a;
        m = b;
    }
    public String toString(){
        String str = l + "/" + m;
        return str;
    }
    public double toDouble(){
        return (double)l/m;
    }
}
