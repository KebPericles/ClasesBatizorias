/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basedatos.conexion;

import java.sql.*;
/**
 *
 * @author Keb
 */
public class Conexion {
    public static Connection conectarBD(){
        String url = "jdbc:mysql://localhost:3306/batizorias";
        String username = "root";
        String password = "n0m3l0";
        
        Connection con = null;
        
        try{
            System.out.println("Inicio");
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Clase encontrada");
            con = DriverManager.getConnection(url, username, password);
            System.out.println("Se conecto exitosamente a la BD °u°");
        }catch(ClassNotFoundException | SQLException ebd){
            System.out.println(ebd.getMessage());
            System.out.println(ebd.getStackTrace());
            System.out.println("Error en la conexion a la BD");
        }
        
        return con;
    }
}
