import java.util.Random;
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

class BladCalki extends ArithmeticException{}

public class CalkaOznaczona {
    CalkaOznaczona(Funkcja f){ this.fun = f; }
    CalkaOznaczona(FunkcjaLambda f){ this.fun = f; }
    FunkcjaLambda fun;

    double wartoscProstokaty(double a, double b, int n){
        if (a >= b) throw new BladCalki();
        if (n <= 0) throw new BladCalki();
        double len = (b-a)/(n-1);
        double result = 0.0;
        for (int i = 0 ; i < n ; i++){
            double x = a + i*len;
            result += len*fun.wartosc(x);
        }
        return result;   
    }
    double wartoscMonteCarlo(double a, double b, int n){
        if (a >= b) throw new BladCalki();
        if (n <= 0) throw new BladCalki();
        Random r = new Random();
        double avg = 0.0;
        for(int i = 0 ; i < n ; i++){
            double x = a + r.nextDouble()*(b-a);
            avg += fun.wartosc(x);
        }
        avg /= n;
        return avg*(b-a);   
    }

    public void draw(double a, double b){
        int imWidth = 500;
        int imHeight = 500;
        String filename = "graph.png";

        BufferedImage myPicture = new BufferedImage(imWidth, imHeight,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = myPicture.createGraphics();

        g.setColor(Color.RED); 
        g.drawLine(0, 250, 500, 250);
        g.drawLine(250, 0, 250, 500);
        g.drawLine(250, 250, 270, 270);

        g.setColor(Color.RED);
        
        for (int i = 0 ; i < 100 ; i ++){
            double x = a + i*(b-a)/100;
            double x2 = a + (i+1)*(b-a)/100;
            g.drawLine((int)(x*100), 500-(int)(fun.wartosc(x)*50), (int)(x2*100), 500-(int)(fun.wartosc(x2)*50));
        }

        g.setColor(Color.RED);
        
        for (int i = 0 ; i < 100 ; i ++){
            double x = a + i*(b-a)/100;
            double x2 = a + (i+1)*(b-a)/100;
            g.drawLine((int)(x*100), 500-(int)(fun.wartosc(x)*50), (int)(x2*100), 500-(int)(fun.wartosc(x2)*50));
        }

        g.setColor(Color.BLUE);
        

        try {
            File outputfile = new File(filename);
            ImageIO.write(myPicture, "png", outputfile);
            System.out.println("zapisano plik");
        } catch (IOException e) {
            System.out.println("I/O error while saving " + filename);
        }

    }

    public static void main(String args[]){
        CalkaOznaczona c = new CalkaOznaczona(Funkcja.X2);
        c.draw(1.0, 4.0);
    }

}
