
package VampireWargame;

import java.util.ArrayList;

public class User extends Player{
    ArrayList<Player> users;

    public User(String username, String password)
    {
        super(username, password, 0);
        users = new ArrayList<>();
    }
    
    
    public boolean createUser(String user, String pass)
    {
        if(search(user) == null){
            if(pass.length() >= 8){
                users.add(new Player(user,pass,0));            
                return true;
            }
        }
        return false;        
    }
    
    
    public void deleteUser(String user, String pass)
    {
        Player player = search(user);
        if(player != null)
            if(player.getPassword().equals(pass)){                
                player.active = false;
                player = null;
            }
    }
    
    public boolean userExists(String user, String pass){
        if(search(user) != null && searchPassword(pass) != null)
            return true;
        return false;
    }
    
    private Player search(String user)
    {
        for(Player u: users)
            if(u.getUsername().equals(user))
                return u;
        return null;
    }
    
    private Player searchPassword(String pass)
    {
        for(Player u: users)
            if(u.getPassword().equals(pass))
                return u;
        return null;
    }
    
    public void changePassword(String user, String pass)
    {
        Player player = search(user);
        if(player != null)
            if(pass.length() >= 8)
                player.setPassword(pass);        
    }
    

    
    
    
}
