import java.util.Scanner;

public class Vetor_Aula02 {
    static int tamanho, minimo, maximo, vaga, repete, opcao;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.print("Tamanho do vetor:  ");
            tamanho = input.nextInt();
            if (tamanho <= 0) {
                System.out.println("ERRO: Vetor deve ter tamanho maior que zero.");
                continue;
            }
            System.out.println("Qual é o tamanho do mínimo:  ");
            minimo = input.nextInt();
            System.out.println("Qual é o tamanho do máximo? ");
            maximo = input.nextInt();
            System.out.println(msg());
            int opc = input.nextInt();

            if (opc == 0) {
                System.out.println("Encerrando o programa...");
                break;
            }
        }

        input.close();
    }

    public static String msg() {
        return "----------------------\n" +
                "Escolha uma opção:\n" +
                "0. Encerrar\n" +
                "1. Atribuir um valor a determinada posição.\n" +
                "2. Alterar o valor de determinada posição.\n" +
                "3. Remover o valor de determinada posição (atribui o valor indicativo de posição vaga).\n" +
                "4. Ler o conteúdo de uma posição.\n" +
                "5. Localizar um valor e retornar sua posição (se permitir repetição tem que retornar todos).\n" +
                "6. Inserir na primeira posição vaga (busca no sentido 0 → N).\n" +
                "7. Remover da última posição ocupada (busca no sentido 0 → N).\n" +
                "8. Imprimir o conteúdo do vetor.\n" +
                "----------------------";
    }
}