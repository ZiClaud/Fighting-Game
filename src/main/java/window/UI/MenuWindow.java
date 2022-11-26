package window.UI;

import window.game.Game;
import window.game.KeyInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow extends JFrame {
    JFrame frame;
    public MenuWindow() {
        Theme.setup();
        Theme.theme();

        JPanel mainPanel = new JPanel();
        JButton btPVP = new JButton("PvP");
        JButton btEasy = new JButton("Easy");
        JButton btMedium = new JButton("Medium");
        JButton btHard = new JButton("Hard");

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
