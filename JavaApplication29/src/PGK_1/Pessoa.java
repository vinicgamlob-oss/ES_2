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
    
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return
     */
    public int getCPF() {
        return CPF;
    }

    /**
     *
     * @param CPF
     */
    public void setCPF(int CPF) {
        this.CPF = CPF;
    }

    /**
     *
     * @return
     */
    public int getNumeroCell() {
        return NumeroCell;
    }

    /**
     *
     * @param NumeroCell
     */
    public void setNumeroCell(int NumeroCell) {
        this.NumeroCell = NumeroCell;
    }

    /**
     *
     * @return
     */
    public String getEmail() {
        return Email;
    }

    /**
     *
     * @param Email
     */
    public void setEmail(String Email) {
        this.Email = Email;
    }

    /**
     *
     * @return
     */
    public int getDataNasc() {
        return DataNasc;
    }

    /**
     *
     * @param DataNasc
     */
    public void setDataNasc(int DataNasc) {
        this.DataNasc = DataNasc;
    }

    /**
     *
     * @return
     */
    public String getResidencia() {
        return Residencia;
    }

    /**
     *
     * @param Residencia
     */
    public void setResidencia(String Residencia) {
        this.Residencia = Residencia;
    }

    /**
     *
     * @param CPF
     * @return
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
     *
     * @return
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
     *
     * @param novoNome
     * @param novoCPF
     * @param novoNumeroCell
     * @param novoEmail
     * @param novaDataNasc
     * @param novaResidencia
     * @return
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
    this.DataNasc=  novaDataNasc;
    this.Email = novoEmail;
    this.Residencia = novaResidencia;
  
    return true;
  
  }
    
    }
