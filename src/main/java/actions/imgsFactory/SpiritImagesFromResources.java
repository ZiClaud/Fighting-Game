package actions.imgsFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SpiritImagesFromResources extends CharacterImagesFromResources {
    @Override
    protected ArrayList<BufferedImage> ImgIdle() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Idle/Idle_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Idle/Idle_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Idle/Idle_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Idle/Idle_4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Idle/Idle_5.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Idle/Idle_6.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Idle/Idle_7.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Idle/Idle_8.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgRun() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Run/Run_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Run/Run_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Run/Run_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Run/Run_4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Run/Run_5.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Run/Run_6.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Run/Run_7.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Run/Run_8.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgAttack1() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
//            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Attack1/Attack1_1.png")));
//            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Attack1/Attack1_2.png")));
//            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Attack1/Attack1_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Attack1/Attack1_4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Attack1/Attack1_5.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Attack1/Attack1_6.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgAttack2() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Attack2/Attack2_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Attack2/Attack2_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Attack2/Attack2_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Attack2/Attack2_4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Attack2/Attack2_5.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Attack2/Attack2_6.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgJump() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Jump/Jump_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Jump/Jump_2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgFall() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Fall/Fall_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Fall/Fall_2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgDeath() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Death/Death_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Death/Death_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Death/Death_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Death/Death_4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Death/Death_5.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Death/Death_6.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgTakeHit() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/TakeHit/TakeHit_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/TakeHit/TakeHit_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/TakeHit/TakeHit_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/TakeHit/TakeHit_4.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }
}
