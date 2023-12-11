class Usuario {
    private String nome;
    private String endereco;
    private String numeroTelefone;
   
    private Cartao cartaoPagamento; // Adicionamos esse atributo
    private Carro carroAluguel; // Adicionamos esse atributo

    // Construtor
    public Usuario(String nome, String endereco, String numeroTelefone, Cartao cartaoPagamento, Carro carroAluguel) {
        this.nome = nome;
        this.endereco = endereco;
        this.numeroTelefone = numeroTelefone;
        this.cartaoPagamento = cartaoPagamento;
        this.carroAluguel = carroAluguel;
        
    }

    // Getters e setters
    public String getNumeroTelefone() {
        return numeroTelefone;
    }

    public Carro getCarroAluguel() {
        return carroAluguel;
    }

    public Cartao getCartaoPagamento() {
        return cartaoPagamento;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setCarroAluguel(Carro carroAluguel) {
        this.carroAluguel = carroAluguel;
    }

    public void setCartaoPagamento(Cartao cartaoPagamento) {
        this.cartaoPagamento = cartaoPagamento;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setNumeroTelefone(String numeroTelefone) {
        this.numeroTelefone = numeroTelefone;
    }
public int getQuantidadeDiasAluguel() {
    return carroAluguel.getQuantidadeDiasAluguel();
}
  
}
