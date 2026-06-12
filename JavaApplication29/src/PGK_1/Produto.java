package PGK_1;

/**
 * Representa um item ou mercadoria catalogada no sistema de estoque.
 * Armazena as chaves de identificação interna e fiscal (código de barras) 
 * necessárias para movimentações e auditoria logística.
 * * @author Vinicius
 */
public class Produto {
    private int codigo;
    private int codigoBarra;

    /**
     * Construtor principal para a criação de um produto com suas chaves de identificação.
     *
     * @param codigo O código identificador interno do produto no sistema.
     * @param codigoBarra O código de barras (identificação fiscal/comercial) do produto.
     */
    public Produto(int codigo, int codigoBarra) {
        this.codigo = codigo;
        this.codigoBarra = codigoBarra;
    }

    /** @return O código interno do produto. */
    public int getCodigo() { 
        return codigo; 
    }

    /** @param codigo O novo código interno a ser definido. */
    public void setCodigo(int codigo) { 
        this.codigo = codigo; 
    }

    /** @return O código de barras comercial do produto. */
    public int getCoddigoBarra() { 
        return codigoBarra; 
    }

    /** @param coddigoBarra O novo código de barras a ser definido. */
    public void setCoddigoBarra(int coddigoBarra) { 
        this.codigoBarra = coddigoBarra; 
    }
}