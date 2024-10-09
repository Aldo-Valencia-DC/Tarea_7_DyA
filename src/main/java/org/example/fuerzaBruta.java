package org.example;

import java.util.Scanner;

public class fuerzaBruta {

    public static int[] maxProducto(int[] A) {
        int maxProd = A[0] * A[1];
        int num1 = A[0], num2 = A[1];
        int n = A.length;


        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int prod = A[i] * A[j];
                if (prod > maxProd) {
                    maxProd = prod;
                    num1 = A[i];
                    num2 = A[j];
                }
            }
        }


        return new int[]{maxProd, num1, num2};
    }

    public static void minMonedas(int[] monedas, int cantidadObjetivo) {
        int minMonedas = Integer.MAX_VALUE;
        int optimoI = 0, optimoJ = 0, optimoK = 0;


        for (int i = 0; i <= cantidadObjetivo / monedas[0]; i++) {
            for (int j = 0; j <= cantidadObjetivo / monedas[1]; j++) {
                for (int k = 0; k <= cantidadObjetivo / monedas[2]; k++) {
                    int total = i * monedas[0] + j * monedas[1] + k * monedas[2];

                    if (total == cantidadObjetivo) {
                        if (i + j + k < minMonedas) {
                            minMonedas = i + j + k;
                            optimoI = i;
                            optimoJ = j;
                            optimoK = k;
                        }
                    }
                }
            }
        }

        if (minMonedas != Integer.MAX_VALUE) {
            System.out.println("Monedas necesarias: " + minMonedas);
            System.out.println(optimoI + " monedas de " + monedas[0]);
            System.out.println(optimoJ + " monedas de " + monedas[1]);
            System.out.println(optimoK + " monedas de " + monedas[2]);
        } else {
            System.out.println("No hay combinación posible para alcanzar el objetivo.");
        }
    }


    public static int maxValorMochila(int[] pesos, int[] valores, int capacidadMax) {
        int maxValor = 0;

        for (int i = 0; i <= 1; i++) {
            for (int j = 0; j <= 1; j++) {
                for (int k = 0; k <= 1; k++) {
                    for (int l = 0; l <= 1; l++) {

                        int pesoTotal = i * pesos[0] + j * pesos[1] + k * pesos[2] + l * pesos[3];
                        int valorTotal = i * valores[0] + j * valores[1] + k * valores[2] + l * valores[3];


                        if (pesoTotal <= capacidadMax) {
                            maxValor = Math.max(maxValor, valorTotal);
                        }
                    }
                }
            }
        }

        return maxValor;
    }




    public static void main(String[] args) {
        //Primer algoritmo
        int[] lista = {2, 5, 6, 3, 8, 1};
        int[] resultado = maxProducto(lista);

        System.out.println("El producto máximo es " + resultado[0] +
                ", y es el resultado de multiplicar " + resultado[1] +
                " y " + resultado[2]);

        //Segundo algoritmo
        int[] monedas = {1, 2, 5};
        Scanner sc = new Scanner(System.in);

        // Pedir al usuario la cantidad objetivo
        System.out.print("Introduce la cantidad objetivo: ");
        int cantidadObjetivo = sc.nextInt();

        minMonedas(monedas, cantidadObjetivo);


        //Tercer algoritmo
        int[] pesos = {2, 3, 4, 5};
        int[] valores = {3, 4, 5, 8};
        int capacidadMax = 8;


        int maxValor = maxValorMochila(pesos, valores, capacidadMax);
        System.out.println("Valor máximo que se puede llevar: " + maxValor);
    }
}
