package window.UI;

import music.GameMusic;
import utils.MyUtils;
import window.game.Game;
import window.game.KeyInput;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MenuWindow extends JFrame {
    JFrame frame;

    public MenuWindow() {
        GameMusic.startMenuMusic();
        Theme.setup();
        Theme.theme();

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 4));
        try {
            BufferedImage myPicture1 = ImageIO.read(new File("src/main/resources/Images/Spirit/Idle/Idle_1.png"));
            BufferedImage myPicture2 = ImageIO.read(new File("src/main/resources/Images/Undead/Idle/Idle_1.png"));
            myPicture2 = MyUtils.mirrorImage(myPicture2);
            mainPanel.add(new JLabel(new ImageIcon(myPicture1)));
            mainPanel.add(new JPanel());
            mainPanel.add(new JPanel());
            mainPanel.add(new JLabel(new ImageIcon(myPicture2)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        JButton btPVP = new JButton("PvP");
        JButton btEasy = new JButton("Easy");
        JButton btMedium = new JButton("Medium");
        JButton btHard = new JButton("Hard");

        btPVP.setFocusable(false);
        btEasy.setFocusable(false);
        btMedium.setFocusable(false);
        btHard.setFocusable(false);

        mainPanel.add(btPVP);
        mainPanel.add(btEasy);
        mainPanel.add(btMedium);
        mainPanel.add(btHard);

        frame = new JFrame("");

        frame.setPreferredSize(new Dimension(Game.WIDTH_WINDOW, Game.HEIGHT_WINDOW));
        frame.setMaximumSize(new Dimension(Game.WIDTH_WINDOW, Game.HEIGHT_WINDOW));
        frame.setMinimumSize(new Dimension(Game.WIDTH_WINDOW, Game.HEIGHT_WINDOW));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(mainPanel);
        frame.setVisible(true);

        btPVP.addActionListener(actionEvent -> newGame(LevelAI.PvP));

        btEasy.addActionListener(actionEvent -> newGame(LevelAI.Easy));

        btMedium.addActionListener(actionEvent -> newGame(LevelAI.Medium));

        btHard.addActionListener(actionEvent -> newGame(LevelAI.Hard));
    }

    private void newGame(LevelAI level) {
        MenuData.setLevelAI(level);

        // TODO: DO IN GAME -> AFTER COUNTDOWN
        KeyInput.setCanMove(true);

        new Game();

        frame.setVisible(false);
    }
}
