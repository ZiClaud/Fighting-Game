package window.game;

import music.GameMusic;
import window.UI.MenuData;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;

public class Game extends Canvas implements Runnable {
    private final MyHandler handler;
    private Thread thread;
    private boolean running = false;
    public Game() {
        GameMusic.startGameMusic();
        handler = new MyHandler();
        KeyInput keyInput = new KeyInput(handler);
        this.addKeyListener(keyInput);

        MenuData.setHandlerObjects(handler);

        // Check if it's single player or multiplayer
        keyInput.checkIfAIIsHere();

        /**
         * Keep always at the end!
         */
        // TODO: Remove +37 from HEIGHT - It's there for a temporary bug fix
        new GameWindow(WIDTH_WINDOW, HEIGHT_WINDOW + 37, "Fight!", this);
    }    public static final int WIDTH_WINDOW = 640, HEIGHT_WINDOW = WIDTH_WINDOW / 12 * 9;

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
            g.drawImage(ImageIO.read(new File("src/main/resources/Images/Background/CyberpunkStreet.png")), 0, 0, WIDTH_WINDOW, HEIGHT_WINDOW, null);
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
