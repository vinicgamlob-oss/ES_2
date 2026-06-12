package PGK_1;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class Estoque {
    private static Estoque instancia;
    
    private List<Lote> lotes = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private List<Fornecedor> fornecedores = new ArrayList<>();
    private EstrategiaReposicao estrategia;
    
    private int capacidadeMaxima = 1000; 

    private Estoque() {}

    /**
     *
     * @return
     */
    public static synchronized Estoque getInstance() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }
    
    /**
     *
     * @param lote
     */
    public void adicionarLote(Lote lote) {
        this.lotes.add(lote); 
    }

    /**
     *
     * @return
     */
    public List<Lote> getLotes() { return lotes; }

    /**
     *
     * @return
     */
    public List<Produto> getProdutos() { return produtos; }

    /**
     *
     * @return
     */
    public List<Fornecedor> getFornecedores() { return fornecedores; }
    
    /**
     *
     * @return
     */
    public int getQtdAtualNoArmazem() {
        int total = 0;
        for (Lote l : lotes) {
            total += l.getQtd_de_Produtos();
        }
        return total;
    }
    
    /**
     *
     * @return
     */
    public int getCapacidadeMaxima() { return capacidadeMaxima; }

    /**
     *
     * @param e
     */
    public void definirEstrategia(EstrategiaReposicao e) {
        this.estrategia = e;
    }

    /**
     *
     * @return
     */
    public List<Lote> executarReposicao() {
        if (estrategia != null) {
            return estrategia.ordenarSaida(this.lotes);
        }
        return this.lotes;
    }
}