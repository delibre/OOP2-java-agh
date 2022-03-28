public class Main {
    static public void main(String[] args){
        for(int i = 0 ; i < 3 ; i ++) {
            int size = 10000000;
            ArrInt a1 = new ArrInt(size, 100);
            ArrInteger a2 = new ArrInteger(size, 100);
            Arr<Integer> a3 = new Arr<>(size, 100);
            long t1 = System.currentTimeMillis();
            a1.getStd();
            long t2 = System.currentTimeMillis();
            a2.getStd();
            long t3 = System.currentTimeMillis();
            a3.getStd();
            long t4 = System.currentTimeMillis();
            System.out.println("Int: " + (t2-t1) + " Integer: " + (t3-t2) + " T<Integer>: " + (t4-t3));
        }
    }
}
