
package VampireWargame;

import java.util.Calendar;

public class Player {
    protected String username, password;
    protected int score = 0;
    protected boolean active;
    protected Calendar createdOn;

    public Player(String username, String password, int sc) {
        this.username = username;
        this.password = password;
        this.createdOn = Calendar.getInstance();
        this.active = true;        
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getScore() {
        return score;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    
    
}
