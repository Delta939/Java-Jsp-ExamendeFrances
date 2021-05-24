<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="modelo.Examen" %>
    <%@ page import="modelo.Estudiante" %>
    <%@ page import="bdatos.AdminDB" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>Menu Desplegable</title>
		<% Examen examen=(Examen)session.getAttribute("examen");%> 
		<% //AdminDB admin=new AdminDB();%>
		<% //Examen examen=new Examen();%>
		
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
				background-color:white;
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
	  
	<%--    <jsp:useBean  id="examen" class="modelo.Examen" scope="session" />  --%>
	
	
		<div id="header">
			<ul class="nav">
				<li><a href="index.jsp">Ventana Principal</a></li>
				<li><a href="">Examen</a>
					<ul>
						<li><a href="Examen.jsp">Generar Examen</a></li>
						
						
					</ul>
				</li>
				<li><a href="">Acceso de Profesor</a>
					<ul>
						<li><a href="AccesodeProfesor.jsp">Consulta de Calificaciones</a></li>
						
					</ul>
				</li>
				<li><a href="calificacion.jsp">Calificacion</a></li>
			</ul>
		</div>

<br><br><br><center><H1>Test de Francais</H1></center>
<center><H1>Répondez aux questions en cochant la bonne réponse</H1></center>
<br>
      
<%int i[]={1,2,3,4,5,6,7,8,9,10}; %>
      
<form action="/examen/controladordepreguntas" method="post" >
          
     <%=i[0] %>.-<%=examen.getPregun().get(0) %><br>
   	<input type="radio"  value= "a"  name="respuesta1" ><%=examen.getOpciona().get(0) %>
	<input type="radio"  value= "b" name="respuesta1"><%=examen.getOpcionb().get(0) %> 
	<input type="radio"  value= "c" name="respuesta1"><%=examen.getOpcionc().get(0) %>
	<br><br>
	<%=i[1] %>.-<%=examen.getPregun().get(1) %><br>
   	<input type="radio"  value= "a"  name="respuesta2" ><%=examen.getOpciona().get(1)%>
	<input type="radio"  value= "b" name="respuesta2"><%=examen.getOpcionb().get(1)%> 
	<input type="radio"  value= "c" name="respuesta2"><%=examen.getOpcionc().get(1)%>
	<br><br>
	<%=i[2] %>.-<%=examen.getPregun().get(2) %><br>
   	<input type="radio"  value= "a"  name="respuesta3" ><%=examen.getOpciona().get(2)%>
	<input type="radio"  value= "b" name="respuesta3"><%=examen.getOpcionb().get(2)%> 
	<input type="radio"  value= "c" name="respuesta3"><%=examen.getOpcionc().get(2)%>
	<br><br>
	<%=i[3] %>.-<%=examen.getPregun().get(3) %><br>
   	<input type="radio"  value= "a"  name="respuesta4" ><%=examen.getOpciona().get(3)%>
	<input type="radio"  value= "b" name="respuesta4"><%=examen.getOpcionb().get(3)%> 
	<input type="radio"  value= "c" name="respuesta4"><%=examen.getOpcionc().get(3)%>
	<br><br>
	<%=i[4] %>.-<%=examen.getPregun().get(4) %><br>
   	<input type="radio"  value= "a"  name="respuesta5" ><%=examen.getOpciona().get(4)%>
	<input type="radio"  value= "b" name="respuesta5"><%=examen.getOpcionb().get(4)%> 
	<input type="radio"  value= "c" name="respuesta5"><%=examen.getOpcionc().get(4)%>
	<br><br>
	<%=i[5] %>.-<%=examen.getPregun().get(5) %><br>
   	<input type="radio"  value= "a"  name="respuesta6" ><%=examen.getOpciona().get(5)%>
	<input type="radio"  value= "b" name="respuesta6"><%=examen.getOpcionb().get(5)%> 
	<input type="radio"  value= "c" name="respuesta6"><%=examen.getOpcionc().get(5)%>
	<br><br>
	<%=i[6] %>.-<%=examen.getPregun().get(6) %><br>
   	<input type="radio"  value= "a"  name="respuesta7" ><%=examen.getOpciona().get(6)%>
	<input type="radio"  value= "b" name="respuesta7"><%=examen.getOpcionb().get(6)%> 
	<input type="radio"  value= "c" name="respuesta7"><%=examen.getOpcionc().get(6)%>
	<br><br>
	<%=i[7] %>.-<%=examen.getPregun().get(7) %><br>
   	<input type="radio"  value= "a"  name="respuesta8" ><%=examen.getOpciona().get(7)%>
	<input type="radio"  value= "b" name="respuesta8"><%=examen.getOpcionb().get(7)%> 
	<input type="radio"  value= "c" name="respuesta8"><%=examen.getOpcionc().get(7)%>
	<br><br>
	<%=i[8] %>.-<%=examen.getPregun().get(8) %><br>
   	<input type="radio"  value= "a"  name="respuesta9" ><%=examen.getOpciona().get(8)%>
	<input type="radio"  value= "b" name="respuesta9"><%=examen.getOpcionb().get(8)%> 
	<input type="radio"  value= "c" name="respuesta9"><%=examen.getOpcionc().get(8)%>
	<br><br>
	<%=i[9] %>.-<%=examen.getPregun().get(9) %><br>
   	<input type="radio"  value= "a"  name="respuesta10" ><%=examen.getOpciona().get(9)%>
	<input type="radio"  value= "b" name="respuesta10"><%=examen.getOpcionb().get(9)%> 
	<input type="radio"  value= "c" name="respuesta10"><%=examen.getOpcionc().get(9)%>
	<br>
	<center><input type="submit" value="Calificar" ></center>
</form>
		
		
	</body>
</html>