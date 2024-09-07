package vendaingressos;

public class Ingresso {
    private Evento Evento; 
    private double Preco;
    private String Assento;
    private boolean Status;

    public Ingresso (Evento Evento, String Assento){
        this.Evento = Evento;
        this.Preco = 0.0;
        this.Assento = Assento;
        this.Status = true;
    }

    public Ingresso (Evento Evento, double Preco, String Assento){
        this.Evento = Evento;
        this.Preco = Preco;
        this.Assento = Assento;
        this.Status = true;
    }

    public Evento getEvento(){
        return  Evento;
    }
    
    public double getPreco(){
        return  Preco;
    }
    
    public String getAssento(){
        return  Assento;
    }

    public boolean isAtivo(){
        return Status;
    }

    public boolean cancelar(){
        if(Evento.isAtivo()){
            this.Status = false;
            return true;
        }else{
            return false;
        }
    
    }

    public boolean reativar(){
        this.Status = true;
        return Status;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((Evento == null) ? 0 : Evento.hashCode());
        long temp;
        temp = Double.doubleToLongBits(Preco);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((Assento == null) ? 0 : Assento.hashCode());
        result = prime * result + (Status ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Ingresso other = (Ingresso) obj;
        if (Evento == null) {
            if (other.Evento != null)
                return false;
        } else if (!Evento.equals(other.Evento))
            return false;
        if (Double.doubleToLongBits(Preco) != Double.doubleToLongBits(other.Preco))
            return false;
        if (Assento == null) {
            if (other.Assento != null)
                return false;
        } else if (!Assento.equals(other.Assento))
            return false;
        if (Status != other.Status)
            return false;
        return true;
    }


}