public class Lista {
    Node head;
    int len = 0;
    public class Node{
        Object val;
        Node next; 
        Node(){
            val = null;
            next = null;
        }
        Node(Object o){
            val = o;
            next = null;
        }
    }
    Lista(){
        head = null;
    }
    public void add(Object o){
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
    public int len(){
        return len;
    }
    public Node getFirst(){
        return head;
    }
    public Node getLast(){
        Node tmp = head;
        if(tmp != null){
            while(tmp.next != null){
                tmp = tmp.next;
            }
            return tmp;
        }
        return null;
    }
    public Node get(int j){
        Node tmp = head;
        for(int i = 0; i < j-1; i++){
            tmp = tmp.next;
        }
        return tmp;
    }
    public void remove(int j){
        Node tmp = head;
        for(int i = 1; i < j-1; i++){
            tmp = tmp.next;
        }
        tmp.next = tmp.next.next;
        len--;
    }
    public void removeAll(){
        head = null;
        len = 0;
    }
    public String toString(){
        String arr = "";
        for(int i = 1; i < len+1; i++){
            arr += get(i).val;
            arr += " ";
        }
        return arr;
    }
}
