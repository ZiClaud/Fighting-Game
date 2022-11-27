package actions.imgsFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class UndeadImagesFromResources extends CharacterImagesFromResources {
    @Override
    protected ArrayList<BufferedImage> ImgIdle() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Idle/Idle_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Idle/Idle_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Idle/Idle_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Idle/Idle_4.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    ArrayList<BufferedImage> ImgRun() {
        return ImgIdle();
    }

    @Override
    protected ArrayList<BufferedImage> ImgAttack1() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Attack1/Attack1_1.png")));
//            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Attack1/Attack1_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Attack1/Attack1_3.png")));
//            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Attack1/Attack1_4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Attack1/Attack1_5.png")));
//            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Attack1/Attack1_6.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgAttack2() {
        return null;
    }

    @Override
    protected ArrayList<BufferedImage> ImgJump() {
        return ImgIdle();
    }

    @Override
    protected ArrayList<BufferedImage> ImgFall() {
        return ImgIdle();
    }

    @Override
    protected ArrayList<BufferedImage> ImgTakeHit() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/TakeHit/TakeHit_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/TakeHit/TakeHit_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/TakeHit/TakeHit_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/TakeHit/TakeHit_4.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgDeath() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Death/Death_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Death/Death_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Death/Death_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Death/Death_4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Death/Death_5.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Undead/Death/Death_6.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }
}
