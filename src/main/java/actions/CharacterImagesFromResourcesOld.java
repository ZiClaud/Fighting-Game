package actions;

/*
import music.SoundEffect;
import utils.MyUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Image stats: <p>
 * ImgWidth: 200px <p>
 * ImgHeight:200px <p>
 * <p>
 * ActualWidth: 37px <p>
 * ActualHeight: 52px <p>
 * <p>
 * WidthToRemoveFromLeft: 76px <p>
 * WidthToRemoveFromRight: 87px <p>
 * HeightToRemoveFromBottom: 78px <p>
 * HeightToRemoveFromTop: 70px <p>
 *
class CharacterImagesFromResources {
    public static ArrayList<BufferedImage> getPlayerImg(ActionType actionType, boolean facingRight) {
        if (facingRight) {
            if (actionType == ActionType.Idle)
                return PlayerImgIdle();
            else if (actionType == ActionType.Run)
                return PlayerImgRun();
            else if (actionType == ActionType.Jump)
                return PlayerImgJump();
            else if (actionType == ActionType.Fall)
                return PlayerImgFall();
            else if (actionType == ActionType.Attack1)
                return PlayerImgAttack1();
            else if (actionType == ActionType.Attack2)
                return PlayerImgAttack2();
            else if (actionType == ActionType.TakeHit)
                return PlayerImgTakeHit();
            else if (actionType == ActionType.Death)
                return PlayerImgDeath();
            else
                return PlayerImgIdle();
        } else {
            if (actionType == ActionType.Idle)
                return MirrorImages(PlayerImgIdle());
            else if (actionType == ActionType.Run)
                return MirrorImages(PlayerImgRun());
            else if (actionType == ActionType.Jump)
                return MirrorImages(PlayerImgJump());
            else if (actionType == ActionType.Fall)
                return MirrorImages(PlayerImgFall());
            else if (actionType == ActionType.Attack1)
                return MirrorImages(PlayerImgAttack1());
            else if (actionType == ActionType.Attack2)
                return MirrorImages(PlayerImgAttack2());
            else if (actionType == ActionType.TakeHit)
                return MirrorImages(PlayerImgTakeHit());
            else if (actionType == ActionType.Death)
                return MirrorImages(PlayerImgDeath());
            else
                return MirrorImages(PlayerImgIdle());
        }
    }

    public static ArrayList<BufferedImage> getEnemyImg(ActionType actionType, boolean facingRight) {
        //System.out.println("isFacingRight()" + facingRight);
        if (facingRight) {
            if (actionType == ActionType.Idle)
                return EnemyImgIdle();
            else if (actionType == ActionType.Attack1)
                return EnemyImgAttack1();
            else if (actionType == ActionType.TakeHit)
                return EnemyImgTakeHit();
            else if (actionType == ActionType.Death)
                return EnemyImgDeath();
            else
                return EnemyImgIdle();
        } else {
            if (actionType == ActionType.Idle)
                return MirrorImages(EnemyImgIdle());
            else if (actionType == ActionType.Attack1)
                return MirrorImages(EnemyImgAttack1());
            else if (actionType == ActionType.TakeHit)
                return MirrorImages(EnemyImgTakeHit());
            else if (actionType == ActionType.Death)
                return MirrorImages(EnemyImgDeath());
            else
                return MirrorImages(EnemyImgIdle());
        }
    }

    /**
     * Player
     *
    private static ArrayList<BufferedImage> PlayerImgIdle() {
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

    private static ArrayList<BufferedImage> PlayerImgRun() {
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

    private static ArrayList<BufferedImage> PlayerImgAttack1() {
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

    private static ArrayList<BufferedImage> PlayerImgAttack2() {
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

    private static ArrayList<BufferedImage> PlayerImgJump() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Jump/Jump_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Jump/Jump_2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    private static ArrayList<BufferedImage> PlayerImgFall() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Fall/Fall_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Images/Spirit/Fall/Fall_2.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageList;
    }

    private static ArrayList<BufferedImage> PlayerImgDeath() {
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

    private static ArrayList<BufferedImage> PlayerImgTakeHit() {
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

    /**
     * Enemy
     *
    private static ArrayList<BufferedImage> EnemyImgIdle() {
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

    private static ArrayList<BufferedImage> EnemyImgAttack1() {
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

    private static ArrayList<BufferedImage> EnemyImgTakeHit() {
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

    private static ArrayList<BufferedImage> EnemyImgDeath() {
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

    /**
     * Mirror
     *
    private static ArrayList<BufferedImage> MirrorImages(ArrayList<BufferedImage> images) {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        for (BufferedImage image : images) {
            imageList.add(MyUtils.mirrorImage(image));
        }
        return imageList;
    }

    // TODO IMPORTANT: Make sure that all the image size are the same for both Player and Enemy
}
*/