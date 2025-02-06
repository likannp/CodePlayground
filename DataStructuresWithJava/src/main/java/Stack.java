import java.util.Scanner;

public class Stack {
    private static int[] pilha;
    private static int topo;
    private static int tamanhoMaximo;

    public Stack(int tamanhoMaximo) {
        this.pilha = new int[tamanhoMaximo];
        this.topo = -1;
        this.tamanhoMaximo = tamanhoMaximo;
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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Tamanho da pilha: ");
        int tamanho = input.nextInt();
        Stack pilha = new Stack(tamanho);
    }

}

