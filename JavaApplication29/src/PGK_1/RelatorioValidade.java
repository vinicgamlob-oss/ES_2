package PGK_1;

/**
 *
 * @author Vinicius
 */
public class RelatorioValidade extends Relatorio {

    /**
     *
     * @return
     */
    @Override
    protected String processarEFormatar() {
        StringBuilder sb = new StringBuilder("--- RELATÓRIO DE VALIDADE ---\n");
        for (Lote l : dados) {
            if (l.getValidade() < 2026) { 
                sb.append("Lote: ").append(l.getCodigo()).append(" - VENCIDO (")
                  .append(l.getValidade()).append(")\n");
            }
        }
        return sb.toString();
    }
}