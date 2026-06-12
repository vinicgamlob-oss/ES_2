package PGK_1;

import java.util.ArrayList;
import java.util.List;

/**
 * Representa um parceiro comercial (Fornecedor) no sistema de estoque.
 * Gerencia as informações cadastrais e operações de CRUD (Cadastro, Busca e Alteração) 
 * dos fornecedores vinculados à logística de mercadorias.
 * * @author vinicius
 */
public class Fornecedor {

    private int Cnpj;
    private String nomef;
    private String empresa;
    private String endereco;
    
    /** Lista interna para gerenciamento local de fornecedores (opcional). */
    List<Fornecedor> lf = new ArrayList<>();

    /**
     * Construtor principal para inicialização de um fornecedor com dados essenciais.
     *
     * @param Cnpj O número de identificação jurídica (CNPJ) do fornecedor.
     * @param nomef O nome fantasia ou de contato do fornecedor.
     */
    public Fornecedor(int Cnpj, String nomef) {
        this.Cnpj = Cnpj;
        this.nomef = nomef;
    }

    /**
     * Construtor alternativo para sobrecarga de inicialização do fornecedor.
     *
     * @param par Código ou parâmetro numérico de identificação.
     * @param fornecedor_A Razão social ou identificador do fornecedor.
     * @param nome Nome do responsável ou contato direto.
     */
    public Fornecedor(int par, String fornecedor_A, String nome) {
    }

    /** @return O nome da empresa ou razão social. */
    public String getEmpresa() { return empresa; }

    /** @param empresa O nome da empresa ou razão social a ser definido. */
    public void setEmpresa(String empresa) { this.empresa = empresa; }

    /** @return O endereço físico do fornecedor. */
    public String getEndereco() { return endereco; }

    /** @param endereco O endereço físico a ser definido. */
    public void setEndereco(String endereco) { this.endereco = endereco; }

    /** @return O CNPJ numérico do fornecedor. */
    public int getCnpj() { return Cnpj; }

    /** @param Cnpj O CNPJ numérico a ser definido. */
    public void setCnpj(int Cnpj) { this.Cnpj = Cnpj; }

    /** @return O nome de contato do fornecedor. */
    public String getNomef() { return nomef; }

    /** @param nomef O nome de contato a ser definido. */
    public void setNomef(String nomef) { this.nomef = nomef; }

    /**
     * Realiza o cadastro de um novo fornecedor na lista informada.
     * Aplica a regra de segurança que impede o registro caso o CNPJ possua 
     * um valor inferior ao limite mínimo de 100000.
     *
     * @param lista A lista de fornecedores ativa no sistema.
     * @param novo O objeto Fornecedor contendo os dados a serem validados e inseridos.
     * @return true se o cadastro atender aos critérios de segurança; false se o CNPJ for inválido.
     */
    public static boolean cadastrarFornecedor(List<Fornecedor> lista, Fornecedor novo) {
        if (novo.getCnpj() < 100000){
            return false;
        }
        lista.add(novo);
        return true;
    }
    
    /**
     * Localiza a existência de um fornecedor na base de dados através do CNPJ de busca.
     *
     * @param lista A lista de fornecedores onde a busca será realizada.
     * @param cnpjBuscado O número do CNPJ que deseja encontrar.
     * @return true se o fornecedor for localizado na lista; false caso não exista.
     */
    public static boolean buscarFornecedor(List<Fornecedor> lista, int cnpjBuscado) {
        for (Fornecedor f : lista) {
            if (f.getCnpj() == cnpjBuscado) {
                return true; 
            }
        }
        return false; 
    }
    
    /**
     * Modifica os dados cadastrais de um fornecedor já existente.
     * Valida primeiro se o novo CNPJ sugerido já não está sendo utilizado por outro 
     * fornecedor na base de dados para evitar duplicidade de chaves.
     *
     * @param lista A lista contendo os registros de fornecedores.
     * @param cnpjAlvo O CNPJ atual do fornecedor que será modificado.
     * @param novoNomef O novo nome de contato que substituirá o antigo.
     * @param novoCnpj O novo número de CNPJ a ser atribuído ao cadastro.
     * @return true se a alteração for consolidada com sucesso; false se o novo CNPJ gerar duplicidade 
     * ou se o fornecedor alvo não for localizado.
     */
    public static boolean alterarFornecedor(List<Fornecedor> lista, int cnpjAlvo, String novoNomef, int novoCnpj) {
        for (Fornecedor f : lista) {
            if (f.getCnpj() == novoCnpj && f.getCnpj() != cnpjAlvo) {
                return false; 
            }
        }
       
        for (Fornecedor f : lista) {
            if (f.getCnpj() == cnpjAlvo) {
                f.setNomef(novoNomef);
                f.setCnpj(novoCnpj);
                return true; 
            }
        }
        return false; 
    }
}