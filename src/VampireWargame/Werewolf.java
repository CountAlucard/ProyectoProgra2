
package VampireWargame;

public class Werewolf extends Ficha{
    public static final int codFicha = 1;

    public Werewolf(String nameFicha, String colorFicha) 
    {
        super(nameFicha, colorFicha);
        attackDamage = 5;
        healthPoints = 5;
        shieldPoints = 2;
        movements = 1;
    }

    
}
