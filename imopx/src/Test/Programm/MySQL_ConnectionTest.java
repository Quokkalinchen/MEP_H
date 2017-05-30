/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test.Programm;

import Programm.MySQL_Connection;
import java.sql.Connection;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tim Pontzen
 */
public class MySQL_ConnectionTest {

    public MySQL_ConnectionTest() {
    }

    @Test
    public void testConnection() {
        //wrong init
        Connection con
                = MySQL_Connection.connectToMysql("", "", "", "");
        assertNull(con);
        //correct init
        //TODO: fill with actual data
        con= MySQL_Connection.connectToMysql("", "", "", "");
        assertNotNull(con);

    }

}
