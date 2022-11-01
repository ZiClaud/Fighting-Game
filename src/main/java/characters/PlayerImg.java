package characters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class PlayerImg {

    public static LinkedList<BufferedImage> PlayerImgIdle() {
        LinkedList<BufferedImage> imageList = new LinkedList<>();

        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Idle/Idle_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Idle/Idle_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Idle/Idle_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Idle/Idle_4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Idle/Idle_5.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Idle/Idle_6.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Idle/Idle_7.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Idle/Idle_8.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return imageList;
    }

    public static LinkedList<BufferedImage> PlayerImgAttack1() {
        LinkedList<BufferedImage> imageList = new LinkedList<>();

        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Attack1/Attack1_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Attack1/Attack1_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Attack1/Attack1_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Attack1/Attack1_4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Attack1/Attack1_5.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Attack1/Attack1_6.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return imageList;
    }

}
