package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bdatos.AdminDB;
import modelo.Estudiante;
import modelo.Examen;

/**
 * Servlet implementation class Controlador
 */
@WebServlet("/controlador")
public class Controlador extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controlador() {
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
		
		Examen examen=new Examen();
		HttpSession sesion= request.getSession();
		Estudiante estudiante= new Estudiante();
			
		String nombre=request.getParameter("nombre");
		String apellidopaterno=request.getParameter("apellidopaterno");
		String apellidomaterno=request.getParameter("apellidomaterno");
		String matricula=request.getParameter("matricula");
		estudiante.setNombre(nombre);
		estudiante.setApellidoPaterno(apellidopaterno);
		estudiante.setApellidoMaterno(apellidomaterno);
		estudiante.setMatricula(matricula);
		

		 AdminDB admin=new AdminDB(); 
		 admin.conectate(); 
		 admin.Traerpreguntas();
		 
		 examen.setPregun(admin.getPregunta());
		 examen.setOpciona(admin.getOpciona());
		 examen.setOpcionb(admin.getOpcionb());
		 examen.setOpcionc(admin.getOpcionc());
		 examen.setResp(admin.getRespuesta());
		 
		 
		 
		 sesion.setAttribute("examen", examen);
		 sesion.setAttribute("estudiante", estudiante);
				
		RequestDispatcher despachador= request.getRequestDispatcher("crearexamen.jsp");
		despachador.forward(request, response);
		
		
	}

}
