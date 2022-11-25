package window.UI;

import window.game.Game;
import window.game.KeyInput;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuWindow2 extends JFrame {
    private JButton btPVP = new JButton();
    private JButton btEasy = new JButton();
    private JButton btMedium = new JButton();
    private JButton btHard = new JButton();
    private JPanel mainPanel = new JPanel();

    public MenuWindow2() {
        mainPanel.add(btPVP);
        mainPanel.add(btEasy);
        mainPanel.add(btMedium);
        mainPanel.add(btHard);

        JFrame frame = new JFrame("title");

        frame.setPreferredSize(new Dimension(Game.WIDTH_WINDOW, Game.HEIGHT_WINDOW));
        frame.setMaximumSize(new Dimension(Game.WIDTH_WINDOW, Game.HEIGHT_WINDOW));
        frame.setMinimumSize(new Dimension(Game.WIDTH_WINDOW, Game.HEIGHT_WINDOW));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(mainPanel);
        frame.setVisible(true);

        btPVP.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                newGame(LevelAI.PvP);            }
        });

        btEasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                newGame(LevelAI.Easy);            }
        });

        btMedium.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                newGame(LevelAI.Medium);            }
        });

        btHard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                newGame(LevelAI.Hard);
            }
        });
    }

    private void newGame(LevelAI level) {
        MenuData.setLevelAI(level);

        new Game();

        setVisible(false);


        KeyInput.setCanMove(true);
    }
}
