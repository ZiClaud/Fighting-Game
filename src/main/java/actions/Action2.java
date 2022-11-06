package actions;

import actions.fight.Damage;
import actions.fight.Attack;
import actions.movement.Facing;
import actions.movement.Jump;
import actions.movement.Moving;
import characters.Player;
import window.ID;

public class Action2 extends Action {
    ID id;
    Attack attack;
    Facing facing;
    Jump jump;
    Moving moving;
    Damage damage;

    public Action2(Player player, ActionType actionType) {
        super(player, actionType);
        this.attack = new Attack(player, actionType);
        this.facing = new Facing(player, actionType);
        this.jump = new Jump(player, actionType);
        this.moving = new Moving(player, actionType, false);
        this.damage = new Damage(player, actionType);
    }

    public Attack getAttack() {
        return attack;
    }

    public void setAttack(Attack attack) {
        this.attack = attack;
    }

    public Facing getFacing() {
        return facing;
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }

    public Jump getJump() {
        return jump;
    }

    public void setJump(Jump jump) {
        this.jump = jump;
    }

    public Moving getMoving() {
        return moving;
    }

    public void setMoving(Moving moving) {
        this.moving = moving;
    }

    public Damage getDamage() {
        return damage;
    }

    public void setDamage(Damage damage) {
        this.damage = damage;
    }
}
