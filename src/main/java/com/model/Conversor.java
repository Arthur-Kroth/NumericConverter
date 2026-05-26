package com.model;

public class Conversor {
    
    public double binaryToDeci(String binario) {
        
        if (binario == null || binario.isEmpty()) throw new IllegalArgumentException("Binario Invalido");
        binario = binario.replace(",", ".");
        String[] partes = binario.split("\\.", 2);
        long parteIntDeci = (long) Integer.parseInt(partes[0], 2);
        
        double somaFracao = 0;
        if (partes.length > 1) {
            for (int i = 0; i < partes[1].length(); i++) {
                char bit = partes[1].charAt(i);
                if (bit < '0' || bit > '1') throw new IllegalArgumentException("Digito invalido na fracao");
                if (bit == '1') {
                    somaFracao += Math.pow(2, -(i + 1));
                }
            }
        }
        
        return parteIntDeci + somaFracao;
    }
    
    
    public double octalToDeci(String octal) {
        if (octal == null || octal.isEmpty()) throw new IllegalArgumentException("Octal Invalido");
        octal = octal.replace(",", ".");
        String[] partes = octal.split("\\.", 2);
        long parteIntOct = (long) (Integer.parseInt(partes[0], 8));
        
        double somaFracao = 0;
        if (partes.length > 1) {
            for (int i = 0; i < partes[1].length(); i++){
                int bit = partes[1].charAt(i) - '0';
                if (bit < 0 || bit > 7) throw new IllegalArgumentException("Digito invalido na fracao");
                
                somaFracao += bit * Math.pow(8, -(i + 1));
            }
        }
        return parteIntOct + somaFracao;
    }
    
    public double hexaToDeci(String hexa) {
        if (hexa == null || hexa.isEmpty()) throw new IllegalArgumentException("Hexadecimal Invalido");
        hexa = hexa.replace(",", ".");
        String[] partes = hexa.split("\\.", 2);
        long parteIntHexa = Long.parseUnsignedLong(partes[0], 16);
        
        double somaFracao = 0;
        if (partes.length > 1) {
            for (int i = 0; i < partes[1].length(); i++){
                int bit = Character.digit(partes[1].charAt(i), 16);
                
                if (bit == -1) throw new IllegalArgumentException("Caractere inválido na fração");
                
                somaFracao += bit * Math.pow(16, -(i + 1));
            }
        }
        return parteIntHexa + somaFracao;
    }
}