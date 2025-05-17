package com.financeiro.model;

public class CalculadoraJuros {
    
    public static double calcularJurosSimples(double capital, double taxa, int tempo) {
        // Converte a taxa anual para decimal
        double taxaDecimal = taxa / 100;
        // Converte o tempo para anos
        double tempoAnos = tempo / 12.0;
        
        return capital * taxaDecimal * tempoAnos;
    }
    
    public static double calcularJurosCompostos(double capital, double taxa, int tempo) {
        // Converte a taxa anual para decimal
        double taxaDecimal = taxa / 100;
        // Converte o tempo para anos
        double tempoAnos = tempo / 12.0;
        
        double montante = capital * Math.pow((1 + taxaDecimal), tempoAnos);
        return montante - capital;
    }
    
    public static double calcularMontanteSimples(double capital, double taxa, int tempo) {
        return capital + calcularJurosSimples(capital, taxa, tempo);
    }
    
    public static double calcularMontanteComposto(double capital, double taxa, int tempo) {
        return capital + calcularJurosCompostos(capital, taxa, tempo);
    }
} 