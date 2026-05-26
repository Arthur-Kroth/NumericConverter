package com.principal;

import com.model.Conversor;
import java.util.Scanner;

public class ConversorNumerico {

    public static void main(String[] args) throws Exception {
        
        Conversor conversor = new Conversor();
        Scanner sc = new Scanner(System.in);
        
        boolean i = false;
        
        while (i == false) {
            
            System.out.println("[1] Converter Binario");
            System.out.println("[2] Converter Octal");
            System.out.println("[3] Converter Decimal");
            System.out.println("[4] Converter Hexadecimal");
            System.out.println("[5] Sair");

            int escolha = sc.nextInt();
            sc.nextLine();
            
            String numero ="";
            
            switch (escolha) {
                case 1:
                    System.out.print("Qual numero deseja converter? ");
                    numero = sc.nextLine();
                    System.out.println("O numero " + numero + " em decimal eh: " + conversor.binaryToDeci(numero));
                    break;
                case 2:
                    System.out.print("Qual numero deseja converter? ");
                    numero = sc.nextLine();
                    System.out.println("O numero " + numero + " em decimal eh: " + conversor.octalToDeci(numero));
                    break;
                case 3:
                    System.out.print("Qual numero deseja converter? ");
                    numero = sc.nextLine();
                    System.out.println("O numero " + numero + " em decimal eh: " + conversor.deciToBinary(Double.parseDouble(numero)));
                    break;
                case 4:
                    System.out.print("Qual numero deseja converter? ");
                    numero = sc.nextLine();
                    System.out.println("O numero " + numero + " em decimal eh: " + conversor.hexaToDeci(numero));
                    break;
                case 5: System.exit(0); break;
                default: System.out.println("Numero invalido"); break;
            }
        }
    }
}