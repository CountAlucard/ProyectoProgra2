
package VampireWargame;

public class Necromancer extends Ficha{
    public static final int codFicha = 3;
    
    public Necromancer(String nameFicha, String colorFicha) 
    {
        super(nameFicha, colorFicha);
        attackDamage = 4;
        healthPoints = 3;
        shieldPoints = 1;
        movements = 1;
    }
            
    private boolean castGhoul(int XposFinal, int YposFinal)
    {
        if(Tablero.pieces[YposFinal][XposFinal]==null){            
                Tablero.pieces[YposFinal][XposFinal]=new Ghoul("GHO"+nameFicha.charAt(3), colorFicha);
                return true;            
       }else 
           return false;
    }
    
    public boolean castGhoul(String castPos)
    {
        String p = ""+castPos.charAt(1);
        int XposFinal = x(castPos.charAt(0));
        int YposFinal = Integer.parseInt(p)-1;
        return castGhoul(XposFinal,YposFinal);
    }
    
    public boolean ultimateAttack(int Xpos, int Ypos, int XposFinal, int YposFinal)
    {
        if(Math.abs(Xpos-XposFinal)>=2 && Math.abs(Ypos-YposFinal)>=2 &&
            Math.abs(Xpos-XposFinal)<=3 && Math.abs(Ypos-YposFinal)<=3 &&
            Tablero.pieces[Ypos][XposFinal]!=null && Tablero.pieces[Ypos][Xpos]!=null){            
            return true;        
        }
        else if(Math.abs(Xpos-XposFinal)>=2 && Math.abs(Xpos-XposFinal)<=3 &&
                Math.abs(Ypos-YposFinal)==0 && Tablero.pieces[YposFinal][XposFinal]!=null &&
                Tablero.pieces[Ypos][Xpos]!=null){            
            return true;        
        }
        else if(Math.abs(Ypos-YposFinal)>=2 && Math.abs(Ypos-YposFinal)<=3&&
                Math.abs(XposFinal-XposFinal)==0 && Tablero.pieces[YposFinal][XposFinal]!=null &&
                Tablero.pieces[Ypos][Xpos]!=null){           
            return true;        
        }
        else{             
            return false;
        }
    }

    @Override
    public int getHealthPoints() {
        return healthPoints;
    }

    
}
