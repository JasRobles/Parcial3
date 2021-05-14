package com.parcial3.DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import com.parcial3.Entidades.*;
import com.parcial3.ConexionBd.ConexionBd;


public class Usuario {

	ConexionBd con = new ConexionBd();
    Connection conectar = con.retornarConexion();

    public ArrayList<usuario> MostrarUsuario() {
        ArrayList<usuario> lista = new ArrayList<>();
        try {
            CallableStatement call = conectar.prepareCall("select * from usuario");
            ResultSet resultado = call.executeQuery();
            while (resultado.next()) {
            	usuario usu = new usuario();
            	usu.setId(resultado.getInt("Id"));
            	usu.setNombre(resultado.getString("Nombre"));
            	usu.setContrasena(resultado.getString("Contrasena"));
                lista.add(usu);
            }
        } catch (Exception e) {
            System.out.println("Error" + e);
        }

        return lista;
    }
}
