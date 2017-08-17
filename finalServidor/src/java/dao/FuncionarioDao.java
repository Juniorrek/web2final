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
import model.Funcionario;

/**
 *
 * @author Fornalha
 */
public class FuncionarioDao {
    public static List<Funcionario> getFuncionariosByEmpresaCodigo(int codigo) throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("SELECT * "
                                             + "FROM Funcionario "
                                             + "WHERE funcionario.empresa_codigo = ?");
            stmt.setInt(1, codigo);
            ResultSet resultSet = stmt.executeQuery();
            
            while(resultSet.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultSet.getInt("codigo"));
                funcionario.setCpf(resultSet.getString("cpf"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setEndereco(resultSet.getString("endereco"));
                funcionario.setEmail(resultSet.getString("email"));
                funcionario.setCelular(resultSet.getString("celular"));
                funcionarios.add(funcionario);
                
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
        
        return funcionarios;
    }
    
    public static List<Funcionario> listarFuncionarios() throws SQLException {
        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("SELECT * "
                                             + "FROM Funcionario ");
            ResultSet resultSet = stmt.executeQuery();
            
            while(resultSet.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultSet.getInt("codigo"));
                funcionario.setCpf(resultSet.getString("cpf"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setEndereco(resultSet.getString("endereco"));
                funcionario.setEmail(resultSet.getString("email"));
                funcionario.setCelular(resultSet.getString("celular"));
                funcionario.setEmpresa_codigo(resultSet.getString("empresa_codigo"));
                funcionarios.add(funcionario);
                
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
        
        return funcionarios;
    }
    
    public static Funcionario formEditarFuncionario(int codigo) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("SELECT * "
                                             + "FROM Funcionario "
                                             + "WHERE codigo = ?");
            stmt.setInt(1, codigo);
            ResultSet resultSet = stmt.executeQuery();
            
            if(resultSet.next()){
                Funcionario funcionario = new Funcionario();
                funcionario.setCodigo(resultSet.getInt("codigo"));
                funcionario.setCpf(resultSet.getString("cpf"));
                funcionario.setNome(resultSet.getString("nome"));
                funcionario.setEndereco(resultSet.getString("endereco"));
                funcionario.setEmail(resultSet.getString("email"));
                funcionario.setCelular(resultSet.getString("celular"));
                funcionario.setEmpresa_codigo(resultSet.getString("empresa_codigo"));
                return funcionario;
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
    
    public static void adicionarFuncionario(Funcionario funcionario) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("INSERT INTO Funcionario (cpf, nome, endereco, email, celular, empresa_codigo) "
                                             + "VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getEndereco());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getCelular());
            stmt.setString(6, funcionario.getEmpresa_codigo());
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
    
    public static void editarFuncionario(Funcionario funcionario, int codigo) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("UPDATE Funcionario "
                                             + "SET cpf = ?, nome = ?, endereco = ?, email = ?, celular = ?, empresa_codigo = ? "
                                             + "WHERE codigo = ?");
            stmt.setString(1, funcionario.getCpf());
            stmt.setString(2, funcionario.getNome());
            stmt.setString(3, funcionario.getEndereco());
            stmt.setString(4, funcionario.getEmail());
            stmt.setString(5, funcionario.getCelular());
            stmt.setString(6, funcionario.getEmpresa_codigo());
            stmt.setInt(7, codigo);
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
    
    public static void deletarFuncionario(int codigo) throws SQLException {
        Connection connection = new ConnectionFactory().getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = connection.prepareStatement("DELETE FROM Funcionario "
                                             + "WHERE codigo = ? ");
            stmt.setInt(1, codigo);
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
