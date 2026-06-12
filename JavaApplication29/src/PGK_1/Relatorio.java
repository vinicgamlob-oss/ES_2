package PGK_1;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public abstract class Relatorio {

    /**
     *
     */
    protected List<Lote> dados;

<<<<<<< HEAD
    
   /**
     * Define o esqueleto do algoritmo para a geração de relatórios do sistema.
     * Coordena de forma sequencial as etapas de coleta de dados e processamento, 
     * garantindo que o fluxo de montagem do informativo textual seja sempre padronizado.
     *
     * @return Uma String contendo o relatório final totalmente processado e formatado.
=======
    /**
     *
     * @return
>>>>>>> 19f642692848786f833d73ba2df4e0bed526fafe
     */
    public final String gerarRelatorio() {
        coletarDados();
        return processarEFormatar();
    }

    /**
<<<<<<< HEAD
     * Realiza a primeira etapa da montagem do relatório, extraindo as informações brutas.
     * Consulta diretamente a instância centralizada do Estoque (via padrão Singleton) para 
     * popular a coleção de lotes que será submetida à análise e formatação.
=======
     *
>>>>>>> 19f642692848786f833d73ba2df4e0bed526fafe
     */
    protected void coletarDados() {
        this.dados = Estoque.getInstance().getLotes();
    }

    /**
     *
     * @return
     */
    protected abstract String processarEFormatar();
}