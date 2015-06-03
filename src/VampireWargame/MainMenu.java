
package VampireWargame;

import java.util.Scanner;

public class MainMenu {      
        
    public static void main(String[] args) 
    {
        
        User us = new User("","");
        Scanner lea = new Scanner(System.in);
        boolean seguir = true, loggedin = true;
        
        try{
            do{

                System.out.println("\n----------------");
                System.out.println("1- Login");
                System.out.println("2- Create Player");
                System.out.println("3- Exit");
                int answer = lea.nextInt();

                switch(answer){
                    case 1:
                        System.out.println("\nUsername: ");
                        String user = lea.next();
                        System.out.println("Password: ");
                        String pass = lea.next();

                        if(us.userExists(user, pass)){

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
                                        System.out.println("-----Vampire Wargame-----");
                                        System.out.println("\n 1- Nueva Partida");
                                        System.out.println("\n 2- Cargar Partida");
                                        System.out.println("\n 3- Eliminar Partida");
                                        System.out.println("\n 4- Transferir Partida");
                                        System.out.println("\n 5- Regresar a Main Menu");

                                        int respg = lea.nextInt();

                                        switch(respg){
                                            case 1:
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
                                                break;
                                            case 4:
                                                break;
                                        }
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
                            System.out.println("\nUsername o Password incorrecto, intente de nuevo.");
                            break;

                    case 2:
                        System.out.println("Ingrese su nuevo username: ");
                        String u = lea.next();
                        System.out.println("Ingrese su password (minimo de 8 caracteres): ");
                        String p = lea.next();

                        if(us.createUser(u, p))
                            System.out.println("Player creado con exito.");
                        else
                            System.err.println("El usuario ya existe, intente de nuevo.");
                        break;
                    case 3:
                        System.exit(0);
                }

            }while(seguir);
        }catch(Exception ex){
            System.out.println("Error: "+ex.getMessage());
        }
    }
    
    
}
