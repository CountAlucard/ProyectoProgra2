
package VampireWargame;

public class Necromancer extends Ficha{
    public static final int codFicha = 3;
    
    public Necromancer(String nameFicha, String colorFicha) {
        super(nameFicha, colorFicha);
        attackDamage = 4;
        healthPoints = 3;
        shieldPoints = 1;
        movements = 1;
    }
    
    @Override
    public boolean validateMovement(int Xpos, int Ypos, int XposFinal, int YposFinal, int mov)
    {
        if(Ypos<YposFinal && mov>0){
            if(Xpos<XposFinal){                        
                if(mov==1){
                    if(Tablero.pieces[Ypos+1][Xpos-1]==null && Ypos+1<6 && Xpos-1>=0 && 
                       Ypos+1==YposFinal && Xpos-1==XposFinal || Tablero.pieces[Ypos+1][Xpos-1]==null && 
                       Ypos+1<6 && Xpos-1>=0 && Ypos-1==YposFinal && Xpos+1==XposFinal){                                  
                        mov=0;
                        return true;
                    }                                                     
                }                        
                if(Tablero.pieces[Ypos+1][Xpos+1]==null && Ypos+1<6 && Xpos+1<6){                                                     
                    return validateMovement(Xpos+1, Ypos+1, XposFinal, YposFinal, mov-1);
                }     
            } 

            if(Xpos>XposFinal && mov>0){                        
                if(mov==1){
                    if(Tablero.pieces[Ypos+1][Xpos+1]==null && Ypos+1<6 && Xpos+1<6 &&
                        Ypos+1==YposFinal && Xpos+1==XposFinal || Tablero.pieces[Ypos-1][Xpos-1]==null && 
                        Ypos-1>=0 && Xpos-1>=0 && Ypos-1==YposFinal &&
                        Xpos-1==XposFinal){
                            mov=0;
                            return true;
                    }                                                     
                }
                        
                if(Tablero.pieces[Ypos+1][Xpos-1]==null && Ypos+1<6 && Xpos-1>=0){                                       
                    return validateMovement(Xpos-1, Ypos+1, XposFinal, YposFinal, mov-1);                            
                }
            }

            if(Xpos==XposFinal && mov>0){                      
                if(mov==1){
                    if(Tablero.pieces[Ypos][Xpos-1]==null && Xpos-1>=0 && Ypos==YposFinal && 
                        Xpos-1==XposFinal || Tablero.pieces[Ypos][Xpos+1]==null && Xpos+1<6 &&
                        Ypos==YposFinal && Xpos+1==XposFinal){
                        mov=0;
                        return true;
                    }                           
                                                     
                }                      
                if(Tablero.Arreglo[YposActual+1][XposActual]==null&&YposActual+1<6&&Mov>0){                                            
                    return validarMovieminto(XposActual,YposActual+1,XposDestino,YposDestino,Mov-1);                            
                }
                   
            }
                    
        }
                        
            
            
            if(YposActual>YposDestino&&Mov>0){
                    if(XposActual<XposDestino){
                        
                         if(Mov==1){
                              if(Tablero.Arreglo[YposActual+1][XposActual+1]==null&&YposActual+1<6&&XposActual+1<6
                                      &&YposActual+1==YposDestino&&XposActual+1==XposDestino
                                      ||Tablero.Arreglo[YposActual-1][XposActual-1]==null&&YposActual-1>=0&&XposActual-1>=0
                                      &&YposActual-1==YposDestino&&XposActual-1==XposDestino){
                                        Mov=0;
                                  return true;
                              }                           
                                                     
                                  }
                        
                        if(Tablero.Arreglo[YposActual-1][XposActual+1]==null&&YposActual-1>=0&&XposActual+1<6)
                                               
                            return validarMovieminto(XposActual+1,YposActual-1,XposDestino,YposDestino,Mov-1);
                            
                    }

                    if(XposActual>XposDestino){
                        
                        if(Mov==1){
                              if(Tablero.Arreglo[YposActual-1][XposActual+1]==null&&YposActual-1>=0&&XposActual+1<6
                                      &&YposActual-1==YposDestino&&XposActual+1==XposDestino
                                      ||Tablero.Arreglo[YposActual+1][XposActual-1]==null&&YposActual+1<6&&XposActual-1>=0
                                      &&YposActual+1==YposDestino&&XposActual-1==XposDestino){
                                        Mov=0;
                                  return true;
                              }                           
                                                     
                                  }
                        
                        if(Tablero.Arreglo[YposActual-1][XposActual-1]==null&&YposActual-1>=0&&XposActual-1>=0)
                                            
                            return validarMovieminto(XposActual-1,YposActual-1,XposDestino,YposDestino,Mov-1);
                            
                    }

                    if(XposActual==XposDestino&&Mov>0){
                        
                        if(Mov==1){
                              if(Tablero.Arreglo[YposActual][XposActual-1]==null&&XposActual-1>=0
                                      &&YposActual==YposDestino&&XposActual-1==XposDestino
                                      ||Tablero.Arreglo[YposActual][XposActual+1]==null&&XposActual+1<6
                                      &&YposActual==YposDestino&&XposActual+1==XposDestino){
                                        Mov=0;
                                  return true;
                              }                           
                                                     
                                  }
                        
                        if(Tablero.Arreglo[YposActual-1][XposActual]==null&&YposActual-1>=0)
                                      
                            return validarMovieminto(XposActual,YposActual-1,XposDestino,YposDestino,Mov-1);
                            
                    } 
                   
            }          
                    
            
            
          if(YposActual==YposDestino&&Mov>0){
                    if(XposActual<XposDestino){
                        
                        if(Mov==1){
                              if(Tablero.Arreglo[YposActual+1][XposActual]==null&&YposActual+1<6
                                      &&YposActual+1==YposDestino&&XposActual==XposDestino
                                      ||Tablero.Arreglo[YposActual-1][XposActual]==null&&YposActual-1>=0
                                      &&YposActual-1==YposDestino&&XposActual==XposDestino){
                                       Mov=0;
                                  return true;
                              }                           
                                                     
                                  }
                        
                        if(Tablero.Arreglo[YposActual][XposActual+1]==null&&XposActual+1<6)
                                               
                            return validarMovieminto(XposActual+1,YposActual,XposDestino,YposDestino,Mov-1);
                            
                      }
                    
                    if(XposActual>XposDestino){
                        
                        if(Mov==1){
                              if(Tablero.Arreglo[YposActual+1][XposActual]==null&&YposActual+1<6
                                      &&YposActual+1==YposDestino&&XposActual==XposDestino
                                      ||Tablero.Arreglo[YposActual-1][XposActual]==null&&YposActual-1>=0
                                      &&YposActual-1==YposDestino&&XposActual==XposDestino){
                                        Mov=0;
                                  return true;
                              }                           
                                                     
                                  }
                        
                        if(Tablero.Arreglo[YposActual][XposActual-1]==null&&XposActual-1>=0)
                                    
                            return validarMovieminto(XposActual-1,YposActual,XposDestino,YposDestino,Mov-1);
                            
                    }

                    if(XposActual==XposDestino&&Mov>0){
                        
                        return false;
                            
                    } 
                    
                        
                   
          }
          
          if(YposActual==YposDestino&&XposActual==XposDestino&&Mov<1){
              return true;
          }else
              return false;
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

    
}
