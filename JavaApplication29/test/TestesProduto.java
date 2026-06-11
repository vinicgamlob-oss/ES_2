

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import PGK_1.Produto;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinicius
 */
public class TestesProduto {

    List<Produto> lp = new ArrayList<>();
    Produto p = new Produto(1, 100);
    Produto p2 = new Produto(2, 500);
    Produto p3 = new Produto(3, 600);
    Produto p4 = new Produto(4, 700);

    public TestesProduto() {
    }

    /**
     * CT008 Verificar o cadastro de um novo produto com dados válidos. O
     * usuário deve estar logado e na tela de "Cadastro de Produtos". O teste
     * espera que o método retorne verdadeiro (true), confirmando o cadastro.
     */
    @Test
    public void testarCadastroProdutoValido() {
        Produto novoProduto = new Produto(5, 150);

        boolean RE = true;
        boolean RO = Produto.cadastrarProduto(lp, novoProduto);

        assertEquals(RE, RO);
    }

    /**
     * CT009 Impedir o cadastro de um produto caso o código de barras já exista
     * no sistema. Já existir um produto cadastrado com o código. O usuário está
     * na tela de cadastro. O teste espera que o método retorne falso (false),
     * impedindo a duplicidade.
     */
    @Test
    public void testarImpedirCadastroCodigoDuplicado() {
        Produto produtoExistente = new Produto(789, 100);
        lp.add(produtoExistente);

        Produto produtoDuplicado = new Produto(789, 250);

        boolean RE = false;
        boolean RO = Produto.cadastrarProduto(lp, produtoDuplicado);

        assertEquals(RE, RO);
    }

    /**
     * CT010 Valida o comportamento do sistema quando uma busca é realizada
     * utilizando um código de produto válido e já cadastrado na lista. O teste
     * espera que o método retorne verdadeiro (true), confirmando que o produto
     * foi localizado.
     */
    @Test
    public void validarBusca() {

        lp.add(p);
        lp.add(p2);
        lp.add(p3);
        lp.add(p4);

        boolean RE = true;

        boolean RO = Produto.consultarProduto(lp, 1);

        assertEquals(RE, RO);
    }

    
    /**
     * CT011
     * Verificar a alteração de dados (código ou código de barras) de um produto cadastrado.
     * O produto com código 101 deve estar previamente cadastrado no sistema.
     * O teste espera que o método retorne verdadeiro (true) e que os dados sejam atualizados.
     */
    @Test
    public void testarAlterarDadosProdutoCadastrado() {
       
        Produto produtoOriginal = new Produto(101, 100); 
       
        lp.add(produtoOriginal);
        
        boolean RE = true;
        boolean RO = Produto.alterarProduto(lp, 101, 999);
        assertEquals(RE, RO);
        
        
    }
    
    /**
     * CT012
     * Impedir a atualização de um produto caso o novo código de barras já pertença a outro produto do sistema.
     * O teste espera que o método retorne falso (false), bloqueando a alteração duplicada.
     */
    @Test
    public void testarAlterarDadosProdutoCadastradoInvalido() {
        lp.clear(); 
        
        p.setCodigo(1); p.setCoddigoBarra(100); 
        p2.setCodigo(2); p2.setCoddigoBarra(200); 
        
        lp.add(p);
        lp.add(p2);
        
        boolean RE = false; 
        boolean RO = Produto.alterarProduto(lp, 1, 200); 
        
        assertEquals(RE, RO); 
    }
}
