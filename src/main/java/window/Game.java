package window;

import UI.HealthBar;
import actions.PlayerAction;
import characters.CharacterInt;
import characters.Enemy;
import characters.Player;
import window.GameObject.ID;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

public class Game extends Canvas implements Runnable {
    private final MyHandler handler;    public static final int WIDTH_WINDOW = 640, HEIGHT_WINDOW = WIDTH_WINDOW / 12 * 9;
    private Thread thread;
    private boolean running = false;
    public Game() {
        handler = new MyHandler();
        this.addKeyListener(new KeyInput(handler));

        setHandlerObjects();

        /**
         * Keep always at the end!
         */
        // TODO: Remove +37 from HEIGHT - It's there for a temporary bug fix
        new MyWindow(WIDTH_WINDOW, HEIGHT_WINDOW + 37, "Fight!", this);
    }

    private void setHandlerObjects() {
        CharacterInt player = new Player(50, Game.HEIGHT_WINDOW, ID.Player, 200, 200, 100, "Player");
        CharacterInt enemy = new Enemy(Game.WIDTH_WINDOW - 50 - 163, Game.HEIGHT_WINDOW, ID.Enemy, 100, 100, 100, "Enemy");
//        enemy.getAction().setFacingRight(false);
        enemy.getAnimatePlayer().update(PlayerAction.Idle, false);

        handler.addObject(player);
        handler.addObject(enemy);
//        handler.addObject(new Player(500, 300, ID.Enemy, 200, 200, 100));  // TODO: USE TO CHECK -> THERE'S NO BUG

        handler.addObject(new HealthBar(50, 50, ID.HealthBarPlayer, handler));
        handler.addObject(new HealthBar(Game.WIDTH_WINDOW - 50 - enemy.getHp(), 50, ID.HealthBarEnemy, handler));
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    /*
    public void resetHandlerObjects() {
        for (MovingGameObjectInt tempObject : handler.objects) {
            handler.removeObject(tempObject);
        }
        setHandlerObjects();
    }
    */

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        long lastTime = System.nanoTime();
        final double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0; // Its use is commented

        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            if (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
//                System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        handler.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }

        Graphics g = bs.getDrawGraphics();

        try {
            g.drawImage(ImageIO.read(new File("src/main/resources/Background/cyberpunk-street.png")), 0, 0, WIDTH_WINDOW, HEIGHT_WINDOW, null);
//            g.fillRect(0, 0, WIDTH, HEIGHT);
        } catch (IOException e) {
            g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH_WINDOW, HEIGHT_WINDOW);
            e.printStackTrace();
        }
        handler.render(g);

        g.dispose();
        bs.show();
    }




}
