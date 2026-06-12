



package PGK_1;

/**
 *
 * @author Vinicius
 */
public class GerenteFactory extends FuncionarioFactory {

    /**
     *
     * @return
     */
    @Override
    public Funcionario criarFuncionario() {
        return new Gerente();
    }
}