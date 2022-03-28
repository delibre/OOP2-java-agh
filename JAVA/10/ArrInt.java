import java.util.Arrays;
import java.util.Random;

public class ArrInt {
    int[] arr;
    int size;
    ArrInt(int size, int k){
        this.size = size;
        arr = new int[size];
        Random rand = new Random();
        for(int i  = 0 ; i < size ; i++){
            arr[i] = rand.nextInt(k+1);
        }
    }
    ArrInt(int first, int second, int third, int... rest){
        this.size = 3+rest.length;
        arr = new int[size];
        arr[0] = first;
        arr[1] = second;
        arr[2] = third;
        for(int i  = 3 ; i < size ; i++){
            arr[i] = rest[i-3];
        }
    }
    double getAvg(){
        double avg = 0.0;
        for(int el: arr){
            avg += el;
        }
        avg /= size;
        return avg;
    }
    double getStd(){
        double avg = getAvg();
        double std = 0.0;
        for(int el: arr){
            std += Math.pow(el-avg,2);
        }
        std = Math.sqrt(std/size);
        return std;
    }
}
