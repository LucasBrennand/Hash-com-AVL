package Versao1;

public class AVLNode {
    private AVLNode esquerda;
    private AVLNode direita;
    private AVLNode pai;
    private int chave;
    private int h;
    private int elemento;

    AVLNode(int chave, int elemento){
        this.chave = chave;
        this.elemento = elemento;
        this.h = 1;
        this.esquerda = null;
        this.direita = null;
    }
    AVLNode(int chave, int elemento, AVLNode esquerda, AVLNode direita){
        this.elemento = elemento;
        this.esquerda = esquerda;
        this.direita = direita;
        this.h = 0;
        this.chave = chave;
    }

    public AVLNode getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(AVLNode esquerda) {
        this.esquerda = esquerda;
    }

    public AVLNode getDireita() {
        return direita;
    }

    public void setDireita(AVLNode direita) {
        this.direita = direita;
    }

    public AVLNode getPai() {
        return pai;
    }

    public void setPai(AVLNode pai) {
        this.pai = pai;
    }

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "elemento=" + elemento +
                '}';
    }
}
