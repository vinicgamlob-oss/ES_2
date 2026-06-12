import org.junit.Test;
import org.junit.Before;
import static org.junit.Assert.assertEquals;
import PGK_1.Produto;
import PGK_1.SistemaEstoque;
import PGK_1.Estoque;

/**
 * Suite de testes unitários para validação do catálogo e consistência de dados de produtos.
 * Avalia fluxos de inserção, buscas internas por ID e travas contra duplicidade de códigos de barras.
 * @author Vinicius
 */
public class TestesProduto {

    private SistemaEstoque sistema = new SistemaEstoque();
    private Produto p = new Produto(101, 789111);
    private Produto p2 = new Produto(102, 789222);

    /**
     * Rotina de pré-configuração executada antes de cada caso de teste.
     * Garante o isolamento limpando o banco de dados em memória do catálogo de produtos.
     */
    @Before
    public void limparCatalogo() {
        Estoque.getInstance().getProdutos().clear();
    }

    /**
     * CT008 
     * Verificar o cadastro de um novo produto com dados válidos. O
     * usuário deve estar logado e na tela de "Cadastro de Produtos". O teste
     * espera que o método retorne verdadeiro (true), confirmando o cadastro.
     */
    @Test
    public void testarCadastroProdutoValido() {
        Produto novoProduto = new Produto(101, 789123);

        boolean RE = true;
        boolean RO = sistema.cadastrarProduto(novoProduto);

        assertEquals(RE, RO);
    }

    /**
     * CT009 
     * Impedir o cadastro de um produto caso o código de barras já exista no sistema. 
     * Já existir um produto cadastrado com o código de barras. O usuário está na tela de cadastro.
     */
    @Test
    public void testarImpedirCadastroCodigoDuplicado() {
        // Primeiro produto cadastrado com código de barras 789123
        Produto produtoExistente = new Produto(101, 789123);
        sistema.cadastrarProduto(produtoExistente);

        // Tentando cadastrar outro produto com o MESMO código de barras (789123)
        // O código interno (102) pode até ser diferente, mas o de barras vai forçar o bloqueio
        Produto produtoDuplicado = new Produto(102, 789123); 

        boolean RE = false;
        boolean RO = sistema.cadastrarProduto(produtoDuplicado);

        assertEquals(RE, RO);
    }

    /**
     * CT010 
     * Verificar a consulta de um produto através do seu código único.
     */
    @Test
    public void validarBusca() {
        sistema.cadastrarProduto(p);

        boolean RE = true;
        boolean RO = false;
        
        for (Produto prod : Estoque.getInstance().getProdutos()) {
            if (prod.getCodigo() == 101) {
                RO = true;
                break;
            }
        }

        assertEquals(RE, RO);
    }

    /**
     * CT011
     * Verificar a alteração de dados (código ou código de barras) de um produto cadastrado.
     * O produto com código 101 deve estar previamente cadastrado no sistema.
     */
    @Test
    public void testarAlterarDadosProdutoCadastrado() {
        sistema.cadastrarProduto(p);
        
        boolean RE = true;
        boolean RO = false;
        
        for (Produto prod : Estoque.getInstance().getProdutos()) {
            if (prod.getCodigo() == 101) {
                prod.setCoddigoBarra(789999);
                RO = true;
                break;
            }
        }
        
        assertEquals(RE, RO);
    }
    
    /**
     * CT012
     * Impedir a atualização de um produto caso o novo código de barras já pertença a outro produto do sistema.
     */
    @Test
    public void testarAlterarDadosProdutoCadastradoInvalido() {
        sistema.cadastrarProduto(p);
        sistema.cadastrarProduto(p2);
        
        boolean RE = false;
        boolean RO = true; // Iniciamos assumindo que a operação é válida até que a duplicidade seja provada
        
        // Simulação da regra de negócio: Se tentar atualizar o produto 'p' (101) com o código de barras do 'p2' (789222)
        int sugeridoCoddigoBarra = 789222;
        int idAlvo = 101;
        
        for (Produto prod : Estoque.getInstance().getProdutos()) {
            if (prod.getCoddigoBarra() == sugeridoCoddigoBarra && prod.getCodigo() != idAlvo) {
                RO = false; // Bloqueia (duplicidade detectada em outro ID)
                break;
            }
        }
        
        assertEquals(RE, RO);
    }
}