public final class MeiaEntrada extends Ingresso {

    public MeiaEntrada(double valor, String nomeDoFilme, DisplayMode displayMode) {
        super(valor, nomeDoFilme, displayMode);
    }

    @Override
    double valorDoIngresso() {
        return this.getValor() / 2;
    }

}
