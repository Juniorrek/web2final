/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Empresa;
import model.Funcionario;

/**
 *
 * @author Fornalha
 */
public class EmpresaDao {
    public static List<Empresa> listarEmpresas() throws SQLException {
        List<Empresa> empresas = new ArrayList<Empresa>();
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("SELECT * "
                                             + "FROM Empresa ");
            ResultSet resultSet = stmt.executeQuery();
            
            while(resultSet.next()){
                Empresa empresa = new Empresa(resultSet.getInt("codigo"),
                                              resultSet.getString("cnpj"),
                                              resultSet.getString("razao_social"),
                                              resultSet.getString("endereco"),
                                              resultSet.getString("email"),
                                              null);
                empresas.add(empresa);
                
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro. Origem="+exception.getMessage());
        } finally {
            if (stmt != null)
                try { stmt.close(); }
                catch (SQLException exception) { System.out.println("Erro ao fechar stmt. Ex="+exception.getMessage()); }
            if (connection != null)
                try { connection.close(); }
                catch (SQLException exception) { System.out.println("Erro ao fechar conexão. Ex="+exception.getMessage()); }
        }
        
        return empresas;
    }
    
    public static void adicionarEmpresa(Empresa empresa) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("INSERT INTO Empresa (cnpj, razao_social, endereco, email) "
                                             + "VALUES (?, ?, ?, ?)");
            stmt.setString(1, empresa.getCnpj());
            stmt.setString(2, empresa.getRazaoSocial());
            stmt.setString(3, empresa.getEndereco());
            stmt.setString(4, empresa.getEmail());
            stmt.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro. Origem="+exception.getMessage());
        } finally {
            if (stmt != null)
                try { stmt.close(); }
                catch (SQLException exception) { System.out.println("Erro ao fechar stmt. Ex="+exception.getMessage()); }
            if (connection != null)
                try { connection.close(); }
                catch (SQLException exception) { System.out.println("Erro ao fechar conexão. Ex="+exception.getMessage()); }
        }
    }
    
    public static Empresa formEditarEmpresa(int codigo, List<Funcionario> funcionarios) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("SELECT * "
                                             + "FROM Empresa "
                                             + "WHERE Empresa.codigo = ?");
            stmt.setInt(1, codigo);
            ResultSet resultSet = stmt.executeQuery();
            
            if(resultSet.next()){
                return new Empresa(resultSet.getInt("codigo"),
                                   resultSet.getString("cnpj"),
                                   resultSet.getString("razao_social"),
                                   resultSet.getString("endereco"),
                                   resultSet.getString("email"),
                                   funcionarios);
            } else {
                return null;
            }
        } catch (SQLException exception) {
            throw new RuntimeException("Erro. Origem="+exception.getMessage());
        } finally {
            if (stmt != null)
                try { stmt.close(); }
                catch (SQLException exception) { System.out.println("Erro ao fechar stmt. Ex="+exception.getMessage()); }
            if (connection != null)
                try { connection.close(); }
                catch (SQLException exception) { System.out.println("Erro ao fechar conexão. Ex="+exception.getMessage()); }
        }
    }
    
    public static void editarEmpresa(Empresa empresa) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("UPDATE Empresa "
                                             + "SET cnpj = ?, razao_social = ?, endereco = ?, email = ? "
                                             + "WHERE codigo = ? ");
            stmt.setString(1, empresa.getCnpj());
            stmt.setString(2, empresa.getRazaoSocial());
            stmt.setString(3, empresa.getEndereco());
            stmt.setString(4, empresa.getEmail());
            stmt.setInt(5, empresa.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro. Origem="+exception.getMessage());
        } finally {
            if (stmt != null)
                try { stmt.close(); }
                catch (SQLException exception) { System.out.println("Erro ao fechar stmt. Ex="+exception.getMessage()); }
            if (connection != null)
                try { connection.close(); }
                catch (SQLException exception) { System.out.println("Erro ao fechar conexão. Ex="+exception.getMessage()); }
        }
    }
    
    public static void excluirEmpresa(Empresa empresa) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("DELETE FROM Empresa "
                                             + "WHERE codigo = ? ");
            stmt.setInt(1, empresa.getCodigo());
            stmt.executeUpdate();
        } catch (SQLException exception) {
            throw new RuntimeException("Erro. Origem="+exception.getMessage());
        } finally {
            if (stmt != null)
                try { stmt.close(); }
                catch (SQLException exception) { System.out.println("Erro ao fechar stmt. Ex="+exception.getMessage()); }
            if (connection != null)
                try { connection.close(); }
                catch (SQLException exception) { System.out.println("Erro ao fechar conexão. Ex="+exception.getMessage()); }
        }
    }
}
