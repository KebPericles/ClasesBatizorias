<%-- 
    Document   : Lista
    Created on : 1/04/2020, 03:00:02 PM
    Author     : Paladin18
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java" import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Tus asesorias</title>
    </head>
    
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
    
    <body>
        <div align="center" width="200%" >
            <br>
            <h2>
                tus asesorias
            </h2>
            <br>
            <div align="left" width="200%" >
                <% //este elemento nos va a servir para llamar a otro jsp que inserte datos
                    out.println("<a class='space' href='inserta.jsp'> crear nueva asesoria </a>");
                    
                %>
            </div>
            <br>
            <table border="1" borderColor="black">
                <tbody>
                <td bgColor="cyan" width="150" align="center" >Num asesoria
                    
                </td>
                <td bgColor="cyan" width="290" align="center" >unidad de aprendizaje
                    
                
                <%  //vamos a conectarnos con la BD
                    String DRIVER = "com.mysql.jdbc.Driver";
                    Class.forName(DRIVER).newInstance();
                    Connection con = null;
                    Statement st = null;
                    ResultSet rs = null;
                    try{
                        String url="jdbc:mysql://localhost:3306/batizorias?user=root&password=n0m3l0";
                        //users es la bd,  user es el usuario root 
                        int i = 1;
                        con = DriverManager.getConnection(url);
                        st = con.createStatement();
                        String q = "Select * from asesorias where idUsuario='?'";
                        rs = st.executeQuery(q);
                        //y asi como le hicimos con lo demas hay que recorrer la tabla con un while
                        while(rs.next()){
                            //y vamos a hacer que se imprima directo en la tabla
                            if(i == (i/2)*2){
                 %>
                 
                 <tr>
                     <td bgColor="lightgreen" valign="top" width="80" height="19" ><%=rs.getString(1) %> 
                         
                     </td>
                     <td bgColor="lightgreen" valign="top" width="80" height="19" ><%=rs.getInt("idMateria") %> 
                     </td>
                     <td bgColor="lightgreen" valign="top" width="80" height="19" >
                         <a href="editar.jsp">  <%=rs.getInt("id") %> </a> 
                         
                     </td>
                     <td bgColor="lightgreen" valign="top" width="80" height="19" >
                         <a href="borrar.jsp">  <%=rs.getInt("id") %> </a> 
                         
                     </td>
                 </tr>
                 
                 <% 
                        }else{// aqui va el else %>
                         
                        
                   <tr>
                     <td bgColor="lightgreen" valign="top" width="80" height="19" ><%=rs.getString(1) %> 
                         
                     </td>
                     <td bgColor="lightgreen" valign="top" width="80" height="19" ><%=rs.getString("idMateria") %> 
                         
                     </td>
                     <td bgColor="lightgreen" valign="top" width="80" height="19" >
                         <a href="editar.jsp">  <%=rs.getInt("id") %> </a> 
                         
                     </td>
                     <td bgColor="lightgreen" valign="top" width="80" height="19" >
                         <a href="borrar.jsp">  <%=rs.getInt("id") %> </a> 
                         
                     </td>
                 </tr>    
                        
                <%         }
                     i++;
                    //este es de mi whiel
                        }
                        
                        rs.close();
                        st.close();
                        con.close();
                    }catch(Exception e){
                        System.out.println("Si aqui no sirve sout T_T");
                        System.out.println(e.getMessage());
                        System.out.println(e.getStackTrace());
                    }
                
                %>
                 
                
                </tbody>
                   
            </table>
            
            
        </div>
        
        
    </body>
</html>
