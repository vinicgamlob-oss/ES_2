package PGK_1;

import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author vinicius
 */
public class Lote {
    
   
    private int Codigo;
    private Produto Produto;
    private int Validade;
    private int Qtd_de_Produtos; 
    private int Data_Recebida;
    private int Data_Fabricacao;

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    public Produto getProduto() {
        return Produto;
    }

    public void setProduto(Produto Produto) {
        this.Produto = Produto;
    }

    public int getValidade() {
        return Validade;
    }

    public void setValidade(int Validade) {
        this.Validade = Validade;
    }

    public int getQtd_de_Produtos() {
        return Qtd_de_Produtos;
    }

    public void setQtd_de_Produtos(int Qtd_de_Produtos) {
        this.Qtd_de_Produtos = Qtd_de_Produtos;
    }

    public int getData_Recebida() {
        return Data_Recebida;
    }

    public void setData_Recebida(int Data_Recebida) {
        this.Data_Recebida = Data_Recebida;
    }

    public int getData_Fabricacao() {
        return Data_Fabricacao;
    }

    public void setData_Fabricacao(int Data_Fabricacao) {
        this.Data_Fabricacao = Data_Fabricacao;
    }

    
   
    public Lote(int Codigo, Produto Produto, int Validade, int Qtd_de_Produtos, int Data_Recebida, int Data_Fabricacao) {
        this.Codigo = Codigo;
        this.Produto = Produto;
        this.Validade = Validade;
        this.Qtd_de_Produtos = Qtd_de_Produtos;
        this.Data_Recebida = Data_Recebida;
        this.Data_Fabricacao = Data_Fabricacao;
    }
    
    public static boolean cadastrarLote(List<Lote> lista, Lote novo) {
        
        if (novo.getQtd_de_Produtos() <= 0) {
            return false;
        }
        
       
        if (novo.getValidade() < 2026) {
            return false;
        }
        
        
        if (novo.getData_Recebida() < novo.getData_Fabricacao()) {
            return false;
        }
        
        lista.add(novo);
        return true;
    }

    
    public static boolean consultarLote(List<Lote> lista, int codigoBuscado) {
        for (Lote l : lista) {
            if (l.getCodigo() == codigoBuscado) {
                return true; 
            }
        }
        return false;
    }

   
    public static boolean ajustarSaldo(List<Lote> lista, int codigoBuscado, int novaQtd) {
        if (novaQtd < 0) {
            return false;
        }
        for (Lote l : lista) {
            if (l.getCodigo() == codigoBuscado) {
                l.setQtd_de_Produtos(novaQtd); 
                return true;
            }
        }
        return false;
    }

    public static boolean gerarRelatorioVencimento(List<Lote> lista) {
        if (lista == null || lista.isEmpty()) {
            return false;
        }
      
        return true;
    }

   
    public static boolean gerarRelatorioPerdas(List<Lote> lista) {
        boolean possuiPerdas = false;
        for (Lote l : lista) {
           
            if (l.getValidade() < 2026) {
                possuiPerdas = true;
            }
        }
        return possuiPerdas; 
    }

   
    public static boolean salvarRotaLogistica(Fornecedor fornecedor, String nomeRota) {
        if (fornecedor == null) {
            return false; 
        }
        
        return true;
    }

    
    public static boolean cadastrarLoteComLimite(List<Lote> lista, Lote novo, int qtdAtualNoArmazem, int capacidadeMaxima) {
        
        if ((qtdAtualNoArmazem + novo.getQtd_de_Produtos()) > capacidadeMaxima) {
            return false; 
        }
        
        lista.add(novo);
        return true;
    }
   
    
}