package PGK_1;

public class RelatorioPerdas extends Relatorio {
    /**
     * Processa os dados de estoque coletados e formata o corpo do relatório de perdas.
     * Varre todos os lotes carregados filtrando aqueles cujo ano de validade seja 
     * inferior a 2026, contabilizando o total de unidades vencidas e construindo 
     * um informativo textual detalhado usando StringBuilder.
     *
     * @return Uma String formatada contendo o cabeçalho, a discriminação por lote afetado 
     * e o somatório total de itens perdidos.
     */
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