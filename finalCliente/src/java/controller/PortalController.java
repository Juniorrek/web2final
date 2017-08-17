/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.EmpresaDao;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Funcionario;

/**
 *
 * @author Fornalha
 */
@WebServlet(name = "PortalController", urlPatterns = {"/PortalController"})
public class PortalController extends HttpServlet {

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
        if (request.getSession().getAttribute("usuario") == null) {
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/login.jsp");
            requestDispatcher.forward(request, response);
        }
            
        String action = request.getParameter("action");
        
        if ("listarEmpresas".equals(action)) {
            try {
                request.setAttribute("empresas", EmpresaDao.listarEmpresas());
                
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/empresas/listar.jsp");
                requestDispatcher.forward(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(PortalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if ("listarFuncionarios".equals(action)) {
            Client client = ClientBuilder.newClient();
            Response resp = client
                    .target("http://localhost:8084/finalServidor/webresources/funcionarios/")
                    .request(MediaType.APPLICATION_JSON)
                    .get();
            List<Funcionario> lista =
                    resp.readEntity(
                            new GenericType<List<Funcionario>>() {}
                    );
            request.setAttribute("funcionarios", lista);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/funcionarios/listar.jsp");
            requestDispatcher.forward(request, response);
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
