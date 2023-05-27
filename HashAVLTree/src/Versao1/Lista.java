package Versao1;

public class Lista {
    private Node primeiro;
    private int qtd;

    public Lista(){
        primeiro = null;
    }

    public boolean empty (){
        return primeiro == null;
    }

    public void inserir(int info) {
        Node node = new Node(info);
        if(empty() == true){
            node.prox = null;
            primeiro = node;
        }
        Node atual = primeiro;
        while (atual.prox != null){
            atual = atual.prox;
            atual.prox = node;
            node.prox = null;
        }
    }

    public void imprimeLista() {
        Node atual = primeiro;
        while (atual != null) {
            atual.mostra();
            atual = atual.prox;
        }
    }

    public boolean buscarLista(int chave) {
        Node atual = primeiro;
        while (atual!=null) {
            if(atual.info == chave){
                return true;
            }
            atual = atual.prox;
        }
        return false;
    }

    public void deletarLista(double valor) {
        if (!buscarLista((int) valor)) {
            System.out.println("Valor não encontrado");
            return;
        }
        Node atual, anterior;
        atual = anterior = primeiro;
        while (atual!=null) {
            if(atual.info == valor){
                break;
            }
            anterior = atual;
            atual = atual.prox;
        }
        if (atual == primeiro){
            primeiro = primeiro.prox;
        }
        else{
            anterior.prox = atual.prox;
        }
    }

}