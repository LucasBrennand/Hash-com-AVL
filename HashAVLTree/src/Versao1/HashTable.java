package Versao1;

public class HashTable {
    private Lista[] tab;
    private int tableSize;
    AVLTree[] avlTree;

    public HashTable(int tam) {
        tab = new Lista[tam];
        tableSize = tam;
        for(int i=0; i<tam; i++) {
            tab[i] = null;
        }
        avlTree = new AVLTree[tam];
        for (int i = 0; i < tam; i++) {
            avlTree[i] = new AVLTree();
        }
    }

    private int funcaohashing(double chave) {
        return (int) chave % tableSize;
    }
    public void inserir(double valor) {
        int pos = funcaohashing(valor);
        if (tab[pos] != null) {
            if (tab[pos].buscarLista((int) valor)) {
                System.out.println(" Esse valor já foi cadastrado");
                return;
            }
        }
        else {
            tab[pos] = new Lista();
        }
        tab[pos].inserir((int) valor);
    }
    public void deletar(int chave) {
        int pos = buscar(chave);
        if (pos != -1) {
            tab[pos].deletarLista(chave);
        }
        else System.out.println("Valor nao encontrado");
    }

    public void imprime() {
        for (int i = 0; i<tableSize; i++) {
            System.out.print("HASH[" + i + "] -> ");
            if (tab[i] != null){
                tab[i].imprimeLista();
            }
            else {
                System.out.println("Vazio");
            }
        }
    }

    public int buscar(int chave) {
        for (int i=0; i<tableSize; i++) {
            if (tab[i] != null)
                if (tab[i].buscarLista(chave)) {
                    return i;
                }
        }
        return -1;
    }

    public int buscaAVLTree(int ID) {
        AVLNode raiz = avlTree[ID % tableSize].getRaiz();
        return avlTree[ID % this.tableSize].buscaAVL(ID, raiz);
    }

}
