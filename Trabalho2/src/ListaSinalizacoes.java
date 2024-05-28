import java.time.LocalDate;
import java.util.Map;
import java.util.HashMap;

public class ListaSinalizacoes {
    private Node head;
    private int count;

    class Node {
        public Sinalizacao elemento;
        public Node proximo;
    }

    public ListaSinalizacoes() {
        head = null;
        count = 0;
    }

    public void add(Sinalizacao sinalizacao) {
        Node node = new Node();
        node.elemento = sinalizacao;
        if (head == null) {
            head = node;
        } else {
            Node atual = head;
            while (atual.proximo != null) {
                atual = atual.proximo;
            }
            atual.proximo = node;
        }
        count++;
    }

    public int size() {
        return count;
    }

    public void reset() {
        head = null;
        count = 0;
    }
    
    public Node proximo() {
        if (head != null) {
            Node atual = head;
            head = head.proximo;
            return atual;
        }
        return null;
    }

    public int[] contarMeses() {
        int[] meses = new int[13];
        Node aux = head;
        for (int i = 0; i < count; i++) {
            for (int j = 1; j <= 12; j++) {
                if (aux.elemento.getMes() == j) {
                    meses[0]++;
                    meses[j]++;
                }
            }
            aux = aux.proximo;
        }
        return meses;
    }

    public int[] encontrarMaiorMes(int[] meses) {
        int[] resultado = new int[2];
        int maior = 1;
        for (int i = 1; i < meses.length; i++) {
            if (meses[i] > meses[maior]) {
                maior = i;
            }
        }
        resultado[0] = maior;
        resultado[1] = meses[maior];
        return resultado;
    }

    public Map<String, Integer> maisSinalizacoes() {
        int[] meses = contarMeses();
        int[] resultado = encontrarMaiorMes(meses);
        Map<String, Integer> map = new HashMap<>();
        map.put("mes", resultado[0]);
        map.put("quantidade", resultado[1]);
        return map;
    }


    public int getMes(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        Node atual = head;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }
        return atual.elemento.getMes();
    }

    public LocalDate getData(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException();
        }
        Node atual = head;
        for (int i = 0; i < index; i++) {
            atual = atual.proximo;
        }

        return atual.elemento.getData();
    }

    public LocalDate getMaiorData() {
        if (head == null) {
            throw new IllegalStateException("A lista está vazia.");
        }
    
        Node atual = head;
        LocalDate maiorData = atual.elemento.getData();
    
        while (atual != null) {
            LocalDate dataImplantacao = atual.elemento.getData();
            if (dataImplantacao.isAfter(maiorData)) {
                maiorData = dataImplantacao;
            }
            atual = atual.proximo;
        }
    
        return maiorData;
    }

    public LocalDate getMenorData() {
        if (head == null) {
            throw new IllegalStateException("A lista está vazia.");
        }
    
        Node atual = head;
        LocalDate menorData = atual.elemento.getData();
    
        while (atual != null) {
            LocalDate dataImplantacao = atual.elemento.getData();
            if (dataImplantacao.isBefore(menorData)) {
                menorData = dataImplantacao;
            }
            atual = atual.proximo;
        }
    
        return menorData;
    }
}
