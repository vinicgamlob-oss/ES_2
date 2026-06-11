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

    
    public boolean validarCPF(int CPF){
        if (CPF == 1){
            return true;
        }
        else{
            return false ;
        }
        
        
    }
    
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
    
    }
