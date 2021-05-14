package com.parcial3.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import com.parcial3.ConexionBd.ConexionBd;
import com.parcial3.Entidades.usuario;



public class ClsLoguin {
	ConexionBd con = new ConexionBd();
    Connection coneccion = con.retornarConexion();
   
    
	public usuario login(usuario user) {

        usuario usuar = new usuario();
        try {
            CallableStatement call = coneccion.prepareCall("Call SP_S_LOGIN(?,?)");
            call.setString("pUsuario", user.getNombre());
            call.setString("pContrasena", user.getContrasena());
            ResultSet resul = call.executeQuery();
            while (resul.next()) {
            	usuar.setId(resul.getInt("Id"));
                usuar.setNombre(resul.getString("Nombre"));
                usuar.setContrasena(resul.getString("Contrasena"));
                
                 }
            
            coneccion.close();

        } catch (Exception e) {
            System.out.println("Error" + e);
        }
      
        return usuar;
        
    }
}
