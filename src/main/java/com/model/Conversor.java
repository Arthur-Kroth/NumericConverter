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
    
    public String deciToBinary(double deci) {
        boolean isNegative = deci < 0;
        deci = Math.abs(deci);

        long parteInt = (long) deci;
        double frac = deci - parteInt;

        String somaFrac = "";
        
        if (frac > 0) {
            somaFrac += ",";

            while (frac > 0 && somaFrac.length() <= 16) {
                frac *= 2;

                if (frac >= 1) {
                    somaFrac += "1";
                    frac -= 1;
                } else {
                    somaFrac += "0";
                }
            }
        }

        String resultadoBinario = Long.toBinaryString(parteInt) + somaFrac;
        return isNegative ? "-" + resultadoBinario : resultadoBinario;
    }
    
    public String deciToOctal(double deci) {
        boolean isNegative = deci <0;
        deci = Math.abs(deci);
        
        long parteInt = (long) deci;
        double frac = deci - parteInt;
        
        String somaFrac = "";

        if (frac > 0) {
            somaFrac = ",";
            
            while (frac > 0 && somaFrac.length() <= 16) {
                frac *= 8;
                int parteIntOct = (int) frac;
                if (frac >= 1) {
                    somaFrac += parteIntOct;
                    frac -= parteIntOct;
                } else {
                    somaFrac += "0";
                }
            }
        }
        String resultadoOctal = Long.toOctalString(parteInt) + somaFrac;
        return isNegative ? "-" + resultadoOctal : resultadoOctal;
    }

    public String deciToHexa(double deci) {
        boolean isNegative = deci < 0;
        deci = Math.abs(deci);

        long parteInt = (long) deci;
        double frac = deci - parteInt;

        String somaFrac = "";
        if (frac > 1e-10) {
            somaFrac = ",";
            int maxDigits = 16;
            while (frac > 1e-10 && maxDigits-- > 0) {
                frac *= 16;
                int digito = (int) frac;
                // Converte 10-15 para A-F
                somaFrac += Character.toUpperCase(Character.forDigit(digito, 16));
                frac -= digito;
            }
        }

        String resultado = Long.toHexString(parteInt).toUpperCase() + somaFrac;
        return isNegative ? "-" + resultado : resultado;
    }
    
    public double parseDeciInput(String s) {
        if (s.isEmpty()) throw new IllegalArgumentException("Campo decimal está vazio.");
        return Double.parseDouble(s.replace(",", "."));
    }
    
    public String formatDeciOutput(double value) {
        long intPart = (long) value;
        if (Math.abs(value - intPart) < 1e-12) return String.valueOf(intPart);
        // Limit to ~10 significant decimal places to avoid floating-point noise
        String raw = String.format("%.10f", value).replaceAll("0+$", "");
        if (raw.endsWith(".")) raw = raw.substring(0, raw.length() - 1);
        return raw.replace(".", ",");
    }
}