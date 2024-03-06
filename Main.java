import java.time.LocalDateTime;
import java.util.Scanner;

// Classe principal do programa
public class Main {
    public static void main(String[] args) {
        EventoManager eventoManager = new EventoManager();
        UsuarioManager usuarioManager = new UsuarioManager();
        eventoManager.carregarEventos();

        Scanner scanner = new Scanner(System.in);
        int opcao;
        do {
            System.out.println("1. Cadastrar Evento");
            System.out.println("2. Listar Eventos");
            System.out.println("3. Sair");
            System.out.println("Escolha uma opção:");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarEvento(scanner, eventoManager);
                    break;
                case 2:
                    listarEventos(eventoManager);
                    break;
                case 3:
                    eventoManager.salvarEventos();
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao != 3);
    }

    private static void cadastrarEvento(Scanner scanner, EventoManager eventoManager) {
        scanner.nextLine(); // Consumir a quebra de linha pendente
        System.out.println("Nome do evento:");
        String nome = scanner.nextLine();
        System.out.println("Endereço do evento:");
        String endereco = scanner.nextLine();
        System.out.println("Categoria do evento:");
        String categoria = scanner.nextLine();
        System.out.println("Horário do evento (yyyy-MM-dd HH:mm):");
        String horarioString = scanner.nextLine();
        LocalDateTime horario = LocalDateTime.parse(horarioString);
        System.out.println("Descrição do evento:");
        String descricao = scanner.nextLine();

        Evento evento = new Evento(nome, endereco, categoria, horario, descricao);
        eventoManager.cadastrarEvento(evento);
        System.out.println("Evento cadastrado com sucesso!");
    }

    private static void listarEventos(EventoManager eventoManager) {
        eventoManager.ordenarEventos();
        for (Evento evento : eventoManager.listarEventos()) {
            System.out.println("Nome: " + evento.getNome());
            System.out.println("Endereço: " + evento.getEndereco());
            System.out.println("Categoria: " + evento.getCategoria());
            System.out.println("Horário: " + evento.getHorario());
            System.out.println("Descrição: " + evento.getDescricao());
            System.out.println();
        }
    }
}
