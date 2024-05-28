public class Rua {
    private String nome;
    private String id;
    private ListaSinalizacoes listaSinalizacoes;

    public Rua(String nome, String id) {
        this.nome = nome;
        this.id = id;
        this.listaSinalizacoes = new ListaSinalizacoes();
    }

    public String getNome() {
        return nome;
    }

    public String getId() {
        return id;
    }

    public ListaSinalizacoes getListaSinalizacoes() {
        return listaSinalizacoes;
    }
}
