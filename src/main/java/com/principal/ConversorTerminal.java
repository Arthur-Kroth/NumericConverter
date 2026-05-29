package com.principal;

import com.model.Conversor;
import java.util.Scanner;

public class ConversorTerminal {

    public static void main(String[] args) throws Exception {
        
        Conversor conversor = new Conversor();
        Scanner sc = new Scanner(System.in);
        
        boolean i = false;
        
        while (i == false) {
            System.out.println("=========================");
            System.out.println("    CONVERSOR NUMERICO   ");
            System.out.println("=========================");
            System.out.println("[1] Converter Binario");
            System.out.println("[2] Converter Octal");
            System.out.println("[3] Converter Decimal");
            System.out.println("[4] Converter Hexadecimal");
            System.out.println("[5] Sair");
            System.out.println("=========================");
            System.out.print("O que deseja fazer: ");
            int escolha = sc.nextInt();
            sc.nextLine();
            
            String numero ="";
            
            switch (escolha) {
                case 1 -> {
                    System.out.print("Qual numero binario deseja converter: ");
                    numero = sc.nextLine();
                    System.out.println("O numero binario " + numero + " em outros sistemas numericos sao:");
                    System.out.println("Em decimal: " + conversor.binaryToDeci(numero));
                    System.out.println("Em ocatal: " + conversor.deciToOctal(conversor.binaryToDeci(numero.replace(",", "."))));
                    System.out.println("Em hexadecimal: " + conversor.deciToHexa(conversor.binaryToDeci(numero.replace(",", "."))));
                }
                case 2 -> {
                    System.out.print("Qual numero octal deseja converter: ");
                    numero = sc.nextLine();
                    System.out.println("O numero octal " + numero + " em outros sistemas numericos sao:");
                    System.out.println("Em binario: " + conversor.deciToBinary(conversor.octalToDeci(numero.replace(",", "."))));
                    System.out.println("Em decimal: " + conversor.octalToDeci(numero));
                    System.out.println("Em hexadecimal: " + conversor.deciToHexa(conversor.octalToDeci(numero.replace(",", "."))));
                }
                case 3 -> {
                    System.out.print("Qual numero decimal deseja converter: ");
                    numero = sc.nextLine();
                    System.out.println("O numero decimal " + numero + " em outros sistemas numericos sao:");
                    System.out.println("Em binario: " + conversor.deciToBinary(Double.parseDouble(numero.replace(",", "."))));
                    System.out.println("Em ocatal: " + conversor.deciToOctal(Double.parseDouble(numero.replace(",", "."))));
                    System.out.println("Em hexadecimal: " + conversor.deciToHexa(Double.parseDouble(numero.replace(",", "."))));
                }
                case 4 -> {
                    System.out.print("Qual numero hexadeciaml deseja converter: ");
                    numero = sc.nextLine();
                    System.out.println("O numero hexadeciaml " + numero + " em outros sistemas numericos sao:");
                    System.out.println("Em binario: " + conversor.deciToBinary(conversor.hexaToDeci(numero.replace(",", "."))));
                    System.out.println("Em ocatal: " + conversor.deciToOctal(conversor.hexaToDeci(numero.replace(",", "."))));
                    System.out.println("Em decimal: " + conversor.hexaToDeci(numero));
                }
                case 5 -> System.exit(0);
                default -> System.out.println("Numero invalido");
            }
        }
    }
}