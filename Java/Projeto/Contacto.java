package Projeto;

import java.io.Serializable;

public class Contacto implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private String nome;
    private String telefone;
    private String email;

    public Contacto(String nome, String telefone, String email){
        if (nome == null || telefone == null || email == null){
            throw new IllegalArgumentException("Nome, telefone e email não podem ser nulos.");
        }
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        if (nome == null){
            throw new IllegalArgumentException("Nome não pode ser nulo.");
        }
        this.nome = nome;
    }

    public String getTelefone(){
        return telefone;
    }

    public void setTelefone(String telefone){
        if(telefone == null){
            throw new IllegalArgumentException("Telefone não pode ser nulo.");
        }
        this.telefone = telefone;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        if(email == null){
            throw new IllegalArgumentException("E-mail não pode ser nulo.");
        }
        this.email = email;
    }

    @Override
    public String toString(){
        return "Nome: " + nome + "\nTelefone: " + telefone + "\nEmail: " + email;
    }
}
