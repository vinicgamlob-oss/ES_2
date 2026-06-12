package PGK_1;

public class Lote {
    private int Codigo;
    private Produto Produto;
    private int Validade;
    private int Qtd_de_Produtos; 
    private int Data_Recebida;
    private int Data_Fabricacao;

    public Lote(int Codigo, Produto Produto, int Validade, int Qtd_de_Produtos, int Data_Recebida, int Data_Fabricacao) {
        this.Codigo = Codigo;
        this.Produto = Produto;
        this.Validade = Validade;
        this.Qtd_de_Produtos = Qtd_de_Produtos;
        this.Data_Recebida = Data_Recebida;
        this.Data_Fabricacao = Data_Fabricacao;
    }

    // Mantenha APENAS os Getters e Setters abaixo...
    public int getCodigo() { return Codigo; }
    public void setCodigo(int Codigo) { this.Codigo = Codigo; }
    public Produto getProduto() { return Produto; }
    public void setProduto(Produto Produto) { this.Produto = Produto; }
    public int getValidade() { return Validade; }
    public void setValidade(int Validade) { this.Validade = Validade; }
    public int getQtd_de_Produtos() { return Qtd_de_Produtos; }
    public void setQtd_de_Produtos(int Qtd_de_Produtos) { this.Qtd_de_Produtos = Qtd_de_Produtos; }
    public int getData_Recebida() { return Data_Recebida; }
    public void setData_Recebida(int Data_Recebida) { this.Data_Recebida = Data_Recebida; }
    public int getData_Fabricacao() { return Data_Fabricacao; }
    public void setData_Fabricacao(int Data_Fabricacao) { this.Data_Fabricacao = Data_Fabricacao; }
}