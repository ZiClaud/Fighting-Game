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
 * HeightToRemoveFromBottom: 78px <p>
 * WidthToRemoveFromLeft: 76px (78px is fine too) <p>
 * WidthToRemoveFromRight: 87px (78px is fine too) <p>
 */
public class PlayerImg {

    public static ArrayList<BufferedImage> getPlayerImg(PlayerAnimationType playerAnimationType) {
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
        else
            return PlayerImgIdle();
    }

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

}
