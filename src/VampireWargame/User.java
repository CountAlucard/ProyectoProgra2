package VampireWargame;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Date;

public class User implements DataInFile {

    RandomAccessFile players;

    public User() {
        try {
            players = new RandomAccessFile("players.vwg", "rw");
        } catch (IOException e) {
            System.out.println("This shouldn't happen!");
        }
    }

    //Funcion que creara una nueva entrada en el archivo players.vwg y creara un folder del mismo.
    @Override
    public final boolean createUser(String user, String pass) {
        if (search(user) == null) {
            if (pass.length() >= 8) {
                new File(user).mkdir();
                try {
                    create(user, pass);
                } catch (IOException e) {
                    System.out.println("This won't happen.");
                }
                return true;
            }
        }
        return false;
    }

    //Funcion que eliminara el folder de x Usuario.
    @Override
    public final void deleteUser(String user, String pass) {
        try {
            if (search(user) != null) {

                if (players.readUTF().equals(pass)) {
                    players.readInt();
                    players.readLong();
                    players.writeBoolean(false);
                    deleteFiles(user);
                }
            }
        } catch (IOException e) {
            System.out.println("");
        }
    }

    public void setScore(String user, int nscore) {
        try {
            if (search(user) != null) {

                players.readUTF();
                int score = players.readInt();
                players.seek(players.getFilePointer() - 4);
                players.writeInt(score + nscore);
            }
        } catch (IOException e) {
            System.out.println("");
        }

    }

    //Funcion para validar que el usuario exista en el archivo players.vwg
    public boolean userExists(String user, String pass) {
        try {
            if (search(user) != null) {
                if (players.readUTF().equals(pass)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("");
        }
        return false;
    }

    //Funcion search para encontrar x usuario en el archivo players.vwg
    public String search(String user) {
        try {
            players.seek(0);
            while (players.getFilePointer() < players.length()) {

                if (players.readUTF().equals(user)) {

                    return user;
                }
                players.readUTF();
                players.readInt();
                players.readLong();
                players.readBoolean();
            }
        } catch (IOException e) {
            System.out.println("");
        }
        return null;
    }

    //Funcion para validar la password de un usuario en el archivo players.vwg
    public boolean searchPassword(String user, String pass) {
        try {
            if (search(user) != null) {

                if (players.readUTF().equals(pass)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("");
        }
        return false;
    }

    //Funcion que permite cambiar la password en el archivo players.vwg
    public void changePassword(String user, String pass) {
        if (search(user) != null) {
            if (pass.length() >= 8) {
                try {

                    players.writeUTF(pass);
                } catch (IOException e) {
                    System.out.println("");
                }
            }
        }
    }

    //Funcion para imprimir todos los datos de x usuario del archivo players.vwg
    public void printInfo(String user) {
        String activa;
        try {
            players.seek(0);
            String usern = search(user);
            String pass = players.readUTF();
            int score = players.readInt();
            String current = new Date(players.readLong()).toString();
            boolean active = players.readBoolean();

            if (active == true) {
                activa = "Inactiva";
            } else {
                activa = "Activa";
            }

            System.out.println("\nUsername: " + usern + "\nPassword: " + pass
                    + "\nScore: " + score + "\nFecha de Creacion: " + current
                    + "\nEstado: " + activa);

        } catch (IOException e) {
            System.out.println("");
        }
    }

    private void create(String u, String p) throws IOException {
        players.seek(players.length());
        players.writeUTF(u);
        players.writeUTF(p);
        players.writeInt(0);
        players.writeLong(new Date().getTime());
        players.writeBoolean(true);
    }

    //Funcion que permite eliminar archivos dentro de un Folder.
    private void deleteFiles(String user) {
        File index = new File(user);
        String[] entries = index.list();
        for (String s : entries) {
            File currentFile = new File(index.getPath(), s);
            currentFile.delete();
        }
        index.delete();
    }

    @Override
    public void saveGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void loadGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void deleteGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void transferGame() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printLogs() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void printRanking() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
