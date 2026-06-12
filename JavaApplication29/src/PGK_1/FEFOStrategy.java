package PGK_1;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class FEFOStrategy implements EstrategiaReposicao {

    /**
     *
     * @param lotes
     * @return
     */
    @Override
    public List<Lote> ordenarSaida(List<Lote> lotes) {
        List<Lote> resultado = new ArrayList<>(lotes);
        resultado.sort((l1, l2) -> Integer.compare(l1.getValidade(), l2.getValidade()));
        return resultado;
    }
}