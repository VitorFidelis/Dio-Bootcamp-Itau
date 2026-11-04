public final class Familia extends Ingresso {

    private int numeroDepessoas;

    public Familia(double valor, String nomeDoFilme, DisplayMode displayMode, int numeroDepessoas) {
        super(valor, nomeDoFilme, displayMode);
        this.numeroDepessoas = numeroDepessoas;
    }

    public int getNumeroDepessoas() {
        return numeroDepessoas;
    }

    @Override
    double valorDoIngresso() {

        if (this.numeroDepessoas < 3) {
            return this.getValor() * this.numeroDepessoas;
        }

        double valorComDesconto = ((this.getValor() * this.numeroDepessoas) * 0.05);

        return valorComDesconto;
    }

}
