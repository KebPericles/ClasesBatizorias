/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import basedatos.crud.BDUsuario;
import basedatos.entidades.*;
import java.util.Date;

/**
 *
 * @author Keb
 */
public class registrarUsuario extends HttpServlet {

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
        
        
        BDUsuario u = new BDUsuario();
        Usuario r = new Usuario();
        try{
            request.getParameter("tipo");
            
            if(request.getParameter("nick").isEmpty() || request.getParameter("exampleInputEmail").isEmpty() || request.getParameter("exampleInputFirstName").isEmpty()
                    || request.getParameter("exampleInputLastName").isEmpty() || request.getParameter("exampleInputPassword").isEmpty() || request.getParameter("tipo").isEmpty()) {
                 response.sendRedirect("register.html");
            }else{
                try{
                    r.setNick(request.getParameter("nick"));
                    r.setCorreo(request.getParameter("exampleInputEmail"));
                    r.setNombre(request.getParameter("exampleInputFirstName"));
                    r.setApPat(request.getParameter("exampleInputLastName"));
                    r.setClave(request.getParameter("exampleInputPassword"));
                    r.setfNac(new Date((2000-1900),1,1));//cambiar por el año cuando se implemente
                    r.setTelefono(false);
                    r.setApMat(" ");
                    r.setCorreoVisible(false);
                    r.setSemestre(Byte.valueOf("1"));
                    r.setGenero('N');
                    r.setIdMunicipio("1");
                    byte tipo = -1;
                    
                    if (request.getParameter("tipo").equals("asesor")) {
                        tipo = 1;
                    }else if(request.getParameter("tipo").equals("alumno")){
                        tipo = 2;
                    }
                    
                    if(tipo != -1){
                        boolean b = u.registrar(r);
                        
                        if(b){
                            request.setAttribute("recordarme", true);
                            request.getRequestDispatcher("login").forward(request, response);
                        }else{
                            response.sendRedirect("register.html");
                        }
                    }else{
                        response.sendRedirect("register.html");
                    }
                }catch(IOException e){
                    response.sendRedirect("register.html");
                }
            }
        }catch(Exception e){
            response.sendRedirect("register.html");
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
        response.sendRedirect("register.html");
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
