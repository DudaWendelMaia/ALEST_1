import java.util.HashMap;
import java.util.Map;

public class ListaDeRuas {
    private Node header;
    private Node trailer;
    private Node current;
    private int contador;

    class Node {
        public Node anterior;
        public Node proximo;
        public ListaSinalizacoes lista;
        public Elemento elemento;
        public String nomeDaRua;
        public String idRua;

        public Node(Elemento e) {
            elemento = e;
            anterior = null;
            proximo = null;
        }
    }

    public ListaDeRuas() {
        header = new Node(null);
        trailer = new Node(null);
        header.proximo = trailer;
        trailer.anterior = header;
        contador = 0;
    }
    

    private String meses(int mes) {
        switch (mes) {
            case 1:
                return "Janeiro";

            case 2:
                return "Fevereiro";

            case 3:
                return "Março";

            case 4:
                return "Abril";

            case 5:
                return "Maio";

            case 6:
                return "Junho";

            case 7:
                return "Julho";

            case 8:
                return "Agosto";

            case 9:
                return "Setembro";

            case 10:
                return "Outubro";

            case 11:
                return "Novembro";

            case 12:
                return "Dezembro";

            default:
                return "Mês inválido";
        }
    }

    public void add(Elemento elemento) {
        Node n = new Node(elemento);
        n.proximo = trailer;
        n.anterior = trailer.anterior;
        trailer.anterior.proximo = n;
        trailer.anterior = n;
        contador++;
    }

    public boolean remove(Elemento elemento) {
        Node aux = header.proximo;
        for (int i = 0; i < contador; i++) {
            if (aux.elemento.equals(elemento)) {
                aux.anterior.proximo = aux.proximo;
                aux.proximo.anterior = aux.anterior;
                contador--;
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }

    public Elemento maisSinalizacoes() {
        int num = 0;
        Elemento elemento = null;
        Node aux = header.proximo;
        for (int i = 0; i < contador; i++) {
            int tamanhoSinalizacoes = aux.elemento.getLista().size();
            if (tamanhoSinalizacoes > num) {
                num = tamanhoSinalizacoes;
                elemento = aux.elemento;
            }
            aux = aux.proximo;
        }
        return elemento;
    }

    public Map<String, String> maisMesSinalizacoes() {
        int[] meses = contarSinalizacoesPorMes();
        int maior = encontrarMesComMaisSinalizacoes(meses);
        return criarMapaResultado(maior, meses);
    }
    
    private int[] contarSinalizacoesPorMes() {
        int[] meses = new int[13];
        Node aux = header.proximo;
        Node aux2 = trailer.anterior;
    
        for (int i = 0; i < contador / 2; i++) {
            for (int j = 1; j <= 12; j++) {
                if (aux.elemento.getLista().maisSinalizacoes().get("mes") == j) {
                    meses[0]++;
                    meses[j]++;
                }
    
                if (aux2.elemento.getLista().maisSinalizacoes().get("mes") == j) {
                    meses[0]++;
                    meses[j]++;
                }
            }
            aux = aux.proximo;
            aux2 = aux2.anterior;
        }
    
        return meses;
    }
    
    private int encontrarMesComMaisSinalizacoes(int[] meses) {
        int maior = 1;
        for (int i = 1; i < meses.length; i++) {
            if (meses[i] > meses[maior]) {
                maior = i;
            }
        }
        return maior;
    }
    
    private Map<String, String> criarMapaResultado(int maior, int[] meses) {
        Map<String, String> map = new HashMap<>();
        map.put("mes", meses(maior));
        map.put("quantidade", Integer.toString(meses[maior]));
        return map;
    }


    public void add(int index, Elemento elemento) throws IndexOutOfBoundsException {
        if (index < 0 || index > contador)
            throw new IndexOutOfBoundsException();
    }

    private Node getNodeIndex(int index) {
        Node aux = null;
        if (index < contador / 2) {
            aux = header.proximo;
            for (int i = 0; i < index; i++)
                aux = aux.proximo;
        } else {
            aux = trailer.anterior;
            for (int i = contador - 1; i > index; i--)
                aux = aux.anterior;
        }
        return aux;
    }


    public Elemento removeByIndex(int index) {
        if (index < 0 || index >= contador) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        aux.anterior.proximo = aux.proximo;
        aux.proximo.anterior = aux.anterior;
        contador--;
        return aux.elemento;
    }

    public Elemento get(int index) {
        if ((index < 0) || (index >= contador)) {
            throw new IndexOutOfBoundsException();
        }
        Node aux = getNodeIndex(index);
        return aux.elemento;
    }

    public Elemento set(int index, Elemento element) {
        if ((index < 0) || (index >= contador)) {
            throw new IndexOutOfBoundsException();
        }
        return null;
    }

    public boolean contains(String nomeLog) {
        Node aux = header.proximo;
        for (int i = 0; i < contador; i++) {
            if (aux.elemento.getLogradouroNome().equals(nomeLog)) {
                return true;
            }
            aux = aux.proximo;
        }
        return false;
    }

    private Node containsElement(String elemento) {
        Node aux = header.proximo;

        while (aux != trailer) {
            if (aux.elemento.equals(elemento)) {
                return aux;
            }
            aux = aux.proximo;
        }
        return null;
    }

    public int indexOf(String nomeLog) {
        Node aux = header.proximo;
        for (int i = 0; i < contador; i++) {
            if (aux.elemento.getLogradouroNome().equals(nomeLog)) {
                return i;
            }
            aux = aux.proximo;
        }
        return -1;
    }

    public void clear() {
        header = new Node(null);
        trailer = new Node(null);
        header.proximo = trailer;
        trailer.anterior = header;
        contador = 0;
    }

    public int size() {
        return contador;
    }

    public boolean isEmpty() {
        return (contador == 0);
    }

    public void orderedAdd(Elemento elemento) {
        Node aux = containsElement(elemento.getLogradouroNome());
        if (aux == null) {
            Node n = new Node(elemento);
            if (header.proximo == trailer) {
                n.anterior = header;
                n.proximo = trailer;
                trailer.anterior = n;
                header.proximo = n;
            } else if (elemento.getLogradouroNome().compareTo(header.proximo.elemento.getLogradouroNome()) < 0) {
                n.proximo = header.proximo;
                n.anterior = header;
                header.proximo = n;
                n.proximo.anterior = n;
            } else if (elemento.getLogradouroNome().compareTo(trailer.anterior.elemento.getLogradouroNome()) > 0) {
                n.proximo = trailer;
                n.anterior = trailer.anterior;
                trailer.anterior.proximo = n;
                trailer.anterior = n;
            } else {
                aux = header.proximo;
                boolean inseriu = false;
                while (aux != trailer && !inseriu) {
                    if (elemento.getLogradouroNome().compareTo(aux.elemento.getLogradouroNome()) < 0) {
                        inseriu = true;
                        n.proximo = aux;
                        n.anterior = aux.anterior;
                        aux.anterior.proximo = n;
                        aux.anterior = n;
                    }
                    aux = aux.proximo;
                }
            }
            contador++;
        }
    }

    public void reset() {
        current = header.proximo;
    }

    public Elemento proximo() {
        if (current != trailer) {
            Elemento num = current.elemento;
            current = current.proximo;
            return num;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        Node aux = header.proximo;
        for (int i = 0; i < contador; i++) {
            s.append(aux.elemento.getLogradouroNome());
            s.append("\n");
            aux = aux.proximo;
        }
        return s.toString();
    }
}
