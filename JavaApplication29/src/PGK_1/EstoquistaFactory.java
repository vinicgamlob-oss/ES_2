package PGK_1;







public class EstoquistaFactory extends FuncionarioFactory {
    @Override
    public Funcionario criarFuncionario() {
        return new Estoquista();
    }
}