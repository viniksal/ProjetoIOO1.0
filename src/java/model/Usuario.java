package model;

public class Usuario {
    private int idUsuario;
    private String email;
    private String senha;
    
    //IDUSUARIO
    public int getIdUsuario(){
        return idUsuario;
    }
    
    public void setIdUsuario(int idUsuario){
        this.idUsuario = idUsuario;
    }
    
    //EMAIL
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    //SENHA
    public String getSenha(){
        return senha;
    }
    
    public void setSenha(String senha){
        this.senha = senha;
    }
}
