package PGK_1;

public class RelatorioValidade extends Relatorio {
  
    
   /**
     * Processa os dados de estoque coletados e formata o corpo do relatório de validades.
     * Varre todos os lotes carregados filtrando especificamente aqueles cujo ano de validade 
     * seja inferior a 2026, anexando um alerta visual de "VENCIDO" ao texto formatado 
     * para cada ocorrência identificada.
     *
     * @return Uma String formatada contendo o cabeçalho e a listagem de auditoria cronológica 
     * dos lotes vencidos presentes no sistema.
     */
    @Override
    protected String processarEFormatar() {
        StringBuilder sb = new StringBuilder("--- RELATÓRIO DE VALIDADE ---\n");
        for (Lote l : dados) {
            if (l.getValidade() < 2026) { 
                sb.append("Lote: ").append(l.getCodigo()).append(" - VENCIDO (")
                  .append(l.getValidade()).append(")\n");
            }
        }
        return sb.toString();
    }
}