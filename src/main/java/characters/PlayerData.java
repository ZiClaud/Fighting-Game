package characters;

import actions.Action;

public class PlayerData {
    Player player;
    private final PlayerImage playerImage;
    private final PlayerSize size;
    private final Action action;
    private final AnimatePlayer animatePlayer;

    public PlayerData(Player player, int playerWidth, int playerHeight) {
        this.player = player;

        this.size = new PlayerSize(playerWidth, playerHeight);
        this.playerImage = new PlayerImage();

        this.action = new Action(this);
        this.animatePlayer = new AnimatePlayer(this);

        animatePlayer.animatePlayer();
    }

    public Player getPlayer() {
        return player;
    }

    public PlayerImage getPlayerImage() {
        return playerImage;
    }


    public PlayerSize getSize() {
        return size;
    }

    public Action getAction() {
        return action;
    }
}
