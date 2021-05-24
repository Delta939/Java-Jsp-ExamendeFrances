package modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import bdatos.AdminDB;

public class Estudiante {
	private Connection conexion;
	private String nombre;
	private String apellidoPaterno;
	private String apellidoMaterno;
	private String matricula;
	private double calificacion;
		
	public Estudiante(){
		
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public double getCalificacion() {
		return calificacion;
	}

	public void setCalificacion(double calificacion) {
		this.calificacion = calificacion;
	}
	
/*
	 // BUSCAR UN ESTUDIANTE DE LA BASE DE DATOS POR SU MATRICULA	 
	  // @throws ExcepcionNombre
	 
		public Estudiante buscarEstudiante(String matricula){ //throws ExcepcionNombre{///////////////////////////////////////////////////
			String mensaje="Buscando... ";
			conexion=null;
			String ordenSQL=null;
			Statement proposicion=null;
			ResultSet rs=null;
			Estudiante estudiante = new Estudiante();
			//cat= new Categoria();
			AdminDB db=new AdminDB();
			
			mensaje = db.conectate(); 
			
			if(conexion != null){
				try{
			        proposicion = conexion.createStatement(); 
				    rs= proposicion.executeQuery("Select * From estudiante Where matricula= '"+matricula+"';");
		            while(rs.next()){
		            	
		            	estudiante.setNombre(rs.getString(1));
			            estudiante.setApellidoPaterno(rs.getString(2));
			            estudiante.setApellidoMaterno(rs.getString(3));
			            estudiante.setMatricula(rs.getString(4));
			            estudiante.setCalificacion(rs.getDouble(5));
			            
		            }
		            proposicion.close();            
			//	 }catch(ExcepcionNombre en){
			//		 System.out.println(en);
			//	 }catch(ExcepcionApellido ea){
			//		 System.out.println(ea);
				 }catch(SQLException sqle){
					 mensaje=""+sqle.getMessage();
				 }finally{
				   try{
					  conexion.close();
				   }catch(SQLException sqle){
	                  mensaje="falla conexcion";			   
				   }
				 } 
				 
			}else {
				mensaje="clase Estudiante fallo conexion";
			}
			System.out.println(mensaje);
			return estudiante;
		}

	*/
	
	
	
}
