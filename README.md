# TSP
Traveling Salesperson Problem

Universidade Federal de Pelotas Bacharelado em Ciência da Computação

Pablo Margreff - 14100513 - pmargreff@inf.ufpel.edu.br

Implementação de diferentes heurísticas para resolver o problema do caixero viajante. A proposta completa do problema se encontra [aqui](http://www.cis.upenn.edu/~cis110/13sp/hw/hw08/tsp.shtml).

## Documentação

O programa é composto por três arquivos, os métodos `OrderInsertion`, `NearestInsertion` e `SmallestInsertion` onde cada um deles usa uma heurística diferente para a resolução do problema.  
O repositório contém os arquivos de código, os arquivos do entrada para na pasta `/IO`.


## Como usar

### Compilação
* `javac *Insertion.java`
	
### Execução
* `java *Insertion < IO/arquivoDeEntrada.txt`

Onde `*` pode ser substituido por Order, Nearest ou Smallest. E `arquivoDeEntrada.txt` pode ser qualquer arquivo do tipo `.txt` na pasta `/IO`. 

