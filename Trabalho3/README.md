# 📘 Dicionário

<div align="center">
  <img width="150" height="150" src="https://cdn-icons-png.flaticon.com/512/1902/1902654.png">
</div>

## ℹ️ Informações

- **Autores:** Maria Maia
- **Data:** 15/05/2023
- **Status:** Concluído
- **Descrição:** Gerenciar uma árvore de palavras para um dicionário.
- **Link:** [GitHub](https://github.com/DudaWendelMaia/AlestI.git)

## 🎯 Problema

Trabalhando com Árvores

## 📝 Instruções

O objetivo deste trabalho é desenvolver uma solução para gerenciar uma árvore de palavras para um dicionário. Para isso, deve-se ler um arquivo de palavras com seus significados que serão armazenados em uma árvore. A partir de dois ou três caracteres digitados, será apresentada uma lista de palavras que começam com esses caracteres.

## 📋 Detalhamento

As palavras devem ser armazenadas, caractere a caractere, em uma árvore genérica da seguinte maneira:

- Deve haver uma maneira de indicar que um nodo é o último caractere que forma uma palavra e que conterá o significado da palavra. 
- As palavras são compostas pelos caracteres armazenados nos nodos visitados da raiz até o último caractere que forma a palavra.

Para possibilitar uma consulta ao dicionário, a entrada deve ser um conjunto de caracteres, e a saída deve ser as possíveis palavras que podem ser formadas a partir deste conjunto de caracteres. Considerando a árvore exemplificada, se fosse digitado “ba”, a lista de palavras de saída seria: baia, baiano, bala e bar. A partir disso, é escolhida uma destas palavras para apresentar o seu significado.

## 🌳 Estrutura de Dados

A estrutura de dados a ser desenvolvida obrigatoriamente deve ser baseada em uma árvore genérica. Sugere-se ter como referência a implementação de árvore genérica estudada. Neste caso, a classe `Node` deve armazenar um caractere e sempre que for o último caractere que forma uma palavra, deve armazenar também o seu significado (por exemplo, pode ser incluído um atributo `String significado`, se for null é porque não é o último caractere que forma a palavra). Além disso, os seus métodos devem ser alterados para darem suporte às funcionalidades necessárias.

## 💻 Aplicação

Para usar e testar a estrutura de dados desenvolvida, deve ser feita uma aplicação para um dicionário. O funcionamento deve ser o seguinte:

1. É fornecido um conjunto de caracteres;
2. Após a pesquisa na árvore, é retornada uma lista de palavras que iniciam com os caracteres fornecidos;
3. É escolhida uma palavra desta lista;
4. É apresentado o significado desta palavra.

## 📂 Formato do Arquivo de Entrada

O arquivo do dicionário deverá ter o seguinte formato:

```
Palavra 1; significado da palavra 1
Palavra 2; significado da palavra 2
Palavra 3; significado da palavra 3
```

**Importante:** Este arquivo não pode conter caracteres com acento!

## ▶️ Como Executar

Certifique-se de ter o JDK instalado. Clone o repositório e compile o código Java.

1. Clone o repositório:
    ```sh
    git clone https://github.com/DudaWendelMaia/AlestI.git
    ```

2. Navegue até a pasta do projeto:
    ```sh
    cd Trabalho3
    ```

3. Compile o código:
    ```sh
    javac Main.java
    ```

4. Execute o programa:
    ```sh
    java Main
    ```

---

Espero que este trabalho tenha sido útil! 😊
