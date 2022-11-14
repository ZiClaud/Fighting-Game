package zGardbage.the_actions;

import zGardbage.the_actions.movement.Facing;
import zGardbage.the_actions.movement.Moving;
import zGardbage.the_actions.fight.Damage;
import zGardbage.the_actions.fight.Attack;
import zGardbage.the_actions.movement.Jump;
import characters.PlayerInterface;
import window.ID;

public class TheAction2 extends TheAction {
    ID id;
    Attack attack;
    Facing facing;
    Jump jump;
    Moving moving;
    Damage damage;

    public TheAction2(PlayerInterface player, ActionType actionType) {
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
