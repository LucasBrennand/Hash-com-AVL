package Versao2;

import java.util.List;

public class AVLNode<List> {
    private AVLNode<List> esquerda;
    private AVLNode<List> direita;
    private AVLNode<List> pai;
    private int chave;
    private int h;
    private List elemento;

    AVLNode(int chave, List elemento){
        this.chave = chave;
        this.elemento = elemento;
        this.esquerda = null;
        this.direita = null;
    }
    AVLNode(int chave, List elemento, AVLNode esquerda, AVLNode direita){
        this.elemento = elemento;
        this.esquerda = esquerda;
        this.direita = direita;
        this.h = 0;
        this.chave = chave;
    }

    public AVLNode<List> getEsquerda() {
        return esquerda;
    }

    public void setEsquerda(AVLNode<List> esquerda) {
        this.esquerda = esquerda;
    }

    public AVLNode<List> getDireita() {
        return direita;
    }

    public void setDireita(AVLNode<List> direita) {
        this.direita = direita;
    }

    public AVLNode<List> getPai() {
        return pai;
    }

    public void setPai(AVLNode<List> pai) {
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

    public List getElemento() {
        return elemento;
    }

    public void setElemento(List elemento) {
        this.elemento = elemento;
    }

    @Override
    public String toString() {
        return "AVLNode{" +
                "elemento=" + elemento +
                '}';
    }
}
