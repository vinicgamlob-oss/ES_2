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

    /**
     *
     * @return
     */
    public final String gerarRelatorio() {
        coletarDados();
        return processarEFormatar();
    }

    /**
     *
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