package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import modelo.Estudiante;
import modelo.Examen;
import bdatos.AdminDB;

/**
 * Servlet implementation class ControladordePreguntas
 */
@WebServlet("/controladordepreguntas")
public class ControladordePreguntas extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControladordePreguntas() {
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
		Examen examen=(Examen) sesion.getAttribute("examen");
			
		String respuestaest1= request.getParameter("respuesta1");
		String respuestaest2= request.getParameter("respuesta2");
		String respuestaest3= request.getParameter("respuesta3");
		String respuestaest4= request.getParameter("respuesta4");
		String respuestaest5= request.getParameter("respuesta5");
		String respuestaest6= request.getParameter("respuesta6");
		String respuestaest7= request.getParameter("respuesta7");
		String respuestaest8= request.getParameter("respuesta8");
		String respuestaest9= request.getParameter("respuesta9");
		String respuestaest10= request.getParameter("respuesta10");
		
		
       
   ArrayList<String> respuesta = new ArrayList<String>();
   	respuesta.add(respuestaest1);	
   	respuesta.add(respuestaest2);
   	respuesta.add(respuestaest3);
   	respuesta.add(respuestaest4);
   	respuesta.add(respuestaest5);
   	respuesta.add(respuestaest6);
   	respuesta.add(respuestaest7);
   	respuesta.add(respuestaest8);
   	respuesta.add(respuestaest9);
   	respuesta.add(respuestaest10);
    	
   	examen.setRespEst(respuesta);
		
			
		String rc1= examen.getResp().get(0);
		String rc2= examen.getResp().get(1);
		String rc3= examen.getResp().get(2);
		String rc4= examen.getResp().get(3);
		String rc5= examen.getResp().get(4);
		String rc6= examen.getResp().get(5);
		String rc7= examen.getResp().get(6);
		String rc8= examen.getResp().get(7);
		String rc9= examen.getResp().get(8);
		String rc10= examen.getResp().get(9);
		
		System.out.println("Respuesta correcta BD: "+rc1);
	 
		String[] respuestascorrectas={rc1,rc2,rc3,rc4,rc5,rc6,rc7,rc8,rc9,rc10};
		String[] respuestasdelestudiante={respuestaest1,respuestaest2,respuestaest3,respuestaest4,respuestaest5,respuestaest6,respuestaest7,respuestaest8,respuestaest9,respuestaest10};
		
		Estudiante estudiante=(Estudiante) sesion.getAttribute("estudiante");
		sesion.setAttribute("examen", examen);
		
		examen.calificarExamen(respuestascorrectas,respuestasdelestudiante,estudiante,examen);
		
		
		
		
		RequestDispatcher despachador= request.getRequestDispatcher("calificacion.jsp");
		despachador.forward(request, response); 
	}

}
