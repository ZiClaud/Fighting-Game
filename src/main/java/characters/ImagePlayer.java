package characters;

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
 */
public class ImagePlayer {
    public static ArrayList<BufferedImage> getPlayerImg(PlayerAnimationType playerAnimationType, boolean facingRight) {
        //System.out.println("isFacingRight()" + facingRight);
        if (facingRight) {
            if (playerAnimationType == PlayerAnimationType.Idle)
                return PlayerImgIdle();
            else if (playerAnimationType == PlayerAnimationType.Run)
                return PlayerImgRun();
            else if (playerAnimationType == PlayerAnimationType.RunLeft)
                return PlayerImgRunLeft();
            else if (playerAnimationType == PlayerAnimationType.Jump)
                return PlayerImgJump();
            else if (playerAnimationType == PlayerAnimationType.Fall)
                return PlayerImgFall();
            else if (playerAnimationType == PlayerAnimationType.Attack1)
                return PlayerImgAttack1();
            else if (playerAnimationType == PlayerAnimationType.Attack2)
                return PlayerImgAttack2();
            else if (playerAnimationType == PlayerAnimationType.TakeHit)
                return PlayerImgTakeHit();
            else if (playerAnimationType == PlayerAnimationType.Death)
                return PlayerImgDeath();
            else
                return PlayerImgIdle();
        } else {
            if (playerAnimationType == PlayerAnimationType.Idle)
                return MirrorImages(PlayerImgIdle());
            else if (playerAnimationType == PlayerAnimationType.Run)
                return MirrorImages(PlayerImgRun());
            else if (playerAnimationType == PlayerAnimationType.RunLeft)
                return MirrorImages(PlayerImgRunLeft());
            else if (playerAnimationType == PlayerAnimationType.Jump)
                return MirrorImages(PlayerImgJump());
            else if (playerAnimationType == PlayerAnimationType.Fall)
                return MirrorImages(PlayerImgFall());
            else if (playerAnimationType == PlayerAnimationType.Attack1)
                return MirrorImages(PlayerImgAttack1());
            else if (playerAnimationType == PlayerAnimationType.Attack2)
                return MirrorImages(PlayerImgAttack2());
            else if (playerAnimationType == PlayerAnimationType.TakeHit)
                return MirrorImages(PlayerImgTakeHit());
            else if (playerAnimationType == PlayerAnimationType.Death)
                return MirrorImages(PlayerImgDeath());
            else
                return MirrorImages(PlayerImgIdle());
        }
    }

    public static ArrayList<BufferedImage> getEnemyImg(PlayerAnimationType playerAnimationType, boolean facingRight) {
        //System.out.println("isFacingRight()" + facingRight);
        if (facingRight) {
            if (playerAnimationType == PlayerAnimationType.Idle)
                return EnemyImgIdle();
            else if (playerAnimationType == PlayerAnimationType.Attack1)
                return EnemyImgAttack1();
            else
                return EnemyImgIdle();
        } else {
            if (playerAnimationType == PlayerAnimationType.Idle)
                return MirrorImages(EnemyImgIdle());
            else if (playerAnimationType == PlayerAnimationType.Attack1)
                return MirrorImages(EnemyImgAttack1());
            else
                return MirrorImages(EnemyImgIdle());
        }
    }

    /**
     * Player
     */
    private static ArrayList<BufferedImage> PlayerImgIdle() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
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

    private static ArrayList<BufferedImage> PlayerImgRun() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Run/Run_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Run/Run_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Run/Run_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Run/Run_4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Run/Run_5.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Run/Run_6.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Run/Run_7.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Run/Run_8.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageList;
    }

    private static ArrayList<BufferedImage> PlayerImgRunLeft() {
        ArrayList<BufferedImage> images = PlayerImgRun();
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        for (BufferedImage image : images) {
            imageList.add(MyUtils.mirrorImage(image));
        }
        return imageList;
    }

    private static ArrayList<BufferedImage> PlayerImgAttack1() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
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

    private static ArrayList<BufferedImage> PlayerImgAttack2() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Attack2/Attack2_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Attack2/Attack2_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Attack2/Attack2_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Attack2/Attack2_4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Attack2/Attack2_5.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Attack2/Attack2_6.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageList;
    }

    private static ArrayList<BufferedImage> PlayerImgJump() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Jump/Jump_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Jump/Jump_2.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageList;
    }

    private static ArrayList<BufferedImage> PlayerImgFall() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Fall/Fall_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Fall/Fall_2.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageList;
    }

    private static ArrayList<BufferedImage> PlayerImgDeath() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Death/Death_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Death/Death_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Death/Death_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Death/Death_4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Death/Death_5.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Death/Death_6.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageList;
    }

    private static ArrayList<BufferedImage> PlayerImgTakeHit() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/TakeHit/TakeHit_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/TakeHit/TakeHit_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/TakeHit/TakeHit_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/TakeHit/TakeHit_4.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageList;
    }

    /**
     * Enemy
     */
    private static ArrayList<BufferedImage> EnemyImgIdle() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Death/Idle/Idle_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Death/Idle/Idle_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Death/Idle/Idle_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Death/Idle/Idle_4.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageList;
    }

    private static ArrayList<BufferedImage> EnemyImgAttack1() {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Death/Attack1/Attack1_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Death/Attack1/Attack1_2.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Death/Attack1/Attack1_3.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Death/Attack1/Attack1_4.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Death/Attack1/Attack1_5.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Death/Attack1/Attack1_6.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageList;
    }

    /**
     * Mirror
     */
    private static ArrayList<BufferedImage> MirrorImages(ArrayList<BufferedImage> images) {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        for (BufferedImage image : images) {
            imageList.add(MyUtils.mirrorImage(image));
        }
        return imageList;
    }
}
