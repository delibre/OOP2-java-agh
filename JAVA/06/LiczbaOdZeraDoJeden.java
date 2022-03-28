public class LiczbaOdZeraDoJeden implements Liczba{
    double val;
    LiczbaOdZeraDoJeden(double v){
        if (v>=0.0 && v<=1.0){
            val = v;
        }
        else{
            System.out.println("Liczba musi byc [0,1]");
        }
    }
    public String toString(){
        String str = "" + val;
        return str;
    }
    public double toDouble(){
        return val;
    }
}