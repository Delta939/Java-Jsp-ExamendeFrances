package bdatos;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import modelo.*;

public class AdminDB {
	private Connection conexion;
	private ResultSet resultado;
	private String controladorBD;
	private String host;
	private String puerto;
	private String baseDatos;
	private String url;
	private String usuario;
	private String contra;
	private Statement proposicion=null;
	private int num_pregunta;
	private int numaleatorios[]; // Arreglo de Numeros Aleatorios
	private String respondidas;
	private ArrayList<String> cajarespondidas;
	private String numempleado;
	private String email;
	private String password;
	private ArrayList<String> pregunta;
	private ArrayList<String> opciona;
	private ArrayList<String> opcionb;
	private ArrayList<String> opcionc;
	private ArrayList<String> respuesta;

private int numpregunta[];

	
	Statement sentencia;
	Examen examen;
	private Estudiante estudiante;
/**
 * AdminDB
 * Guarda los datos que se van a usar para hacer la conexion	
 */
	public AdminDB(){
		numaleatorios=new int[10];// numero Aleatorio Random
		examen=new Examen();
		numaleatorios=examen.generarExamen(1,10);
		
		controladorBD= "org.postgresql.Driver";
		host= "localhost";
		puerto = "5432";
		baseDatos="examen";
		url ="jdbc:postgresql://"+host+":"+puerto+"/"+baseDatos;
		usuario="postgres";
		//contra="p057gr35";
		contra="12345";
		resultado=null;
		conexion =null;
	}
/**
 * Metodo conectate(), hace la conexion a la base de datos	
 */
	public String conectate(){
       String mensaje="Conectando...";
       try{
    	   Class.forName(controladorBD);
	   }catch(ClassNotFoundException cnfe){
		  mensaje="No se hallo el controlador de PostgreSQL";
	   } 
       try{
 	       conexion=DriverManager.getConnection(url,usuario,contra);
 	 
       }catch(SQLException sqe){
    	   System.out.println(sqe.getMessage());
    	   mensaje ="AdminDB conexion Fallo"; 
       }
       return mensaje;
    }
//------------------------------------------------------------------------------------------
			
