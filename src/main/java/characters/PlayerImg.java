package characters;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

public class PlayerImg {

    public static LinkedList<BufferedImage> getPlayerImg(PlayerAnimationType playerAnimationType) {
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

    private static LinkedList<BufferedImage> PlayerImgIdle() {
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

    private static LinkedList<BufferedImage> PlayerImgRun() {
        LinkedList<BufferedImage> imageList = new LinkedList<>();
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

    private static LinkedList<BufferedImage> PlayerImgRunLeft() {
        LinkedList<BufferedImage> images = PlayerImgRun();
        LinkedList<BufferedImage> imageList = new LinkedList<>();
        for (BufferedImage image : images) {
            AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
            tx.translate(-image.getWidth(null), 0);
            AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
            imageList.add(op.filter(image, null));
        }
        return imageList;
    }

    private static LinkedList<BufferedImage> PlayerImgAttack1() {
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

    private static LinkedList<BufferedImage> PlayerImgAttack2() {
        LinkedList<BufferedImage> imageList = new LinkedList<>();
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

    private static LinkedList<BufferedImage> PlayerImgJump() {
        LinkedList<BufferedImage> imageList = new LinkedList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Jump/Jump_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Jump/Jump_2.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageList;
    }

    private static LinkedList<BufferedImage> PlayerImgFall() {
        LinkedList<BufferedImage> imageList = new LinkedList<>();
        try {
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Fall/Fall_1.png")));
            imageList.add(ImageIO.read(new File("src/main/resources/Sprites/Fall/Fall_2.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return imageList;
    }

}
