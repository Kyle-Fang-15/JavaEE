package appLayer;

public class User {
    public boolean isValidUserCrendentials(String name, String password){
        if(name.equals("myName") && password.equals("myPassword")){
            return true;
        }
        return false;
    }
}
