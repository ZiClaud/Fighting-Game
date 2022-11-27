package window.UI;

import AI.EasyLevel;
import AI.HardLevel;
import AI.MediumLevel;
import actions.ActionType;
import actions.imgsFactory.Skin;
import characters.CharacterInt;
import characters.Enemy;
import characters.Player;
import events.EventClass;
import events.HealthBar;
import window.game.Game;
import window.game.GameObject.ID;
import window.game.KeyInput;
import window.game.MyHandler;

public class MenuData {
    protected static LevelAI levelAI;
    protected static Skin playerSkin = Skin.Spirit;
    protected static Skin enemySkin = Skin.Devil;

    public MenuData() {

        // TODO: do somewhere - menu

        // TODO: in menu - countdown
        // After countdown
        KeyInput.setCanMove(true);
    }

    public static LevelAI getLevelAI() {
        return levelAI;
    }

    public static void setLevelAI(LevelAI levelAI) {
        MenuData.levelAI = levelAI;
    }

    public static Skin getPlayerSkin() {
        return playerSkin;
    }

    public static void setPlayerSkin(Skin playerSkin) {
        MenuData.playerSkin = playerSkin;
    }

    public static Skin getEnemySkin() {
        return enemySkin;
    }

    public static void setEnemySkin(Skin enemySkin) {
        MenuData.enemySkin = enemySkin;
    }

    public static void setHandlerObjects(MyHandler handler) {
        CharacterInt player = new Player(50, Game.HEIGHT_WINDOW, ID.Player, 100, "Player", playerSkin);
        CharacterInt enemy = new Enemy(Game.WIDTH_WINDOW - 50 - 163, Game.HEIGHT_WINDOW, ID.Enemy, 100, "Enemy", enemySkin);

        player.getAnimatePlayer().addPlayerAction(ActionType.Idle, true);
        enemy.getAnimatePlayer().addPlayerAction(ActionType.Idle, false);

        handler.addObject(player);
        handler.addObject(enemy);
//        handler.addObject(new Player(500, 300, ID.Enemy, 200, 200, 100));  // TODO: USE TO CHECK -> THERE'S NO BUG

        handler.addObject(new HealthBar(50, 50, ID.HealthBarPlayer, player));
        handler.addObject(new HealthBar(Game.WIDTH_WINDOW - 50 - enemy.getHp(), 50, ID.HealthBarEnemy, enemy));

        handler.addObject(new EventClass(handler));

        if (levelAI == LevelAI.PvP) {
            PvP();
        } else if (levelAI == LevelAI.Easy) {
            easyLevelPvE(handler, enemy, player);
        } else if (levelAI == LevelAI.Medium) {
            mediumLevelPvE(handler, enemy, player);
        } else if (levelAI == LevelAI.Hard) {
            hardLevelPvE(handler, enemy, player);
        }
    }

    private static void PvP() {
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
