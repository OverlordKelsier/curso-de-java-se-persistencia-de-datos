package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author OVERLORD
 */
public class MensajesDAO {
    
    public static void crearMensajesDB (Mensajes mensaje){
        Conexion conexion = new Conexion();
        try(Connection cnx = conexion.getConnection()){
            PreparedStatement ps = null;
            try{
            String query="INSERT INTO mensajes " + "(mensaje, autor_mensaje) " + "VALUES (?,?);";
            ps = cnx.prepareStatement(query);
            ps.setString(1, mensaje.getMensaje());
            ps.setString(2, mensaje.getAutorMensaje());
            ps.executeUpdate();
            System.out.println("Mensaje creado");
            }catch(SQLException ex){
                System.out.println(ex);
            }            
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public static void leerMensajesDB(){
        
    }
    public static void borrarMensajesDB( int idMensaje){
        
    }
    public static void actualizarMensajesDB(Mensajes mensaje){
        
    }
    
}
