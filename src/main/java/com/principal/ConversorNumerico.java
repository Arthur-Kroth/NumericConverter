package com.principal;

import com.model.Conversor;
import java.util.Scanner;

public class ConversorNumerico {

    public static void main(String[] args) throws Exception {
        
        Conversor conversor = new Conversor();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("║   CONVERSOR DE BASE NUMERICA ║");
            System.out.println("╠══════════════════════════════╣");
            System.out.println("║  [1] Binario  → ?            ║");
            System.out.println("║  [2] Octal    → ?            ║");
            System.out.println("║  [3] Decimal  → ?            ║");
            System.out.println("║  [4] Hexa     → ?            ║");
            System.out.println("║  [5] Sair                    ║");
            System.out.println("╚══════════════════════════════╝");
            System.out.print("Escolha a base de origem: ");

            int origem;
            try {
                origem = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  ✗ Entrada invalida. Digite um numero de 1 a 5.");
                continue;
            }

            if (origem == 5) {
                System.out.println("Encerrando... Ate logo!");
                break;
            }

            if (origem < 1 || origem > 4) {
                System.out.println("  ✗ Opcao invalida. Escolha entre 1 e 5.");
                continue;
            }

            // ── Lê o número ──────────────────────────────────────────
            System.out.print("Digite o numero: ");
            String numero = sc.nextLine().trim();

            if (numero.isEmpty()) {
                System.out.println("  ✗ Nenhum numero digitado.");
                continue;
            }

            // ── Submenu de destino (exclui a própria base) ────────────
            System.out.println("\nConverter para:");
            if (origem != 1) System.out.println("  [1] Binario");
            if (origem != 2) System.out.println("  [2] Octal");
            if (origem != 3) System.out.println("  [3] Decimal");
            if (origem != 4) System.out.println("  [4] Hexadecimal");
            System.out.print("Escolha o destino: ");

            int destino;
            try {
                destino = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("  ✗ Entrada invalida.");
                continue;
            }

            if (destino == origem) {
                System.out.println("  ✗ Origem e destino sao iguais. Escolha uma base diferente.");
                continue;
            }

            if (destino < 1 || destino > 4) {
                System.out.println("  ✗ Opcao de destino invalida.");
                continue;
            }

            // ── Conversão ─────────────────────────────────────────────
            try {
                // Passo 1: converte para decimal
                double valorDecimal = switch (origem) {
                    case 1 -> conversor.binaryToDeci(numero);
                    case 2 -> conversor.octalToDeci(numero);
                    case 3 -> Double.parseDouble(numero.replace(",", "."));
                    case 4 -> conversor.hexaToDeci(numero);
                    default -> throw new IllegalArgumentException("Origem invalida");
                };

                // Passo 2: converte do decimal para a base destino
                String resultado = switch (destino) {
                    case 1 -> conversor.deciToBinary(valorDecimal);
                    case 2 -> conversor.deciToOctal(valorDecimal);
                    case 3 -> formatarDecimal(valorDecimal);
                    case 4 -> conversor.deciToHexa(valorDecimal);
                    default -> throw new IllegalArgumentException("Destino invalido");
                };

                String[] nomes = {"", "Binario", "Octal", "Decimal", "Hexadecimal"};
                System.out.println("\n  ✓ " + nomes[origem] + " " + numero
                        + "  →  " + nomes[destino] + " " + resultado);

            } catch (NumberFormatException e) {
                System.out.println("  ✗ Numero invalido para a base escolhida: " + e.getMessage());
            } catch (IllegalArgumentException e) {
                System.out.println("  ✗ Erro: " + e.getMessage());
            }
        }

        sc.close();
    }

    /** Exibe o decimal sem casas desnecessárias (ex: 10.0 → "10", 10.75 → "10,75") */
    private static String formatarDecimal(double valor) {
        if (valor == Math.floor(valor) && !Double.isInfinite(valor)) {
            return String.valueOf((long) valor);
        }
        return String.valueOf(valor).replace(".", ",");
    }
}