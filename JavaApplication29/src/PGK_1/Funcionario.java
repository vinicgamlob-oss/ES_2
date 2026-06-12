package PGK_1;

/**
 *
 * @author Vinicius
 */
public abstract class Funcionario extends Pessoa {
    private double salario = 0;
    private String senha;

    /**
     *
     */
    public Funcionario() {}

    /**
     *
     * @return
     */
    public String getSenha() { return senha; }

    /**
     *
     * @param senha
     */
    public void setSenha(String senha) { this.senha = senha; }

    /**
     *
     * @return
     */
    public double getSalario() { return salario; }

    /**
     *
     * @param salario
     */
    public void setSalario(double salario) { this.salario = salario; }
}