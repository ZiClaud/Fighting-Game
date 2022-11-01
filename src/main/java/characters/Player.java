package characters;

import window.GameObject;
import window.ID;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.ImageProducer;
import java.io.File;
import java.io.IOException;

public class Player extends GameObject {

    int playerX;
    int playerY;
    int hp;

    BufferedImage img;

    public Player(int x, int y, ID id, int playerX, int playerY, int hp) {
        super(x, y, id);
        this.playerX = playerX;
        this.playerY = playerY;
        this.hp = hp;
        try {
            this.img = ImageIO.read(new File("src/main/resources/Sprites/Attack1/Attack1_1.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        int w = img.getWidth(null);
        int h = img.getHeight(null);
        BufferedImage bi = new
                BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);

    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        if (id == ID.Player) {
            g.drawImage(img, x, y, null);
        }
//        if (id == ID.Player) g.setColor(Color.WHITE);
        else if (id == ID.Enemy) {
            g.setColor(Color.RED);
            g.fillRect(x, y, playerX, playerY);
        }
    }
}
