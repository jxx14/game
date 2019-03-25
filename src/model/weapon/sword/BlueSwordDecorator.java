package model.weapon.sword;

import model.weapon.IWeapon;
import model.weapon.IWeaponDecorator;

public class BlueSwordDecorator implements IWeaponDecorator {
    /**
     * 每个装饰品维护一个装备
     */
    private IWeapon iWeapon;

    public BlueSwordDecorator(IWeapon iWeapon)
    {
        this.iWeapon = iWeapon;
    }


    @Override
    public int calculateAttack() {
        return 20+iWeapon.calculateAttack();
    }

    @Override
    public String description() {
        return iWeapon.description()+"蓝宝石";
    }
}
