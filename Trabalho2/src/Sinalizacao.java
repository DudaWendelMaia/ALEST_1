import java.time.LocalDate;

public class Sinalizacao {
    private LocalDate data;
    private String informacao;
    private String direcao;
    private String lugarInstalar;
    private double numeroI;
    private double numeroF;
    private int dia;
    private int mes;
    private int ano;
    private int anoInicial;
    private int mesInicial;
    private int horaInicial;
    private int minutoInicial;

    public Sinalizacao(String informacao, int anoInicial, int mesInicial, int diaInicial,
            int horaInicial, int minutoInicial, double numeroI, double numeroF, String direcao,
            String lugarInstalar, int dia, int mes, int ano) {
                this.data = LocalDate.of(ano, mes, dia);
                this.dia = dia;
                this.mes = mes;
                this.ano = ano;
                this.numeroI = numeroI;
                this.numeroF = numeroF;
                this.direcao = direcao;
                this.informacao = informacao;
                this.anoInicial = anoInicial;
                this.mesInicial = mesInicial;
                this.horaInicial = horaInicial;
                this.minutoInicial = minutoInicial;
                this.lugarInstalar = lugarInstalar;           
    }

    public LocalDate getData() {
        return data;
    }

    public String getInformacao() {
        return informacao;
    }

    public String getDirecao() {
        return direcao;
    }

    public String getLugarInstalar() {
        return lugarInstalar;
    }

    public double getNumeroI() {
        return numeroI;
    }

    public double getNumeroF() {
        return numeroF;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int getAnoInicial() {
        return anoInicial;
    }

    public int getMesInicial() {
        return mesInicial;
    }

    public int getHoraInicial() {
        return horaInicial;
    }

    public int getMinutoInicial() {
        return minutoInicial;
    }

    @Override
    public String toString() {
        return "Sinalizacao [informacao=" + informacao + ", anoInicial=" + anoInicial + ", mesInicial="
                + mesInicial + ", diaInicial=" + ", horaInicial=" + horaInicial
                + ", minutoInicial=" + minutoInicial + ", numeroI=" + numeroI + ", numeroF=" + numeroF
                + ", direcao=" + direcao + ", lugarInstalar=" + lugarInstalar + ", dia=" + dia + ", mes=" + mes
                + ", ano=" + ano + "]";
    }
}
