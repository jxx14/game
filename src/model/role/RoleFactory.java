package model.role;

import javax.management.relation.Role;

public class RoleFactory {
    //使用 getRole 方法获取role
    public IRole getRole(String roleKind){
        if(roleKind == null){
            return null;
        }
        if(roleKind.equalsIgnoreCase("hero")){
            return new Hero();
        } else if(roleKind.equalsIgnoreCase("soldier")){
            return new Soldier();
        }
        return null;
    }
}
