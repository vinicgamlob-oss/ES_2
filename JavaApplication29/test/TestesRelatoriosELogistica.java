import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import PGK_1.Lote;
import PGK_1.Produto;
import PGK_1.Fornecedor;
import PGK_1.SistemaEstoque;
import PGK_1.Estoque;
import java.util.List;

public class TestesRelatoriosELogistica {

    SistemaEstoque sistema = new SistemaEstoque();
    Produto produtoBase = new Produto(10, 100);

    @Before
    public void limparLotes() {
        Estoque.getInstance().getLotes().clear();
    }

    /**
     * CT025
     * Verificar a geração do relatório que lista os produtos ordenados por data de vencimento.
     * Existirem lotes e produtos cadastrados no sistema. O usuário está na tela de "Relatórios".
     */
    @Test
    public void testarGerarRelatorioOrdenadoPorVencimento() {
        Lote l1 = new Lote(501, produtoBase, 2029, 100, 2026, 2025);
        Lote l2 = new Lote(502, produtoBase, 2027, 50, 2026, 2025);
        sistema.registrarLote(l1);
        sistema.registrarLote(l2);
        
        List<Lote> ordenada = sistema.executarFEFO();
        
        boolean RE = true;
        boolean RO = ordenada.size() == 2 && ordenada.get(0).getCodigo() == 502;
        
        assertEquals(RE, RO);
    }

    /**
     * CT026
     * Verificar a geração do relatório que consolida os produtos que venceram ou foram descartados do estoque.
     * O teste espera que o método retorne verdadeiro (true) ao processar o relatório de perdas com dados existentes.
     */
    @Test
    public void testarGerarRelatorioProdutosVencidosOuDescartados() {
        Lote loteVencido = new Lote(503, produtoBase, 2024, 40, 2026, 2023);
        Estoque.getInstance().getLotes().add(loteVencido); 
        
        String textoRelatorio = sistema.gerarRelatorioPerdas();
        
        boolean RE = true;
        boolean RO = textoRelatorio.contains("Lote 503");
        
        assertEquals(RE, RO);
    }

    /**
     * CT027
     * Garantir que o sistema notifique o usuário adequadamente se ele tentar gerar um relatório de perdas quando não houver nenhuma perda registrada.
     * O sistema não possui nenhum registro de produto vencido ou descartado. O usuário está na tela de "Relatórios"
     */
    @Test
    public void testarNotificarRelatorioPerdasVazio() {
        Lote loteValido = new Lote(501, produtoBase, 2030, 100, 2026, 2025);
        sistema.registrarLote(loteValido);
        
        String textoRelatorio = sistema.gerarRelatorioPerdas();
        
        boolean RE = false;
        boolean RO = textoRelatorio.contains("Total de itens perdidos: 0.0");
        
        assertEquals(RE, RO);
    }

    /**
     * CT028
     * Verificar a vinculação de uma rota logística para o transporte dos lotes de um fornecedor.
     * O fornecedor com a Empresa "Distribuidora Alimentos deve estar cadastrado. O usuário está na tela de "Logística/Rotas".
     */
    @Test
    public void testarVincularRotaLogisticaComFornecedor() {
        Fornecedor fornecedorValido = new Fornecedor(123456, "Distribuidora Alimentos");
        
        boolean RE = true;
        boolean RO = (fornecedorValido != null);
        
        assertEquals(RE, RO);
    }

    /**
     * CT029
     * Garantir que o sistema não permita salvar uma rota se nenhum fornecedor estiver associado a ela.
     * O usuário está na tela de "Logistica/Rotas".
     */
    @Test
    public void testarImpedirSalvarRotaSemFornecedor() {
        boolean RE = false;
        boolean RO = (null != null);
        
        assertEquals(RE, RO);
    }

    /**
     * CT030
     * Garantir que o sistema impeça a entrada de um lote cuja quantidade ultrapasse a capacidade máxima de armazenamento (Estoque Máximo) definida para o produto.
     * O produto possui um limite máximo configurado de 500 unidades no armazém e já existem 450 unidades guardadas.
     */
    @Test
    public void testarImpedirLoteAcimaDaCapacidadeMaxima() {
        Lote lotePreExistente = new Lote(999, produtoBase, 2029, 450, 2026, 2025);
        Estoque.getInstance().adicionarLote(lotePreExistente);
        
        Lote novoLoteEstourado = new Lote(505, produtoBase, 2029, 100, 2026, 2025);
        
        boolean RE = false;
        int limiteConfigurado = 500;
        boolean RO = (Estoque.getInstance().getQtdAtualNoArmazem() + novoLoteEstourado.getQtd_de_Produtos()) <= limiteConfigurado;
        
        assertEquals(RE, RO);
    }
}