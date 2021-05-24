package modelo;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import bdatos.AdminDB;

public class Examen {
	String respuesta=null; //r=respuesta de estudiante
	private double calificacion = 0;
private	ArrayList<String> pregun;	
private	ArrayList<String> opciona;
private	ArrayList<String> opcionb;
private	ArrayList<String> opcionc;
private	ArrayList<String> resp;
private	ArrayList<String> respEst;

	//int numpregunta[]={1,2,3,4,5,6,7,8,9,10};
	int numpregunta[];
		
 	ArrayList<String> numpreguntavista;
 	ArrayList<String> respuestasdelEstudiante;
 	
 	static int[] num;
 	
 	ArrayList<String> respuestasCorrectas;
	
 	public Examen(){
		 numpregunta=new int[10];
		pregun=new ArrayList<String>(); 
		opciona=new ArrayList<String>();
		opcionb=new ArrayList<String>();
		opcionc=new ArrayList<String>();
		resp=new ArrayList<String>();
		respEst=new ArrayList<String>();
		
		numpreguntavista=new ArrayList<>();
		respuestasdelEstudiante=new ArrayList<>();
		respuestasCorrectas=new ArrayList<>();
		
		
		
		
	}
	
	public int[] generarExamen(int ni,int nf){
		num=new int[10];
		int numeroInicial=ni;
		int numeroFinal=nf;
		
		//int numeroInicial = 1;
		//int numeroFinal = 10;
	    NumeroAleatorios na = new NumeroAleatorios(numeroInicial,numeroFinal);    
	          for(int i = 0; i < (numeroFinal - numeroInicial) + 1;i++){
	            //System.out.print(na.generar()+",");
	        	  num[i]=na.generar();
	        	  
	          }
			return num;
		
	}
	
	public void calificarExamen(String[] respuestacorrecta, String[] respuestadelestudiante,Estudiante estudiante,Examen examen){
		String[] rc=respuestacorrecta;
		String[] re=respuestadelestudiante;
		String respuestac,respuestae;
		
		for(int i=0;i<10;i++){
	
	
				respuestac=rc[i];
					respuestae=re[i];
	
					System.out.println("Caja de respuestas: "+rc[i]+" Caja respondidas:  "+re[i]);
	 
					if(respuestac.equals(respuestae)){
	 
						calificacion++;
						System.out.println("#: "+i+"  respuesta Correcta "+respuestac+" su respuesta  "+respuestae+" calificacion: "+calificacion);
					}
		}
		
		
				
		
		estudiante.setCalificacion(calificacion);
		
		AdminDB ad=new AdminDB();
		ad.agregarEstudiante(estudiante);
		ad.agregarExamen(examen, estudiante);
		
		//assert( cal==0):" :) Prueba Correcta cal es diferente de Cero ";
		System.out.println(":) Calificacion: "+calificacion);
		
		
	}
	
	
	
	public int[] getNumpregunta() {
		return numpregunta;
	}

	public void setNumpregunta(int[] numpregunta) {
		this.numpregunta = numpregunta;
	}

		
	public ArrayList<String> getPregun() {
		return pregun;
	}

	public void setPregun(ArrayList<String> pregun) {
		this.pregun = pregun;
	}
	
	
	

	public ArrayList<String> getOpciona() {
		return opciona;
	}

	public void setOpciona(ArrayList<String> opciona) {
		this.opciona = opciona;
	}

	public ArrayList<String> getOpcionb() {
		return opcionb;
	}

	public void setOpcionb(ArrayList<String> opcionb) {
		this.opcionb = opcionb;
	}

	public ArrayList<String> getOpcionc() {
		return opcionc;
	}

	public void setOpcionc(ArrayList<String> opcionc) {
		this.opcionc = opcionc;
	}

	

	public ArrayList<String> getResp() {
		return resp;
	}

	public void setResp(ArrayList<String> resp) {
		this.resp = resp;
	}

	public ArrayList<String> getRespEst() {
		return respEst;
	}

	public void setRespEst(ArrayList<String> respEst) {
		this.respEst = respEst;
	}

	
	
	public void respuestadeEstudiante(String respuesta){
		this.respuesta=respuesta;
	respuestasdelEstudiante.add(this.respuesta);
	}
	

	


	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	
	
	
	
}
