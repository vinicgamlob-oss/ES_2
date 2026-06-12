package PGK_1;
import java.util.ArrayList;
import java.util.List;

public class FEFOStrategy implements EstrategiaReposicao {
    
    
    
    /**
     * Ordena a lista de lotes aplicando o algoritmo FEFO (First Expired, First Out).
     * Organiza os lotes em ordem crescente com base no ano de validade, garantindo que 
     * os produtos com vencimento mais próximo sejam priorizados para a saída.
     *
     * @param lotes A lista original de lotes disponíveis no estoque.
     * @return Uma nova lista clonada e ordenada contendo os lotes prontos para expedição.
     */
    @Override
    public List<Lote> ordenarSaida(List<Lote> lotes) {
        List<Lote> resultado = new ArrayList<>(lotes);
        resultado.sort((l1, l2) -> Integer.compare(l1.getValidade(), l2.getValidade()));
        return resultado;
    }
}