import java.util.Scanner;

public class Vetor_Aula02 {
    static int tamanho, minimo, maximo, posicaoVaga = 0, repete;
    static int[] vetor;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Tamanho do vetor:  ");
        tamanho = input.nextInt();
        if (tamanho <= 0) {
            System.out.println("ERRO: Vetor deve ter tamanho maior que zero.");
        }else {
            vetor = new int[tamanho];

            System.out.println("Qual é o tamanho do mínimo:  ");
            minimo = input.nextInt();
            System.out.println("Qual é o tamanho do máximo? ");
            maximo = input.nextInt();
        }

        while (true) {
            System.out.println(msg());
            int opc = input.nextInt();

            if (opc == 0) {
                System.out.println("Encerrando o programa...");
                break;
            }

            switch (opc) {
                case 1:
                    atribuirValor(input);
                    break;
                case 2:
                    alterarValor(input);
                    break;
                case 3:
                    removerValor(input);
                    break;
                case 4:
                    lerConteudo(input);
                    break;
                case 5:
                    localizarValor(input);
                    break;
                case 7:
                    removerUltimaOcupada(input);
                    break;
                case 8:
                    imprimirVetor();
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }
        }

        input.close();
    }

    public static boolean verificarPosicao(int posicao, boolean deveEstarOcupada) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("ERRO: Posição inválida. A posição deve estar entre 0 e " + (tamanho - 1) + ".");
            return false;
        }
        if (deveEstarOcupada && vetor[posicao] == posicaoVaga) {
            System.out.println("ERRO: A posição " + posicao + " está vaga. Nada para alterar.");
            return false;
        } else if (!deveEstarOcupada && vetor[posicao] != posicaoVaga) {
            System.out.println("ERRO: A posição " + posicao + " já está ocupada com o valor " + vetor[posicao] + ".");
            return false;
        }
        return true;
    }

    public static void atribuirValor(Scanner input) {
        System.out.println("Opção 1 selecionada: Atribuir um valor a determinada posição.");

        System.out.print("Digite a posição (0 a " + (tamanho - 1) + "): ");
        int posicao = input.nextInt();

        if (!verificarPosicao(posicao, false)) {
            return; // Sai do método se a posição não for válida ou já estiver ocupada
        }

        System.out.print("Digite o valor a ser atribuído: ");
        int valor = input.nextInt();

        vetor[posicao] = valor;
        System.out.println("Valor " + valor + " atribuído à posição " + posicao + ".");

        System.out.println("Vetor atualizado:");
        imprimirVetor();
    }

    public static void alterarValor(Scanner input) {
        System.out.println("Opção 2 selecionada: Alterar o valor de determinada posição.");

        System.out.print("Digite a posição (0 a " + (tamanho - 1) + "): ");
        int posicao = input.nextInt();

        if (!verificarPosicao(posicao, true)) {
            return; // Sai do método se a posição não for válida ou estiver vaga
        }

        System.out.print("Digite o novo valor para a posição " + posicao + ": ");
        int novoValor = input.nextInt();

        vetor[posicao] = novoValor;
        System.out.println("Valor da posição " + posicao + " alterado para " + novoValor + ".");

        System.out.println("Vetor atualizado:");
        imprimirVetor();
    }

    public static void removerValor(Scanner input) {
        System.out.println("Opção 3 selecionada: Remover o valor de determinada posição.");

        System.out.print("Digite a posição (0 a " + (tamanho - 1) + "): ");
        int posicao = input.nextInt();

        if (!verificarPosicao(posicao, true)) {
            return;
        }

        int valorRemovido = vetor[posicao];
        vetor[posicao] = posicaoVaga;
        System.out.println("Valor " + valorRemovido + " removido da posição " + posicao + ".");

        System.out.println("Vetor atualizado:");
        imprimirVetor();
    }
    public static void lerConteudo(Scanner input) {
        System.out.println("Opção 4 selecionada: Ler o conteúdo de uma posição.");

        System.out.print("Digite a posição (0 a " + (tamanho - 1) + "): ");
        int posicao = input.nextInt();

        if (!verificarPosicao(posicao, true)) {
            return;
        }
        System.out.println("O valor na posição " + posicao + " é: " + vetor[posicao]);
    }

    public static void localizarValor(Scanner input) {
        System.out.println("Opção 5 selecionada: Localizar um valor e retornar sua posição.");

        System.out.print("Digite o valor a ser localizado: ");
        int valor = input.nextInt();

        boolean encontrado = false;
        System.out.println("Posições onde o valor " + valor + " foi encontrado:");

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] == valor) {
                System.out.println("Posição " + i);
                encontrado = true;
            }
        }
        if (!encontrado) {
            System.out.println("O valor " + valor + " não foi encontrado no vetor.");
        }
    }

    public static void removerUltimaOcupada(Scanner input) {
        System.out.println("Opção 7 selecionada: Remover da última posição ocupada.");

        // Percorre o vetor do final para o início
        for (int i = vetor.length - 1; i >= 0; i--) {
            if (vetor[i] != posicaoVaga) {
                int valorRemovido = vetor[i];
                vetor[i] = posicaoVaga;
                System.out.println("Valor " + valorRemovido + " removido da posição " + i + ".");
                System.out.println("Vetor atualizado:");
                imprimirVetor();
                return; // Sai do método após remover o valor
            }
        }

        System.out.println("ERRO: Nenhuma posição ocupada encontrada para remover.");
    }

    public static void imprimirVetor() {
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("Posição " + i + ": " + vetor[i]);
        }
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