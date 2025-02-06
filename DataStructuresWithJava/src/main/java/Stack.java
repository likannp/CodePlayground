import java.util.Scanner;

public class Stack {
    private int[] pilha;
    private int topo;
    private int tamanhoMaximo;

    public Stack(int tamanhoMaximo) {
        this.tamanhoMaximo = tamanhoMaximo;
        this.pilha = new int[tamanhoMaximo];
        this.topo = -1;
    }

    public boolean full() {
        return topo == tamanhoMaximo - 1;
    }

    public boolean empty() {
        return topo == -1;
    }

    public boolean push(int valor) {
        if (!full()) {
            topo++;
            pilha[topo] = valor;
            return true;
        } else {
            System.out.println("Pilha cheia! Não é possível adicionar mais elementos.");
            return false;
        }
    }

    public int pop() {
        if (!empty()) {
            int valor = pilha[topo];
            topo--;
            return valor;
        } else {
            System.out.println("Pilha vazia! Não é possível remover elementos.");
            return -1; // Retorno indicando falha
        }
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
                "1 - Inserir um elemento\n" +
                "2 - Extrair um elemento\n" +
                "3 - Imprimir a pilha\n";
    }

    // Método main para testar a classe
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Tamanho da pilha: ");
        int tamanho = input.nextInt();
        Stack pilha = new Stack(tamanho);

        int opcao;
        do {
            System.out.println(msg());
            System.out.print("Escolha uma opção: ");
            opcao = input.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a ser inserido: ");
                    int valor = input.nextInt();
                    pilha.push(valor);
                    break;

                case 2:
                    int elementoRemovido = pilha.pop();
                    if (elementoRemovido != -1) {
                        System.out.println("Elemento removido: " + elementoRemovido);
                    }
                    break;

                case 3:
                    pilha.print();
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