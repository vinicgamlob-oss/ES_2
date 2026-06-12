package PGK_1;

public class Produto {
    private int codigo;
    private int codigoBarra;

    public Produto(int codigo, int codigoBarra) {
        this.codigo = codigo;
        this.codigoBarra = codigoBarra;
    }

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public int getCoddigoBarra() { return codigoBarra; }
    public void setCoddigoBarra(int coddigoBarra) { this.codigoBarra = coddigoBarra; }
}