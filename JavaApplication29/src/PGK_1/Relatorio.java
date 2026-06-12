package PGK_1;
import java.util.List;

public abstract class Relatorio {
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

    protected abstract String processarEFormatar();
}