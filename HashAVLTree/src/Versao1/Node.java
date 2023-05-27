package Versao1;

public class Node {
    public int info;
    public Node prox;

    public Node(int valor) {
        this.info = valor;
    }

    public void mostra() {
        System.out.println(info);
    }
}
