package actions.imgsFactory;

import actions.ActionType;
import utils.MyUtils;

import java.awt.image.BufferedImage;
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
public abstract class CharacterImagesFromResources {
    public ArrayList<BufferedImage> getImg(ActionType actionType, boolean facingRight) {
        if (facingRight) {
            if (actionType == ActionType.Idle)
                return ImgIdle();
            else if (actionType == ActionType.Run)
                return ImgRun();
            else if (actionType == ActionType.Jump)
                return ImgJump();
            else if (actionType == ActionType.Fall)
                return ImgFall();
            else if (actionType == ActionType.Attack1)
                return ImgAttack1();
            else if (actionType == ActionType.Attack2)
                return ImgAttack2();
            else if (actionType == ActionType.TakeHit)
                return ImgTakeHit();
            else if (actionType == ActionType.Death)
                return ImgDeath();
            else
                return ImgIdle();
        } else {
            if (actionType == ActionType.Idle)
                return MirrorImages(ImgIdle());
            else if (actionType == ActionType.Run)
                return MirrorImages(ImgRun());
            else if (actionType == ActionType.Jump)
                return MirrorImages(ImgJump());
            else if (actionType == ActionType.Fall)
                return MirrorImages(ImgFall());
            else if (actionType == ActionType.Attack1)
                return MirrorImages(ImgAttack1());
            else if (actionType == ActionType.Attack2)
                return MirrorImages(ImgAttack2());
            else if (actionType == ActionType.TakeHit)
                return MirrorImages(ImgTakeHit());
            else if (actionType == ActionType.Death)
                return MirrorImages(ImgDeath());
            else
                return MirrorImages(ImgIdle());
        }
    }

    /**
     * Mirror
     */
    private ArrayList<BufferedImage> MirrorImages(ArrayList<BufferedImage> images) {
        ArrayList<BufferedImage> imageList = new ArrayList<>();
        for (BufferedImage image : images) {
            imageList.add(MyUtils.mirrorImage(image));
        }
        return imageList;
    }

    /**
     * Character
     */
    abstract ArrayList<BufferedImage> ImgIdle();

    abstract ArrayList<BufferedImage> ImgRun();

    abstract ArrayList<BufferedImage> ImgAttack1();

    abstract ArrayList<BufferedImage> ImgAttack2();

    abstract ArrayList<BufferedImage> ImgJump();

    abstract ArrayList<BufferedImage> ImgFall();

    abstract ArrayList<BufferedImage> ImgDeath();

    abstract ArrayList<BufferedImage> ImgTakeHit();

    // TODO IMPORTANT: Make sure that all the image size are the same for both  and Enemy
}
