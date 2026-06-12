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
public class Fornecedor {

    /**
     *
     * @param Cnpj
     * @param nomef
     */
    public Fornecedor(int Cnpj, String nomef) {
        this.Cnpj = Cnpj;
        this.nomef = nomef;
    }

    private int Cnpj;
    private String nomef;
    private String empresa;
    private String endereco;

    /**
     *
     * @return
     */
    public String getEmpresa() {
        return empresa;
    }

    /**
     *
     * @param empresa
     */
    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    /**
     *
     * @return
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     *
     * @param endereco
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     *
     * @return
     */
    public int getCnpj() {
        return Cnpj;
    }

    /**
     *
     * @param Cnpj
     */
    public void setCnpj(int Cnpj) {
        this.Cnpj = Cnpj;
    }

    /**
     *
     * @return
     */
    public String getNomef() {
        return nomef;
    }

    /**
     *
     * @param nomef
     */
    public void setNomef(String nomef) {
        this.nomef = nomef;
    }
    
    List<Fornecedor> lf = new ArrayList<>();

    /**
     *
     * @param par
     * @param fornecedor_A
     * @param nome
     */
    public Fornecedor(int par, String fornecedor_A, String nome) {
    }

    /**
     *
     * @param lista
     * @param novo
     * @return
     */
    public static boolean cadastrarFornecedor(List<Fornecedor> lista, Fornecedor novo) {

        if (novo.getCnpj() < 100000){
            return false;
        }

        lista.add(novo);
        return true;
    }
    
    /**
     *
     * @param lista
     * @param cnpjBuscado
     * @return
     */
    public static boolean buscarFornecedor(List<Fornecedor> lista, int cnpjBuscado) {
    
    for (Fornecedor f : lista) {
        if (f.getCnpj()== cnpjBuscado) {
            return true; 
        }
    }
    
    return false; 
}
    
    /**
     *
     * @param lista
     * @param cnpjAlvo
     * @param novoNomef
     * @param novoCnpj
     * @return
     */
    public static boolean alterarFornecedor(List<Fornecedor> lista, int cnpjAlvo, String novoNomef, int novoCnpj) {
    
    for (Fornecedor f : lista) {
        if (f.getCnpj() == novoCnpj && f.getCnpj() != cnpjAlvo) {
            return false; 
        }
    }
   
    for (Fornecedor f : lista) {
        if (f.getCnpj() == cnpjAlvo) {
            f.setNomef(novoNomef);
            f.setCnpj(novoCnpj);
            return true; 
        }
    }
    
    return false; 
}

}
