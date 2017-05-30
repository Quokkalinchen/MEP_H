package Programm;

import java.io.File;

public class ImpoXiStart implements Runnable {

    public static int fileCounter = 0;
    public static int progressCounter = 0;
    private final String dbUser;
    private final String dbIp;
    private final String dbPw;
    private final String dbName;
    public File dataPath;
    public File[] data;

    @Override
    public void run() {

        Extractor cr = new Extractor();
        data = dataPath.listFiles();
        //Extractor cr = new Extractor();
        cr.connectToMysql(dbIp, dbName, dbUser, dbPw);

        if (dataPath != null && data.length != 0) {
            for (File f : data) {
                if (f.getAbsolutePath().endsWith("CSV")) {
                    String[] strPath = cr.createTable(f.getAbsolutePath(), ';');
                    cr.insertInto(f.getAbsolutePath(), ';', strPath);
                }
            }

        }

        //cr.dropTables();
    }

    public ImpoXiStart(File pathData, String dbUser, String dbIp, String dbPw, String dbName) {

        this.dbUser = dbUser;
        this.dbIp = dbIp;
        this.dbPw = dbPw;
        this.dbName = dbName;

        this.dataPath = pathData;

        data = dataPath.listFiles();
        if (data != null && data.length != 0) {
            for (File file : data) {
                if (file.getAbsolutePath().endsWith("CSV")) {
                    fileCounter++;
                }
            }

        }
    }

}
