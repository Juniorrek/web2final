/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ws;

import com.google.gson.Gson;
import dao.FuncionarioDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import model.Funcionario;
import model.Pessoa;

/**
 * REST Web Service
 *
 * @author Fornalha
 */
@Path("funcionarios")
public class FuncionarioResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of FuncionarioResource
     */
    public FuncionarioResource() {
    }

    /**
     * Retrieves representation of an instance of ws.FuncionarioResource
     * @return an instance of java.lang.String
     *
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of FuncionarioResource
     * @param  representation for the resource
     *
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }*/
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFuncionarios() {
        List<Funcionario> funcionarios = null;
        
        try {
            funcionarios = FuncionarioDao.listarFuncionarios();
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*Gson gson = new Gson();
        String x = gson.toJson(funcionarios);*/
        GenericEntity<List<Funcionario>> lista = new GenericEntity<List<Funcionario>>(funcionarios) {};
        return Response.ok().entity(lista).build();
    }
    
    @GET
    @Path("/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Funcionario getFuncionarios(@PathParam("codigo") int codigo) {
        Funcionario funcionario = null;
        
        try {
            funcionario = FuncionarioDao.formEditarFuncionario(codigo);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return funcionario;
    }
    
    @GET
    @Path("/empresa/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getFuncionariosByEmpresaCodigo(@PathParam("codigo") int codigo) {
        List<Funcionario> funcionarios = null;
        
        try {
            funcionarios = FuncionarioDao.getFuncionariosByEmpresaCodigo(codigo);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        /*Gson gson = new Gson();
        String x = gson.toJson(funcionarios);*/
        GenericEntity<List<Funcionario>> lista = new GenericEntity<List<Funcionario>>(funcionarios) {};
        return Response.ok().entity(lista).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void adicionarFuncionario(Funcionario funcionario) {
        try {
            FuncionarioDao.adicionarFuncionario(funcionario);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @PUT
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void editarFuncionario(Funcionario funcionario, @PathParam("codigo") int codigo) {
        try {
            FuncionarioDao.editarFuncionario(funcionario, codigo);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @DELETE
    @Path("/{codigo}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void deletarFuncionario(@PathParam("codigo") int codigo) {
        try {
            FuncionarioDao.deletarFuncionario(codigo);
        } catch (SQLException ex) {
            Logger.getLogger(FuncionarioResource.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
