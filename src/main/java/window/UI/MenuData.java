package window.UI;

import AI.MediumLevel;
import actions.ActionType;
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

    public static void setHandlerObjects(MyHandler handler) {
        CharacterInt player = new Player(50, Game.HEIGHT_WINDOW, ID.Player, 200, 200, 100, "Player");
        CharacterInt enemy = new Enemy(Game.WIDTH_WINDOW - 50 - 163, Game.HEIGHT_WINDOW, ID.Enemy, 100, 100, 100, "Enemy");

        player.getAnimatePlayer().addPlayerAction(ActionType.Idle, true);
        enemy.getAnimatePlayer().addPlayerAction(ActionType.Idle, false);

        handler.addObject(player);
        handler.addObject(enemy);
//        handler.addObject(new Player(500, 300, ID.Enemy, 200, 200, 100));  // TODO: USE TO CHECK -> THERE'S NO BUG

        handler.addObject(new HealthBar(50, 50, ID.HealthBarPlayer, player));
        handler.addObject(new HealthBar(Game.WIDTH_WINDOW - 50 - enemy.getHp(), 50, ID.HealthBarEnemy, enemy));

        handler.addObject(new EventClass(handler));

        if (levelAI == LevelAI.PvP) {
            PvP(handler, enemy, player);
        }
        else if (levelAI == LevelAI.Easy) {
            //TODO
        }
        else if (levelAI == LevelAI.Medium) {
            mediumLevelPvE(handler , enemy, player);
        }
        else if (levelAI == LevelAI.Hard) {
            //TODO
        }
    }

    private static void PvP(MyHandler handler, CharacterInt enemy, CharacterInt player){
        handler.addObject(new MediumLevel(enemy, player));
    }

    private static void mediumLevelPvE(MyHandler handler, CharacterInt enemy, CharacterInt player){
        handler.addObject(new MediumLevel(enemy, player));
    }
}
