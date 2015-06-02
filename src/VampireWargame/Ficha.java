
package VampireWargame;

public abstract class Ficha {
    protected String nameFicha, colorFicha;
    
    protected int attackDamage, healthPoints, shieldPoints, movements;              

    public Ficha(String nameFicha, String colorFicha) {
        this.nameFicha = nameFicha;
        this.colorFicha = colorFicha;
    }
    
    public int getHealthPoints(){
        return healthPoints;
    }
    
    public boolean validateMovement(int Xpos, int Ypos, int XposFinal, int YposFinal, int mov)
    {             
            if(Ypos<YposFinal && mov>0){
                if(Xpos<XposFinal){                        
                    if(Tablero.pieces[Ypos+1][Xpos+1]==null && Ypos+1<6 && Xpos+1<6)                                                     
                        return validateMovement(Xpos+1,Ypos+1,XposFinal,YposFinal,mov-1);                            
                }
                if(Xpos>XposFinal && mov>0){
                    if(Tablero.pieces[Ypos+1][Xpos-1]==null&&Ypos+1<6&&Xpos-1>=0)                                           
                        return validateMovement(Xpos-1,Ypos+1,XposFinal,YposFinal,mov-1);                            
                }
                if(Xpos==XposFinal && mov>0){
                    if(Tablero.pieces[Ypos+1][Xpos]==null && Ypos+1<6 && mov>0)
                        return validateMovement(Xpos,Ypos+1,XposFinal,YposFinal,mov-1);                   
               }                    
            }            
            
            if(Ypos>YposFinal && mov>0){
                if(Xpos<XposFinal){                        
                    if(Tablero.pieces[Ypos-1][Xpos+1]==null && Ypos-1>=0 && Xpos+1<6)                                               
                        return validateMovement(Xpos+1,Ypos-1,XposFinal,YposFinal,mov-1);                            
                }
                if(Xpos>XposFinal){
                    if(Tablero.pieces[Ypos-1][Xpos-1]==null && Ypos-1>=0 && Xpos-1>=0)                                            
                        return validateMovement(Xpos-1,Ypos-1,XposFinal,YposFinal,mov-1);
                }
                if(Xpos==XposFinal && mov>0){
                    if(Tablero.pieces[Ypos-1][Xpos]==null && Ypos-1>=0)
                        return validateMovement(Xpos,Ypos-1,XposFinal,YposFinal,mov-1);
                }                    
            }            
            
            if(Ypos==Ypos&&mov>0){
                if(Xpos<Xpos){
                    if(Tablero.pieces[Ypos][Xpos+1]==null && Xpos+1<6)
                        return validateMovement(Xpos+1,Ypos,Xpos,Ypos,mov-1);
                }
                if(Xpos>XposFinal){
                    if(Tablero.pieces[Ypos][Xpos-1]==null && Xpos-1>=0)
                        return validateMovement(Xpos-1,Ypos,XposFinal,YposFinal,mov-1);
                }
                if(Xpos==XposFinal && mov>0){
                    return true;
                }
            }
          
          if(Ypos==YposFinal && Xpos==XposFinal){
              return true;
          }else
              return false;
    }
    
    public boolean validateAtack(int Xpos, int Ypos, int XposFinal, int YposFinal)
    {
        if(Math.abs(Xpos-XposFinal)==1 && Math.abs(Ypos-YposFinal)==1 && Tablero.pieces[YposFinal][XposFinal]!=null && Tablero.pieces[Ypos][Xpos]!=null){
            return true;
        }
        else if(Math.abs(Xpos-XposFinal)==0 && Math.abs(Ypos-YposFinal)==1 && Tablero.pieces[YposFinal][XposFinal]!=null && Tablero.pieces[Ypos][Xpos]!=null){
            return true;        
        }
        else if(Math.abs(Xpos-XposFinal)==1 && Math.abs(Ypos-YposFinal)==0 && Tablero.pieces[YposFinal][XposFinal]!=null && Tablero.pieces[Ypos][Xpos]!=null){
            return true;        
        }
        else
            return false;        
    }
    
    
    public int x (char y)
    {
        switch(y){   
            case 'A': return 0;
            case 'B': return 1;
            case 'C': return 2;
            case 'D': return 3;
            case 'E': return 4;
            case 'F': return 5;
            default: return -1;
        }
    }
}
