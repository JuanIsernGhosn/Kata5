/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kata5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author usuario
 */
public class KATA5V10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //Class.forName("oracle.jdbc.driver.OracleDriver"); //Oracle
        
        Class.forName("org.sqlite.JDBC");
        
        //Connection conect = DriverManager.getConnection("jdbc:oracle:thin:@10.22.143.90:1521:orcl", "system", "orcl"); //Oracle
        
        Connection conect = DriverManager.getConnection("jdbc:sqlite:KATA.DB");
        
        Statement state = conect.createStatement();
        
        String query = "SELECT * FROM PEOPLE";
        
        ResultSet rs = state.executeQuery(query);
        
        while (rs.next()) {
            System.out.print(rs.getInt("ID")+": ");            
            System.out.println(rs.getString("NAME"));      
        }
        
        rs.close();
        state.close();
        conect.close();
    }
}
