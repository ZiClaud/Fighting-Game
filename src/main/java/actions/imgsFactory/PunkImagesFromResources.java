package actions.imgsFactory;

import utils.MyUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PunkImagesFromResources extends CharacterImagesFromResources {
    @Override
    protected ArrayList<BufferedImage> ImgIdle() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Idle/idle1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Idle/idle2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Idle/idle3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Idle/idle4.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MyUtils.mirrorImage(imageList);
    }

    @Override
    protected ArrayList<BufferedImage> ImgRun() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Walk/walk1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Walk/walk2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Walk/walk3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Walk/walk4.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MyUtils.mirrorImage(imageList);
    }

    @Override
    protected ArrayList<BufferedImage> ImgAttack1() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Punch/punch1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Punch/punch2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Punch/punch3.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MyUtils.mirrorImage(imageList);
    }

    @Override
    protected ArrayList<BufferedImage> ImgAttack2() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        return MyUtils.mirrorImage(imageList);
    }

    @Override
    protected ArrayList<BufferedImage> ImgJump() {
        return ImgIdle();
    }

    @Override
    protected ArrayList<BufferedImage> ImgFall() {
        return ImgJump();
    }

    @Override
    protected ArrayList<BufferedImage> ImgDeath() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Hurt/hurt1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Hurt/hurt2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Hurt/hurt3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Hurt/hurt4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Hurt/hurt4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Hurt/hurt4.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return MyUtils.mirrorImage(imageList);
    }

    @Override
    protected ArrayList<BufferedImage> ImgTakeHit() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Hurt/hurt1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Hurt/hurt2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Hurt/hurt2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Hurt/hurt1.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return MyUtils.mirrorImage(imageList);
    }
}
