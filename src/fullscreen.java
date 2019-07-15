import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class fullscreen {

    public void fullss(String fileName,String format){
        try {
            Thread.sleep(0);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Robot robot = null;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            e.printStackTrace();
        }
        Rectangle rectArea = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());


        // Define an area of size 500*400 starting at coordinates (10,50)
        BufferedImage screenFullImage = robot.createScreenCapture(rectArea);
        try {
            ImageIO.write(screenFullImage, format, new File(fileName));


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
