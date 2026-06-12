import org.junit.Test;
import static org.junit.Assert.assertEquals;
import PGK_1.Funcionario;
import PGK_1.GerenteFactory;

public class TestesFuncionario {

    Funcionario f = new GerenteFactory().criarFuncionario();

    public TestesFuncionario() {
        f.setEmail("funcionario@email.com");
        f.setSenha("SenhaCorreta123");
    }

    /**
     * CT005
     * Verificar se o funcionário consegue realizar o login com credenciais válidas.
     * O funcionário deve estar previamente cadastrado e ativo no sistema.
     */
    @Test
    public void testarLoginFuncionarioValido() {
        
        boolean RE = true;
        boolean RO = "funcionario@email.com".equals(f.getEmail()) && "SenhaCorreta123".equals(f.getSenha());
        
        assertEquals(RE, RO);
    }

    /**
     * CT006
     * Impedir o acesso ao sistema caso a senha informada esteja incorreta
     * O funcionário deve estar previamente cadastrado no sistema.
     */
    @Test
    public void testarImpedirLoginSenhaIncorreta() {
        
        boolean RE = false;
        boolean RO = "funcionario@email.com".equals(f.getEmail()) && "SenhaErrada999".equals(f.getSenha());
        
        assertEquals(RE, RO);
    }
}