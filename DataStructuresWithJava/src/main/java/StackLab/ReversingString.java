package StackLab;

import java.util.Scanner;

//Exercício 2: Inversão de uma String
//Implemente uma função que use uma pilha para inverter uma string.
//Exemplo:
//  Entrada: "pilha"
//  Saída: "ahlip"

public class ReversingString {
    private String[] pilha;
    private int topo;
    private int tamanhoMaximo;

    public ReversingString(int tamanhoMaximo) {
        this.pilha = new String[tamanhoMaximo];
        this.topo = -1;
        this.tamanhoMaximo = tamanhoMaximo;
    }
    public static boolean isEntradaValida(String inputEntrada) {
        return inputEntrada != null && !inputEntrada.trim().isEmpty();
    }
    public void push(String elemento) {
        if (topo == tamanhoMaximo - 1) {
            throw new IllegalStateException("Pilha cheia!");
        }
        pilha[++topo] = elemento;
    }
    public String pop() {
        if (topo == -1) {
            throw new IllegalStateException("Pilha vazia!");
        }
        return pilha[topo--];
    }
    public static String inverterString(String input) {
        ReversingString pilha = new ReversingString(input.length());

        for (int i = 0; i < input.length(); i++) {
            pilha.push(String.valueOf(input.charAt(i)));
        }

        StringBuilder stringInvertida = new StringBuilder();
        while (pilha.topo != -1) {
            stringInvertida.append(pilha.pop());
        }

        return stringInvertida.toString();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Digite uma palavra ou frase: ");
        String inputEntrada = input.nextLine();

        if (isEntradaValida(inputEntrada)) {
            String stringInvertida = inverterString(inputEntrada);
            System.out.println("String invertida: " + stringInvertida);
        } else {
            System.out.println("Entrada inválida: a string está vazia ou é nula.");
        }
    }
}
