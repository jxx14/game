package model.role;

public class RoleFactory {
    //使用 getRole 方法获取role
    public IRole getRole(String roleKind){
        if(roleKind == null){
            return null;
        }
        if(roleKind.equalsIgnoreCase("hero")){
            return new Hero(300,1,100,100);
        } else if(roleKind.equalsIgnoreCase("soldier")){
            return new Soldier(300,1,100,100);
        }
        return null;
    }
}
