// MW 2021

import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;

public class lab01 {

    public static void main(String[] args) {
    
        int imageWidth = 500;
        int imageHeight = 500;
        String filename = "graph.png";
        
        BufferedImage myPicture = new BufferedImage(imageWidth,imageHeight,BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = myPicture.createGraphics();
        
        g.setStroke(new BasicStroke(3));
        g.setColor(Color.BLUE);
        g.drawRect(10, 10, myPicture.getWidth() - 20, myPicture.getHeight() - 20);
        
        try {
            File outputfile = new File(filename);
            ImageIO.write(myPicture, "png", outputfile);
        } catch (IOException e) {
            System.out.println("I/O error while saving " + filename);
        }
    
    }
    
}
