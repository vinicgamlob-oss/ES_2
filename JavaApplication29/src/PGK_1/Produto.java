package PGK_1;

/**
 *
 * @author Vinicius
 */
public class Produto {
    private int codigo;
    private int codigoBarra;

    /**
     *
     * @param codigo
     * @param codigoBarra
     */
    public Produto(int codigo, int codigoBarra) {
        this.codigo = codigo;
        this.codigoBarra = codigoBarra;
    }

    /**
     *
     * @return
     */
    public int getCodigo() { return codigo; }

    /**
     *
     * @param codigo
     */
    public void setCodigo(int codigo) { this.codigo = codigo; }

    /**
     *
     * @return
     */
    public int getCoddigoBarra() { return codigoBarra; }

    /**
     *
     * @param coddigoBarra
     */
    public void setCoddigoBarra(int coddigoBarra) { this.codigoBarra = coddigoBarra; }
}