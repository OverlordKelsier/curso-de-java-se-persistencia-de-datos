package com.mycompany.mensajes_app;

import java.util.Scanner;

public class mensajesService {
    public static void crearMensaje (){
        Scanner sc =new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Escribe tu nombre");
        String nombre = sc.nextLine();
        Mensajes registro = new Mensajes();
        registro.setMensaje(mensaje);
        registro.setAutor_mensaje(nombre);
        MensajesDAO.crearMensajesDB(registro);
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }
    public static void borrarMensaje(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Indica el ID del mensaje a borrar");
        int idMensaje = sc.nextInt();
        MensajesDAO.borrarMensajesDB(idMensaje);
    }
    public static void editarMensaje(){
        Scanner sc =new Scanner(System.in);
        System.out.println("Escribe tu mensaje");
        String mensaje = sc.nextLine();
        System.out.println("Escribe el ID del mensaje");
        int idMensaje = sc.nextInt();
        Mensajes act = new Mensajes();
        act.setId_mensaje(idMensaje);
        act.setMensaje(mensaje);
        MensajesDAO.actualizarMensajesDB(act);
    }
}
