public class Main {
    public static void main(String args[]){
        ListaLiczb l = new ListaLiczb();
        LiczbaWymierna b = new LiczbaWymierna(3,2);
        LiczbaWymierna a = new LiczbaWymierna(1,8);
        LiczbaOdZeraDoJeden c = new LiczbaOdZeraDoJeden(0.8);
        LiczbaOdZeraDoJeden d = new LiczbaOdZeraDoJeden(0.9);
        LiczbaOdZeraDoJeden e = new LiczbaOdZeraDoJeden(1.2);
        l.add("cos");
        l.add(a);
        l.add(b);
        l.add(c);
        l.add(d);
        System.out.println(l);
        l.remove(2);
        System.out.println(l);
        System.out.println("min: " + l.min());
        System.out.println("max: " + l.max());
        System.out.println("avg: " + l.avg());
        double arr[] = l.toDoubleArray();
        System.out.println("["+arr[0]+" "+arr[1]+" "+arr[2]+"]");
    }
}
