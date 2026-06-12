package PGK_1;

/**
 * Representa um Lote de mercadorias no sistema de gestão de estoque.
 * Armazena informações cruciais sobre o produto, quantitativos e dados temporais 
 * de fabricação, recebimento e validade para auditorias e aplicação de algoritmos logísticos.
 * * @author Vinicius
 */
public class Lote {
    private int Codigo;
    private Produto Produto;
    private int Validade;
    private int Qtd_de_Produtos; 
    private int Data_Recebida;
    private int Data_Fabricacao;

    /**
     * Construtor completo para a inicialização e estruturação física de um lote.
     *
     * @param Codigo O identificador numérico exclusivo do lote.
     * @param Produto O objeto Produto vinculado que compõe as unidades do lote.
     * @param Validade O ano limite de vencimento para consumo das mercadorias.
     * @param Qtd_de_Produtos A quantidade física de itens disponíveis no lote.
     * @param Data_Recebida O ano/período em que o lote deu entrada física no armazém.
     * @param Data_Fabricacao O ano/período de manufatura ou produção do produto.
     */
    public Lote(int Codigo, Produto Produto, int Validade, int Qtd_de_Produtos, int Data_Recebida, int Data_Fabricacao) {
        this.Codigo = Codigo;
        this.Produto = Produto;
        this.Validade = Validade;
        this.Qtd_de_Produtos = Qtd_de_Produtos;
        this.Data_Recebida = Data_Recebida;
        this.Data_Fabricacao = Data_Fabricacao;
    }

    /** @return O código identificador do lote. */
    public int getCodigo() { return Codigo; }

    /** @param Codigo O novo código identificador a ser atribuído ao lote. */
    public void setCodigo(int Codigo) { this.Codigo = Codigo; }

    /** @return O objeto Produto associado a este lote. */
    public Produto getProduto() { return Produto; }

    /** @param Produto O produto a ser vinculado ao lote. */
    public void setProduto(Produto Produto) { this.Produto = Produto; }

    /** @return O ano de validade do lote. */
    public int getValidade() { return Validade; }

    /** @param Validade O novo ano de validade a ser estabelecido. */
    public void setValidade(int Validade) { this.Validade = Validade; }

    /** @return O quantitativo total de produtos armazenados neste lote. */
    public int getQtd_de_Produtos() { return Qtd_de_Produtos; }

    /** @param Qtd_de_Produtos O novo volume de produtos do lote. */
    public void setQtd_de_Produtos(int Qtd_de_Produtos) { this.Qtd_de_Produtos = Qtd_de_Produtos; }

    /** @return A data cronológica de recebimento do lote na plataforma. */
    public int getData_Recebida() { return Data_Recebida; }

    /** @param Data_Recebida A nova data de entrada no armazém. */
    public void setData_Recebida(int Data_Recebida) { this.Data_Recebida = Data_Recebida; }

    /** @return A data de fabricação original das mercadorias. */
    public int getData_Fabricacao() { return Data_Fabricacao; }

    /** @param Data_Fabricacao A nova data de fabricação do lote. */
    public void setData_Fabricacao(int Data_Fabricacao) { this.Data_Fabricacao = Data_Fabricacao; }
}