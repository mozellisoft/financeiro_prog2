package com.financeiro.controller;

import com.financeiro.model.Cliente;
import com.financeiro.model.CalculadoraJuros;
import java.util.ArrayList;
import java.util.List;

public class ClienteController {
    private List<Cliente> clientes;
    private Long proximoId;

    public ClienteController() {
        this.clientes = new ArrayList<>();
        this.proximoId = 1L;
    }

    public Cliente cadastrarCliente(String nome, String cpf, double valorEmprestimo, double taxaJuros, int tempoMeses) {
        Cliente cliente = new Cliente(proximoId++, nome, cpf, valorEmprestimo, taxaJuros, tempoMeses);
        clientes.add(cliente);
        return cliente;
    }

    public List<Cliente> listarClientes() {
        return new ArrayList<>(clientes);
    }

    public Cliente buscarClientePorId(Long id) {
        return clientes.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Cliente buscarClientePorCPF(String cpf) {
        return clientes.stream()
                .filter(c -> c.getCpf().equals(cpf))
                .findFirst()
                .orElse(null);
    }

    public boolean atualizarCliente(Long id, String nome, String cpf, double valorEmprestimo, double taxaJuros, int tempoMeses) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            cliente.setNome(nome);
            cliente.setCpf(cpf);
            cliente.setValorEmprestimo(valorEmprestimo);
            cliente.setTaxaJuros(taxaJuros);
            cliente.setTempoMeses(tempoMeses);
            return true;
        }
        return false;
    }

    public boolean removerCliente(Long id) {
        return clientes.removeIf(c -> c.getId().equals(id));
    }

    public double calcularJurosSimples(Long id) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            return CalculadoraJuros.calcularJurosSimples(
                cliente.getValorEmprestimo(),
                cliente.getTaxaJuros(),
                cliente.getTempoMeses()
            );
        }
        return 0.0;
    }

    public double calcularJurosCompostos(Long id) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            return CalculadoraJuros.calcularJurosCompostos(
                cliente.getValorEmprestimo(),
                cliente.getTaxaJuros(),
                cliente.getTempoMeses()
            );
        }
        return 0.0;
    }

    public double calcularMontanteSimples(Long id) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            return CalculadoraJuros.calcularMontanteSimples(
                cliente.getValorEmprestimo(),
                cliente.getTaxaJuros(),
                cliente.getTempoMeses()
            );
        }
        return 0.0;
    }

    public double calcularMontanteComposto(Long id) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null) {
            return CalculadoraJuros.calcularMontanteComposto(
                cliente.getValorEmprestimo(),
                cliente.getTaxaJuros(),
                cliente.getTempoMeses()
            );
        }
        return 0.0;
    }

    public boolean quitarEmprestimo(Long id) {
        Cliente cliente = buscarClientePorId(id);
        if (cliente != null && !cliente.isQuitado()) {
            cliente.setQuitado(true);
            return true;
        }
        return false;
    }
} 