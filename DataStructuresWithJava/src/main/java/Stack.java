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

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Tamanho da pilha: ");
        int tamanho = input.nextInt();
        Stack pilha = new Stack(tamanho);
    }

}