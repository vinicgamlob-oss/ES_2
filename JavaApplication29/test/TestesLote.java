
import PGK_1.Fornecedor;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import PGK_1.Lote;
import PGK_1.Produto;
import java.util.ArrayList;
import java.util.List;


public class TestesLote {

    List<Lote> ll = new ArrayList<>();
    
    
    Produto produtoBase = new Produto(10, 100);

    /**
     * CT019
     * Verificar o cadastro de um novo lote com dados perfeitamente válidos.
     * O produto correspondente deve estar cadastrado. O usuário deve estar na tela de "Cadastro de Lote".
     * O teste espera que o método retorne verdadeiro (true), confirmando o cadastro do lote.
     */
    @Test
    public void testarCadastroLoteValido() {
        ll.clear();
        Lote novoLote = new Lote(501, produtoBase, 2029, 100, 2026, 2025);
        
        boolean RE = true;
        boolean RO = Lote.cadastrarLote(ll, novoLote);
        
        assertEquals(RE, RO);
    }

    /**
     * CT020
     * Garantir que o sistema bloqueie a entrada de lotes sem itens ou com saldo negativo.
     * O usuário está na tela de "Cadastro de Lote".
     * O teste espera que o método retorne falso (false), impedindo o saldo inválido.
     */
    @Test
    public void testarBloquearLoteSaldoInvalido() {
        ll.clear();
        Lote loteInvalido = new Lote(502, produtoBase, 2029, -5, 2026, 2025);
        
        boolean RE = false;
        boolean RO = Lote.cadastrarLote(ll, loteInvalido);
        
        assertEquals(RE, RO);
    }

    /**
     * CT021
     * Bloquear o cadastro de lotes que já entrem no sistema com o prazo de validade expirado.
     * O usuário está na tela de "Cadastro de Lote". (Considerando o ano corrente como 2026).
     * O teste espera que o método retorne falso (false), rejeitando o produto vencido.
     */
    @Test
    public void testarBloquearLoteValidadeExpirada() {
        ll.clear();
        Lote loteVencido = new Lote(503, produtoBase, 2024, 50, 2026, 2023);
        
        boolean RE = false;
        boolean RO = Lote.cadastrarLote(ll, loteVencido);
        
        assertEquals(RE, RO);
    }

    /**
     * CT022
     * Garantir a coerência cronológica do lote (um produto não pode ser recebido antes de ser fabricado).
     * O usuário está na tela de "Cadastro de Lote".
     * O teste espera que o método retorne falso (false), acusando a inconsistência nas datas.
     */
    @Test
    public void testarCoerenciaCronologicaLote() {
        ll.clear();
        Lote loteCronologiaErrada = new Lote(504, produtoBase, 2030, 80, 2024, 2025);
        
        boolean RE = false;
        boolean RO = Lote.cadastrarLote(ll, loteCronologiaErrada);
        
        assertEquals(RE, RO);
    }

    /**
     * CT023
     * Verificar a exibição correta das informações e datas de um lote específico.
     * O lote 501 deve estar previamente cadastrado. O usuário está na tela de "Consulta de Estoque".
     * O teste espera que o método retorne verdadeiro (true) ao localizar o lote indicado.
     */
    @Test
    public void testarExibicaoInformacoesLote() {
        ll.clear();
        Lote lote501 = new Lote(501, produtoBase, 2029, 100, 2026, 2025);
        ll.add(lote501);
        
        boolean RE = true;
        boolean RO = Lote.consultarLote(ll, 501);
        
        assertEquals(RE, RO);
    }

    /**
     * CT024
     * Verificar o ajuste manual de saldo/quantidade de um lote por motivos de auditoria ou correção.
     * O lote 501 (com quantidade inicial 100) deve estar previamente cadastrado. O usuário está na tela de "Edição de Lote".
     * O teste espera que o método retorne verdadeiro (true), efetuando a alteração da quantidade.
     */
    @Test
    public void testarAjusteManualSaldoLote() {
        ll.clear();
        Lote lote501 = new Lote(501, produtoBase, 2029, 100, 2026, 2025);
        ll.add(lote501);
        
        boolean RE = true;
        boolean RO = Lote.ajustarSaldo(ll, 501, 150);
        
        assertEquals(RE, RO);
    }
    
    
    
}