Exercicio desenvolvido para o trabalho 2 da cadeira de Algoritmos e Estruturas de Dados

# T2 Alest
tem como objetivo modelar e implementar um sistema de consultas sobre as placas de sinalização de trânsito de Porto Alegre usando estruturas encadeadas. Para isso, inicialmente, deve ser feita a leitura de um arquivo contendo informações sobre as sinalizaçõoes, para posteriormente serem implementadas diferentes consultas sobre estas sinalizaçõoes

## 1. Estrutura de Dados e Formato do Arquivo
A primeira tarefa para a realização desse trabalho é criar uma estrutura de dados capaz de manipular as
informações relativas as placas de sinalização que forem lidas do arquivo.
Depois deve-se fazer a modelagem de uma estrutura encadeada para armazená-los. Esta estrutura consiste em uma lista que deverá ser
mantida ordenada pelo nome da rua/av/trav (logradouro nome) onde a sinalização foi instalada.
Também é preciso definir as classes e métodos que irão gerenciar esta lista, considerando as informações
apresentadas a seguir.


Conforme ilustram as Figuras 2 e 3, a lista principal deverá ser duplamente encadeada, com referência para o próximo nodo e o nodo anterior. O nodo da lista deverá ser único para cada rua/av/trav
(logradouro nome). Além disso, cada nodo guardará a lista simplesmente encadeada de sinalizações
daquela mesma rua. Esta lista também deverá ter métodos que permitam navegar por esta estrutura
e que garantam que cada vez que uma nova sinalização for armazenada, seja feito o encadeamento e o
armazenamento correto para manter a ordenação por logradouro nome.

Figura 2: Estrutura do nodo.

Figura 3: Exemplo de estrutura formada por três ruas (Conceição, Olavo Bilac e Santana) sendo que cada
um dos nodos contém uma lista com informações sobre as sinalizações que foram instaladas nela.
Depois disso, a partir do código para a leitura do arquivo CSV que foi fornecido, faça o correto
armazenamento das informações lidas dentro da estrutura encadeada implementada. Atenção: os nomes
das rua/av/trav possuem “Av”, “R” ou “Trav” na frente. Para facilitar o processo de ordenação, sugere-se
que esta informação seja guardada de forma separada (por exemplo, um atributo guarda se é rua, avenida,
travessa, etc., e o outro atributo guarda apenas o nome) e para a comparação de nomes use o método compareTo

## 2. Consultas sobre a Estrutura
A partir da estrutura encadeada implementada, deve ser possível fazer as seguintes consultas através de
uma interface textual simples:
1. Apresentar o nome da rua/av/trav que tem mais sinalizações registradas;
2. Apresentar o mês em que mais foram implantadas mais sinalizações em uma rua/av/trav;
3. Permitir entrar em um modo de navegação. Onde é possível navegar pelas rua/av/trav, isto é,
avançar e retroceder, apresentando o número total de sinalizações desta rua/av/trav e qual foi a
primeira e a última sinalização registrada na rua.
