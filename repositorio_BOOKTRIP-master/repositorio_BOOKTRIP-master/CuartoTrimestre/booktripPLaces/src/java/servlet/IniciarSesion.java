/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import modelo.usuario;
import controlador.usuarioDao;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oscar sanabria
 */
@WebServlet(name = "IniciarSesion", urlPatterns = {"/IniciarSesion"})
public class IniciarSesion extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            
            String Email = request.getParameter("email");
            String Password = request.getParameter("pass");
            
            try {
               
                usuarioDao miUsuarioDAO = new usuarioDao(); 

                usuario miUsuario = new usuario(); 
                
                miUsuario = miUsuarioDAO.consultarUsuario(Email);

                if (miUsuario == null) {
                    System.out.println(Email);
                    out.println("<script type=\"text/javascript\">");
                    out.println("alert('" + "El email: " + Email + " no es correcto" + "');");
                    out.println("window.location.href='/booktripPLaces/login.jsp'");
                    out.println("</script>");
                    
                } else {
                    System.out.println(miUsuario.getPassword());
                    System.out.println(Password);
                    if (miUsuario.getPassword().equals(Password)) {
                         System.out.println("si entra");
                       
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('" + "Bienvenido: " + miUsuario.getNombre() + " " + miUsuario.getApellido() + "');");
                        out.println("window.location.href='/booktripPLaces/vista/inmueble.jsp'");
                        out.println("</script>");
                    } else {
                        
                        out.println("<script type=\"text/javascript\">");
                        out.println("alert('" + "Error de contrase??a" + "');");
                        out.println("window.location.href='/booktripPLaces/login.jsp'");
                        out.println("</script>");
                    }
                }

            } catch (NumberFormatException e) {
               e.printStackTrace();
            }

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