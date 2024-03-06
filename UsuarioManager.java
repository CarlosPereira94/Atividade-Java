import java.util.ArrayList;
import java.util.List;

// Classe responsável pela gestão dos usuários
public class UsuarioManager {
    private List<Usuario> usuarios = new ArrayList<>();

    // Método para cadastrar um usuário
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    // Método para listar os usuários
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
}
