class Carro {
    private String modelo;
private int quantidadeDiasAluguel;
    public Carro(String modelo, int quantidadeDiasAluguel) {
        this.modelo = modelo;
        this.quantidadeDiasAluguel = quantidadeDiasAluguel;
    }

    // Getters e setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

public int getQuantidadeDiasAluguel() {
        return quantidadeDiasAluguel;
    }

    public void setQuantidadeDiasAluguel(int quantidadeDiasAluguel) {
        this.quantidadeDiasAluguel = quantidadeDiasAluguel;
    }






    @Override
    public String toString() {
        return "Modelo: " + modelo;
    }
}