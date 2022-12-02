package actions.imgsFactory;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GirlImagesFromResources extends CharacterImagesFromResources {
    @Override
    protected ArrayList<BufferedImage> ImgIdle() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Idle/idle1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Idle/idle2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Idle/idle3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Idle/idle4.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgRun() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Walk/walk1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Walk/walk2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Walk/walk3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Walk/walk4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Walk/walk5.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Walk/walk6.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Walk/walk7.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Walk/walk8.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Walk/walk9.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Walk/walk10.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgAttack1() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Punch/punch1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Punch/punch2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Punch/punch3.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgAttack2() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgJump() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Jump/jump1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Jump/jump2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Jump/jump3.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgFall() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Jump/jump4.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgDeath() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Hurt/hurt1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Hurt/hurt1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Hurt/hurt2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Hurt/hurt2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Hurt/hurt1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Hurt/hurt2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Hurt/hurt1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Hurt/hurt2.png")));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    @Override
    protected ArrayList<BufferedImage> ImgTakeHit() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Hurt/hurt1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Hurt/hurt1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Hurt/hurt2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Hurt/hurt2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }
}
