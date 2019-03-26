package model.role;

import model.skill.Skill;

import java.util.ArrayList;
import java.util.List;

public class Hero implements IRole {

    private int life;
    private int level;
    private int hurt;
    private int Shield;
    private List<Skill>skills;

    public Hero(int life, int level, int hurt, int shield ) {
        this.life = life;
        this.level = level;
        this.hurt = hurt;
        this.Shield = shield;
//        this.skills = makeSkillsLevelOne();
        this.skills = makeSkillsLevelTwo();

    }

    @Override
    public int getLife() {
        return life;
    }

    @Override
    public void setLife(int life) {
        this.life = life;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String getName() {
        return "hero";
    }

    @Override
    public int getHurt() {
        return hurt;
    }

    @Override
    public void setHurt(int hurt) {
        this.hurt = hurt;
    }

    @Override
    public int getShield() {
        return Shield;
    }

    public void setShield(int shield) {
        Shield = shield;
    }

    @Override
    public Skill getSkill(String skillName) {
//        if (level==2){
//            skills = makeSkillsLevelTwo();
//        }
        int index = 0;
        for (int i = 0; i <skills.size() ; i++) {
            if (skillName.equalsIgnoreCase(skills.get(i).getName())){
                index = i;
                break;
            }
        }

        return skills.get(index);
    }

    private List<Skill> makeSkillsLevelOne(){
        List<Skill>skillList =new  ArrayList<>();

        Skill windOne =new Skill("windOne",50);
        skillList.add(windOne);

        Skill dirtOne =new Skill("dirtOne",50);
        skillList.add(dirtOne);

        Skill windOneAndDirtOne =new Skill("windOne",50);
        windOneAndDirtOne.add(dirtOne);
        skillList.add(windOneAndDirtOne);

        return skillList;
    }

    private List<Skill> makeSkillsLevelTwo(){
        List<Skill>skillList =new  ArrayList<>();

        Skill windOne =new Skill("windOne",50);
        skillList.add(windOne);

        Skill dirtOne =new Skill("dirtOne",50);
        skillList.add(dirtOne);

        Skill windOneAndDirtOne =new Skill("windOne",50);
        windOneAndDirtOne.add(dirtOne);
        skillList.add(windOneAndDirtOne);

        Skill windTwo =new Skill("windTwo",100);
        skillList.add(windTwo);

        Skill dirtTwo =new Skill("dirtTwo",100);
        skillList.add(dirtTwo);

        //        "一级风技能，二级土技能", "b");
        Skill windOneAndDirtTwo =new Skill("windOne",50);
        windOneAndDirtTwo.add(dirtTwo);
        skillList.add(windOneAndDirtTwo);

//        "二级风技能，一级土技能", "d");
        Skill windTwoAndDirtOne =new Skill("windTwo",100);
        windTwoAndDirtOne.add(dirtOne);
        skillList.add(windTwoAndDirtOne);

//       ("二级土技能，二级风技能", "b");
        Skill windTwoAndDirtTwo=new Skill("windTwo",100);
        windTwoAndDirtTwo.add(dirtTwo);
        skillList.add(windTwoAndDirtTwo);

        return skillList;
    }
}
