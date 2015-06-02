
package VampireWargame;

public class Ghoul extends Ficha{
    public static final int codFicha = 4;

    public Ghoul(String nameFicha, String colorFicha) {
        super(nameFicha, colorFicha);
        attackDamage = 1;
        healthPoints = 1;
        shieldPoints = 0;
        movements = 0;
    }

    @Override
    public boolean validateAtack(int Xpos, int Ypos, int XposFinal, int YposFinal) 
    {
        return false;
    }

    @Override
    public boolean validateMovement(int mov, int Xpos, int Ypos, int XposFinal, int YposFinal) 
    {
        return false;
    }

    
    
}
