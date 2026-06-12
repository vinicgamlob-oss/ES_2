package PGK_1;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class FIFOStrategy implements EstrategiaReposicao {

    /**
     *
     * @param lotes
     * @return
     */
    @Override
    public List<Lote> ordenarSaida(List<Lote> lotes) {
        List<Lote> resultado = new ArrayList<>(lotes);
        resultado.sort((l1, l2) -> Integer.compare(l1.getData_Recebida(), l2.getData_Recebida()));
        return resultado;
    }
}