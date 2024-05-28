import java.io.BufferedReader;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class LeituraArquivo {
    Scanner input;
    ListaDeRuas lista;

        public LeituraArquivo(){
        String linhas[] = new String[110000];
        int numLinhas = 0;
        input = new Scanner(System.in);
        lista = new ListaDeRuas();
        BufferedReader reader = null;

        try {
            System.out.println("Por favor, informe o caminho do arquivo.");
            String path = input.nextLine();
            reader = new BufferedReader(new FileReader(path));
            String line = reader.readLine();
            line = reader.readLine();

            while (line != null) {
                linhas[numLinhas] = line;
                numLinhas++;
                line = reader.readLine();
            }
        } catch (Exception e) {
            System.err.format("Erro na leitura do arquivo: %s", e.getMessage());
        }

        try {
            for (int i = 0; i < numLinhas; i++) {
                String[] campos = linhas[i].split(";");

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
                LocalDateTime dateTime = LocalDateTime.parse(campos[0], formatter);
                int anoInicial = dateTime.getYear();
                int mesInicial = dateTime.getMonthValue();
                int diaInicial = dateTime.getDayOfMonth();
                int horaInicial = dateTime.getHour();
                int minutoInicial = dateTime.getMinute();

                String informacao = campos[1];

                int anoColocado = 1500;
                int mesColocado = 1;
                int diaColocado = 1;
                if (!campos[4].equals("")) {
                    if (campos[4].contains("-"))
                        formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    else
                        formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate date = LocalDate.parse(campos[4], formatter);
                    anoColocado = date.getYear();
                    mesColocado = date.getMonthValue();
                    diaColocado = date.getDayOfMonth();
                }

                String logradouro = campos[5].split(" ", 2)[0];
                String nomeLog = campos[5].split(" ", 2)[1];

                double numeroI;
                if (campos[6].equals(""))
                    numeroI = 0;
                else
                    numeroI = Double.parseDouble(campos[6]);

                double numeroFinal;
                if (campos[7].equals(""))
                    numeroFinal = 0;
                else
                    numeroFinal = Double.parseDouble(campos[7]);

                String direcao = campos[10];

                String lugarInstalar = "";
                if (campos.length >= 13)
                    lugarInstalar = campos[12];

                    Sinalizacao sinalizacao = new Sinalizacao(informacao, anoInicial, mesInicial, diaInicial,
                    horaInicial, minutoInicial, numeroI, numeroFinal, direcao, lugarInstalar, diaColocado,
                    mesColocado, anoColocado);

                    if (lista.contains(nomeLog)) {
                        int index = lista.indexOf(nomeLog);
                        Elemento element = lista.get(index);
                        element.getLista().add(sinalizacao);
                    } else {
                        ListaSinalizacoes lista2 = new ListaSinalizacoes();
                        lista2.add(sinalizacao);
                        lista.orderedAdd((new Elemento(logradouro, nomeLog, lista2)));
                    }

            }
        } catch (Exception e) {
            System.err.format("Erro na leitura do arquivo: %s", e.getMessage());
        }
    }



    public void executa() {
        boolean entradaValida;
        int escolha = 0;
        do {
            do {
                entradaValida = true;
                exibirMenu();
                try {
                    escolha = input.nextInt();
                } catch (InputMismatchException e) {
                    input.nextLine();
                    entradaValida = false;
                    System.out.println("Tipo incorreto. Digite novamente.");
                } catch (Exception e1) {
                    input.nextLine();
                    entradaValida = false;
                    e1.printStackTrace();
                    System.out.println("Digite novamente.");
                }
            } 
            
            while (!entradaValida);
            input.nextLine();
            switch (escolha) {
                case 1:
                    maisSinalizacao();
                    break;
                case 2:
                    maisMesSinalizacao();
                    break;
                case 3:
                    modoNavegacao();
                    break;
                case 0:
                    System.out.println("Sistema encerrado com sucesso.");
                    break;
                default:
                    System.out.println("esta opção é inválida.");
            }
        } 
        
        while (escolha != 0);
    }
    
    public void exibirMenu() {
        System.out.println(" ");
        System.out.println("***********************************************************************************");
        System.out.println("Selecione a opção desejada:");
        System.out.println("[0] Sair do sistema");
        System.out.println("[1] Apresentar a rua/av/trav com mais sinalizações registradas");
        System.out.println("[2] Apresentar o mês em que foram implementadas mais sinalizações em uma rua/av/trav");
        System.out.println("[3] Modo navegação");
        System.out.println(" ");
        System.out.println("***********************************************************************************");
    }

    public void maisSinalizacao() {
        Elemento elemento = lista.maisSinalizacoes();
        System.out.println("Rua/Av/Trav com mais sinalizações: " + elemento.getLogradouroNome() + " = " + elemento.getLista().size() + " sinalizações.");
        }
        
        public void maisMesSinalizacao() {
        Map<String, String> map = lista.maisMesSinalizacoes();
        System.out.println("Mês em que mais colocaram sinalizações: " + map.get("mes") + " com " + map.get("quantidade") + " sinalizações instaladas");
        }

     public void modoNavegacao() {
    boolean entradaValida;
    int escolha = -1;
    int indice = -1;
    Elemento elemento = null;
    System.out.println("Digite um número entre 0 e 3125 para começar:");

    do {
        entradaValida = true;
        do {
            entradaValida = true;
            try {
                indice = input.nextInt();
                elemento = lista.get(indice);
            } catch (InputMismatchException e) {
                input.nextLine();
                entradaValida = false;
                System.out.println("caractere inválido, digite um número entre 0 e 3125.");
            } catch (IndexOutOfBoundsException e2) {
                input.nextLine();
                entradaValida = false;
                System.out.println("número inválido.");
            } catch (Exception e1) {
                input.nextLine();
                entradaValida = false;
                e1.printStackTrace();
                System.out.println("Digite novamente:");
            }
        } while (!entradaValida);

        exibirInformacoesElemento(elemento);

    } while (!entradaValida);

    do {
        entradaValida = true;
        System.out.println("**************************");
        System.out.println("Para avançar selecione 2 \nPara o anterior selecione 1 \nPara sair selecione 0.");
        System.out.println("\n**************************");

        do {
            entradaValida = true;
            try {
                escolha = input.nextInt();
            } catch (InputMismatchException e) {
                input.nextLine();
                entradaValida = false;
                System.out.println("Tipo incorreto. Digite novamente.");
            } catch (Exception e1) {
                input.nextLine();
                entradaValida = false;
                e1.printStackTrace();
                System.out.println("Digite novamente.");
            }
        } while (!entradaValida);

        if (escolha == 2) {
            if (indice >= 3125) {
                System.out.println("fim da lista.");
                break;
            } else {
                indice++;
                elemento = lista.get(indice);
            }
        } else if (escolha == 1) {
            if (indice <= 0) {
                System.out.println("início da lista.");
                break;
            } else {
                indice--;
                elemento = lista.get(indice);
            }
        } else if (escolha == 0) {
            entradaValida = false;
        } else {
            entradaValida = false;
            System.out.println("Opção incorreta.");
            break;
        }

        exibirInformacoesElemento(elemento);

    } while (entradaValida);
}

private void exibirInformacoesElemento(Elemento elemento) {
    if (elemento != null) {
        int tamanho = elemento.getLista().size();
        System.out.println(elemento.getLogradouroNome() + ": " + "\n " + "Total de sinalizações = " + tamanho + "\n" + " Primeira sinalização = " + elemento.getLista().getMenorData() + "\n" + " Última sinalização = " + elemento.getLista().getMaiorData() + "\n");
    } else {
        System.out.println("Elemento inválido.");
    }
}
}
