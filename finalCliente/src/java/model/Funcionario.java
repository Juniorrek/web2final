/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;

/**
 *
 * @author Fornalha
 */
public class Funcionario implements Serializable {
    private int codigo;
    private String cpf;
    private String nome;
    private String endereco;
    private String email;
    private String celular;
    //private Empresa empresa; BUGGGGGGGGGGGGGGGGGGG
    private String empresa_codigo;

    public Funcionario() {}

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmpresa_codigo() {
        return empresa_codigo;
    }

    public void setEmpresa_codigo(String empresa_codigo) {
        this.empresa_codigo = empresa_codigo;
    }
}
