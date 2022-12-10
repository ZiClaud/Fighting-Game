package windows.game;

import events.Events;

import javax.swing.*;
import java.awt.*;

public class GameWindow extends Canvas {
    GraphicsDevice gDevice;

    public GameWindow(int width, int height, String title, Game game) {
        GraphicsEnvironment gEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
        gDevice = gEnvironment.getDefaultScreenDevice();

        JFrame frame = new JFrame(title);
        Events.setGame(game, frame);

        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        game.start();

        //setFullScreen(frame);
    }

    void setFullScreen(JFrame frame) {
        gDevice.setFullScreenWindow(frame);
    }
}
