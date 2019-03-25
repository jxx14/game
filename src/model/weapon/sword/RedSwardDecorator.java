package model.weapon.sword;

import model.weapon.IWeapon;
import model.weapon.IWeaponDecorator;

public class RedSwardDecorator implements IWeaponDecorator {
    /**
     * 每个装饰品维护一个装备
     */
    private IWeapon iWeapon;

    public RedSwardDecorator(IWeapon iWeapon)
    {
        this.iWeapon = iWeapon;
    }

    @Override
    public int calculateAttack() {
        return iWeapon.calculateAttack()+40;
    }

    @Override
    public String description() {
        return iWeapon.description()+"红宝石";
    }
}
