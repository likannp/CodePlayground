package StackLab;

import java.util.Scanner;
import java.util.Stack;

public class StackNativo {
    public static void main(String[] args) {
        Stack<Integer> pilha01 = new Stack<>();
        Stack<Triangulo> pilha02= new Stack<>();

        while (true) {
            Scanner scn = new Scanner(System.in);
            System.out.println("\n\n\n==============================================");
            System.out.println("PILHA 1 - contem numeros inteiros");
            System.out.println("PILHA 2 - contem objetos da classe StackLab.Triangulo");
            System.out.println("==============================================");
            System.out.println("0 - encerrar");
            System.out.println("----- opcoes da PILHA 1 -----");
            System.out.println("1 - inserir elemento");
            System.out.println("2 - extrair elemento");
            System.out.println("3 - localizar elemento");
            System.out.println("4 - imprimir a pilha");
            System.out.println("----- opcoes da PILHA 2 -----");
            System.out.println("5 - inserir elemento");
            System.out.println("6 - extrair elemento");
            System.out.println("7 - localizar elemento");
            System.out.println("8 - imprimir a pilha");
            System.out.println("==============================================");
            System.out.println("");
            System.out.print("Opcao: ");
            int opc = scn.nextByte();

            if (opc == 0) {
                break;
            }
            else if (opc == 1) {  //===> push
                Scanner scn1 = new Scanner(System.in);
                System.out.print("Valor do elemento (numero int.) -> ");
                int valor1 = scn1.nextInt();
                int x = pilha01.push(valor1);
                System.out.print("x = " + x);
            } else if (opc == 2) {  //===> pop
                if (pilha01.empty()) {
                    System.out.println("A pilha esta' vazia");
                } else {
                    System.out.println("Elemento extraido -> " + pilha01.pop());
                }
            } else if (opc == 3) {  //===> localizar

                Scanner scn3 = new Scanner(System.in);
                System.out.print("Valor a localizar -> ");
                int valor3 = scn.nextInt();
                System.out.println("Valor encontrado nas seguintes posicoes: ");
                System.out.print("===> ");
                for (int i = 0; i < pilha01.size(); i++) {
                    if (pilha01.get(i) == valor3) {
                        System.out.print(i + " ");
                    }
                }


                System.out.println("");
                System.out.println("Posicao pelo metodo 'search' -> " + pilha01.search(valor3));

                System.out.println("\n--- Agora pelo meu método equivalente ao 'search' plus:");
                for (int i = pilha01.size() - 1; i >= 0; i--) {
                    if (pilha01.get(i) == valor3) {
                        System.out.print(((pilha01.size() - i)) + " ");
                    }
                }

            } else if (opc == 4) {  //===> imprimir
                int qtd = pilha01.size();
                System.out.println("stack1.size() -> " + qtd + " elementos na pilha.");
                for (int i = 0; i < qtd; i++) {
                    System.out.print(pilha01.get(i) + " ");
                }

            }
            else if (opc == 5) {  //===> push

                float[] t = defineTriangulo();
                Triangulo tri = new Triangulo(t[0], t[1], t[2]);
                if (!tri.trianguloValido()) {
                    System.out.println("ERRO: triangulo invalido.");
                    continue;
                }
                pilha02.push(tri);

            } else if (opc == 6) {  //===> pop
                if (pilha02.empty()) {
                    System.out.println("A pilha esta' vazia");
                } else {
                    System.out.println("Elemento extraido -> " + printTriangulo(pilha02.pop()));
                }
            } else if (opc == 7) {

                float[] t = defineTriangulo();
                Triangulo tri = new Triangulo(t[0], t[1], t[2]);

                int pos = pilha02.search(tri);
                System.out.println("StackLab.Triangulo na posicao -> " + pos);

            } else if (opc == 8) {
                int qtd = pilha02.size();
                System.out.println("stack2.size() -> " + qtd);
                for (int i = 0; i < qtd; i++) {
                    System.out.print(printTriangulo(pilha02.get(i)) + " == ");
                }

            }

        }

    }

    private static float[] defineTriangulo() {
        float[] tri = new float[3];
        Scanner scn = new Scanner(System.in);
        System.out.print("Lado 1 -> ");
        tri[0] = scn.nextFloat();
        System.out.print("Lado 2 -> ");
        tri[1] = scn.nextFloat();
        System.out.print("Lado 3 -> ");
        tri[2] = scn.nextFloat();
        return tri;
    }

    private static String printTriangulo(Triangulo t) {
        return "|" + t.getLado1() + "|" + t.getLado2() + "|" + t.getLado3() + "|";
    }

}