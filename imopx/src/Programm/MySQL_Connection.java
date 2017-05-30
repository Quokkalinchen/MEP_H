package Programm;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQL_Connection {

    /**
     * Baut eine Verbindung zu einer MySQL-Datenbank auf
     *
     * @param host		   IP-Adresse des Host
     * @param database	Name der Datenbank
     * @param user		   Nutzername f�r Zugriff auf die Datenbank
     * @param passwd	  Entsprechendes Passwort f�r den Nutzernamen
     */
    public static Connection connectToMysql(String host, String database, String user, String passwd) {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            String connectionCommand = "jdbc:mysql://" + host + "/" + database + "?user=" + user + "&password="
                    + passwd + "&useSSL=true";
            return (DriverManager.getConnection(connectionCommand));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return null;
        }
    }
}
