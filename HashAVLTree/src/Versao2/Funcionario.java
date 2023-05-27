package Versao2;

import java.util.List;

public class Funcionario<List2> {
    public int ID;
    public List2 nome;

    public Funcionario(int ID, List2 nome) {
        this.ID = ID;
        this.nome = nome;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public List2 getNome() {
        return nome;
    }

    public void setNome(List2 nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "ID=" + ID +
                ", nome=" + nome +
                '}';
    }
}
