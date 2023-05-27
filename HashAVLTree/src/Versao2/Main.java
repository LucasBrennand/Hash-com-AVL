package Versao2;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Funcionario<String> funcionario = new Funcionario<>(1234, "Lucas");
        Hash hash = new Hash<>(5);

        System.out.println("Insersao Linear:\n");
        hash.inserirLinear(funcionario);
        hash.inserirAVLTree(funcionario.getID(), funcionario);

        System.out.println(hash);
        System.out.println();
        System.out.println(hash.buscaLinear(48));
        System.out.println(hash.buscaAVLTree(funcionario.getID()));
    }

    private static Funcionario<String> criaFuncionario() {
        Scanner in = new Scanner(System.in);
        System.out.println("Digite o nome do Funcionario:");
        String nome = in.next();

        System.out.println("Digite o ID do Funcionario:");
        int ID = in.nextInt();

        Funcionario<String> novoFuncionario = new Funcionario(ID, nome);

        return novoFuncionario;
    }
}

