package utils;

import characters.CharacterWidthHeight;

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

    /*
    public static boolean collideRect(Rectangle r1, Rectangle r2) {
        // Check if they have the same X
        if ((r1.getX() > r2.getX() && r1.getX() < r2.getXPlusWidth()) ||
                (r2.getX() > r1.getX() && r2.getX() < r1.getXPlusWidth())){
            // Check if they have the same Y
            if ((r1.getY() > r2.getY() && r1.getY() < r2.getYPlusHeight()) ||
                    (r2.getY() > r1.getY() && r2.getY() < r1.getYPlusHeight())) {
                return true;
            }
        }
        return false;
    }
     */

    public static boolean collideW(CharacterWidthHeight c1, CharacterWidthHeight c2, int x1, int x2) {
        // Check if they have the same X

        System.out.println("c1: ");
        drawCW(c1, x1);

        System.out.println("c2: ");
        drawCW(c2, x2);

        // C1 collides with C2
        if ((c1.getX(x1) >= c2.getX(x2) && c1.getX(x1) < c2.getXPlusWidth(x2)) ||
                (c1.getXPlusWidth(x1) > c2.getX(x2) && c1.getXPlusWidth(x1) <= c2.getXPlusWidth(x2))) {
            System.out.println("Si toccano");
            return true;
        }
        // C2 collides with C1
        if ((c2.getX(x2) >= c1.getX(x1) && c2.getX(x2) < c1.getXPlusWidth(x1)) ||
                (c2.getXPlusWidth(x2) > c1.getX(x1) && c2.getXPlusWidth(x2) <= c1.getXPlusWidth(x1))) {
            System.out.println("Si toccano");
            return true;
        }
        System.out.println("Non si toccano");
        return false;
    }

    public static void drawCW(CharacterWidthHeight c, int x) {
        int i = 0;
        String ris = "";
        do {
            if (x > i) {
                ris += " ";
            } else {
                ris += "-";
            }
            i++;
        } while (i < c.getXPlusWidth(x));

        System.out.println(ris);
    }

    public static boolean collideWH(CharacterWidthHeight c1, CharacterWidthHeight c2, int x1, int y1, int x2, int y2) {
        // Check if they have the same X
        if ((c1.getX(x1) >= c2.getX(x2) && c1.getX(x1) <= c2.getXPlusWidth(x1)) ||
                (c2.getX(x2) >= c1.getX(x1) && c2.getX(x2) <= c1.getXPlusWidth(x1))) {
            // Check if they have the same Y
            if ((c1.getY(y1) >= c2.getY(y2) && c1.getY(y1) <= c2.getYPlusHeight(y2)) ||
                    (c2.getY(y2) >= c1.getY(y1) && c2.getY(y2) <= c1.getYPlusHeight(y1))) {
                return true;
            }
        }
        return false;
    }
}
