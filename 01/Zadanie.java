import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class Zadanie {

    public static void main(String[] args) {
        Funkcja fun = new Funkcja(2,2,-4);
        fun.print();
        fun.printIloczynowa();
        fun.printKanoniczna();
        fun.draw();
    }
}

class Funkcja {
    private double a, b, c;

        
    public Funkcja(double x, double y, double z){
        a = x;
        b = y;
        c = z;
    }

    public double getDelta() {
        return b*b-4*a*c;
    }

    public double[] getZeros() {
        double[] arr;
        arr = new double[2];
        double delta = getDelta();
        if (delta >= 0){
            arr[0] = (-b + Math.sqrt(getDelta()))/(2*a);
            arr[1] = (-b - Math.sqrt(getDelta()))/(2*a);
            return arr;
        }
        else return null;
    }

    public void print() {
        System.out.println(a + "x^2+" + b + "x+" + c);
        if (getDelta() >= 0 && a!= 0)
            System.out.println("Rozwiazania: " + getZeros()[0] + ", " + getZeros()[1]);
        if (a == 0)
            System.out.println("Rozwiazanie: " + -c/b);
    }

    public void printKanoniczna() {
        if (getDelta() > 0 && a != 0)
            System.out.println(a + "*(x-" + -b/(2*a) + ")^2" + -getDelta()/(4*a));
        else
            System.out.println("Brak postaci kanonicznej");
    }
    
    public void printIloczynowa() {
        if (getDelta()>0 && a != 0)
            System.out.println(a + "(x-" + getZeros()[0] + ")(x-" + getZeros()[1] + ")");
        else
            System.out.println("Brak postaci iloczynowej");
    }

    private double getValue(double x){
        return a*x*x + b*x + c;
    }

    public void draw(){
        int imWidth = 500;
        int imHeight = 500;
        String filename = "graph.png";

        BufferedImage myPicture = new BufferedImage(imWidth, imHeight,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = myPicture.createGraphics();

        g.setColor(Color.BLACK);
        g.drawLine(250, 0, 500, 0);
        g.drawLine(0, 250, 0, 500);

        g.setColor(Color.RED);
        double[] arr = new double[2];
        arr = getZeros();
             
        for (int i = 0 ; i < 500 ; i +=10){
            g.drawLine(i, (int)getValue((i-250)/50)+250, i+10, (int)getValue((i-250+10)/50)+250);
        }

        try {
            File outputfile = new File(filename);
            ImageIO.write(myPicture, "png", outputfile);
        } catch (IOException e) {
            System.out.println("I/O error while saving " + filename);
        }

    }

}