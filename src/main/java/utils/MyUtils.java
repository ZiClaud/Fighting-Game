package utils;

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
}
