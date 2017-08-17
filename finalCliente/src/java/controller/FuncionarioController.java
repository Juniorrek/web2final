/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import model.Funcionario;

/**
 *
 * @author Fornalha
 */
@WebServlet(name = "FuncionarioController", urlPatterns = {"/FuncionarioController"})
public class FuncionarioController extends HttpServlet {

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
        
        if ("formAdicionarFuncionario".equals(action)) { 
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/funcionarios/adicionar.jsp");
            requestDispatcher.forward(request, response);
        } else if ("adicionarFuncionario".equals(action)) {
            Funcionario funcionario = new Funcionario();
            funcionario.setCpf(request.getParameter("cpf"));
            funcionario.setNome(request.getParameter("nome"));
            funcionario.setEndereco(request.getParameter("endereco"));
            funcionario.setEmail(request.getParameter("email"));
            funcionario.setCelular(request.getParameter("celular"));
            funcionario.setEmpresa_codigo(request.getParameter("empresa_codigo"));
            
            Client client = ClientBuilder.newClient();
            client.target("http://localhost:8084/finalServidor/webresources/funcionarios/")
                  .request()
                  .post(Entity.json(funcionario));
                    
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/PortalController?action=listarFuncionarios");
            requestDispatcher.forward(request, response);
        } else if ("formEditarFuncionario".equals(action)) {
            String codigo = request.getParameter("codigo");
            
            Client client = ClientBuilder.newClient();
            Funcionario funcionario = client
                                            .target("http://localhost:8084/finalServidor/webresources/funcionarios/" + codigo)
                                            .request(MediaType.APPLICATION_JSON)
                                            .get(Funcionario.class);
            
            request.setAttribute("funcionario", funcionario);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/view/funcionarios/editar.jsp");
            requestDispatcher.forward(request, response);
        } else if ("editarFuncionario".equals(action)) {
            Funcionario funcionario = new Funcionario();
            funcionario.setCodigo(Integer.parseInt(request.getParameter("codigo")));
            funcionario.setCpf(request.getParameter("cpf"));
            funcionario.setNome(request.getParameter("nome"));
            funcionario.setEndereco(request.getParameter("endereco"));
            funcionario.setEmail(request.getParameter("email"));
            funcionario.setCelular(request.getParameter("celular"));
            funcionario.setEmpresa_codigo(request.getParameter("empresa_codigo"));
            
            Client client = ClientBuilder.newClient();
            client.target("http://localhost:8084/finalServidor/webresources/funcionarios/" + funcionario.getCodigo())
                  .request()
                  .put(Entity.json(funcionario));
            
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/PortalController?action=listarFuncionarios");
            requestDispatcher.forward(request, response);
        } else if ("excluirFuncionario".equals(action)) {
            String codigo = request.getParameter("codigo");
            
            Client client = ClientBuilder.newClient();
            client.target("http://localhost:8084/finalServidor/webresources/funcionarios/" + codigo)
                  .request()
                  .delete();
            
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/PortalController?action=listarFuncionarios");
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
