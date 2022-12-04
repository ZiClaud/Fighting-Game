package utils;

import characters.Rectangle;

import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class MyUtils {
    public static BufferedImage mirrorImage(BufferedImage image) {
        AffineTransform tx = AffineTransform.getScaleInstance(-1, 1);
        tx.translate(-image.getWidth(null), 0);
        AffineTransformOp op = new AffineTransformOp(tx, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
        return op.filter(image, null);
    }

    public static ArrayList<BufferedImage> mirrorImage(ArrayList<BufferedImage> images) {
        ArrayList<BufferedImage> ris = new ArrayList<>();
        for (BufferedImage image : images) {
            ris.add(mirrorImage(image));
        }
        return ris;
    }

    public static void printSkinNotFound() {
        System.out.println("Skin not found");
        System.err.println("Skin not found");
        System.out.println("Skin not found");
    }

    public static boolean collideRect(Rectangle r1, Rectangle r2) {
        // TODO
        System.out.println("r1 getX: " + r1.getX()); // 1
        System.out.println("r2 getX: " + r2.getX()); // 2
        System.out.println("r1 getXPlusWidth: " + r1.getXPlusWidth()); // 3
        System.out.println("r2 getXPlusWidth: " + r2.getXPlusWidth()); // 2

        // Check if they have the same X
        if ((r1.getX() > r2.getX() && r1.getX() < r2.getXPlusWidth()) ||
                (r2.getX() > r1.getX() && r2.getX() < r1.getXPlusWidth())){
            if ((r1.getY() > r2.getY() && r1.getY() < r2.getYPlusHeight()) ||
                    (r2.getY() > r1.getY() && r2.getY() < r1.getYPlusHeight())) {
                return true;
            }
        }

        return false;
    }
}
