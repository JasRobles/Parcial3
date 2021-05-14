package com.parcial2.Negocio;

import com.parcial2.DAO.ClsLoguin;
import com.parcial2.Entidades.usuario;

public class Login {
	
	public int acceso(usuario log) {
		int acceso = 0;
		ClsLoguin loguinDao = new ClsLoguin();
		usuario usu = new usuario();
		
		usu=loguinDao.login(log);
		if(usu!=null) {
			if(usu.getId()==1) {
			acceso=1;
			}
	}else {
		System.out.println("Usuario No Valido");
		
	}
		return acceso;
		}
	}
	

