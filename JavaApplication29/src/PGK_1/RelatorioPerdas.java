package PGK_1;

public class RelatorioPerdas extends Relatorio {
    @Override
    protected String processarEFormatar() {
        StringBuilder sb = new StringBuilder("--- RELATÓRIO DE PERDAS ---\n");
        double totalPerdido = 0;
        for (Lote l : dados) {
            if (l.getValidade() < 2026) {
                totalPerdido += l.getQtd_de_Produtos();
                sb.append("Lote ").append(l.getCodigo()).append(": ").append(l.getQtd_de_Produtos()).append(" unidades perdidas.\n");
            }
        }
        sb.append("Total de itens perdidos: ").append(totalPerdido);
        return sb.toString();
    }
}