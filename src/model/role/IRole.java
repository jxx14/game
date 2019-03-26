package model.role;

import model.skill.Skill;

public interface IRole {

    public int getHurt();
    public void setHurt(int hurt);

    public int getShield();
    public void setShield(int shield);

    public int getLife();
    public void setLife(int life);

    public int getLevel() ;
    public void setLevel(int level);

    public String getName();

    public Skill getSkill(String skillName);
}
