/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import basedatos.crud.BDUsuario;
import basedatos.entidades.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Keb
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        BDUsuario bdu = new BDUsuario();

        if(!request.getParameter("nick").equalsIgnoreCase("")){
            Usuario u = bdu.buscarNick(request.getParameter("nick"));

            try{
                if(u.getClave().equals(request.getParameter("clave"))){
                    HttpSession s = request.getSession();
                    
                    if( !( request.getParameter("recuerdame") == null) ){
                        
                        if (((String)request.getParameter("recuerdame")).equals("on")) {
                            
                            
                            s.setAttribute("sesionIniciada", true);
                            s.setAttribute("idUsuario", u.getId());
                            s.setAttribute("tipoUsuario", u.getTipoUsuario());
                            s.setAttribute("nombreUsuario", u.getNick());
                            
                            s.setMaxInactiveInterval(0);
                        }
                        
                    }else{
                        s.setAttribute("sesionIniciada", true);
                        s.setAttribute("idUsuario", u.getId());
                        s.setAttribute("tipoUsuario", u.getTipoUsuario());
                        s.setAttribute("nombreUsuario", u.getNick());
                        
                        s.setMaxInactiveInterval(1500);
                    }

                    if(u.getTipoUsuario()==1){
                        response.sendRedirect("asesores.jsp");
                    }else if(u.getTipoUsuario()==0){
                        response.sendRedirect("alumnos.jsp");
                    }else {
                        response.sendRedirect("login.jsp");
                    }

                }else{
                    response.sendRedirect("login.jsp");
                }

            }catch(Exception e){
                response.sendRedirect("login.jsp");
            }

        }else{
            response.sendRedirect("login.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
