package com.example.ramon.hortifruticadastro.database;

/**
 * Created by Ramon on 27/05/2017.
 */

public class Cliente {

    private int id;
    private String email;
    private String nomeInstituicao;
    private String cnpj;
    private String telefone;
    private String password;

    public Cliente(String email, String nomeInstituicao, String cnpj, String telefone, String password) {
        this.email = email;
        this.nomeInstituicao = nomeInstituicao;
        this.cnpj = cnpj;
        this.telefone = telefone;
        this.password = password;
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nomeInstituicao='" + nomeInstituicao + '\'' +
                ", cnpj='" + cnpj + '\'' +
                ", telefone='" + telefone + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getNomeInstituicao() {
        return nomeInstituicao;
    }

    public void setNomeInstituicao(String nomeInstituicao) {
        this.nomeInstituicao = nomeInstituicao;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }




}
