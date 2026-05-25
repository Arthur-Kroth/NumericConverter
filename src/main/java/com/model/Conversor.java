package com.model;

public class Conversor {
    
    public String binaryToDeci(String binario) {
        
        if (binario == null || binario.isEmpty()) {
            throw new IllegalArgumentException("Binario Invalido");
        }
        
        String[] partes = binario.split("\\.");
        
        String parteIntDeci = Integer.toString(Integer.parseInt(partes[0], 2));
        String parteFracDeci = "";
        
        if (partes.length > 1) {
            String fracao = partes[1];
            double somaFracao = 0;
            
            for (int i = 0; i < fracao.length(); i++) {
                char bit = fracao.charAt(i);
                if (bit == '1') {
                    somaFracao += Math.pow(2, -(i+1));
                }
            }
            parteFracDeci = String.valueOf(somaFracao).substring(1);
        }
        
        return parteIntDeci + parteFracDeci;
    }
    
    
    public String binaryToOctal() {
        
    }
}