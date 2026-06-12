
import PGK_1.Pessoa;
import org.junit.Test;            
import static org.junit.Assert.*;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

/**
 *
 * @author vinicius
 */
public class TestesUnitariosPessoa {
    
    Pessoa p = new Pessoa();
    
    /**
     *
     */
    public TestesUnitariosPessoa() {
        
    }
 
    /**
     * Valida o cenário de sucesso (CT001) para o método de verificação de CPF.
     * Certifica que o sistema retorna verdadeiro (true) quando um documento
     * válido e previamente configurado na instância é processado.
     */
    @Test
    public void verificarUmCpfValido (){
    
        boolean RE = true ;
        
        boolean RO = p.validarCPF(p.getCPF());
        
        
        assertEquals(RE, RO);
    }
    
    /**
     * Valida o cenário de falha (CT002) para o método de verificação de CPF.
     * Certifica que o sistema retorna falso (false) quando um documento
     * invalido e previamente configurado na instância é processado.
     */
     @Test
    public void verificarUmCpfInvalido (){
    
        boolean RE = false ;
        
        p.setCPF(200);
        
        boolean RO = p.validarCPF(p.getCPF());
        
        
        assertEquals(RE, RO);
    }
    
    
    
    /**
     * CT003: Verifica se o sistema reconhece um cadastro quando todos 
     * os campos obrigatórios estão preenchidos corretamente.
     */
    @Test
    public void verificarCadastroValido(){
        
       boolean RE = true ;
       
       boolean RO = p.verificarCadastro();
       
       assertEquals(RE,RO);
        
    
    
}
    
    
    
    
    /**
     * CT004: Verifica se o sistema reconhece um cadastro quando um ou mais  
     * campos obrigatórios estão preenchidos incorretamente.
     */
     @Test
    public void verificarCadastroInvalido(){
        
       boolean RE =false ;
       
       p.setName("");
       p.setEmail("");
       p.setResidencia("");
       p.setCPF(2); 
       p.setNumeroCell(122);
       p.setDataNasc(111);
       
       boolean RO = p.verificarCadastro();
       
       assertEquals(RE,RO);
        
    
    
}
    
    
    /**
     * Valida o cenário de sucesso (CT007) para o método atualizacao de dados.
     * Certifica que o sistema retorna verdadeiro (true) quando um documento
     * válido e previamente configurado na instância e processado.
     */
    @Test
    public void validarUpdate(){
    
        String Novonome = "Maria";
    int NovoCPF = 2;
    int NovoNumeroCell = 13;
    String NovoEmail = "Maria@email.com";
    int NovaDataNasc = 14;
    String NovaResidencia = " Rua Dom Sebastiao ";
    
    
    
    boolean RE = true;
    boolean RO = p.atualizarCadastro(Novonome, NovoCPF, NovoNumeroCell, NovoEmail, NovaDataNasc, NovaResidencia);
    
    assertEquals(RE,RO);
    }
    
    
    /**
     * Valida o cenário de falha (CT008) para o método de atualizacao de dados.
     * Certifica que o sistema retorna verdadeiro (true) quando um documento
     * inválido e previamente configurado na instância é processado.
     */
     @Test
    public void invalidarUpdate(){
    
    String Novonome = "";
    int NovoCPF = 200;
    int NovoNumeroCell = 130;
    String NovoEmail = "";
    int NovaDataNasc = 140;
    String NovaResidencia = "";
    
    
    
    boolean RE = false;
    boolean RO = p.atualizarCadastro(Novonome, NovoCPF, NovoNumeroCell, NovoEmail, NovaDataNasc, NovaResidencia);
    
    assertEquals(RE,RO);
    }
    
    
}