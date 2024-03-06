import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Opencar {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Usuario> usuarios = new ArrayList<>();
    private static ArrayList<Carro> carrosDisponiveis = new ArrayList<>();
    private static ArrayList<Reserva> reservas = new ArrayList<>();
    private static final Map<String, Double> TABELA_PRECOS = new HashMap<>();
static {
    TABELA_PRECOS.put("Fiat Uno", 70.0); 
    TABELA_PRECOS.put("Volkswagen Gol", 70.0); 
    TABELA_PRECOS.put("Ford Fiesta", 70.0);
    TABELA_PRECOS.put("Chevrolet Onix", 150.0); 
    TABELA_PRECOS.put("Toyota Corolla", 300.0); 
    TABELA_PRECOS.put("Honda Civic", 250.0);
    TABELA_PRECOS.put("Hyundai HB20", 150.0);
} 

    public static void main(String[] args) {
        inicializarCarrosDisponiveis();

        System.out.println("Bem-vindo ao sistema de aluguel de carros!");

        int opcao;
        do {
            exibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer do scanner

            switch (opcao) {
                case 1:
                    cadastrarUsuario();
                    break;
                case 2:
                    escolherCarroEfazerReserva();
                    break;
                case 3:
                    exibirClientesCadastrados();
                    break;
                case 4:
                    exibirReservas();
                    break;
                case 5:
                    System.out.println("Saindo do programa...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 5);

        scanner.close();
    }

    private static void inicializarCarrosDisponiveis() {
        carrosDisponiveis.add(new Carro("Fiat Uno", 0));
        carrosDisponiveis.add(new Carro("Volkswagen Gol", 0));
        carrosDisponiveis.add(new Carro("Ford Fiesta", 0));
        carrosDisponiveis.add(new Carro("Chevrolet Onix", 0));
        carrosDisponiveis.add(new Carro("Toyota Corolla", 0));
    carrosDisponiveis.add(new Carro("Honda Civic", 0));
    carrosDisponiveis.add(new Carro("Hyundai HB20", 0));
    }

    private static void exibirMenu() {
        System.out.println("\nMenu:");
        System.out.println("1 - Cadastrar usuário");
        System.out.println("2 - Escolher carro");
        System.out.println("3 - Exibir clientes cadastrados");
        System.out.println("4 - Exibir reservas");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opção: ");
    }
    private static void cadastrarUsuario() {
        
        System.out.print("Digite o nome do usuário: ");
        String nome = scanner.nextLine();
    
        System.out.print("Digite o endereço do usuário: ");
        String endereco = scanner.nextLine();
    
        System.out.print("Digite o número de telefone do usuário: ");
        String numeroTelefone = scanner.nextLine();
    
        // Coleta informações do cartão de pagamento
        System.out.print("Digite o nome no cartão: ");
        String nomeNoCartao = scanner.nextLine();
    
        System.out.print("Digite o número do cartão: ");
        String numeroDoCartao = scanner.nextLine();
    
        System.out.print("Digite a senha do cartão: ");
        String senha = scanner.nextLine();
    
        System.out.print("Digite o código de segurança do cartão: ");
        String codigoSeguranca = scanner.nextLine();
    
        // Criando o objeto Cartao com as informações coletadas
        Cartao cartaoPagamento = new Cartao(nomeNoCartao, numeroDoCartao, senha, codigoSeguranca);
    
        // Criando o objeto Usuario com as informações coletadas
        Usuario novoUsuario = new Usuario(nome, endereco, numeroTelefone, cartaoPagamento, null);
    
        // Adicionando o novo usuário à lista de usuários
        usuarios.add(novoUsuario);
    
        System.out.println("Usuário cadastrado com sucesso!");
    }

    private static void escolherCarroEfazerReserva() {
            
        System.out.print("Digite o nome do usuário: ");
        String nomeUsuario = scanner.nextLine();
    
        Usuario usuarioEncontrado = null;
        for (Usuario u : usuarios) {
            if (u.getNome().equalsIgnoreCase(nomeUsuario)) {
                usuarioEncontrado = u;
                break;
            }
        }
    
        if (usuarioEncontrado == null) {
            System.out.println("Usuário não encontrado. Por favor, cadastre o usuário primeiro.");
            return;
        }
    
        System.out.print("Digite a quantidade de dias para o aluguel: ");
        int quantidadeDias = scanner.nextInt();
        scanner.nextLine(); // Limpar o buffer do scanner
    
        if (quantidadeDias < 1) {
            System.out.println("A quantidade de dias deve ser pelo menos 1.");
            return;
        }
    
        System.out.println("\nCarros disponíveis:");
        for (int i = 0; i < carrosDisponiveis.size(); i++) {
            System.out.println((i + 1) + " - " + carrosDisponiveis.get(i).getModelo());
        }
    
        System.out.print("Escolha o número do carro desejado: ");
int numeroCarro = scanner.nextInt();
scanner.nextLine(); // Limpar o buffer do scanner

if (numeroCarro >= 1 && numeroCarro <= carrosDisponiveis.size()) {
    Carro carroEscolhido = carrosDisponiveis.get(numeroCarro - 1);

    // Verificar se o carro escolhido é válido
    String modeloCarroEscolhido = carroEscolhido.getModelo();
    if (TABELA_PRECOS.containsKey(modeloCarroEscolhido)) {
        double precoDiario = calcularPrecoDiario(modeloCarroEscolhido);
        double valorTotal = precoDiario * quantidadeDias;
        System.out.println("Valor total da reserva: R$" + valorTotal);

        Reserva novaReserva = new Reserva(usuarioEncontrado, carroEscolhido, quantidadeDias, valorTotal);
        reservas.add(novaReserva);
    } else {
        // Carro escolhido inválido
        System.out.println("Carro escolhido inválido!");
        return;
    }

    System.out.println("Reserva feita com sucesso para " + usuarioEncontrado.getNome() + " do carro " + carroEscolhido.getModelo() + " por " + quantidadeDias + " dias.");
   

} else {
    System.out.println("Opção inválida!");
}
        
    }

    

    private static void exibirClientesCadastrados() {
        if (usuarios.isEmpty()) {
            System.out.println("Não há clientes cadastrados.");
        } else {
            System.out.println("Clientes cadastrados:");
            for (Usuario u : usuarios) {
                System.out.println(u.getNome());
            }
        }
    }

    private static void exibirReservas() {
        if (reservas.isEmpty()) {
            System.out.println("Não há reservas feitas ainda.");
        } else {

            System.out.println("Reservas:");
            for (Reserva r : reservas) {
                System.out.println("Cliente: " + r.getUsuario().getNome() + " | Carro: " + r.getCarro().getModelo() + " | Dias: " + r.getQuantidadeDias() + " | Valor Total: R$" + r.getValorTotal());
            }
        }
    }
    
    public static double calcularPrecoDiario(String modeloCarro) {
        if (TABELA_PRECOS.containsKey(modeloCarro)) {
            return TABELA_PRECOS.get(modeloCarro);
        } else {
            throw new IllegalArgumentException("Modelo de carro inválido: " + modeloCarro);
        }
    }
}
