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
<<<<<<< HEAD
     * Garante que a variável instancia nunca fique vazia (nula), gerenciando o ciclo de vida único do estoque.
     * Implementa o padrão Singleton de forma thread-safe.
     * * @return A instância única e centralizada do estoque do sistema.
=======
     *
     * @return
>>>>>>> 19f642692848786f833d73ba2df4e0bed526fafe
     */
    public static synchronized Estoque getInstance() {
        if (instancia == null) {
            instancia = new Estoque();
        }
        return instancia;
    }
    
    /**
<<<<<<< HEAD
     * Insere fisicamente um novo lote de produtos na lista de armazenamento do estoque.
     * Este método é chamado após todas as validações de segurança do sistema terem sido aprovadas.
     *
     * @param lote O objeto Lote validado que será adicionado à coleção.
=======
     *
     * @param lote
>>>>>>> 19f642692848786f833d73ba2df4e0bed526fafe
     */
    public void adicionarLote(Lote lote) {
        this.lotes.add(lote); 
    }

    /**
<<<<<<< HEAD
     * Retorna a lista de lotes armazenados no estoque.
     *
     * @return A lista contendo todos os lotes.
=======
     *
     * @return
>>>>>>> 19f642692848786f833d73ba2df4e0bed526fafe
     */
    public List<Lote> getLotes() { return lotes; }

    /**
<<<<<<< HEAD
     * Retorna a lista de produtos cadastrados.
     *
     * @return A lista contendo os produtos.
=======
     *
     * @return
>>>>>>> 19f642692848786f833d73ba2df4e0bed526fafe
     */
    public List<Produto> getProdutos() { return produtos; }

    /**
<<<<<<< HEAD
     * Retorna a lista de fornecedores parceiros comerciais.
     *
     * @return A lista contendo os fornecedores.
=======
     *
     * @return
>>>>>>> 19f642692848786f833d73ba2df4e0bed526fafe
     */
    public List<Fornecedor> getFornecedores() { return fornecedores; }
    
    /**
<<<<<<< HEAD
     * Consulta a quantidade total de itens atualmente armazenados no armazém.
     * Realiza o somatório dos produtos de todos os lotes ativos, permitindo um controle 
     * eficiente de ocupação e evitando a sobrecarga da capacidade máxima.
     *
     * @return O número total de mercadorias físicas estocadas no momento.
=======
     *
     * @return
>>>>>>> 19f642692848786f833d73ba2df4e0bed526fafe
     */
    public int getQtdAtualNoArmazem() {
        int total = 0;
        for (Lote l : lotes) {
            total += l.getQtd_de_Produtos();
        }
        return total;
    }
    
    /**
<<<<<<< HEAD
     * Retorna a capacidade máxima suportada pelo armazém.
     *
     * @return O limite total de armazenamento em inteiro.
=======
     *
     * @return
>>>>>>> 19f642692848786f833d73ba2df4e0bed526fafe
     */
    public int getCapacidadeMaxima() { return capacidadeMaxima; }

    /**
<<<<<<< HEAD
     * Configura dinamicamente a estratégia de reposição e ordenação de estoque que será utilizada.
     * Permite alternar entre diferentes algoritmos de logística (como FIFO ou FEFO) em tempo de execução.
     *
     * @param e O objeto contendo a estratégia de reposição escolhida.
=======
     *
     * @param e
>>>>>>> 19f642692848786f833d73ba2df4e0bed526fafe
     */
    public void definirEstrategia(EstrategiaReposicao e) {
        this.estrategia = e;
    }

    /**
<<<<<<< HEAD
     * Executa o processo de reposição de estoque aplicando a estratégia atualmente configurada.
     * Caso nenhuma estratégia específica tenha sido definida, retorna a lista original de lotes 
     * sem nenhuma ordenação adicional.
     *
     * @return Uma lista de objetos Lote ordenada conforme os critérios da estratégia logística aplicada.
=======
     *
     * @return
>>>>>>> 19f642692848786f833d73ba2df4e0bed526fafe
     */
    public List<Lote> executarReposicao() {
        if (estrategia != null) {
            return estrategia.ordenarSaida(this.lotes);
        }
        return this.lotes;
    }
}