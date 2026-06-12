/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PGK_1;

/**
 *
 * @author vinicius
 */
public class Funcionario extends Pessoa {

    private double salario = 0;
    private String senha;

    public Funcionario() {

    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public boolean login(String emailDoSistema,String senhaDoSistema) {
        
        if(emailDoSistema.equals("funcionario@email.com") && senhaDoSistema.equals("123")) {
            return true;
        } 
            return false;
        
    }

}
