package model.weapon;

import model.role.IRole;

/*
https://www.cnblogs.com/zzhangkuoo/articles/9199371.html
需求：武器类型与加强系统
设计：
  武器类型：热武器枪支（攻击力100） 和 冷兵器剑（攻击力20）
  加强系统：热武器 枪支可以添加倍镜
           冷兵器剑可以添加蓝宝石（攻击力5/颗）、黄宝石（攻击力10/颗）、红宝石（攻击力15/颗）

*/
public interface IWeapon {
    /**
     * 计算攻击力
     *
     * @return
     */
    public int calculateAttack();

    /**
     * 装备的描述
     *
     * @return
     */
    public String description();
}
