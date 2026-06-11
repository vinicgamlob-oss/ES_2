/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PGK_1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinicius
 */
public class Produto {
    
    List<Produto> lp = new ArrayList<>();

    public Produto(int codigo, int codigoBarra) {
        this.codigo = codigo;
        this.codigoBarra = codigoBarra;
    }
    
    private int codigo;
    private int codigoBarra;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getCoddigoBarra() {
        return codigoBarra;
    }

    public void setCoddigoBarra(int coddigoBarra) {
        this.codigoBarra = coddigoBarra;
    }
    
    
   public static boolean cadastrarProduto(List<Produto> lista, Produto novo) {
    for (Produto p : lista) {
        if (p.getCodigo() == novo.getCodigo()) {
            return false; 
        }
    }
    
    lista.add(novo);
    return true;
}
    
    
    public static boolean consultarProduto(List<Produto> lp,int codigo){
        
        for(Produto p : lp){
        if (p.getCodigo() == codigo) { 
            return true;
        }
        }
        
        return false ;
    
    }
    
   public static boolean alterarProduto(List<Produto> lista, int codigoBuscado, int novoCodigoBarras) {
    
    for (Produto prod : lista) {
        if (prod.getCoddigoBarra() == novoCodigoBarras && prod.getCodigo() != codigoBuscado) {
            return false; 
        }
    }
   
    for (Produto p : lista) {
        if (p.getCodigo() == codigoBuscado) {
            p.setCoddigoBarra(novoCodigoBarras); 
            return true; 
        }
    }
    
    return false; 
}
}
