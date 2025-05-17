package com.financeiro.model;

public class Cliente {
    private Long id;
    private String nome;
    private String cpf;
    private double valorEmprestimo;
    private double taxaJuros;
    private int tempoMeses;
    private boolean quitado;

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cpf, double valorEmprestimo, double taxaJuros, int tempoMeses) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.valorEmprestimo = valorEmprestimo;
        this.taxaJuros = taxaJuros;
        this.tempoMeses = tempoMeses;
        this.quitado = false;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValorEmprestimo() {
        return valorEmprestimo;
    }

    public void setValorEmprestimo(double valorEmprestimo) {
        this.valorEmprestimo = valorEmprestimo;
    }

    public double getTaxaJuros() {
        return taxaJuros;
    }

    public void setTaxaJuros(double taxaJuros) {
        this.taxaJuros = taxaJuros;
    }

    public int getTempoMeses() {
        return tempoMeses;
    }

    public void setTempoMeses(int tempoMeses) {
        this.tempoMeses = tempoMeses;
    }

    public boolean isQuitado() {
        return quitado;
    }

    public void setQuitado(boolean quitado) {
        this.quitado = quitado;
    }
} 