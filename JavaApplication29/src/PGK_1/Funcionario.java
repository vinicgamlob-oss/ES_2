package PGK_1;


public abstract class Funcionario extends Pessoa {
    private double salario = 0;
    private String senha;

    public Funcionario() {}

    public String getSenha() { return senha; }
    public void setSenha(String senha) { this.senha = senha; }
    public double getSalario() { return salario; }
    public void setSalario(double salario) { this.salario = salario; }
}