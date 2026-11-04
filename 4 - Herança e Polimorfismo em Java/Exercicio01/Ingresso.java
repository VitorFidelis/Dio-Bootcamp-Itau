
public sealed abstract class Ingresso permits MeiaEntrada, Familia {
    private double valor;
    private String nomeDoFilme;
    private DisplayMode displayMode;

    public Ingresso(double valor, String nomeDoFilme, DisplayMode displayMode) {
        this.valor = valor;
        this.nomeDoFilme = nomeDoFilme;
        this.displayMode = displayMode;
    }

    abstract double valorDoIngresso();

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getNomeDoFilme() {
        return nomeDoFilme;
    }

    public void setNomeDoFilme(String nomeDoFilme) {
        this.nomeDoFilme = nomeDoFilme;
    }

    public DisplayMode getDisplayMode() {
        return displayMode;
    }

    public void setDisplayMode(DisplayMode displayMode) {
        this.displayMode = displayMode;
    }
}