	public String Traerpreguntas(){
		String mensaje="Buscando preguntas";
				try{

				  for(int i=0;i<10;i++){
						System.out.println("#"+i+" Numero Aleatorio: "+numaleatorios[i]);
          		  }
				  
				sentencia=conexion.createStatement();
				String consultaSQL="SELECT * FROM reactivos";
				resultado=sentencia.executeQuery(consultaSQL);
	pregunta=new ArrayList<String>();
	opciona=new ArrayList<String>();
	opcionb=new ArrayList<String>();
	opcionc=new ArrayList<String>();
	respuesta=new ArrayList<String>();
	numpregunta=new int[10];

					while(resultado.next()){
							num_pregunta=resultado.getInt("num_pregunta");
							String preguntaa=resultado.getString("pregunta");					
							String opcion_a=resultado.getString("opcion_a");
							String opcion_b=resultado.getString("opcion_b");
							String opcion_c=resultado.getString("opcion_c");
							String respuestaa=resultado.getString("respuesta");
						    //numpregunta[i]=num_pregunta;
							pregunta.add(preguntaa);
							opciona.add(opcion_a);
							opcionb.add(opcion_b);
							opcionc.add(opcion_c);
							respuesta.add(respuestaa);
					} //Fin While
						numpregunta=numaleatorios; //Pongo los numeros por numero Aleatorio
						for(int i=0;i<10;i++) {	
						   if(numaleatorios[i]==numpregunta[i]) {	
								System.out.println("Numero Base de datos  es: "+numpregunta[i]);
								System.out.println("Pregunta  es: "+pregunta.get(i));
								System.out.println("Opcion A  es: "+opciona.get(i));
								System.out.println("Opcion B  es: "+opcionb.get(i));
								System.out.println("Opcion C  es: "+opcionc.get(i));
								System.out.println("Respuesta es: "+respuesta.get(i));
								
								
							}
							
						
						}   //Cierra for
						
						
						examen.setPregun(pregunta);
						examen.setOpciona(opciona);
						examen.setOpcionb(opcionb);
						examen.setOpcionc(opcionc);								
						examen.setResp(respuesta);
						examen.setNumpregunta(numpregunta);
						
						
					
					for(int x=0;x<examen.getPregun().size();x++) {
					  System.out.println("La pregunta #"+x+" :"+examen.getPregun().get(x));
					}		
						
						sentencia.close();
					}catch(Exception e){
						e.printStackTrace();
						conexion=null;
						
					}finally{
						if(resultado !=null){
							try{
								resultado.close();
								
							}catch(Exception e){
							e.printStackTrace();
							}
						}
						if(sentencia !=null){
							try{
								sentencia.close();
							}catch(Exception e){
								e.printStackTrace();
							}
						}
						if(conexion !=null){
							try{
								conexion.close();
								
							}catch(Exception e){
								e.printStackTrace();
							}
							
						}
					}
				return mensaje;
	}
/**
 * AGREGAR UN ESTUDIANTE A LA BASE DE DATOS	
 */
	public String agregarEstudiante(Estudiante estudiante){
		String mensaje="Agregando estudiante... ";
		String ordenSQL=null;
		Statement proposicion=null;
		int exito=0;
		
		mensaje = conectate(); 
		
		if(conexion != null){
			try{
		        proposicion = conexion.createStatement(); 
			    ordenSQL="INSERT INTO estudiante values( '"
		        +estudiante.getNombre()+"','"+estudiante.getApellidoPaterno()+"',"
			    + "'"+estudiante.getApellidoMaterno()+"','"+estudiante.getMatricula()+"',"
		        +estudiante.getCalificacion()+");";
	            exito=proposicion.executeUpdate(ordenSQL);
	            proposicion.close();
	
	            if(exito==1){
	            	mensaje="El registro se Agrego Exitosamente";
	            
	            }else{
	            	mensaje="ERROR: El registro No se Agrego Exitosamente";
	            	
	            }	            
			 }catch(SQLException sqle){
				 mensaje=""+sqle.getMessage();
			 }finally{
			   try{
				  conexion.close();
			   }catch(SQLException sqle){
                  mensaje="falla conexion";			   
			   }
			 } 
			 
		}else {
			mensaje="fallo conexion";
		}
		return mensaje;
	  }
	
