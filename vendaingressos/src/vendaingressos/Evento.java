package vendaingressos;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;


public class Evento {
    private String Nome;
    private String Descricao;
    private Date Data;
    private List<String> Assento;

    public Evento (String Nome,String Descricao, Date Data){
        this.Nome = Nome;
        this.Descricao = Descricao;
        this.Data = Data;
        this.Assento = new ArrayList<>();
    }
    
    public String getNome(){
        return Nome;
    }

    public String getDescricao(){
        return Descricao;
    }

    public Date getData(){
        return Data;
    }

    public void adicionarAssento(String assento) {
        this.Assento.add(assento);
    }

    public List<String> getAssentosDisponiveis(){
        return Assento;
    }

    public void removerAssento(String assento){
        for (String assentos : Assento){
            if (assento == assentos){
                this.Assento.remove(assento); 
                return;
            }
        }
    }

    public boolean isAtivo(){
    Calendar calendario = Calendar.getInstance();
    calendario.set(2024, Calendar.AUGUST, 10);
    Date dataSet = calendario.getTime();
    
    return (this.Data.after(dataSet));
}
}