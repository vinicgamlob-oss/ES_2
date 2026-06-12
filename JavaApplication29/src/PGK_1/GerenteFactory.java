



package PGK_1;

public class GerenteFactory extends FuncionarioFactory {
    @Override
    public Funcionario criarFuncionario() {
        return new Gerente();
    }
}