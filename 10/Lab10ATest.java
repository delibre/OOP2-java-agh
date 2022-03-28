import java.lang.reflect.*;

public class Lab10ATest {
    static public void main(String[] args){
        try {
            //Stworzenie obiektu
            Class c = Class.forName("Lab10A");
            Object obj = c.getConstructor().newInstance();
            //Wypisanie publicznych pól
            System.out.println("\nPubliczne pola:");
            Field[] fields = c.getFields();
            for (Field f: fields){
                System.out.println("Nazwa: " + f.getName() + " Wartość: " + f.get(obj));
            }
            //Wypisanie publicznych metod
            Method[] tm = c.getMethods();
            System.out.println("\nPubliczne metody:");
            for (Method m: tm) {
                System.out.print("Nazwa: " + m.getName() + " argumenty: ");
                Type[] tt = m.getGenericParameterTypes();
                for (Type t: tt){
                    System.out.print(t+ " ");
                }
                System.out.print("\n");
            }
            //Wywołanie publicznych metod
            System.out.println("\nWywołanie metod: ");
            System.out.println(tm[0].invoke(obj));
            System.out.println(tm[1].invoke(obj, 1, 2, 3));
            System.out.println(tm[2].invoke(obj, "Cokolwiek"));
        } catch(Exception e) { e.printStackTrace(); }
    }
}
