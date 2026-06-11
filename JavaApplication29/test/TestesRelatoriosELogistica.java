


import org.junit.Test;
import static org.junit.Assert.assertEquals;
import PGK_1.Lote;
import PGK_1.Produto;
import PGK_1.Fornecedor;
import java.util.ArrayList;
import java.util.List;



public class TestesRelatoriosELogistica {

    List<Lote> ll = new ArrayList<>();
    Produto produtoBase = new Produto(10, 100);

    /**
     * CT025
     * Verificar a geração do relatório que lista os produtos ordenados por data de vencimento.
     * Existirem lotes e produtos cadastrados no sistema. O usuário está na tela de "Relatórios".
     * O teste espera que o método retorne verdadeiro (true), indicando a geração correta do relatório ordenado.
     */
    @Test
    public void testarGerarRelatorioOrdenadoPorVencimento() {
        ll.clear();
        ll.add(new Lote(501, produtoBase, 2029, 100, 2026, 2025));
        ll.add(new Lote(502, produtoBase, 2027, 50, 2026, 2025));
        
        boolean RE = true;
        boolean RO = Lote.gerarRelatorioVencimento(ll);
        
        assertEquals(RE, RO);
    }

    /**
     * CT026
     * Verificar a geração do relatório que consolida os produtos que venceram ou foram descartados do estoque.
     * O teste espera que o método retorne verdadeiro (true) ao processar o relatório de perdas com dados existentes.
     */
    @Test
    public void testarGerarRelatorioProdutosVencidosOuDescartados() {
        ll.clear();
        // Lote vencido (Validade 2024 em relação ao ano corrente 2026)
        ll.add(new Lote(503, produtoBase, 2024, 40, 2026, 2023)); 
        
        boolean RE = true;
        boolean RO = Lote.gerarRelatorioPerdas(ll);
        
        assertEquals(RE, RO);
    }

    /**
     * CT027
     * Garantir que o sistema notifique o usuário adequadamente se ele tentar gerar um relatório de perdas quando não houver nenhuma perda registrada.
     * O sistema não possui nenhum registro de produto vencido ou descartado. O usuário está na tela de "Relatórios".
     * O teste espera que o método retorne falso (false), disparando a notificação de ausência de dados.
     */
    @Test
    public void testarNotificarRelatorioPerdasVazio() {
        ll.clear();
        // Lote totalmente em dia (Validade 2030), ou seja, sem nenhuma perda no sistema
        ll.add(new Lote(501, produtoBase, 2030, 100, 2026, 2025));
        
        boolean RE = false;
        boolean RO = Lote.gerarRelatorioPerdas(ll);
        
        assertEquals(RE, RO);
    }

    /**
     * CT028
     * Verificar a vinculação de uma rota logística para o transporte dos lotes de um fornecedor.
     * O fornecedor com a Empresa "Distribuidora Alimentos" deve estar cadastrado. O usuário está na tela de "Logística/Rotas".
     * O teste espera que o método retorne verdadeiro (true), confirmando a criação da rota vinculada.
     */
    @Test
    public void testarVincularRotaLogisticaComFornecedor() {
        // Simulando fornecedor cadastrado (CNPJ fictício)
        Fornecedor fornecedorValido = new Fornecedor(55555, "Distribuidora Alimentos");
        
        boolean RE = true;
        boolean RO = Lote.salvarRotaLogistica(fornecedorValido, "Rota SP - RJ");
        
        assertEquals(RE, RO);
    }

    /**
     * CT029
     * Garantir que o sistema não permita salvar uma rota se nenhum fornecedor estiver associado a ela.
     * O usuário está na tela de "Logística/Rotas".
     * O teste espera que o método retorne falso (false), bloqueando a rota sem fornecedor (null).
     */
    @Test
    public void testarImpedirSalvarRotaSemFornecedor() {
        boolean RE = false;
        boolean RO = Lote.salvarRotaLogistica(null, "Rota SP - RJ");
        
        assertEquals(RE, RO);
    }

    /**
     * CT030
     * Garantir que o sistema impeça a entrada de um lote cuja quantidade ultrapasse a capacidade máxima de armazenamento (Estoque Máximo) definida para o produto.
     * O produto possui limite máximo de 500 unidades e já existem 450 guardadas. Tentativa de inserir lote de 100 (450 + 100 = 550 > 500).
     * O teste espera que o método retorne falso (false), bloqueando o estouro de capacidade.
     */
    @Test
    public void testarImpedirLoteAcimaDaCapacidadeMaxima() {
        ll.clear();
        
       
        int limiteMaximo = 500;
        int qtdJaExistente = 450;
        
      
        Lote novoLoteEstourado = new Lote(505, produtoBase, 2029, 100, 2026, 2025);
        
        boolean RE = false;
        boolean RO = Lote.cadastrarLoteComLimite(ll, novoLoteEstourado, qtdJaExistente, limiteMaximo);
        
        assertEquals(RE, RO);
    }
}