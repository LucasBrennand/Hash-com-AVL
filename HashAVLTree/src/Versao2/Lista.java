package Versao2;

public class Lista<List> {
    public Node primeiro;
    private int qtd;

    public void inserir(List info) {
        Node node = new Node();
        node.info = info;
        node.prox = primeiro;
        primeiro = node;
        qtd++;
    }

    public Funcionario buscar(int ID) {
        Node<Funcionario> node = primeiro;
        while (node != null) {
            if (node.info.getID() == ID) {
                return node.info;
            }
            else {
                node = node.prox;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Lista{" +
                "primeiro=" + primeiro +
                ", tamanho=" + qtd +
                '}';
    }
}
