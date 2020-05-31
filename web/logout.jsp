<%-- 
    Document   : logout
    Created on : 28/05/2020, 04:02:22 PM
    Author     : Keb
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    request.getRequestDispatcher("cerrarSesion").forward(request, response);
%>