package model.equipment;

import java.util.ArrayList;
import java.util.List;

public class Equipment {
    private String name;
    private int protect;
    private List<Equipment> equipmentList;

    //构造函数
    public Equipment(String name) {
        this.name = name;
        equipmentList = new ArrayList<Equipment>();
    }

    public void add(Equipment equipment) {
        equipmentList.add(equipment);
    }

    public void remove(Equipment equipment) {
        equipmentList.remove(equipment);
    }

    public List<Equipment> getEquipmentList(){
        return equipmentList;
    }

    public String getName() {
        return name;
    }

    public int getProtect() {
        return protect;
    }

    public void setProtect(int protect) {
        this.protect = protect;
    }


}
