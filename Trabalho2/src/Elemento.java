public class Elemento {
    private String log;
    private String logradouroNome;
    private ListaSinalizacoes listagem;

    public Elemento(String log, String logradouroNome, ListaSinalizacoes listagem) {
        this.log = log;
        this.logradouroNome = logradouroNome;
        this.listagem = listagem;
    }

    public String getLog() {
        return log;
    }

    public String getLogradouroNome() {
        return logradouroNome;
    }

    public ListaSinalizacoes getLista() {
        return listagem;
    }
}
