class Reserva {
    private Usuario usuario;
    private Carro carro;
    private int quantidadeDias;
    double valorTotal;
    

    public Reserva(Usuario usuario, Carro carro, int quantidadeDias, double valorTotal) {
        this.usuario = usuario;
        this.carro = carro;
        this.quantidadeDias = quantidadeDias;
        this.valorTotal = valorTotal;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public int getQuantidadeDias() {
        return quantidadeDias;
    }

    public void setQuantidadeDias(int quantidadeDias) {
        this.quantidadeDias = quantidadeDias;
    }
    public double getValorTotal() {
        return valorTotal;
    }
    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
