package Programm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class configController {

    public static String[] getConfig() {
        String config[] = new String[4];
        String tmp;
        File file = new File("src/Programm/dbConfig");
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            while ((tmp = reader.readLine()) != null) {

                if (tmp.contains("DB-IP")) {
                    config[0] = getBetween(tmp);
                }
                if (tmp.contains("DB-NAME")) {
                    config[1] = getBetween(tmp);
                }
                if (tmp.contains("DB-USER")) {
                    config[2] = getBetween(tmp);
                }
                if (tmp.contains("DB-PASSWORD")) {
                    config[3] = getBetween(tmp);
                }

            }

        } catch (IOException e) {
        }
        return config;
    }

    private static String getBetween(String str) {
        String tmp = "";
        boolean read = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '"') {
                read = !read;
            } else {
                if (read) {
                    tmp += str.charAt(i);
                }
            }
        }
        return tmp;
    }

    public static void setConfig(String[] str) {
        try (FileWriter fw = new FileWriter("src/Programm/dbConfig"); 
                BufferedWriter bw = new BufferedWriter(fw)) {
            bw.write("DB-IP= \"" + str[0] + "\"");
            bw.newLine();
            bw.write("DB-NAME= \"" + str[1] + "\"");
            bw.newLine();
            bw.write("DB-USER= \"" + str[2] + "\"");
            bw.newLine();
            bw.write("DB-PASSWORD= \"" + str[3] + "\"");
            // flush the stream
            bw.flush();
            // close the BufferedWriter object to finish operation
        } catch (IOException e) {
        }
    }

}
