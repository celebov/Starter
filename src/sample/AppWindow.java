package sample;
import javax.swing.JComponent;
import javax.imageio.ImageIO;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Created by celebov on 11.12.16.
 */
public class AppWindow extends JComponent {
    String strEng;
    String strFch;
    Image image;

    public AppWindow(File imageFile,String str1, String str2){
        try { //it is a must to handle this method
            this.image = ImageIO.read(imageFile);
        }
        catch (IOException e){
            e.printStackTrace();
        }
        this.strEng = str1;
        this.strFch = str2;
    }

}
