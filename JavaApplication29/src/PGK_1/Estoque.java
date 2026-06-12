package PGK_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Entidade centralizada que gerencia o armazenamento de lotes, produtos e fornecedores.
 * Implementa o padrão de projeto estrutural Singleton para garantir uma única base de dados em memória, 
 * e atua como o contexto do padrão comportamental Strategy para alternar algoritmos logísticos.
 * * @author Vinicius
 */
public class Estoque {
    private static Estoque instancia;
    
    private List<Lote> lotes = new ArrayList<>();
    private List<Produto> produtos = new ArrayList<>();
    private List<Fornecedor> fornecedores = new ArrayList<>();
    private EstrategiaReposicao estrategia;
    
    private int capacidadeMaxima = 1000; 

    /**
     * Construtor privado para impedir instanciações externas diretas, 
     * reforçando o controle de ciclo de vida do padrão Singleton.
     */
    private Estoque() {}

    /**
     * Garante que a variável instancia nunca fique vazia (nula), gerenciando o ciclo de vida único do estoque.
     * Implementa o padrão Singleton de forma thread-safe utilizando sincronização.
     *
     * @return A instância única e centralizada do estoque do sistema.
     */
    public static synchronized Estoque getInstance() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }
    
    /**
     * Insere fisicamente um novo lote de produtos na lista de armazenamento do estoque.
     * Este método é chamado após todas as validações de segurança do sistema terem sido aprovadas.
     *
     * @param lote O objeto Lote validado que será adicionado à coleção.
     */
    public void adicionarLote(Lote lote) {
        this.lotes.add(lote); 
    }

    /**
     * Retorna a lista de lotes armazenados no estoque.
     *
     * @return A lista contendo todos os lotes ativos.
     */
    public List<Lote> getLotes() { return lotes; }

    /**
     * Retorna a lista de produtos cadastrados no sistema.
     *
     * @return A lista contendo o catálogo de produtos.
     */
    public List<Produto> getProdutos() { return produtos; }

    /**
     * Retorna a lista de fornecedores parceiros comerciais catalogados.
     *
     * @return A lista contendo os fornecedores registrados.
     */
    public List<Fornecedor> getFornecedores() { return fornecedores; }
    
    /**
     * Consulta a quantidade total de itens atualmente armazenados no armazém.
     * Realiza o somatório dos produtos de todos os lotes ativos, permitindo um controle 
     * eficiente de ocupação e evitando a sobrecarga da capacidade máxima.
     *
     * @return O número total de mercadorias físicas estocadas no momento.
     */
    public int getQtdAtualNoArmazem() {
        int total = 0;
        for (Lote l : lotes) {
            total += l.getQtd_de_Produtos();
        }
        return total;
    }
    
    /**
     * Retorna a capacidade máxima física suportada pelo armazém.
     *
     * @return O limite total de unidades permitido para armazenamento.
     */
    public int getCapacidadeMaxima() { return capacidadeMaxima; }

    /**
     * Configura dinamicamente a estratégia de reposição e ordenação de estoque que será utilizada.
     * Permite alternar entre diferentes algoritmos de logística (como FIFO ou FEFO) em tempo de execução.
     *
     * @param e O objeto contendo a estratégia de reposição escolhida.
     */
    public void definirEstrategia(EstrategiaReposicao e) {
        this.estrategia = e;
    }

    /**
     * Executa o processo de reposição de estoque aplicando a estratégia atualmente configurada.
     * Caso nenhuma estratégia específica tenha sido definida, retorna a lista original de lotes 
     * sem nenhuma ordenação adicional.
     *
     * @return Uma lista de objetos Lote ordenada conforme os critérios da estratégia logística aplicada.
     */
    public List<Lote> executarReposicao() {
        if (estrategia != null) {
            return estrategia.ordenarSaida(this.lotes);
        }
        return this.lotes;
    }
}