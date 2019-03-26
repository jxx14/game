package model.role;

import model.skill.Skill;

import java.util.ArrayList;
import java.util.List;

//军人
public class Soldier implements IRole {

    private int life;
    private int level;
    private int hurt;
    private int Shield;
    private List<Skill>skills;

    public Soldier(int life, int level, int hurt, int shield) {
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
        return "soldier";
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
//            skills =makeSkillsLevelTwo();
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
        List<Skill>skillList =new ArrayList<>();

        Skill windOne =new Skill("windOne",50);
        skillList.add(windOne);

        Skill fireOne =new Skill("fireOne",50);
        skillList.add(fireOne);

        Skill windOneAndFireOne =new Skill("windOneAndFireNoe",50);
        windOneAndFireOne.add(fireOne);
        skillList.add(windOneAndFireOne);

        return skillList;
    }

    private List<Skill> makeSkillsLevelTwo(){
        List<Skill>skillList =new ArrayList<>();

        Skill windOne =new Skill("windOne",50);
        skillList.add(windOne);

        Skill fireOne =new Skill("fireOne",50);
        skillList.add(fireOne);

        Skill windOneAndfireOne =new Skill("windOneAndFireOne",50);
        windOneAndfireOne.add(fireOne);
        skillList.add(windOneAndfireOne);

        Skill windTwo =new Skill("windTwo",100);
        skillList.add(windTwo);

        Skill fireTwo =new Skill("fireTwo",100);
        skillList.add(fireTwo);

        Skill windOneAndFireTwo =new Skill("windOneAndFireTwo",50);
        windOneAndFireTwo.add(fireTwo);
        skillList.add(windOneAndFireTwo);

        Skill windTwoAndFireOne =new Skill("windTwoAndFireOne",100);
        windTwoAndFireOne.add(fireOne);
        skillList.add(windTwoAndFireOne);

        Skill windTwoAndFireTwo=new Skill("windTwoAndFireTwo",100);
        windTwoAndFireTwo.add(fireTwo);
        skillList.add(windTwoAndFireTwo);

        return skillList;
    }

}
