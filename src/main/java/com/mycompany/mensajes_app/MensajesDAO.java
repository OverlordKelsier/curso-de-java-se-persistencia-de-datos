package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            ps.setString(2, mensaje.getAutor_mensaje());
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
       Conexion conexion = new Conexion();
       PreparedStatement ps = null;
       ResultSet rs = null;
        try(Connection cnx = conexion.getConnection()){
            String query="SELECT * FROM mensajes";
            ps = cnx.prepareStatement(query);
            rs = ps.executeQuery();
            
            while(rs.next()){
                System.out.println("ID: " + rs.getInt("id_mensaje"));
                System.out.println("Mensaje: " + rs.getString("mensaje"));
                System.out.println("Autor: " + rs.getString("autor_mensaje"));
                System.out.println("Fecha: " + rs.getString("fecha_mensaje"));
                System.out.println("");
            }
            
            
        }catch(SQLException e){
            System.out.println("No se pudieron recuperar los mensajes");
            System.out.println(e);
        } 
    }
    public static void borrarMensajesDB( int idMensaje){
        Conexion conexion = new Conexion();
        try(Connection cnx = conexion.getConnection()){
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = cnx.prepareStatement(query);
                ps.setInt(1, idMensaje);
                ps.executeUpdate();
                System.out.println("El mensaje ha sido borrado");
            }catch(SQLException ex){
                System.out.println("No se pudo borrar el mensaje");
                System.out.println(ex);
            } 
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    public static void actualizarMensajesDB(Mensajes mensaje){
        Conexion conexion = new Conexion();
        try(Connection cnx = conexion.getConnection()){
            PreparedStatement ps = null;
            try{
                String query= "UPDATE mensajes SET mensaje = ? WHERE mensajes.id_mensaje` = ?";
                ps = cnx.prepareStatement(query);
                ps.setString(1, mensaje.getMensaje());
                ps.setInt(2, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("Mensaje actualizado");
            }catch(SQLException ex){
                System.out.println("No se pudo actualizar el mensaje");
                System.out.println(ex);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
    }
    
}
