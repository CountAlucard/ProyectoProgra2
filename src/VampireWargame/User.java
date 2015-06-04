
package VampireWargame;

import java.util.ArrayList;

public class User extends Player implements DataInMemory{
    ArrayList<Player> users;

    public User(String username, String password)
    {
        super(username, password);
        users = new ArrayList<>();
    }
    
    
    @Override
    public boolean createUser(String user, String pass)
    {
        if(search(user) == null){
            if(pass.length() >= 8){
                users.add(new Player(user,pass));            
                return true;
            }
        }
        return false;        
    }
    
    
    @Override
    public void deleteUser(String user, String pass)
    {
        Player player = search(user);
        if(player != null)
            if(player.getPassword().equals(pass)){                
                player.active = false;
                users.remove(player);
            }
    }
    
    public final boolean userExists(String user, String pass)
    {
        if(search(user) != null && searchPassword(user, pass) != false)
            return true;
        return false;
    }
    
    
    public Player search(String user)
    {
        for(Player u: users)
            if(u.getUsername().equals(user))
                return u;
        return null;
    }
    
    public boolean searchPassword(String user1, String pass)
    {
        Player player = search(user1);
        if(player.getPassword().equals(pass))
            return true;
        return false;
    }
    
    public void changePassword(String user, String pass)
    {
        Player player = search(user);
        if(player != null)
            if(pass.length() >= 8)
                player.setPassword(pass);        
    }
    
    public void printInfo(String user)
    {        
        Player player = search(user);
        System.out.println("Username: "+player.getUsername()+"\nCreated on: "+player.createdOn.getTime()+"\nScore: "+player.getScore());
    }

    @Override
    public void saveGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transferGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printLogs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printRanking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
