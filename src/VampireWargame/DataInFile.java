
package VampireWargame;

public interface DataInFile {
    boolean createUser(String name, String password);
    void deleteUser(String name, String password);
    void saveGame();
    void loadGame();
    void deleteGame();
    void transferGame();
    void printLogs();
    void printRanking();
}
