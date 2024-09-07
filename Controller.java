package vendaingressos;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;


public class Controller {
    private List<Evento> listaEventos = new ArrayList<>();
    
    public Usuario cadastrarUsuario(String username, String senha, String nome, String cpf, String email, boolean ativo) {
        return new Usuario(username, senha, nome, cpf, email, ativo);
    }

    public Evento cadastrarEvento(Usuario admin, String nome, String descricao, Date data) throws SecurityException{ 
        if(admin.isAdmin()){
        Evento evento = new Evento(nome, descricao, data);
        this.listaEventos.add(evento);
        return evento;
    }else{
        throw new SecurityException("Somente administradores podem cadastrar eventos.");
    }
    }

    public Evento procuraEvento(String nomeEvento) {
        for (Evento evento : listaEventos) {
            if (evento.getNome().equals(nomeEvento)) {
                return evento;
            }
        }
        System.out.println("Evento Não encontrado!");
        return null; 
    }

    public void adicionarAssentoEvento(String nomeEvento, String assento){
        Evento evento = this.procuraEvento(nomeEvento);
        evento.adicionarAssento(assento);
    }

    public Ingresso comprarIngresso(Usuario usuario, String evento, String assento){
        Evento EventoAtual = this.procuraEvento(evento);
        Ingresso ingresso =  new Ingresso(EventoAtual, assento);
        usuario.adicionarIngresso(ingresso);

        return ingresso;
    }

    public boolean cancelarCompra(Usuario usuario, Ingresso ingresso) {
       return usuario.removeIngresso(ingresso);
    }

    public List<Ingresso> listarIngressosComprados(Usuario usuario){
        return usuario.getIngressos();
    }

    public List<Evento> listarEventosDisponiveis(){
        return listaEventos;
    }
} 