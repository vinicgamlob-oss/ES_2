package PGK_1;

import java.util.List;

/**
 * Classe controladora central que atua como a fachada (Facade) do sistema de estoque.
 * Orquestra as operações de cadastro de entidades, regras restritivas de armazenamento 
 * de lotes, gerenciamento de algoritmos logísticos e emissão de informatórios de auditoria.
 * * @author Vinicius
 */
public class SistemaEstoque {
    
    /** Instância única do estoque obtida via padrão Singleton para manipulação dos dados. */
    private Estoque estoque = Estoque.getInstance();

    /**
     * Realiza o cadastro de um fornecedor parceiro validando os critérios mínimos fiscais.
     *
     * @param novo O objeto Fornecedor a ser inserido no sistema.
     * @return true se o CNPJ possuir extensão válida e for catalogado; false caso viole as regras fiscais.
     */
    public boolean cadastrarFornecedor(Fornecedor novo) {
        if (novo.getCnpj() < 100000) return false;
        estoque.getFornecedores().add(novo);
        return true;
    }

    /**
     * Insere um novo produto na base de dados após realizar a verificação de integridade de chaves.
     * Varre o catálogo atual para impedir a duplicidade de produtos com o mesmo código de barras.
     *
     * @param novo O objeto Produto proposto para cadastro.
     * @return true se o produto for inédito e catalogado com sucesso; false se o código de barras já existir.
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
     * Avalia a consistência física e cronológica de um lote antes de autorizar sua entrada no armazém.
     * Aplica quatro travas de segurança consecutivas: quantidade estritamente positiva, ano de validade 
     * vigente (superior a 2026), cronologia lógica de fabricação/recebimento e verificação de 
     * transbordo de capacidade física máxima (overload) do estoque.
     *
     * @param novo O objeto Lote submetido para conferência de entrada.
     * @return true se o lote atender a todos os parâmetros de integridade física e espaço; 
     * false se violar qualquer uma das restrições ou estourar a capacidade do armazém.
     */
    public boolean registrarLote(Lote novo) {
        if (novo.getQtd_de_Produtos() <= 0) return false;
        if (novo.getValidade() < 2026) return false; 
        if (novo.getData_Recebida() < novo.getData_Fabricacao()) return false;
        
        if ((estoque.getQtdAtualNoArmazem() + novo.getQtd_de_Produtos()) > estoque.getCapacidadeMaxima()) {
            return false; 
        }

        estoque.adicionarLote(novo);
        return true;
    }

    /**
     * Aciona dinamicamente a estratégia logística FEFO (First Expired, First Out) no estoque.
     * Configura o algoritmo para priorizar a saída de mercadorias com a data de vencimento mais próxima.
     *
     * @return Uma lista de lotes ordenada de forma crescentemente pelo ano de validade.
     */
    public List<Lote> executarFEFO() {
        estoque.definirEstrategia(new FEFOStrategy());
        return estoque.executarReposicao();
    }

    /**
     * Aciona dinamicamente a estratégia logística FIFO (First In, First Out) no estoque.
     * Configura o algoritmo para priorizar a saída de mercadorias baseando-se estritamente na ordem de chegada.
     *
     * @return Uma lista de lotes ordenada cronologicamente pela data de recebimento na plataforma.
     */
    public List<Lote> executarFIFO() {
        estoque.definirEstrategia(new FIFOStrategy());
        return estoque.executarReposicao();
    }

    /**
     * Instancia o gerador de relatórios cronológicos e emite o informativo textual de validades.
     *
     * @return Uma String contendo a listagem formatada dos lotes vencidos sob auditoria.
     */
    public String gerarRelatorioValidade() {
        return new RelatorioValidade().gerarRelatorio();
    }

    /**
     * Instancia o gerador de relatórios de perdas e emite o demonstrativo de itens descartados e prejuízos.
     *
     * @return Uma String contendo o compilado formatado com os produtos fora da validade.
     */
    public String gerarRelatorioPerdas() {
        return new RelatorioPerdas().gerarRelatorio();
    }
}