	/**
	 * AGREGA UN EXAMEN A LA BASE DE DATOS	
	 * 
	 * @return mensaje que informa el estado de la operacion
	 */
		public String agregarExamen(Examen examen,Estudiante estudiante){
			cajarespondidas = new ArrayList<String>();
			String mensaje="Agregando examen... ";
			for(int i=0;i<10;i++){
				System.out.println("#"+i+" Numero Aleatorio al Agregar Examen: "+numaleatorios[i]);
			}
			
			
			AdminDB a=new AdminDB();
			a.setCajarespondidas(examen.getRespEst());
			
			
			int exito=0;
			
			mensaje = conectate(); 
			
			if(conexion != null){
				try{
					 
					int i;
					String[] numeros= {"uno","dos","tres","cuatro","cinco","seis","siete","ocho","nueve","diez"};
					int n=numeros.length;
					for( i=0;i<n;i++){
					
						for(int x=0;x<cajarespondidas.size();x++) {
							  respondidas=cajarespondidas.get(x);
								
						
					switch(i){
						case 0:  
					String ordenSQL2="INSERT INTO examen VALUES ("+" '"+estudiante.getMatricula()+"', "+numaleatorios[i]+" ,'"+numeros[i]+"' , '"+respondidas+"');";
					proposicion = conexion.createStatement();
					exito=proposicion.executeUpdate(ordenSQL2);
					break;
						case 1:
							String ordenSQL3="INSERT INTO examen VALUES ("+" '"+estudiante.getMatricula()+"', "+numaleatorios[i]+" ,'"+numeros[i]+"' , '"+respondidas+"');";
							proposicion = conexion.createStatement();
							exito=proposicion.executeUpdate(ordenSQL3);
					break;
						case 2:
							String ordenSQL4="INSERT INTO examen VALUES ("+" '"+estudiante.getMatricula()+"', "+numaleatorios[i]+" ,'"+numeros[i]+"' , '"+respondidas+"');";
							proposicion = conexion.createStatement();
							exito=proposicion.executeUpdate(ordenSQL4);
					break;
						case 3:
							String ordenSQL5="INSERT INTO examen VALUES ("+" '"+estudiante.getMatricula()+"', "+numaleatorios[i]+" ,'"+numeros[i]+"' , '"+respondidas+"');";
							proposicion = conexion.createStatement();
							exito=proposicion.executeUpdate(ordenSQL5);
					break;	
						case 4:
							String ordenSQL6="INSERT INTO examen VALUES ("+" '"+estudiante.getMatricula()+"', "+numaleatorios[i]+" ,'"+numeros[i]+"' , '"+respondidas+"');";
						proposicion = conexion.createStatement();
							exito=proposicion.executeUpdate(ordenSQL6);
					break;
						case 5:
							String ordenSQL7="INSERT INTO examen VALUES ("+" '"+estudiante.getMatricula()+"', "+numaleatorios[i]+" ,'"+numeros[i]+"' , '"+respondidas+"');";
							proposicion = conexion.createStatement();
							exito=proposicion.executeUpdate(ordenSQL7);
					break;
						case 6:
							String ordenSQL8="INSERT INTO examen VALUES ("+" '"+estudiante.getMatricula()+"', "+numaleatorios[i]+" ,'"+numeros[i]+"' , '"+respondidas+"');";
							proposicion = conexion.createStatement();
							exito=proposicion.executeUpdate(ordenSQL8);
					break;
						case 7:
							String ordenSQL9="INSERT INTO examen VALUES ("+" '"+estudiante.getMatricula()+"', "+numaleatorios[i]+" ,'"+numeros[i]+"' , '"+respondidas+"');";
							proposicion = conexion.createStatement();
							exito=proposicion.executeUpdate(ordenSQL9);
					break;
						case 8:
							String ordenSQL10="INSERT INTO examen VALUES ("+" '"+estudiante.getMatricula()+"', "+numaleatorios[i]+" ,'"+numeros[i]+"' , '"+respondidas+"');";
							proposicion = conexion.createStatement();
							exito=proposicion.executeUpdate(ordenSQL10);
					break;
						case 9:
							String ordenSQL11="INSERT INTO examen VALUES ("+" '"+estudiante.getMatricula()+"', "+numaleatorios[i]+" ,'"+numeros[i]+"' , '"+respondidas+"');";
							proposicion = conexion.createStatement();
							 exito=proposicion.executeUpdate(ordenSQL11);
					break;



					}

					}//for x
					} //for i
		
		            if(exito==1){
		            	mensaje="El registro se Agrego Exitosamente";
		            
		            }else{
		            	mensaje="ERROR: El registro No se Agrego Exitosamente";
		            	
		            }	            
				 }catch(SQLException sqle){
					 mensaje=""+sqle.getMessage();
				 }finally{
				   try{
					  conexion.close();
				   }catch(SQLException sqle){
	                  mensaje="falla conexion";			   
				   }
				 } 
				 
			}else {
				mensaje="fallo conexion";
			}
			return mensaje;
		  }
		  
