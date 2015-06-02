
package VampireWargame;

import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        User us = new User("","");
        Scanner lea = new Scanner(System.in);
        boolean seguir = true;
        
        do{
        
            System.out.println("1- Login");
            System.out.println("2- Crear Player");
            System.out.println("3- Salir");
            int answer = lea.nextInt();

            switch(answer){
                case 1:
                    System.out.println("Username: ");
                    String user = lea.next();
                    System.out.println("Password: ");
                    String pass = lea.next();

                    if(us.userExists(user, pass)){
                        System.out.println("Log in exitoso");
                        break;
                    }
                    else
                        break;

                case 2:
                    System.out.println("Ingrese su nuevo username: ");
                    String u = lea.next();
                    System.out.println("Ingrese su password (minimo de 8 caracteres): ");
                    String p = lea.next();

                    if(us.createUser(u, p))
                        System.out.println("Player creado con exito.");
                    else
                        System.out.println("El usuario ya existe, intente de nuevo.");
                    break;
                case 3:
                    System.exit(0);
            }
        
        }while(seguir);
        
    }
}
