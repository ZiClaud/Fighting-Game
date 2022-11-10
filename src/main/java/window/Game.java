package window;

import UI.HealthBar;
import characters.Player;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

public class Game extends Canvas implements Runnable {
    private final MyHandler handler;
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;

    public Game() {
        handler = new MyHandler();
        this.addKeyListener(new KeyInput(handler));

        Player player = new Player(50, Game.HEIGHT, ID.Player, 200, 200, 100);
        Player enemy = new Player(Game.WIDTH - 50 - 163, Game.HEIGHT, ID.Enemy, 37, 52, 100);

        handler.addObject(player);
        handler.addObject(enemy);
//        handler.addObject(new Player(500, 300, ID.Enemy, 200, 200, 100));  // TODO: USE TO CHECK -> THERE'S NO BUG
        handler.addObject(new HealthBar(50, 50, ID.HealthBarPlayer, handler));
        handler.addObject(new HealthBar(Game.WIDTH - 50 - enemy.getHp(), 50, ID.HealthBarEnemy, handler));

        /**
         * Keep always at the end!
         */
        new MyWindow(WIDTH + 14, HEIGHT + 37, "Let's build a game!", this);
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (InterruptedException e) {
            e.printStackTrace();
//            throw new RuntimeException(e);
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
            g.drawImage(ImageIO.read(new File("src/main/resources/Background/cyberpunk-street.png")), 0, 0, WIDTH, HEIGHT, null);
//            g.fillRect(0, 0, WIDTH, HEIGHT);
        } catch (IOException e) {
            g.setColor(Color.black);
            g.fillRect(0, 0, WIDTH, HEIGHT);
            e.printStackTrace();
        }
        handler.render(g);

        g.dispose();
        bs.show();
    }
}
