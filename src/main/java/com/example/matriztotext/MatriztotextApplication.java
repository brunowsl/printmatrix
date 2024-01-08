package com.example.matriztotext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

@SpringBootApplication
public class MatriztotextApplication {

    public static void main(String[] args) {

        // Exemplo de duas matrizes 5x5
        int[][] matrix1 = {
                {1, 4, 2, 7, 5},
                {6, 7, 8, 9, 10},
                {11, 12, 13, 14, 15},
                {16, 17, 18, 19, 20},
                {21, 22, 23, 24, 25}
        };

        int[][] matrix2 = {
                {5, 4, 3, 2, 1},
                {10, 9, 8, 7, 6},
                {15, 14, 13, 12, 11},
                {20, 19, 18, 17, 16},
                {25, 24, 23, 22, 21}
        };

        // Matriz para armazenar o resultado da soma
        int[][] sumMatrix = new int[5][5];

        // Somando elementos de mesmo índice
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                sumMatrix[i][j] = matrix1[i][j] + matrix2[i][j];
            }
        }

        // Escrevendo a matriz resultante em um arquivo
        try (PrintWriter writer = new PrintWriter(new FileWriter("resultMatrix.txt"))) {
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    writer.print(sumMatrix[i][j] + " ");
                }
                writer.println();
            }
            System.out.println("Matriz resultante foi escrita no arquivo resultMatrix.txt");
        } catch (IOException e) {
            System.out.println("Ocorreu um erro ao escrever no arquivo: " + e.getMessage());
        }


        SpringApplication.run(MatriztotextApplication.class, args);
    }

}
