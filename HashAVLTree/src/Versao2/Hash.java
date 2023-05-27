package Versao2;

public class Hash<List> {
    int operador;
    List[] vetor;
    Lista<List>[] lista;
    AVLTree<List>[] avlTree;
    public int tableSize;

    public int funcaoHashing(int chave) {
        return chave % this.tableSize;
    }

    Hash(int operador) {
        this.operador = operador;
        vetor = (List[]) new Object[operador];
        lista = new Lista[operador];
        for (int i = 0; i < operador; i++) {
            lista[i] = new Lista<List>();
        }
        avlTree = new AVLTree[operador];
        for (int i = 0; i < operador; i++) {
            avlTree[i] = new AVLTree<List>();
        }
    }

    Hash(List valor) {
        if (vetor == null) {
            System.out.println("Esse vetor não existe");
            this.operador = 37;
            vetor = (List[]) new Object[this.operador];
            inserirLinear((List) valor);
        }
    }

    public void inserirLinear(List valor) {
        Funcionario funcionario = (Funcionario) valor;
        int chave = funcionario.ID % this.operador;
        if (vetor[chave] != null) {
            int i = chave + 1;
            while (i < vetor.length) {
                if (vetor[i] == null) {
                    vetor[i] = (List) funcionario;
                    return;
                } else {
                    i++;
                }
                inserirValorListaEncadeada(funcionario);
            }
        } else {
            vetor[chave] = (List) funcionario;
        }
    }

    public List buscaLinear(int ID) {
        List perdido;
        Funcionario funcionario;
        int chave = ID % this.operador;
        int i = chave;
        while (i < vetor.length) {
            funcionario = (Funcionario) vetor[i];
            if (funcionario.getID() == ID) {
                perdido = (List) funcionario;
                return perdido;
            } else {
                i++;
            }
        }
        perdido = buscaListaEncadeada(ID);
        if (perdido == null) {
            perdido = buscaAVLTree(ID);
        }
        return perdido;
    }

    public void inserirAVLTree(int ID, List novo) {
        avlTree[ID % operador].inserirNode(ID, novo);
    }
    public List buscaAVLTree(int ID) {
        AVLNode<List> raiz = avlTree[ID % operador].getRaiz();
        return avlTree[ID % operador].buscaAVL(ID, raiz);
    }

    public List buscaListaEncadeada(int ID) {
        return (List) lista[ID % this.operador].buscar(ID);
    }

    public void inserirValorListaEncadeada(Funcionario funcionario) {
        int chave = funcionario.getID() % this.operador;
        lista[chave].inserir((List) funcionario);
    }

    public void inserirValorAVLTree(List valor) {
        AVLTree<List> arvoreAVL = new AVLTree<List>();
        Funcionario funcionario = (Funcionario) valor;
        arvoreAVL.inserirNode(funcionario.getID(), valor);
    }
   public int getID(Funcionario funcionario){
        return funcionario.getID();
}
    public void print(){
        System.out.println(this.vetor);
    }
    public void buscarTodos(){
        System.out.println((vetor[operador]));
    }
}