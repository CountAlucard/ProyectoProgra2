
package VampireWargame;

import java.util.ArrayList;
import java.util.Random;

public class Tablero {
    public static Ficha pieces[][] = new Ficha[6][6];
    public static int movement, damage;
    static ArrayList<String> pieceB, pieceW;
    String rpieceB, rpieceW;
           
    public Tablero(){
      pieceB = new ArrayList<>();
      pieceB.add("WW1B");
      pieceB.add("VP1B");
      pieceB.add("NM1B");
      pieceB.add("NM2B");
      pieceB.add("VP2B");
      pieceB.add("WW2B");
      rpieceB = pieceB.get(new Random().nextInt(pieceB.size()));
      
      pieceW = new ArrayList<>();
      pieceW.add("WW1W");
      pieceW.add("VP1W");
      pieceW.add("NM1W");
      pieceW.add("NM2W");
      pieceW.add("VP2W");
      pieceW.add("WW2W");
      rpieceW = pieceW.get(new Random().nextInt(pieceW.size()));
    }
    
    Ficha WW1B = new Werewolf("WW1B", "Black");
    Ficha VP1B = new Vampire("VP1B","Black");
    Ficha NM1B = new Necromancer("NM1B", "Black");
    Ficha NM2B = new Necromancer("NM2B", "Black");
    Ficha VP2B = new Vampire("VP2B", "Black");
    Ficha WW2B = new Werewolf("WW2B", "Black");
    
    Ficha WW1W = new Werewolf("WW1W", "White");
    Ficha VP1W = new Vampire("VP1W","White");
    Ficha NM1W = new Necromancer("NM1W", "White");
    Ficha NM2W = new Necromancer("NM2W", "White");
    Ficha VP2W = new Vampire("VP2W", "White");
    Ficha WW2W = new Werewolf("WW2W", "White");
    
    
    public void Initiate()
    {                   
            pieces[0][0]=WW1B;
            pieces[0][1]=VP1B;
            pieces[0][2]=NM1B;
            pieces[0][3]=NM2B;
            pieces[0][4]=VP2B;
            pieces[0][5]=WW2B;          
                   
        
            pieces[5][0]=WW1W;
            pieces[5][1]=VP1W;
            pieces[5][2]=NM1W;
            pieces[5][3]=NM2W;
            pieces[5][4]=VP2W;
            pieces[5][5]=WW2W;            
    }
    
    public void PrintBoard()
    {       
        System.out.println("  "+"  A  "+"  B  "+"  C  "+"  D  "+"  E  "+"  F  ");
        for(int y=0;y<6;y++){
            System.out.print(y+1+" ");
            for(int x=0;x<6;x++){                                       
                if(pieces[y][x] instanceof Werewolf ){
                    if(((Werewolf)pieces[y][x]).healthPoints<=0){
                        pieces[y][x]=null;                                
                    }
                }
                if(pieces[y][x] instanceof Vampire){
                    if(((Vampire)pieces[y][x]).healthPoints<=0){
                        pieces[y][x]=null;                           
                    }
                }
                if(pieces[y][x] instanceof Necromancer){
                    if(((Necromancer)pieces[y][x]).healthPoints<=0){
                        pieces[y][x]=null;                               
                    }
                }                        
                if(pieces[y][x] instanceof Ghoul){
                    if(((Ghoul)pieces[y][x]).healthPoints<=0){                                    
                        pieces[y][x]=null;                               
                    }
                }                                     
                if(pieces[y][x]!=null){                    
                   System.out.print(pieces[y][x].nameFicha+" ");                        
                }
                else{
                    System.out.print("  -  ");
                }                    
            }
            System.out.println(" ");
        }
      System.out.println(" "); 
    }
    
    public boolean Movement(String iniPos,String finPos)
    {
       String p1= ""+iniPos.charAt(1);
       String p2= ""+finPos.charAt(1);
      
        int Xpos = x(iniPos.charAt(0));
        int Ypos = Integer.parseInt(p1)-1;
        int XposFinal = x(finPos.charAt(0));
        int YposFinal = Integer.parseInt(p2)-1;
        
        if(pieces[Ypos][Xpos] instanceof Werewolf )
            movement =((Werewolf)pieces[Ypos][Xpos]).movements;
                
        if(pieces[Ypos][Xpos] instanceof Vampire)
            movement =((Vampire)pieces[Ypos][Xpos]).movements;
                
        if(pieces[Ypos][Xpos] instanceof Necromancer){
            movement =((Necromancer)pieces[Ypos][Xpos]).movements;
            if(((Necromancer)pieces[Ypos][Xpos]).validateMovement(Xpos, Ypos, Xpos, Ypos, movement)){
               MakeMove(Xpos,Ypos,XposFinal,YposFinal);
               return true;
            }
            else{
               return false;
            }
        }else
        
        if(pieces[Ypos][Xpos].validateMovement(Xpos, Ypos, XposFinal, YposFinal, movement)){
           MakeMove(Xpos, Ypos, XposFinal, YposFinal);
           return true;
        }
        else{
           return false;
        }
           
    }
    
    public void MakeMove(int Xpos,int Ypos,int XposFinal,int YposFinal)
    {
      pieces[YposFinal][XposFinal]=pieces[Ypos][Xpos];
      pieces[Ypos][Xpos]=null;
    }
    
    public int x(char x)
    {
        switch(x){   
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
