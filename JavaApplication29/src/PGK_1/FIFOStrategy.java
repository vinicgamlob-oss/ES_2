package PGK_1;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vinicius
 */
public class FIFOStrategy implements EstrategiaReposicao {
<<<<<<< HEAD
    
    /**
     * Ordena a lista de lotes aplicando o algoritmo FIFO (First In, First Out).
     * Organiza os lotes em ordem crescentemente cronológica com base na data de recebimento, 
     * garantindo que as mercadorias que deram entrada primeiro no armazém sejam priorizadas para a saída.
     *
     * @param lotes A lista original de lotes disponíveis no estoque.
     * @return Uma nova lista clonada e ordenada contendo os lotes organizados por ordem de chegada.
=======

    /**
     *
     * @param lotes
     * @return
>>>>>>> 19f642692848786f833d73ba2df4e0bed526fafe
     */
    @Override
    public List<Lote> ordenarSaida(List<Lote> lotes) {
        List<Lote> resultado = new ArrayList<>(lotes);
        resultado.sort((l1, l2) -> Integer.compare(l1.getData_Recebida(), l2.getData_Recebida()));
        return resultado;
    }
}