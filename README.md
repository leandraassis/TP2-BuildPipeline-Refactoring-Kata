# BuildPipeline-Refactoring-Kata

## Sobre o projeto

Este projeto é um kata de refatoração cujo sistema é responsável por executar testes, realizar deploys e notificar o resultado via email. 
O objetivo aqui, por se tratar de um Kata, é melhorar a qualidade interna do código sem alterar o comportamento observável, ou seja, refatorar.

## Problemas encontrados

- Método `run` da classe `Pipeline` com múltiplas responsabilidades e estruturas de decisão aninhadas
- Uso de magic strings (`"success"`, `"failure"`) para representar estados
- Parâmetros primitivos soltos
- Responsabilidades de teste, deploy e notificação concentradas em uma única classe (Pipeline)

## Melhorias realizadas

- **Criação dos enums `DeployStatus` e uso do `TestStatus`**, eliminando magic strings
- **Extração de métodos** na classe `Pipeline`, isolando cada etapa com nomes descritivos
- **Criação da classe `PipelineResult`**, agrupando os resultados do pipeline em um único objeto
- **Extração das classes `TestRunner`, `Deployer` e `Notifier`**, cada uma com responsabilidade única e bem definida
- **`Pipeline` passou a ter uma única respobonsabilidade: orquestrar**, delegando cada etapa à classe responsável

## Justificativas

Todas as mudanças seguiram os princípios de **SRP** (cada classe com uma responsabilidade) e **OCP** (novas regras de notificação ou deploy podem ser adicionadas sem modificar o `Pipeline`). 
A refatoração foi conduzida em pequenos passos incrementais, com os testes sendo executados a cada etapa para garantir que nenhum comportamento foi alterado.
