package PGK_1;

import java.util.List;

/**
 *
 * @author Vinicius
 */
public class SistemaEstoque {
    private Estoque estoque = Estoque.getInstance();

    /**
     *
     * @param novo
     * @return
     */
    public boolean cadastrarFornecedor(Fornecedor novo) {
        if (novo.getCnpj() < 100000) return false;
        estoque.getFornecedores().add(novo);
        return true;
    }

    /**
     *
     * @param novo
     * @return
     */
    public boolean cadastrarProduto(Produto novo) {
    for (Produto p : estoque.getProdutos()) {
        
        if (p.getCoddigoBarra() == novo.getCoddigoBarra()) {
            return false; 
        }
    }
    estoque.getProdutos().add(novo);
    return true;
}

    /**
     *
     * @param novo
     * @return
     */
    public boolean registrarLote(Lote novo) {
    if (novo.getQtd_de_Produtos() <= 0) return false;
    
    
    if (novo.getValidade() <= 2026) return false; 
    
    if (novo.getData_Recebida() < novo.getData_Fabricacao()) return false;
    
    if ((estoque.getQtdAtualNoArmazem() + novo.getQtd_de_Produtos()) > estoque.getCapacidadeMaxima()) {
        return false; 
    }

    estoque.adicionarLote(novo);
    return true;
}

    /**
     *
     * @return
     */
    public List<Lote> executarFEFO() {
        estoque.definirEstrategia(new FEFOStrategy());
        return estoque.executarReposicao();
    }

    /**
     *
     * @return
     */
    public List<Lote> executarFIFO() {
        estoque.definirEstrategia(new FIFOStrategy());
        return estoque.executarReposicao();
    }

    /**
     *
     * @return
     */
    public String gerarRelatorioValidade() {
        return new RelatorioValidade().gerarRelatorio();
    }

    /**
     *
     * @return
     */
    public String gerarRelatorioPerdas() {
        return new RelatorioPerdas().gerarRelatorio();
    }
}