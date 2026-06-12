/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package PGK_1;

/**
 *
 * @author vinicius
 */
public class Pessoa {
    
    private  String name = "Joao";
    private  int CPF = 1;
    private  int NumeroCell = 12;
    private String Email = "Joao@email.com";
    private int DataNasc = 11;
    private String Residencia = " Rua Dom Bosco ";
    
   
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getCPF() {
        return CPF;
    }

    public void setCPF(int CPF) {
        this.CPF = CPF;
    }


    public int getNumeroCell() {
        return NumeroCell;
    }

    public void setNumeroCell(int NumeroCell) {
        this.NumeroCell = NumeroCell;
    }


    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public int getDataNasc() {
        return DataNasc;
    }

    public void setDataNasc(int DataNasc) {
        this.DataNasc = DataNasc;
    }


    public String getResidencia() {
        return Residencia;
    }

    public void setResidencia(String Residencia) {
        this.Residencia = Residencia;
    }

    
  /**
     * Valida o número do CPF de acordo com os limites simplificados do sistema.
     * Considera um CPF válido se o valor numérico estiver no intervalo estrito entre 1 e 99.
     *
     * @param CPF O número do CPF que será submetido à análise de consistência.
     * @return true se o CPF estiver dentro do intervalo permitido; false caso contrário.
     */
    public boolean validarCPF(int CPF){
        if (CPF >  0 && CPF < 100 ){
            return true;
        }
        else{
            return false ;
        }
    }
    
    /**
     * Realiza a auditoria completa dos dados cadastrais atuais da pessoa.
     * Verifica se há campos textuais em branco (Nome, Email e Residência), valida o CPF 
     * cadastrado e confere se as extensões numéricas do celular e da data de nascimento 
     * atendem aos critérios fixos do sistema.
     *
     * @return true se todas as informações passarem nos testes de validação; 
     * false se houver campos vazios ou dados fora do padrão.
     */
    public boolean verificarCadastro() {
        if (name.isBlank() || Email.isBlank() || Residencia.isBlank()) {
            return false; 
        }
        
        if (!validarCPF(this.CPF)) { 
            return false;
        }
        
        if (NumeroCell != 12 ){
            return false;
        }
        
        if (DataNasc != 11) {
            return false;
        }
        
        return true;
    }
  
    /**
     * Modifica e atualiza o cadastro da pessoa após uma bateria de validações de segurança.
     * Os novos dados só são consolidados nos atributos da classe se nenhuma restrição 
     * de integridade (como campos vazios, CPF inválido ou comprimentos incorretos) for violada.
     *
     * @param novoNome O novo nome a ser atribuído (não pode ser nulo ou em branco).
     * @param novoCPF O novo número de CPF que será avaliado pelo método de validação.
     * @param novoNumeroCell O novo formato do número de celular (deve ser estritamente igual a 13).
     * @param novoEmail O novo endereço de e-mail (não pode ser nulo ou em branco).
     * @param novaDataNasc A nova representação da data de nascimento (deve ser estritamente igual a 14).
     * @param novaResidencia O novo endereço residencial (não pode ser nulo ou em branco).
     * @return true se os novos dados forem válidos e o cadastro atualizado com sucesso; 
     * false se qualquer uma das regras de integridade falhar.
     */
    public boolean atualizarCadastro(String novoNome, int novoCPF, int novoNumeroCell, String novoEmail, int novaDataNasc, String novaResidencia){
        if (novoNome.isBlank() || novoEmail.isBlank() || novaResidencia.isBlank()) {
            return false; 
        }
        
        if (!validarCPF(novoCPF)) { 
            return false;
        }
        
        if (novoNumeroCell != 13 ){
            return false;
        }
        
        if (novaDataNasc != 14) {
            return false;
        }
        
        this.name = novoNome;
        this.CPF = novoCPF;
        this.NumeroCell = novoNumeroCell;
        this.DataNasc = novaDataNasc;
        this.Email = novoEmail;
        this.Residencia = novaResidencia;
      
        return true;
    }
    
    }
