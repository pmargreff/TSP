# TSP - Traveling Salesperson Problem

## Apresentação

Universidade Federal de Pelotas Bacharelado em Ciência da Computação

Disciplina de Programação Orientada a Objetos (UFPel - 2015/1)

Pablo Margreff - 14100513 - pmargreff@inf.ufpel.edu.br

Implementação de diferentes heurísticas para resolver o problema do caixero viajante. [Link](http://www.cis.upenn.edu/~cis110/13sp/hw/hw08/tsp.shtml) para a proposta completa do problema.

## Documentação

O programa é composto por três arquivos principais, os métodos `OrderInsertion`, `NearestInsertion` e `SmallestInsertion` onde cada um deles usa uma heurística diferente para a resolução do problema.  
O repositório contém os arquivos de código, um pacote para exibição na pasta `std` e arquivos de entrada para, na pasta `/IO`.


## Como usar

### Compilação
* `javac *Insertion.java`
	
### Execução
* `java *Insertion < IO/arquivoDeEntrada.txt`

Onde `*` pode ser substituido por Order, Nearest ou Smallest. E `arquivoDeEntrada.txt` pode ser qualquer arquivo de formato `.txt` localizado na pasta `/IO`. 

