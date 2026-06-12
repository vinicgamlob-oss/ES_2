package PGK_1;

import java.util.List;

/**
 * Classe abstrata que define a estrutura para a geração de relatórios do sistema.
 * Implementa o padrão de projeto comportamental Template Method, estabelecendo um esqueleto 
 * rígido de execução sequencial enquanto delega os passos de estilização para as subclasses.
 * * @author Vinicius
 */
public abstract class Relatorio {

    /** Coleção de dados brutos de lotes compartilhada com as subclasses para processamento. */
    protected List<Lote> dados;

    /**
     * Define o esqueleto do algoritmo para a geração de relatórios do sistema.
     * Coordena de forma sequencial as etapas de coleta de dados e processamento, 
     * garantindo que o fluxo de montagem do informativo textual seja sempre padronizado.
     *
     * @return Uma String contendo o relatório final totalmente processado e formatado.
     */
    public final String gerarRelatorio() {
        coletarDados();
        return processarEFormatar();
    }

    /**
     * Realiza a primeira etapa da montagem do relatório, extraindo as informações brutas.
     * Consulta diretamente a instância centralizada do Estoque (via padrão Singleton) para 
     * popular a coleção de lotes que será submetida à análise e formatação.
     */
    protected void coletarDados() {
        this.dados = Estoque.getInstance().getLotes();
    }

    /**
     * Método abstrato (passo customizável) que deve ser implementado pelas subclasses.
     * Define a lógica específica de filtragem, cálculos e formatação textual dos dados do relatório.
     *
     * @return Uma String contendo o corpo do relatório devidamente processado e formatado.
     */
    protected abstract String processarEFormatar();
}