import java.util.ArrayList;
import java.util.Random;

public class Arr<T extends Integer> {
    ArrayList<Integer> arr;
    int size;
    Arr(int size, int k){
        this.size = size;
        arr = new ArrayList<>();
        Random rand = new Random();
        for(int i  = 0 ; i < size ; i++){
            int el = rand.nextInt(k+1);
            arr.add(el);
        }
    }
    Arr(T first, T second, T third, T... rest){
        this.size = 3+rest.length;
        arr = new ArrayList<>();
        arr.add(first);
        arr.add(second);
        arr.add(third);
        for(int i  = 3 ; i < size ; i++){
            arr.add(rest[i-3]);
        }
    }
    double getAvg(){
        double avg = 0.0;
        for(Integer el: arr){
            avg += el;
        }
        avg /= size;
        return avg;
    }
    double getStd(){
        double std = 0.0;
        double avg = getAvg();
        for(Integer el: arr){
            std += Math.pow(el-avg,2);
        }
        std = Math.sqrt(std/size);
        return std;
    }
}