	//BUSCA EL USUARIO Y contra DESDE LA BASE DE DATOS PARA EL LOGIN DE PROFESOR
		public String logindeProfesor(){
			String mensaje="Buscando usuario y contrasena";
				
					try{
						
						sentencia=conexion.createStatement();
					String consultaSQL="Select * From profesor";
					resultado=sentencia.executeQuery(consultaSQL);
				 
							while(resultado.next()){
									
							   	String email=resultado.getString("usuario");					
								String password=resultado.getString("password");
								
								this.setEmail(email);
								this.setPassword(password);
									
							}
							sentencia.close();
						}catch(Exception e){
							e.printStackTrace();
							conexion=null;
							
						}finally{
							if(resultado !=null){
								try{
									resultado.close();
									
								}catch(Exception e){
								e.printStackTrace();
								}
							}
							if(sentencia !=null){
								try{
									sentencia.close();
								}catch(Exception e){
									e.printStackTrace();
								}
							}
							if(conexion !=null){
								try{
									conexion.close();
									
								}catch(Exception e){
									e.printStackTrace();
								}
								
							}
						}
					return mensaje;
		}
	
	
// BUSCAR UN ESTUDIANTE DE LA BASE DE DATOS POR SU MATRICULA	 
  // @throws ExcepcionNombre
 	public Estudiante buscarEstudiante(String matricula){ 
		String mensaje="Buscando... ";
		String ordenSQL=null;
		Statement proposicion=null;
		ResultSet rs=null;
		estudiante = new Estudiante();
		
		mensaje = conectate(); 
		
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
		
			 }catch(SQLException sqle){
				 mensaje=""+sqle.getMessage();
			 }finally{
			   try{
				  conexion.close();
			   }catch(SQLException sqle){
                  mensaje="falla conexion";			   
			   }
			 } 
			 
		}else {
			mensaje="fallo conexion";
		}
		System.out.println(mensaje);
		return estudiante;
	}
	
/**
 * 	ELIMINAR UN REGISTRO DE LA BASE DE DATOS
 
	public String borrarPersona(int id){
		String mensaje="eliminando registro... ";
		String ordenSQL=null;
		Statement proposicion=null;
		ResultSet rs= null;
		int exito1=0;
		int exito2=0;
		int exito3=0;
		mensaje = conectate(); 
		
		if(conexion != null){
			try{
				//proposicion = conexion.createStatement(); 
			    //rs= proposicion.executeQuery("Select * From personaje Where id= "+id);
				  
		        proposicion = conexion.createStatement();
		        exito3=proposicion.executeUpdate("DELETE FROM foto WHERE id = "+id);
		        exito1=proposicion.executeUpdate("DELETE FROM contribucion WHERE idcontr = "+id);
		        exito2=proposicion.executeUpdate("DELETE FROM personaje WHERE id = "+id);
		        proposicion.close();
		        System.out.println("Id ingresado: : "+id);
		        System.out.println("Numero que regres EXITO DE CONTRIBUCION: "+exito1);
		        System.out.println("Numero que regres EXITO DE PERSONAJE: "+exito2);
		        System.out.println("Numero que regres EXITO DE FOTO: "+exito3);
	            if(exito2==1){
	            	mensaje="El registro fue borrado exitosamente =)";
	   
	            }else{
	            	mensaje="ERROR: Fallo al eliminar =(";
	            	
	            }	            
			 }catch(SQLException sqle){
				 mensaje=""+sqle.getMessage()+"AQUI ESTA";
			 }finally{
			   try{
				  conexion.close();
			   }catch(SQLException sqle){
                  mensaje="falla conexion";			   
			   }
			 } 
			 
		}else {
			mensaje="fallo conexion";
		}
		return mensaje;
	}
	*/	
	
//Getters y Setters	
	public ArrayList<String> getPregunta() {
		return pregunta;
	}
	public void setPregunta(ArrayList<String> pregunta) {
		this.pregunta = pregunta;
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
	public ArrayList<String> getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(ArrayList<String> respuesta) {
		this.respuesta = respuesta;
	}
	
	
	public int[] getnumaleatorios() {
		return numaleatorios;
	}
		public void setnumaleatorios(int[] numaleatorios) {
		this.numaleatorios = numaleatorios;
	}
		
		
	public String getNumempleado() {
		return numempleado;
	}
	public void setNumempleado(String numempleado) {
		this.numempleado = numempleado;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public ArrayList<String> getCajarespondidas() {
		return cajarespondidas;
	}
	public void setCajarespondidas(ArrayList<String> cajarespondidas) {
		this.cajarespondidas = cajarespondidas;
	}
}