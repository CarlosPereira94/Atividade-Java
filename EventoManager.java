import java.io.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Classe responsável pela gestão dos eventos
public class EventoManager {
    private List<Evento> eventos = new ArrayList<>();

    // Método para cadastrar um evento
    public void cadastrarEvento(Evento evento) {
        eventos.add(evento);
    }

    // Método para listar os eventos
    public List<Evento> listarEventos() {
        return eventos;
    }

    // Método para ordenar eventos por horário
    public void ordenarEventos() {
        eventos.sort((e1, e2) -> e1.getHorario().compareTo(e2.getHorario()));
    }

    // Método para salvar eventos no arquivo
    public void salvarEventos() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("events.data"))) {
            for (Evento evento : eventos) {
                bw.write(evento.getNome() + ";" + evento.getEndereco() + ";" + evento.getCategoria() + ";" +
                        evento.getHorario() + ";" + evento.getDescricao());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Erro ao salvar eventos: " + e.getMessage());
        }
    }

    // Método para carregar eventos do arquivo
    public void carregarEventos() {
        try (BufferedReader br = new BufferedReader(new FileReader("events.data"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                String nome = parts[0];
                String endereco = parts[1];
                String categoria = parts[2];
                LocalDateTime horario = LocalDateTime.parse(parts[3]);
                String descricao = parts[4];
                eventos.add(new Evento(nome, endereco, categoria, horario, descricao));
            }
        } catch (IOException e) {
            System.out.println("Erro ao carregar eventos: " + e.getMessage());
        }
    }
}
