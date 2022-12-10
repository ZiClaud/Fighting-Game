package windows;

import AI.EasyLevel;
import AI.HardLevel;
import AI.MediumLevel;
import actions.ActionType;
import actions.box.Skin;
import characters.CharacterInt;
import characters.Enemy;
import characters.Player;
import events.EventClass;
import events.HealthBar;
import windows.game.Game;
import windows.game.GameObject.ID;
import windows.game.KeyInput;
import windows.game.MyHandler;

public class Data {
    protected static Skin playerSkin = Skin.Spirit;
    protected static Skin enemySkin = Skin.Devil;
    private static LevelAI levelAI;

    public Data() {
        // TODO: do somewhere - menu

        // TODO: in menu - countdown
        // After countdown
        KeyInput.setCanMove(true);
    }

    public static LevelAI getLevelAI() {
        return levelAI;
    }

    public static void setLevelAI(LevelAI levelAI) {
        Data.levelAI = levelAI;
    }

    public static Skin getPlayerSkin() {
        return playerSkin;
    }

    public static void setPlayerSkin(Skin playerSkin) {
        Data.playerSkin = playerSkin;
    }

    public static Skin getEnemySkin() {
        return enemySkin;
    }

    public static void setEnemySkin(Skin enemySkin) {
        Data.enemySkin = enemySkin;
    }

    public static void setHandlerObjects(MyHandler handler) {
        CharacterInt player = new Player(50 - playerSkin.getImgWidth() + playerSkin.getActualWidth(), Game.HEIGHT_WINDOW, ID.Player, 100, "Player", playerSkin);
        CharacterInt enemy = new Enemy(Game.WIDTH_WINDOW - 50 - enemySkin.getActualWidth(), Game.HEIGHT_WINDOW, ID.Enemy, 100, "Enemy", enemySkin);

        player.getAnimatePlayer().addPlayerAction(ActionType.Idle, true);
        enemy.getAnimatePlayer().addPlayerAction(ActionType.Idle, false);

        handler.addObject(player);
        handler.addObject(enemy);
//        handler.addObject(new Player(500, 300, ID.Enemy, 200, 200, 100));  // TODO: USE TO CHECK -> THERE'S NO BUG

        handler.addObject(new HealthBar(50, 50, ID.HealthBarPlayer, player));
        handler.addObject(new HealthBar(Game.WIDTH_WINDOW - 50, 50, ID.HealthBarEnemy, enemy));

        handler.addObject(new EventClass(handler));

        switch (levelAI) {
            case PvP:
                break;
            case Easy:
                easyLevelPvE(handler, enemy, player);
                break;
            case Medium:
                mediumLevelPvE(handler, enemy, player);
                break;
            case Hard:
                hardLevelPvE(handler, enemy, player);
                break;
        }
    }

    private static void easyLevelPvE(MyHandler handler, CharacterInt enemy, CharacterInt player) {
        handler.addObject(new EasyLevel(enemy, player));
    }

    private static void mediumLevelPvE(MyHandler handler, CharacterInt enemy, CharacterInt player) {
        handler.addObject(new MediumLevel(enemy, player));
    }

    private static void hardLevelPvE(MyHandler handler, CharacterInt enemy, CharacterInt player) {
        handler.addObject(new HardLevel(enemy, player));
    }
}
