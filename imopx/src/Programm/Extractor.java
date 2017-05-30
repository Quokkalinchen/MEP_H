package Programm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Diese Klasse dient dazu die CSV Daten in unsere Datenbank zu �bertragen
 *
 * @author MedIT's
 *
 */
public class Extractor {

    private Connection con;
    private String tableName[] = new String[15];
    private int tableNamecounter = 0;

    /**
     * Baut eine Verbindung zu einer MySQL-Datenbank auf
     *
     * @param host		   IP-Adresse des Host
     * @param database	Name der Datenbank
     * @param user		   Nutzername f�r Zugriff auf die Datenbank
     * @param passwd	  Entsprechendes Passwort f�r den Nutzernamen
     */
    public void connectToMysql(String host, String database, String user, String passwd) {
       con= MySQL_Connection.connectToMysql(host, database, user, passwd);
    }

    /**
     * Erstellt dynamisch eine Tabelle in der Datenbank
     *
     * @param path		    Pfad der Datei
     * @param seperator	Trennzeichen
     *
     * @return
     */
    public String[] createTable(String path, char seperator) {

        String csv = "";

        File file = new File(path);
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            csv = reader.readLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        path = path.replace('\\', '/');
        String fileName = path.substring(path.lastIndexOf('/') + 1, path.length());
        String fileNameWithoutExtn = fileName.substring(0, fileName.lastIndexOf('.'));
        tableName[tableNamecounter] = fileNameWithoutExtn;
        tableNamecounter++;

        csv = csv.replace('-', '_');
        String createString = "create table " + fileNameWithoutExtn + " (";

        int counter = 1;
        for (int i = 0; i < csv.length(); i++) {
            if (csv.charAt(i) == seperator) {
                counter++;
            }
        }

        String columnNames[] = new String[counter];
        String tmp = "";
        counter = 0;

        for (int i = 0; i < csv.length(); i++) {
            if (csv.charAt(i) == seperator) {
                for (int j = counter - 1; j >= 0; j--) {
                    if (counter != 0) {
                        if (tmp.equals(columnNames[j])) {
                            tmp += "2";
                        }
                    }
                }
                columnNames[counter] = tmp;
                counter++;
                tmp = "";
            } else {
                tmp += csv.charAt(i);
            }
        }
        for (int j = counter - 1; j >= 0; j--) {
            if (counter != 0) {
                if (tmp.equals(columnNames[j])) {
                    tmp += "2";
                }
            }
        }
        columnNames[columnNames.length - 1] = tmp;
        counter++;

        for (int i = 0; i < columnNames.length - 1; i++) {
            createString += columnNames[i] + " VARCHAR(50), ";
        }

        createString += columnNames[columnNames.length - 1] + " VARCHAR(50))";

        try (Statement stmt = con.createStatement()) {
            stmt.executeUpdate(createString);
        } catch (SQLException e) {
            try {
                Statement stmt = con.createStatement();
                stmt.executeUpdate("DROP TABLE " + fileNameWithoutExtn);
                stmt.executeUpdate(createString);
                stmt.close();
                System.out.println("Tabelle " + fileNameWithoutExtn + " exestiert schon und wurde neu angelegt");
            } catch (SQLException i) {
                e.printStackTrace();
            }

        }
        return columnNames;
    }

    /**
     * F�gt Datens�tze in die Datenbanktabellen ein
     *
     * @param path			     Pfad der zu importierenden Daten
     * @param seperator		 Trennelement der Daten
     * @param columnNames	Spaltennamen der Tabelle
     */
    public void insertInto(String path, char seperator, String columnNames[]) {

        path = path.replace('\\', '/');
        String fileName = path.substring(path.lastIndexOf('/') + 1, path.length());
        String fileNameWithoutExtn = fileName.substring(0, fileName.lastIndexOf('.'));

        Statement stmt;
        try {
            stmt = con.createStatement();

            String sql = " LOAD DATA LOCAL INFILE '" + path
                    + "' INTO TABLE " + fileNameWithoutExtn
                    + " FIELDS TERMINATED BY \'" + seperator + "\'"
                    + " LINES TERMINATED BY \'\\n\'" + "IGNORE 1 LINES";

            stmt.execute(sql);
        } catch (SQLException e) {
            //TODO: actual exception handling
        }
        ImpoXiStart.progressCounter++;
    }

    /**
     * L�scht erstellte Tabelle aus der Datenbank nachdem der Load-Prozess abgeschlossen ist
     */
    public void dropTables() {

        try {
            Statement stmt = con.createStatement();
            for (int i = 0; i <= tableNamecounter - 1; i++) {
                stmt.executeUpdate("DROP TABLE " + tableName[i]);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
