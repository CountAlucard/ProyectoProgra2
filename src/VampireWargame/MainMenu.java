
package VampireWargame;

import java.util.Random;
import java.util.Scanner;

public final class MainMenu {      
        
    public static void main(String[] args) 
    {        
        Tablero tb = new Tablero();
        User us = new User();
        Scanner lea = new Scanner(System.in);
        boolean player1, player2, loggedin, cuenta, game;
        int op;
        
        try{
            do{

                System.out.println("\n-----Welcome to Vampire Wargame-----");
                System.out.println("1- Login");
                System.out.println("2- Create Player");
                System.out.println("3- Exit");
                op = lea.nextInt();

                switch(op){
                    case 1:
                        System.out.println("\nUsername: ");
                        String user = lea.next();
                        System.out.println("Password: ");
                        String pass = lea.next();

                        if(us.userExists(user, pass)){
                            loggedin = true;
                            System.out.println("Log in exitoso");


                            do{
                                System.out.println("\n-----MAIN MENU-----");
                                System.out.println("1- Jugar Vampire Wargame");
                                System.out.println("2- Mi Cuenta");
                                System.out.println("3- Reportes");
                                System.out.println("4- Log Out");

                                int resp = lea.nextInt();

                                switch(resp){
                                    case 1:
                                        System.out.println("\n-----Vampire Wargame-----");
                                        System.out.println("1- Nueva Partida");
                                        System.out.println("2- Cargar Partida");
                                        System.out.println("3- Eliminar Partida");
                                        System.out.println("4- Transferir Partida");
                                        System.out.println("5- Regresar a Main Menu");

                                        int respg = lea.nextInt();

                                        switch(respg){
                                            case 1:
                                                player1 = true;                                                                                                                                        
                                                player2 = true;
                                                game = true;
                                                System.out.println("Ingrese el usuario contrincante: ");
                                                String user2 = lea.next();
                                                
                                                if(us.search(user2)){
                                                    System.out.println("------------------------------");
                                                    tb.Initiate();
                                                    tb.PrintBoard();
                                                    do{
                                                        if(player1){                                                            
                                                            tb.rpieceW = Tablero.pieceW.get(new Random().nextInt(Tablero.pieceW.size()));
                                                            System.out.println("\n"+tb.rpieceW);
                                                            System.out.println("\nPlayer "+user+" ingrese las coordenadas para "+tb.rpieceW+": ");
                                                            int mp1x = lea.nextInt();
                                                            int mp1y = lea.nextInt();
                                                            if(mp1x == -1 && mp1y ==-1){
                                                                System.out.println("Player "+user+" desea retirarse?");
                                                                String ret1 = lea.next();
                                                                if(ret1.equalsIgnoreCase("SI")){
                                                                    System.out.println("El player "+user2+" ha ganado por default.");
                                                                    us.setScore(user2,+3);
                                                                    player2 = false;                                                                    
                                                                    player1 = false;
                                                                    game = false;
                                                                }
                                                            }
                                                            else if(mp1x == -2 && mp1y == -2){
                                                                System.out.println("La partida ha sido guardada.");
                                                                player2 = false;                                                                    
                                                                player1 = false;
                                                                game = false;
                                                            }
                                                            else{
                                                                tb.PrintBoard();
                                                                player1 = false;
                                                            }
                                                        }                                                        
                                                        
                                                        if(player2){
                                                            tb.rpieceB = Tablero.pieceB.get(new Random().nextInt(Tablero.pieceB.size()));
                                                            System.out.println("\n"+tb.rpieceB);
                                                            System.out.println("\nPlayer "+user2+" ingrese las coordenadas para "+tb.rpieceB+": ");
                                                            int mp2x = lea.nextInt();
                                                            int mp2y = lea.nextInt();
                                                            if(mp2x == -1 && mp2y ==-1){
                                                                System.out.println("Player "+user2+" desea retirarse?");
                                                                String ret1 = lea.next();
                                                                if(ret1.equalsIgnoreCase("SI")){
                                                                    System.out.println("El player "+user+" ha ganado por default.");
                                                                    us.setScore(user,+3);
                                                                    player1 = false;                                                                                                                                        
                                                                    player2 = false;
                                                                    game = false;
                                                                }
                                                            }
                                                            else if(mp2x == -2 && mp2y == -2){
                                                                System.out.println("La partida ha sido guardada.");
                                                                player2 = false;                                                                    
                                                                player1 = false;
                                                                game = false;
                                                            }
                                                            else{
                                                                tb.PrintBoard();
                                                                player2 = false;
                                                            }
                                                        }
                                                        
                                                        
                                                    }while(game);
                                                    
                                                }
                                                
                                                break;
                                            case 2:
                                                System.out.println("La opcion estara pronto!");
                                                break;
                                            case 3:
                                                System.out.println("La opcion estara pronto!");
                                                break;
                                            case 4:
                                                System.out.println("La opcion estara pronto!");
                                                break;
                                            case 5:
                                                break;
                                        }

                                        break;
                                    case 2:
                                        do{
                                            cuenta = true;
                                            System.out.println("\n-----MI CUENTA-----");
                                            System.out.println("1- Ver Mi Informacion");
                                            System.out.println("2- Cambiar Password");
                                            System.out.println("3- Cerrar Mi Cuenta");
                                            System.out.println("4- Regresar a Main Menu");

                                            int respc = lea.nextInt();

                                            switch(respc){
                                                case 1:
                                                    us.printInfo(user);
                                                    break;
                                                case 2:
                                                    System.out.println("\n Ingrese su password actual: ");
                                                    String passact = lea.next();

                                                    if(us.searchPassword(user, passact)){
                                                        System.out.println("Ingrese su nueva passowrd: ");
                                                        String newpass = lea.next();

                                                        if(newpass.length() >= 8){
                                                            us.changePassword(user, newpass);
                                                            System.out.println("Password cambiada con exito!");
                                                        }
                                                        else
                                                            System.out.println("La nueva password debe ser de 8 caracteres minimo.");
                                                    }
                                                    else{
                                                        System.out.println("La password ingresada no concuerda con la actual.");
                                                    }
                                                    break;
                                                case 3:
                                                    System.out.println("\n Ingrese su password: ");
                                                    passact = lea.next();

                                                    if(us.searchPassword(user, passact)){
                                                        System.out.println("Esta seguro que desea eliminar su cuenta?");
                                                        String seg = lea.next();
                                                        
                                                        if(seg.equalsIgnoreCase("si")){
                                                            System.out.println("Cuenta eliminada con exito!");
                                                            us.deleteUser(user, pass);    
                                                            cuenta = false;
                                                            loggedin = false;
                                                            break;
                                                        }
                                                    }
                                                    else
                                                        System.out.println("La password ingresada es correcta.");
                                                    break;
                                                case 4:
                                                    cuenta = false;
                                                    break;
                                            }
                                        }while(cuenta);
                                        break;
                                    case 3:
                                        System.out.println("La opcion estara pronto!");
                                        break;
                                    case 4:
                                        loggedin = false;
                                        break;
                                }
                            }while(loggedin);

                        }
                        else
                            System.out.println("\nUsername o Password inexistente, intente de nuevo.");
                        break;

                    case 2:
                        System.out.println("Ingrese su nuevo username: ");
                        String u = lea.next();
                        System.out.println("Ingrese su password (minimo de 8 caracteres): ");
                        String p = lea.next();

                        if(us.createUser(u, p))
                            System.out.println("Player creado con exito.");
                        else if(us.search(u))
                            System.out.println("El usuario ya existe, intente de nuevo.");
                        else if(p.length() <= 8)
                            System.out.println("Password muy corta, intente de nuevo.");
                        break;
                }

            }while(op!=3);
            
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    
}
