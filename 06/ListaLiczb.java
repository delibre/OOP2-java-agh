public class ListaLiczb extends Lista{
    public void add(Object o){
        System.out.println("Bledna wartosc");
    }
    public void add(Liczba o){
        if(head == null){
            head = new Node(o);
        }
        else{
            Node tmp = head;
            while(tmp.next != null){
                tmp = tmp.next;
            }
            tmp.next = new Node(o);
        }
        len++;
    }
    Liczba min(){
        Node tmp = head;
        Liczba min = ((Liczba)tmp.val);
        for(int i = 0 ; i < len ; i++){
            if(((Liczba)tmp.val).toDouble() < min.toDouble()){
                min = (Liczba)tmp.val;
            }
            tmp = tmp.next;
        }
        return min;
    }
    Liczba max(){
        Node tmp = head;
        Liczba max = ((Liczba)tmp.val);
        for(int i = 0 ; i < len ; i++){
            if(((Liczba)tmp.val).toDouble() > max.toDouble()){
                max = (Liczba)tmp.val;
            }
            tmp = tmp.next;
        }
        return max;
    }
    double avg(){
        double arr[] = toDoubleArray();
        double sum = 0;
        for(int i = 0 ; i < len ; i++){
            sum += arr[i];
        }
        return sum/len;
    }
    double[] toDoubleArray(){
        double arr[] = new double[len];
        Node tmp = head;
        for(int i = 0 ; i < len ; i++){
            arr[i] = ((Liczba)tmp.val).toDouble();
            tmp = tmp.next;
        }
        return arr;
    }
    void sort(){
        
    }
}
