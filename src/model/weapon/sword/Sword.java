package model.weapon.sword;

import model.role.IRole;
import model.weapon.IWeapon;
//每个装饰品维护一个武器，每个武器对role来讲也是一个装饰品，所以每个武器需要维护一个role
public class Sword implements IWeapon {

//    /**
//     * 每个武器维护一个role
//     */
//    private IRole iRole;
//
//    public Sword(IRole iRole)
//    {
//        this.iRole= iRole;
//    }

    @Override
    public int calculateAttack() {
        return 50;
    }

    @Override
    public String description() {
        return "剑";
    }
}
