# ES_2
# 📦 Sistema de Controle e Gerenciamento de Estoque

Este projeto consiste em um **Sistema de Controle e Gerenciamento de Estoque** evoluído arquiteturalmente. A versão atual incorpora múltiplos padrões de projeto do catálogo **Gang of Four (GoF)** para corrigir problemas de alto acoplamento, baixa coesão e violações de princípios de design orientados a objetos (como o SOLID).

---

## 🛠️ Tecnologias e Paradigmas
* **Paradigma:** Orientação a Objetos (POO)
* **Padronização Visual:** Diagrama de Classes UML
* **Padrões de Projeto (Design Patterns):** GoF (Criação, Estrutura e Comportamento)

---

## 📐 Padrões de Projeto Implementados

O sistema foi refatorado para garantir manutenibilidade, extensibilidade e robustez. Os seguintes padrões GoF foram aplicados:

### 1. Padrões de Criação
*   **Factory Method (`FuncionarioFactory`)**: Isola a lógica de criação de usuários e cargos do sistema. Substitui o uso antigo de condicionais (*flags* e *Enums*) por herança pura e polimorfismo.
    *   *Fábricas Concretas:* `EstoquistaFactory` e `GerenteFactory`.
*   **Singleton (`Estoque`)**: Garante que exista apenas uma única instância global gerenciando o inventário em memória, evitando problemas de concorrência e inconsistência de dados.
    *   *Implementação:* Construtor privado e método `getInstance()`.

### 2. Padrões Estruturais
*   **Facade (`SistemaEstoque`)**: Atua como uma fachada de entrada unificada para o sistema. Simplifica a interação do cliente ao encapsular chamadas complexas para subsistemas de fornecedores, lotes, relatórios e estoque.

### 3. Padrões Comportamentais
*   **Strategy (`EstrategiaReposicao`)**: Desloca algoritmos de ordenação e saída de produtos para fora da classe core de estoque. Permite alternar dinamicamente a lógica de negócio em tempo de execução.
    *   *Estratégias:* `FIFOStrategy` (Primeiro a Entrar, Primeiro a Sair) e `FEFOStrategy` (Primeiro a Vencer, Primeiro a Sair).
*   **Template Method (`Relatorio`)**: Define o esqueleto estrutural fixo para geração de relatórios de auditoria, delegando a formatação e filtros específicos para as subclasses.
    *   *Especializações:* `RelatorioValidade` e `RelatorioPerdas`.

---

## 📊 Estrutura de Classes Principais

*   **`Pessoa` / `Funcionario`**: Base do gerenciamento de acessos, agora utilizando tipagem forte (`String`, `Date`, `double`) e regras de domínio isoladas.
*   **`Gerente` / `Estoquista`**: Especializações físicas de funcionários com comportamentos e permissões polimórficas.
*   **`Fornecedor`**: Representação de parceiros comerciais atrelados ao cadastro de novos itens.
*   **`Produto` / `Lote`**: Entidades fundamentais do estoque. A classe `Lote` contém o método especialista `verificarValidade()`.

---

## 🔄 Evolução Arquitetural (Antes vs. Depois)

| Aspecto | Versão Original | Versão Evoluída (Atual) |
| :--- | :--- | :--- |
| **Criação de Objetos** | Instanciação direta com `new` e acoplada. | Descentralização isolada via **Factory Method**. |
| **Modelagem de Cargos** | Atributo Enum dentro de classe genérica. | Herança pura com classes `Gerente` e `Estoquista`. |
| **Interface de Acesso** | Clientes acoplados a múltiplos subsistemas. | Fachada única e simplificada via **Facade**. |
| **Instância do Estoque** | Risco de múltiplas instâncias concorrentes. | Ponto de acesso global único via **Singleton**. |
| **Regras de Reposição** | Ordenação engessada com `if/else` internos. | Alternância dinâmica de algoritmos via **Strategy**. |
| **Geração de Relatórios**| Duplicação de código e redundâncias. | Fluxo estruturado reaproveitável via **Template Method**. |
| **Regras de Domínio** | Ausência de rotinas de validação de dados. | Métodos especialistas integrados (ex: `verificarValidade`). |

---

## 🚀 Como Executar o Projeto

*(Instruções de exemplo - ajuste conforme a linguagem real do código)*

1. Certifique-se de ter o ambiente correspondente instalado (JDK / .NET SDK).
2. Clone o repositório:
   ```bash
   git clone https://github.com
   ```
3. Navegue até o diretório e compile:
   ```bash
   # Exemplo para Java
   javac Main.java
   java Main
   ```

---
**Curso:** Engenharia da Computação  
**Disciplina:** Engenharia de Software  
**Instituição:** UNISAL  
 
