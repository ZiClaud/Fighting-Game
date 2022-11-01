package window;

import UI.Healthbar;
import characters.Player;

import java.awt.*;
import java.awt.image.BufferStrategy;

public class Game extends Canvas implements Runnable {
    private final MyHandler handler;    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Thread thread;
    private boolean running = false;

    public Game() {
        handler = new MyHandler();
        this.addKeyListener(new KeyInput(handler));

        handler.addObject(new Player(200, 200, ID.Player, 32, 32, 100));
        handler.addObject(new Player(400, 200, ID.Enemy, 50, 20, 100));
        handler.addObject(new Healthbar(50, 50, ID.HealthBarPlayer, handler));
        handler.addObject(new Healthbar(HEIGHT - 50, WIDTH - 50, ID.HealthBarPlayer, handler));

        /**
         * Keep always at the end!
         */
        new MyWindow(WIDTH, HEIGHT, "Let's build a game!", this);
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
/*
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1
*/

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

        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);

        handler.render(g);

        g.dispose();
        bs.show();
    }


}
