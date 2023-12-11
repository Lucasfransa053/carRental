
class Cartao {
    private String nomeNoCartao;
    private String numeroDoCartao;
    private String senha;
    private String codigoSeguranca;

    // Construtor
    public Cartao(String nomeNoCartao, String numeroDoCartao, String senha, String codigoSeguranca) {
        this.nomeNoCartao = nomeNoCartao;
        this.numeroDoCartao = numeroDoCartao;
        this.senha = senha;
        this.codigoSeguranca = codigoSeguranca;
    }

    // Getters e setters
    // ...

    @Override
    public String toString() {
        return "Nome no Cartão: " + nomeNoCartao + "\n" +
                "Número do Cartão: " + numeroDoCartao + "\n" +
                "Senha: " + senha + "\n" +
                "Código de Segurança: " + codigoSeguranca;
    }
}