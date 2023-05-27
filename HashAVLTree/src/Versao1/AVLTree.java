package Versao1;

public class AVLTree {
    private AVLNode raiz;

    public void inserirNode(int chave, int valor) {
        AVLNode avlNode = new AVLNode(chave, valor);
        inserirAVL(this.raiz, avlNode);
    }

    private void inserirAVL(AVLNode comparar, AVLNode inserir) {
        if (comparar == null) {
            this.raiz = inserir;
        }
        else{
            if (inserir.getChave() < comparar.getChave()) {
                if (comparar.getEsquerda() == null) {
                    comparar.setEsquerda(inserir);
                    inserir.setPai(comparar);
                    verificarBalanceamento(comparar);
                }
                else {
                    inserirAVL(comparar.getEsquerda(), inserir);
                }
            }
            else if (inserir.getChave() > comparar.getChave()) {
                if (comparar.getDireita() == null) {
                    comparar.setDireita(inserir);
                    inserir.setPai(comparar);
                    verificarBalanceamento(comparar);
                } else {
                    inserirAVL(comparar.getDireita(), inserir);
                }

            } else {
                System.out.println("Esse node já existe");
            }
        }
    }

    public int buscaAVL(int ID, AVLNode comparar){
        if (ID == comparar.getChave()){
            return comparar.getElemento();
        }
        else if(ID < comparar.getChave() ){
            buscaAVL(ID, comparar.getEsquerda());
        }
        else if (ID > comparar.getChave() ){
            buscaAVL(ID, comparar.getDireita());
        }
        return ID;
    }
    private AVLNode rotacaoEsquerda(AVLNode inicio) {
        AVLNode direita = inicio.getDireita();
        direita.setPai(inicio.getPai());
        inicio.setDireita(direita.getEsquerda());
        if (inicio.getDireita() != null) {
            inicio.getDireita().setPai(inicio);
        }
        direita.setEsquerda(inicio);
        inicio.setPai(direita);
        if (direita.getPai() != null) {
            if (direita.getPai().getDireita() == inicio) {
                direita.getPai().setDireita(direita);
            } else if (direita.getPai().getEsquerda() == inicio) {
                direita.getPai().setEsquerda(direita);
            }
        }
        setBalanceamento(inicio);
        setBalanceamento(direita);
        return direita;
    }

    private AVLNode rotacaoDireita(AVLNode inicio) {
        AVLNode esquerda = inicio.getEsquerda();
        esquerda.setPai(inicio.getPai());
        inicio.setEsquerda(esquerda.getDireita());
        if (inicio.getEsquerda() != null) {
            inicio.getEsquerda().setPai(inicio);
        }
        esquerda.setDireita(inicio);
        inicio.setPai(esquerda);
        if (esquerda.getPai() != null) {
            if (esquerda.getPai().getDireita() == inicio) {
                esquerda.getPai().setDireita(esquerda);

            }
            else if (esquerda.getPai().getEsquerda() == inicio) {
                esquerda.getPai().setEsquerda(esquerda);
            }
        }
        setBalanceamento(inicio);
        setBalanceamento(esquerda);
        return esquerda;
    }

    private AVLNode duplaRotacaoEsquerdaDireita(AVLNode inicio) {
        inicio.setEsquerda(rotacaoEsquerda(inicio.getEsquerda()));
        return rotacaoDireita(inicio);
    }

    private AVLNode duplaRotacaoDireitaEsquerda(AVLNode inicio) {
        inicio.setDireita(rotacaoDireita(inicio.getDireita()));
        return rotacaoEsquerda(inicio);
    }

    private int altura(AVLNode atual) {
        if (atual == null) {
            return -1;
        }
        if (atual.getEsquerda() == null && atual.getDireita() == null) {
            return 0;
        }
        else if (atual.getEsquerda() == null) {
            return 1 + altura(atual.getDireita());
        }
        else if (atual.getDireita() == null) {
            return 1 + altura(atual.getEsquerda());
        } else {
            return 1 + Math.max(altura(atual.getEsquerda()), altura(atual.getDireita()));
        }
    }
    private void setBalanceamento(AVLNode node) {
        node.setH(altura(node.getEsquerda()) - altura(node.getDireita()));
    }
    private void verificarBalanceamento(AVLNode atual) {
        setBalanceamento(atual);
        int balanceamento = atual.getH();
        if (balanceamento == -2) {
            if (altura(atual.getEsquerda().getEsquerda()) >= altura(atual.getEsquerda().getDireita())) {
                atual = rotacaoDireita(atual);
            }
            else {
                atual = duplaRotacaoEsquerdaDireita(atual);
            }
        }
        else if (balanceamento == 2) {
            if (altura(atual.getDireita().getDireita()) >= altura(atual.getDireita().getEsquerda())) {
                atual = rotacaoEsquerda(atual);
            }
            else {
                atual = duplaRotacaoDireitaEsquerda(atual);
            }
        }
        if (atual.getPai() != null) {
            verificarBalanceamento(atual.getPai());
        }
        else {
            this.raiz = atual;
        }
    }
    public String prefixado(AVLNode node) {
        String out = "";
        if(node != null){
            out += node.getElemento();
            if(node.getEsquerda() != null) out+=" Esquerda é " + node.getEsquerda().getElemento();
            if(node.getDireita() != null) out+=" Direita é " + node.getDireita().getElemento();
            out += "\n";
            out += prefixado(node.getEsquerda());
            out += prefixado(node.getDireita());
        }
        return out;
    }
    public AVLNode getRaiz(){
        return this.raiz;
    }

    public String toString() {
        String out = "Raiz: ";
        AVLNode no = raiz;
        out += prefixado(no);
        return out;
    }

}
