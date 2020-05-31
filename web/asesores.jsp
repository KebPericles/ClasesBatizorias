<%-- 
    Document   : asesores
    Created on : 11/05/2020, 09:00:37 AM
    Author     : 52551
--%>

<%@page import="basedatos.crud.BDMateria"%>
<%@page import="basedatos.entidades.Asesoria"%>
<%@page import="basedatos.crud.BDAsesoria"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.util.*, java.sql.*, basedatos.conexion.Conexion" %>
<!DOCTYPE html>
<%
    try{
        if (!session.isNew() && (Boolean)session.getAttribute("sesionIniciada") && ((byte)session.getAttribute("tipoUsuario")) == 1) {
%>
<html>
    <head>
        <title>Asesores </title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
        <link href='https://fonts.googleapis.com/css?family=Kaushan+Script' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Droid+Serif:400,700,400italic,700italic' rel='stylesheet' type='text/css'>
        <link href='https://fonts.googleapis.com/css?family=Roboto+Slab:400,100,300,700' rel='stylesheet' type='text/css'>

    <!-- Custom styles for this template -->
    <link href="css/agency.css" rel="stylesheet">

    </head>
    <body>
        <style>
        h2 { 
            text-align: center;
            font-family: arial;
            color:red;
        };
        
        td {
            
            text-align: center;
            font-family: Verdana;
            font-size: 16;
        }
        div{
            text-align: center;
            height: 100px;
            background-color: aquamarine;
            
        }
    </style>
    
    <%  
        out.println("<style> p {font-family: arial;"
                + "color: blue; font-size: 16};"
                + "</style>"
                + "<style> a,b {font-family: arial;"
                + "color: red; font-size: 16};"
                + "</style>"
                + "<style> a.space {font-family: arial;"
                + "color: green; font-size: 18}"
                + "margin:0 0 0 208px;"
                + "</style>");
    
    
    %>
    <div>
        <div><br><br>pagina para asesores</div>
        <div>
            <a href="permisoMateria.jsp">Permisos de materias</a>
            <a href="crearAsesoria.jsp">Crear asesoria</a>
            
            <div>
                <a href="cerrarSesion">Cerrar sesión</a>
            </div>
            <br>
        </div>
        <div>
            <table border="1" borderColor="black">
                <tbody>
                    <tr>
                        <td bgColor="cyan" width="150" align="center" >Materia</td>
                        <td bgColor="cyan" width="290" align="center" >hora inicio</td>
                        <td bgColor="cyan" width="290" align="center" >dias</td>
                        <td bgColor="cyan" width="290" align="center" >duracion</td>
                        <td bgColor="cyan" width="290" align="center" ><a href="crear_hora.jsp">añadir horario</a></td>
                    </tr>
                
                
                <%  //vamos a conectarnos con la BD
                    Asesoria[] ase = (Asesoria[])BDAsesoria.buscarIdUsuario((String)session.getAttribute("idUsuario"));
                        //y asi como le hicimos con lo demas hay que recorrer la tabla con un while
                        for (int i = 0; i < ase.length; i++) {
                            //y vamos a hacer que se imprima directo en la tabla
                            String nombreMateria = BDMateria.nombreMateriaId(String.valueOf(ase[i].getIdMateria()));
                 %>
                 
                 <tr>
                     <td bgColor="lightgreen" valign="top" width="80" height="19"><%=nombreMateria%></td>
                     <td bgColor="lightgreen" valign="top" width="80" height="19"></td>
                     
                 </tr>
                 
                <%         }
                %>
                 
                
                </tbody>
                   
            </table>
        </div>
    </div>
    </body>
</html>
<%
        }else{
            response.sendRedirect("index.html");
        }
    }catch(Exception e){
        System.out.println("Porque");
        System.out.println(e.getMessage());
        response.sendRedirect("index.html");
    }

%>