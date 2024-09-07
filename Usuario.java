package vendaingressos;

import java.util.List;
import java.util.ArrayList;

public class Usuario {
    private String username;
    private String password;
    private String fullName;
    private String cpf;
    private String email;
    private boolean isAdmin;
    private List<Ingresso> Ingressos;
    


    public Usuario(String username, String password, String fullName, String cpf, String email, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.fullName = fullName;
        this.cpf = cpf;
        this.email = email;
        this.isAdmin = isAdmin;
        this.Ingressos = new ArrayList<>();
    }

   
    public String getLogin() {
        return username;
    }

    public String getNome() {
        return fullName;
    }

    public String getSenha() {
        return password;
    }

    public String getCpf() {
        return cpf;
    }

    public String getEmail() {
        return email;
    }
    public boolean isAdmin() {
        return isAdmin;
    }

    public void setLogin(String username) {
        this.username = username;
    }

    public void setSenha(String password) {
        this.password = password;
    }

    public void setNome(String fullName) {
        this.fullName = fullName;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public boolean login(String username, String password){
        if (this.username == username && this.password == password)
        {return true;}
        
        else { return false;}
    }

    public void adicionarIngresso(Ingresso ingresso) {
        this.Ingressos.add(ingresso);
    }

    public List<Ingresso> getIngressos(){
        return this.Ingressos;
    }

    public boolean removeIngresso(Ingresso ingresso){
        if(ingresso.cancelar()){
            this.Ingressos.remove(ingresso);
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
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
        Usuario other = (Usuario) obj;
        if (cpf == null) {
            if (other.cpf != null)
                return false;
        } else if (!cpf.equals(other.cpf))
            return false;
        return true;
    }

    
}