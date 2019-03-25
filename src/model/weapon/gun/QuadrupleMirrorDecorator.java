package model.weapon.gun;

import model.weapon.IWeapon;
import model.weapon.IWeaponDecorator;

public class QuadrupleMirrorDecorator implements IWeaponDecorator {

    /**
     * 每个装饰品维护一个装备
     */
    private IWeapon iWeapon;

    public QuadrupleMirrorDecorator(IWeapon iWeapon)
    {
        this.iWeapon = iWeapon;
    }


    @Override
    public int calculateAttack() {
        return 5+iWeapon.calculateAttack();
    }

    @Override
    public String description() {
        return iWeapon.description()+"四倍镜";
    }
}
