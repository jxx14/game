package model.weapon.gun;

import model.role.IRole;
import model.weapon.IWeapon;

//枪支
public class Gun implements IWeapon {
//    /**
//     * 每个武器维护一个role
//     */
//    private IRole iRole;
//
//    public Gun(IRole iRole)
//    {
//        this.iRole= iRole;
//    }

    public Gun() {
    }

    @Override
    public int calculateAttack() {
        return 100;
    }

    @Override
    public String description() {
        return "枪支";
    }
}
