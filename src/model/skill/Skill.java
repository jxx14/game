package model.skill;

import java.util.ArrayList;
import java.util.List;

public class Skill {
    private String name;
    private int level;
    private int hurt;
    private List<Skill> skills;

    //构造函数
    public Skill(String name,int hurt) {
        this.name = name;
        this.hurt =hurt;
        skills = new ArrayList<Skill>();
    }

    public void add(Skill skill) {
        skills.add(skill);
    }

    public void remove(Skill skill) {
        skills.remove(skill);
    }

    public List<Skill> getSkills(){
        return skills;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getHurt() {
        return hurt;
    }

    public void setHurt(int hurt) {
        this.hurt = hurt;
    }


}
