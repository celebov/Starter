package sample;

import java.lang.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.imageio.ImageIO;


public class Main{

    static File folder = new File("src/Images");

    static String [] engDictionary = {"apple", "banana", "baby", "mirror", "book", "fish", "house", "pen", "watch", "lamp"};
    static String [] fchDictionary = {"pomme","banane","bébé","miroir","livre","pêcher","maison","stylo","la montre","lampe"};
    static public File [] images;

    public static void main(String[] args) {



         images = folder.listFiles();
         AppWindow one = new AppWindow(images[1],engDictionary[1], fchDictionary[1]);
         EventQueue.invokeLater(new Runnable()
                               {
                                   public void run(){
                                       ImageFrame frame = new ImageFrame();
                                       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                       frame.setVisible(true);


                                   }
                               }
        );



    }
}

class ImageFrame extends JFrame{

    public ImageFrame(){
        setTitle("ImageTest");
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        ImageComponent component = new ImageComponent();
        add(component);

    }

    public static final int DEFAULT_WIDTH = 800;
    public static final int DEFAULT_HEIGHT = 500;
}


class ImageComponent extends JComponent {
    /**
     *
     */
    private Image image;
    private static final long serialVersionUID = 1L;
    static File folder = new File("src/Images");
    static public File [] images2;

    public ImageComponent() {
        try{
            images2 = folder.listFiles();
            image = ImageIO.read(images2[1]);

        }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public void paintComponent(Graphics g) {
        if (image == null) return;
        int imageWidth = image.getWidth(this);
        int imageHeight = image.getHeight(this);

        g.drawImage(image, 50, 50, this);

        for (int i = 0; i * imageWidth <= getWidth(); i++)
            for (int j = 0; j * imageHeight <= getHeight(); j++)
                if (i + j > 0) g.copyArea(0, 0, imageWidth, imageHeight, i * imageWidth, j * imageHeight);
    }
}

