package com.parcial3.Controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import com.parcial3.DAO.Usuario;
import com.parcial3.Entidades.usuario;
import com.parcial3.Negocio.Login;



/**
 * Servlet implementation class ControllerLoguin
 */
@WebServlet("/ControllerLoguin")
public class ControllerLoguin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControllerLoguin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		
		
			String user = request.getParameter("Nombre");
			String pass = request.getParameter("Contrasena");
			
			usuario log = new usuario();
			log.setNombre(user);
			log.setContrasena(pass);
			
			Login clsL = new Login();
			int valordeacceso=clsL.acceso(log);
			
			if(valordeacceso == 1)
			{
				System.out.println("WELCOME");
				Usuario cls = new Usuario();
				ArrayList<usuario> clsuser = new ArrayList<usuario>();
				response.sendRedirect("Bienvenido.jsp");
				for (var iteracion:cls.MostrarUsuario()) {
					usuario usua = new usuario();
					usua.setId(iteracion.getId());
					usua.setNombre(iteracion.getNombre());
					usua.setContrasena(iteracion.getContrasena());
					clsuser.add(usua);
				}
				
			
				
			}else {
				System.out.println("ERROR");
				response.sendRedirect("error.jsp");
			}
			
			
			Usuario usu = new Usuario();
			Gson json = new Gson();
			response.getWriter().append(json.toJson(usu.MostrarUsuario()));
		}

}
