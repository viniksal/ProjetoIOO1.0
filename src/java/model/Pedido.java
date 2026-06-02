package model;

import java.time.LocalDate; //Import da data

public class Pedido {
    private int idPedido;
    private String usuario;
    private String nomePedido;
    private int quantidade;
    private double preco;  
    private LocalDate data;
    
    //IDPEDIDO
    public int getIdPedido(){
        return idPedido;
    }
    
    public void setIdPedido(int idPedido){
        this.idPedido = idPedido;
    }
    
    //USUARIO
    public String getUsuario(){
        return usuario;
    }
    
    public void setUsuario(String usuario){
        this.usuario = usuario;
    }
    
    //NOMEPEDIDO    
    public String getNomePedido(){
        return nomePedido;
    }
    
    public void setNomePedido(String nomePedido){
        this.nomePedido = nomePedido;
    }
    
    //quantidade
    public int getQuantidade(){
        return quantidade;
    }
    
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    
    //PRECO
    
    public double getPreco(){
        return preco;
    }
    
    public void setPreco(double preco){
        this.preco = preco;
    }
    
    public LocalDate getData(){
        return data;
    }
    
    public void setData(LocalDate data){
        this.data = data;
    }
    
    //DATA
}
