package window.UI;

import actions.imgsFactory.Skin;
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

        JButton btPlayerSkin = new JButton();
        JButton btEnemySkin = new JButton();

        updateSkinBt(btPlayerSkin, btEnemySkin, mainPanel);

        mainPanel.add(btPlayerSkin);
        mainPanel.add(new JPanel());
        mainPanel.add(new JPanel());
        mainPanel.add(btEnemySkin);

        JButton btPVP = new JButton("PvP");
        JButton btEasy = new JButton("Easy");
        JButton btMedium = new JButton("Medium");
        JButton btHard = new JButton("Hard");


        btPlayerSkin.setFocusable(false);
        btEnemySkin.setFocusable(false);

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

        btPlayerSkin.addActionListener(actionEvent -> {
            setPlayerSkin();
            updateSkinBt(btPlayerSkin, btEnemySkin, mainPanel);
        });
        btEnemySkin.addActionListener(actionEvent -> {
            setEnemySkin();
            updateSkinBt(btPlayerSkin, btEnemySkin, mainPanel);
        });
    }

    private void updateSkinBt(JButton btPlayerSkin, JButton btEnemySkin, JPanel mainPanel) {
        try {
            BufferedImage picturePlayer = getPlayerImage(MenuData.getPlayerSkin());
            BufferedImage pictureEnemy = getEnemyImage(MenuData.getEnemySkin());

            btPlayerSkin.setIcon(new ImageIcon(picturePlayer));
            btEnemySkin.setIcon(new ImageIcon(pictureEnemy));

            mainPanel.updateUI();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setPlayerSkin() {
        MenuData.setPlayerSkin(cycleSkin(MenuData.getPlayerSkin()));
    }

    private void setEnemySkin() {
        MenuData.setEnemySkin(cycleSkin(MenuData.getEnemySkin()));
    }

    private Skin cycleSkin(Skin skin) {
        if (skin == Skin.Spirit)
            return Skin.Devil;
        else if (skin == Skin.Devil)
            return Skin.Undead;
        else if (skin == Skin.Undead)
            return Skin.Punk;
        else if (skin == Skin.Punk)
            return Skin.BrawlerGirl;
        else if (skin == Skin.BrawlerGirl)
            return Skin.Spirit;
        MyUtils.printSkinNotFound();
        return null;
    }

    private void newGame(LevelAI level) {
        MenuData.setLevelAI(level);

        new Game();
        frame.setVisible(false);

        countdown();
    }

    private void countdown() {
        // TODO: DO IN GAME -> AFTER COUNTDOWN
        KeyInput.setCanMove(true);
    }

    private BufferedImage getPlayerImage(Skin skin) throws IOException {
        if (skin == Skin.Spirit) {
            return ImageIO.read(new File("src/main/resources/Images/Spirit/Idle/Idle_1.png"));
        } else if (skin == Skin.Undead) {
            return ImageIO.read(new File("src/main/resources/Images/Undead/Idle/Idle_1.png"));
        } else if (skin == Skin.Devil) {
            return ImageIO.read(new File("src/main/resources/Images/Devil/Idle/Idle_1.png"));
        } else if (skin == Skin.Punk) {
            return MyUtils.mirrorImage(ImageIO.read(new File("src/main/resources/Images/Enemy-Punk/Idle/idle1.png")));
        } else if (skin == Skin.BrawlerGirl) {
            return ImageIO.read(new File("src/main/resources/Images/Brawler-Girl/Idle/idle1.png"));
        }
        MyUtils.printSkinNotFound();
        return null;
    }

    private BufferedImage getEnemyImage(Skin skin) throws IOException {
        return MyUtils.mirrorImage(getPlayerImage(skin));
    }
}
