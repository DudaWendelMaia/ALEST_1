# 🚦 Consulta Placas de Trânsito

<div align="center">
  <img width="150" height="150" src="https://i.pinimg.com/originals/e6/3f/af/e63fafc1600ddf61941ce34362704447.gif" alt="Placas de Trânsito">
</div>

## ℹ️ Informações

- **Autores:** Maria Maia
- **Data:** 15/05/2023
- **Status:** Concluído
- **Descrição:** Sistema de consultas de placas de trânsito.
- **Link:** [GitHub](https://github.com/DudaWendelMaia/AlestI.git)

## 🎯 Problema

O objetivo é modelar e implementar um sistema de consultas sobre as placas de sinalização de trânsito de Porto Alegre, usando estruturas encadeadas. O sistema deve:
1. Ler um arquivo contendo informações sobre as sinalizações.
2. Implementar diferentes consultas sobre estas sinalizações.

### 📁 Estrutura de Dados e Formato do Arquivo

A primeira tarefa é criar uma estrutura de dados para manipular as informações das placas de sinalização lidas do arquivo. A modelagem deve incluir:
- Uma estrutura encadeada para armazenar as placas, mantida ordenada pelo nome do logradouro (rua/av/trav).
- Definição de classes e métodos para gerenciar esta lista, considerando:
  - A lista principal deve ser duplamente encadeada, com referências para o próximo e o nodo anterior.
  - Cada nodo deve ser único para cada logradouro e guardar uma lista simplesmente encadeada de sinalizações daquela rua.
  - Métodos para navegar pela estrutura e garantir o correto encadeamento e armazenamento das sinalizações.

 Exemplos:

- **Figura 2:** Estrutura do nodo.
- **Figura 3:** Exemplo de estrutura com três ruas (Conceição, Olavo Bilac e Santana), onde cada nodo contém uma lista de sinalizações instaladas.

Para facilitar a ordenação, sugere-se separar o tipo do logradouro (rua, avenida, travessa) do nome e usar o método `compareTo` para a comparação de nomes.

### 🔍 Consultas sobre a Estrutura

A partir da estrutura encadeada, o sistema deve permitir as seguintes consultas através de uma interface textual simples:
1. Apresentar o nome do logradouro com mais sinalizações registradas.
2. Apresentar o mês com mais sinalizações implantadas em um logradouro.
3. Entrar em um modo de navegação, permitindo avançar e retroceder pelas sinalizações de um logradouro, apresentando o total de sinalizações e a primeira e a última sinalização registrada.

## ▶️ Como Executar

Certifique-se de ter o JDK instalado. Clone o repositório e compile o código Java.

1. Clone o repositório:
    ```sh
    git clone https://github.com/DudaWendelMaia/AlestI.git
    ```

2. Navegue até a pasta do projeto:
    ```sh
    cd Trabalho2
    ```

3. Compile o código:
    ```sh
    javac App.java
    ```

4. Execute o programa:
    ```sh
    java App
    ```

---

Espero que este trabalho tenha sido útil! 😊

