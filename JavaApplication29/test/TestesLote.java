import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import PGK_1.Lote;
import PGK_1.Produto;
import PGK_1.SistemaEstoque;
import PGK_1.Estoque;

/**
 *
 * @author Vinicius
 */
public class TestesLote {

    SistemaEstoque sistema = new SistemaEstoque();
    Produto produtoBase = new Produto(101, 789123);

    /**
     *
     */
    @Before
    public void limparArmazem() {
        Estoque.getInstance().getLotes().clear();
    }

    /**
     * CT019
     * Verificar o cadastro de um novo lote com dados perfeitamente válidos.
     * O produto correspondente deve estar cadastrado. O usuário deve estar na tela de "Cadastro de Lote".
     */
    @Test
    public void testarCadastroLoteValido() {
        Lote novoLote = new Lote(501, produtoBase, 2029, 100, 2026, 2025);
        
        boolean RE = true;
        boolean RO = sistema.registrarLote(novoLote);
        
        assertEquals(RE, RO);
    }

    /**
     * CT020
     * Garantir que o sistema bloqueie a entrada de lotes sem itens ou com saldo negativo
     * O usuário está na tela de "Cadastro de Lote
     */
    @Test
    public void testarBloquearLoteSaldoInvalido() {
        Lote loteInvalido = new Lote(502, produtoBase, 2029, -15, 2026, 2025);
        
        boolean RE = false;
        boolean RO = sistema.registrarLote(loteInvalido);
        
        assertEquals(RE, RO);
    }

    /**
     * CT021
     * Bloquear o cadastro de lotes que já entrem no sistema com o prazo de validade expirado.
     * O usuário está na tela de "Cadastro de Lote (Considerando o ano corrente como 2026)
     */
    @Test
    public void testarBloquearLoteValidadeExpirada() {
        Lote loteVencido = new Lote(503, produtoBase, 2025, 50, 2026, 2025);
        
        boolean RE = false;
        boolean RO = sistema.registrarLote(loteVencido);
        
        assertEquals(RE, RO);
    }

    /**
     * CT022
     * Garantir a coerência cronológica do lote (um produto não pode ser recebido antes de ser fabricado).
     * O usuário está na tela de "Cadastro de Lote
     */
    @Test
    public void testarCoerenciaCronologicaLote() {
        Lote loteCronologiaErrada = new Lote(504, produtoBase, 2030, 80, 2026, 2027);
        
        boolean RE = false;
        boolean RO = sistema.registrarLote(loteCronologiaErrada);
        
        assertEquals(RE, RO);
    }

    /**
     * CT023
     * Verificar a exibição correta das informações e datas de um lote específico.
     * O lote 501 deve estar previamente cadastrado. O usuário está na tela de "Consulta de Estoque".
     */
    @Test
    public void testarExibicaoInformacoesLote() {
        Lote lote501 = new Lote(501, produtoBase, 2029, 100, 2026, 2025);
        sistema.registrarLote(lote501);
        
        boolean RE = true;
        boolean RO = false;
        
        for (Lote l : Estoque.getInstance().getLotes()) {
            if (l.getCodigo() == 501) {
                RO = true;
                break;
            }
        }
        
        assertEquals(RE, RO);
    }

    /**
     * CT024
     * Verificar o ajuste manual de saldo/quantidade de um lote por motivos de auditoria ou correção.
     * O lote 501 (com quantidade inicial 100) deve estar previamente cadastrado. O usuário está na tela de 'Edição de Lote
     */
    @Test
    public void testarAjusteManualSaldoLote() {
        Lote lote501 = new Lote(501, produtoBase, 2029, 100, 2026, 2025);
        sistema.registrarLote(lote501);
        
        boolean RE = true;
        boolean RO = false;
        
        for (Lote l : Estoque.getInstance().getLotes()) {
            if (l.getCodigo() == 501) {
                l.setQtd_de_Produtos(98);
                RO = true;
                break;
            }
        }
        
        assertEquals(RE, RO);
    }
}