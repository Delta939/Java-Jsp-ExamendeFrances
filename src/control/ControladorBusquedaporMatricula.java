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
import modelo.Estudiante;

/**
 * Servlet implementation class ControladorBusquedaporMatricula
 */
@WebServlet("/controladorbusquedapormatricula")
public class ControladorBusquedaporMatricula extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladorBusquedaporMatricula() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion= request.getSession();
		String mensaje=null;
		String mensajen=null;
		String mensajeap=null;
		String mensajemat=null;
		Double mensajec=0.0;
		RequestDispatcher despachador;
		//Estudiante estudiante=(Estudiante) sesion.getAttribute("estudiante");
		Estudiante estudiante;
		String matricula=request.getParameter("matricula");
		AdminDB admin=new AdminDB();
		admin.conectate();
		estudiante=admin.buscarEstudiante(matricula);
		
		System.out.println("Matricula= "+estudiante.getMatricula());
		System.out.println("Nombre= "+estudiante.getNombre());
		System.out.println("Ap paterno= "+estudiante.getApellidoPaterno());
		System.out.println("Ap materno= "+estudiante.getApellidoMaterno());
		System.out.println("Calificación= "+estudiante.getCalificacion());
		
		sesion.setAttribute("estudiante", estudiante);
		
		
		
		
		if(estudiante.getMatricula().equals(matricula)){
			
			mensajen= estudiante.getNombre();
			sesion.setAttribute("mensajenombre", mensajen);
			
			mensajeap= estudiante.getApellidoPaterno();
			sesion.setAttribute("mensajeapellidopaterno", mensajeap);
			
			mensajemat=estudiante.getMatricula();
			sesion.setAttribute("mensajematricula", mensajemat);
			
			mensajec= estudiante.getCalificacion();
			sesion.setAttribute("mensajecalificacion", mensajec);
			
			despachador= request.getRequestDispatcher("consultadecalificaciones.jsp");
			despachador.forward(request, response);
			
		}else{        
			mensaje= "Matricula inválida, ingrésela otra vez";
			sesion.setAttribute("mensaje", mensaje);
			despachador= request.getRequestDispatcher("consultadecalificaciones.jsp");
			despachador.forward(request, response);
			
		}
		
		
		
		
	}

}
