
package VampireWargame;

public class Vampire extends Ficha{
    public static final int codFicha = 2;

    public Vampire(String nameFicha, String colorFicha)
    {
        super(nameFicha, colorFicha);
        attackDamage = 3;
        healthPoints = 4;
        shieldPoints = 5;
        movements = 1;
    }
    
    public int lifeSteal(int target)
    {
        switch(target){
            case 1:
                return 1;  
            case 2:
                return 1;
            case 3:
                return 1;
            case 4:
                return 1;
        }
        
        return 0;
    }

 
        
}
