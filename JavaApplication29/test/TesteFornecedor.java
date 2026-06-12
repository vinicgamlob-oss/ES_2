/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import PGK_1.Fornecedor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author vinicius
 */
public class TesteFornecedor {
    
     List<Fornecedor> lf = new ArrayList<>();
    
    /**
     * CT013
     * Verificar o cadastro de um novo fornecedor com dados válidos.
     * O usuário deve estar logado e na tela de "Cadastro de Fornecedores".
     * O teste espera que o método retorne verdadeiro (true), confirmando o cadastro.
     */
    @Test
    public void testarCadastroFornecedorValido() {
        
        
        Fornecedor novoFornecedor = new Fornecedor(10000000, "Fornecedor A");
        
        boolean RE = true;
        boolean RO = Fornecedor.cadastrarFornecedor(lf, novoFornecedor);
        
        assertEquals(RE, RO);
    }

    /**
     * CT014
     * Bloquear o cadastro caso o CNPJ esteja inválido.
     * O usuário está na tela de "Cadastro de Fornecedores".
     * O teste espera que o método retorne falso (false), impedindo o cadastro inválido.
     */
    @Test
    public void testarBloquearCadastroCnpjInvalido() {
        
        // Usando um CNPJ curto (1000) para garantir o bloqueio na validação
        Fornecedor fornecedorInvalido = new Fornecedor(1000, "Fornecedor B");
        
        boolean RE = false;
        boolean RO = Fornecedor.cadastrarFornecedor(lf, fornecedorInvalido);
        
        assertEquals(RE, RO);
    }
    
    /**
     * CT015
     * Verificar a busca de um fornecedor cadastrado através do CNPJ.
     * O teste espera que o método retorne verdadeiro (true) ao encontrar o fornecedor válido na lista.
     */
    @Test
    public void testarBuscarFornecedorPorCnpj() {
        Fornecedor f1 = new Fornecedor(1, "Fornecedor Alfa");
        Fornecedor f2 = new Fornecedor(2, "Fornecedor Beta");
        
        lf.add(f1);
        lf.add(f2);
        
        boolean RE = true;
        boolean RO = Fornecedor.buscarFornecedor(lf,1 );
        
        assertEquals(RE, RO);
    }

    /**
     * CT016
     * Exibir aviso adequado ao buscar por um fornecedor inexistente.
     * O teste espera que o método retorne falso (false) ao não localizar o CNPJ, indicando o erro.
     */
    @Test
    public void testarBuscarFornecedorInexistente() {
        Fornecedor f1 = new Fornecedor(1, "Fornecedor Alfa");
        lf.add(f1);
        
        boolean RE = false;
        boolean RO = Fornecedor.buscarFornecedor(lf, 4);
        
        assertEquals(RE, RO);
    }
    
    
    /**
     * CT017
     * Verificar a alteração do nome/razão social de um fornecedor já existente.
     * O fornecedor com CNPJ 12345 deve estar previamente cadastrado.
     * O teste espera que o método retorne verdadeiro (true), confirmando a alteração do nome.
     */
    @Test
    public void testarAlterarNomeFornecedorExistente() {
        Fornecedor f = new Fornecedor(12345, "Nome Antigo");
        lf.add(f);
        
        boolean RE = true;
        boolean RO = Fornecedor.alterarFornecedor(lf, 12345, "Nova Razao Social", 12345);
        
        assertEquals(RE, RO);
    }

    /**
     * CT018
     * Garantir que um fornecedor não seja alterado para usar o CNPJ de outro fornecedor já cadastrado.
     * Existir o Fornecedor A e Fornecedor B. O usuário está editando o Fornecedor A.
     * O teste espera que o método retorne falso (false), bloqueando o CNPJ duplicado.
     */
    @Test
    public void testarImpedirAlterarCnpjDuplicadoFornecedor() {
        Fornecedor fornecedorA = new Fornecedor(12345, "Fornecedor A");
        Fornecedor fornecedorB = new Fornecedor(67890, "Fornecedor B");
        
        lf.add(fornecedorA);
        lf.add(fornecedorB);
        
        boolean RE = false;
        boolean RO = Fornecedor.alterarFornecedor(lf, 12345, "Fornecedor A Alterado", 67890);
        
        assertEquals(RE, RO);
    }
   
}
