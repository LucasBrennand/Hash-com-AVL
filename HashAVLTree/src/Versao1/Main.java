package Versao1;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int op, cont = 0;
        HashTable tab = new HashTable(7);
        do {
            double valor;
            menu();
            op = in.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Elemento " + cont + "");
                    Random random = new Random();
                    int randomNumber = random.nextInt(100);
                    tab.inserir(randomNumber);
                    System.out.println("Valor aleatorio inserido: " + randomNumber);
                    System.out.println("Lista Hash: ");
                    tab.imprime();
                    cont++;
                    break;
                case 2:
                    System.out.println( "Forneca o valor que deseja apagar: ");
                    valor = in.nextDouble();
                    tab.deletar((int) valor);
                    System.out.println("Lista Hash: ");
                    tab.imprime();
                    break;
                case 0:
                    break;
            }
        } while (op != 0);
    }
    private static void menu(){
        System.out.println("\n"+
                "1 - Inserir um novo valor aleatorio \n"+
                "2 - Apagar um valor \n"+
                "0 - Sair");

    }
}