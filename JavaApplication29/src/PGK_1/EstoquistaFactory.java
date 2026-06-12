package PGK_1;

/**
 *
 * @author Vinicius
 */
public class EstoquistaFactory extends FuncionarioFactory {

    /**
     *
     * @return
     */
    @Override
    public Funcionario criarFuncionario() {
        return new Estoquista();
    }
}