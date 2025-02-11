package StackLab;

import java.util.Scanner;

public class Stack01 {
    private int[] pilha;
    private int topo;
    private int tamanhoMaximo;

    public Stack01(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.pilha = new int[tamanhoMaximo];
        this.topo = -1;
    }

    public boolean empty() {
        return topo == -1;
    }

    public boolean full() {
        return topo == tamanhoMaximo - 1;
    }

    public void push(int valor) {
        if (full()) {
            System.out.println("Erro: Pilha cheia!");
        } else {
            pilha[++topo] = valor;
        }
    }

    public int pop() {
        if (empty()) {
            System.out.println("Erro: Pilha vazia!");
            return -1; // Valor inválido para indicar erro
        } else {
            return pilha[topo--];
        }
    }

    public int quantElementos() {
        return topo + 1;
    }

    public int posicaoTopo() {
        return topo;
    }

    public int localizarElemento(int valor) {
        for (int i = 0; i <= topo; i++) {
            if (pilha[i] == valor) {
                return i;
            }
        }
        return -1;
    }

    public void print() {
        if (empty()) {
            System.out.println("Pilha vazia.");
        } else {
            System.out.print("Conteúdo da pilha: ");
            for (int i = 0; i <= topo; i++) {
                System.out.print(pilha[i] + " ");
            }
            System.out.println();
        }
    }

    public static String msg() {
        return "0 - Encerrar\n" +
                "1 - Informar a quantidade de elementos da pilha\n" +
                "2 - Informar a posição do topo\n" +
                "3 - Localizar um elemento e retornar sua posição\n" +
                "4 - Adicionar elemento à pilha\n" +
                "5 - Remover elemento da pilha\n" +
                "6 - Imprimir pilha\n";
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int opcao;
        Stack01 pilha = null;

        do {
            System.out.println(msg());
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    if (pilha == null) {
                        System.out.println("Pilha não inicializada. Crie uma pilha primeiro.");
                    } else {
                        System.out.println("Quantidade de elementos na pilha: " + pilha.quantElementos());
                    }
                    break;
                case 2:
                    if (pilha == null) {
                        System.out.println("Pilha não inicializada. Crie uma pilha primeiro.");
                    } else {
                        System.out.println("Posição do topo: " + pilha.posicaoTopo());
                    }
                    break;
                case 3:
                    if (pilha == null) {
                        System.out.println("Pilha não inicializada. Crie uma pilha primeiro.");
                    } else {
                        System.out.print("Digite o elemento a ser localizado: ");
                        int elemento = input.nextInt();
                        int posicao = pilha.localizarElemento(elemento);
                        if (posicao != -1) {
                            System.out.println("Elemento encontrado na posição: " + posicao);
                        } else {
                            System.out.println("Elemento não encontrado.");
                        }
                    }
                    break;
                case 4:
                    if (pilha == null) {
                        System.out.print("Digite o tamanho da pilha: ");
                        int tamanho = input.nextInt();
                        pilha = new Stack01(tamanho);
                    }
                    System.out.print("Digite o valor a ser adicionado: ");
                    int valor = input.nextInt();
                    pilha.push(valor);
                    break;
                case 5:
                    if (pilha == null) {
                        System.out.println("Pilha não inicializada. Crie uma pilha primeiro.");
                    } else {
                        int removido = pilha.pop();
                        if (removido != -1) {
                            System.out.println("Elemento removido: " + removido);
                        }
                    }
                    break;
                case 6:
                    if (pilha == null) {
                        System.out.println("Pilha não inicializada. Crie uma pilha primeiro.");
                    } else {
                        pilha.print();
                    }
                    break;
                case 0:
                    System.out.println("Encerrando o programa...");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }

        } while (opcao != 0);

        input.close();
    }
}