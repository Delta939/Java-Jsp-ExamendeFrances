package control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdatos.AdminDB;
import modelo.Examen;
import modelo.Profesor;

/**
 * Servlet implementation class ControladordeLogin
 */
@WebServlet("/controladordelogin")
public class ControladordeLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminDB admin;
	private Profesor profesor;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladordeLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion= request.getSession();
		
		
		String mensaje=null;
		RequestDispatcher despachador;
		
		String em=request.getParameter("email");
		String pass=request.getParameter("password");
		//profesor.setNumempleado(numempl);
		admin = new AdminDB();
		admin.conectate();
		admin.logindeProfesor();
		
		String email=admin.getEmail();
		String pas=admin.getPassword();
	//	System.out.println("Numero de Empleado AdminDB= "+admin.getNumempleado());
		profesor = new Profesor();
		
		profesor.setEmail(email);
		profesor.setPassword(pas);
		
		sesion.setAttribute("profesor", profesor);
		
		sesion.getAttribute("profesor");
	//	System.out.println("Numero de Empleado Profesor= "+profesor.getNumempleado());
		
		if( profesor.getEmail().equals(em) && profesor.getPassword().equals(pass)){
			 despachador= request.getRequestDispatcher("consultadecalificaciones.jsp");
			despachador.forward(request, response);	
			
		}else{
			mensaje= "Datos inválidos, ingréselos otra vez";
			sesion.setAttribute("mensaje", mensaje);
			despachador= request.getRequestDispatcher("AccesodeProfesor.jsp");
			despachador.forward(request, response);
		}
			
		
		
		
		
		
		
		
	}

}
