<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.Date" pageEncoding="ISO-8859-1"%>

<%@ page language="java" contentType="text/html;" pageEncoding="ISO-8859-1"   isELIgnored="false"%>

<%@page import="java.util.Date" %>


<%@ page contentType="text/html;charset=UTF-8" language="Java"%>


    <%@ page import="bdatos.AdminDB" %>
    <%@ page import="modelo.Estudiante" %>
        
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
	<style>
table, td, th {
    border: 1px solid black;
}

table {
    border-collapse: collapse;
    width: 50%;
}

th {
    text-align: left;
}
</style>
		<title>Menu principal</title>
		<style type="text/css">
			
			* {
				margin:0px;
				padding:0px;
			}
			
			#header {
				margin:auto;
				width:700px;
				font-family:Arial, Helvetica, sans-serif;
			}
			
			ul, ol {
				list-style:none;
			}
			
			.nav > li {
				float:left;
			}
			
			.nav li a {
				background-color:Green;
				color:black;
				text-decoration:none;
				padding:10px 12px;
				display:block;
			}
			
			.nav li a:hover {
				background-color:White;
			}
			
			.nav li ul {
				display:none;
				position:absolute;
				min-width:140px;
			}
			
			.nav li:hover > ul {
				display:block;
			}
			
			.nav li ul li {
				position:relative;
			}
			
			.nav li ul li ul {
				right:-140px;
				top:0px;
			}
			
		</style>
	</head>
	<body>
	
      
      <jsp:expression> "Consultation des Notes" </jsp:expression>
      request.setAttribute( "Consultation des Notes");
            
      <%="<u>Consultation des Notes</u>"%>

	<%
	   String mensajeIngreso="Consultation Notes";
	   String mensaje= (String)session.getAttribute("mensaje");
	   	if(mensaje != null)	   
		  mensajeIngreso=mensaje;
	%>   	
	   	

		  <%="<u>Prenom</u>"%>
		<% String mensajeNombre="Nombre";
	   //String mensajen= (String)session.getAttribute("mensajenombre");
	   String mensajen=(String)session.getValue("mensajenombre");
		if(mensajen != null)	   
			mensajeNombre=mensajen;
		%>
		
		
		  <%="<u>Nom Paternel</u>"%>
		<% String mensajeApellidoPaterno="Apellido Paterno";
	   String mensajeap= (String)session.getAttribute("mensajeapellidopaterno");
		if(mensajeap != null)	   
			mensajeApellidoPaterno=mensajeap;
		%>
		
		<%="<u>Numéro d'immatriculation</u>"%>
		<% String mensajeMatricula="Matricula";
	   String mensajemat= (String)session.getAttribute("mensajematricula");
		if(mensajemat != null)	   
			mensajeMatricula=mensajemat;
		%>
		
		
		
		<%="<u>Qualification</u>"%>
		<% Double mensajeCalificacion=0.0;
	   Double mensajec= (Double)session.getAttribute("mensajecalificacion");
		if(mensajec != null)	   
			mensajeCalificacion=mensajec;
		%>
		
		
		<div id="header">
			<ul class="nav">
				<li><a href="index.jsp">Fenêtre Principal</a></li>
				<li><a href="">Examen</a>
					<ul>
						<li><a href="Examen.jsp">Générer de l'Examen</a></li>
						
						
							
					</ul>
				</li>
				<li><a href="">Accès des Professeur</a>
					<ul>
						<li><a href="AccesodeProfesor.jsp">Consultation des Qualification</a></li>
						
					</ul>
				</li>
				<li><a href="calificacion.jsp">Qualification</a></li>
			</ul>
		</div>
		
		
		<br><br><br>
	
	<center><h3> 
	
	<%= mensajeIngreso %>
	
	</h3></center>
	
<center> <table>
  <tr>
    <th>Prenom</th>
    <th>Nom</th>
    <th>Numéro d'immatriculation</th>
    <th>Qualification</th>
  </tr>
  <tr>
    <td><%= mensajeNombre %></td>
    <td><%= mensajeApellidoPaterno %></td>
    <td><%= mensajeMatricula %></td>
    <td><%= mensajeCalificacion %></td>
  </tr>
  <tr>
    <td></td>
    <td></td>
    <td></td>
  </tr>
  </table> </center>
	
	<form action="/examen/controladorbusquedapormatricula" method="post" >
	<br><br><br><br>
	Tapez l'inscription de l'étudiant<br> 
	Pour trouver le note de l'étudiant: <input type="text" name="matricula" > <br><br>
	           <input type="submit" value="Chercher" >
</form>
		
	</body>
</html>