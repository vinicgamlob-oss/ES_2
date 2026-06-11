/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import PGK_1.Funcionario;

/**
 *
 * @author vinicius
 */
public class TestesFuncionario {

    Funcionario f = new Funcionario();

    public TestesFuncionario() {
    }

    /**
     * CT005
     * Valida o comportamento do sistema quando um funcionário tenta realizar o
     * login utilizando credenciais válidas e cadastradas. O teste espera que o
     * método retorne verdadeiro (true) para o acesso autorizado.
     *
     */
    @Test
    public void TestarLogin() {

        boolean RE = true;

        boolean RO = f.login("funcionario@email.com", "123");

        assertEquals(RE, RO);

    }

    /**
     * CT006
     * Valida o comportamento do sistema quando um funcionário tenta realizar o
     * login utilizando credenciais inválidas ou incorretas.
     *
     * O teste verifica se o sistema bloqueia o acesso, esperando um retorno
     * falso (false).
     *
     */
    @Test
    public void TestarLoginErrado() {

        boolean RE = false;

        boolean RO = f.login("funcionario2@email.com", "456");

        assertEquals(RE, RO);

    }

}
