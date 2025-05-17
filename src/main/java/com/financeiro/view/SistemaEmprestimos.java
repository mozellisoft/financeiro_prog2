package com.financeiro.view;

import com.financeiro.controller.ClienteController;
import com.financeiro.model.Cliente;
import java.util.List;
import java.util.Scanner;

public class SistemaEmprestimos {
    private static ClienteController controller = new ClienteController();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean executando = true;
        
        while (executando) {
            System.out.println("\n=== Sistema de Empréstimos ===");
            System.out.println("1. Cadastrar novo cliente");
            System.out.println("2. Listar clientes");
            System.out.println("3. Buscar cliente por CPF");
            System.out.println("4. Calcular juros");
            System.out.println("5. Quitar empréstimo");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");
            
            int opcao = scanner.nextInt();
            scanner.nextLine(); // Limpar o buffer
            
            switch (opcao) {
                case 1:
                    cadastrarCliente();
                    break;
                case 2:
                    listarClientes();
                    break;
                case 3:
                    buscarClientePorCPF();
                    break;
                case 4:
                    calcularJuros();
                    break;
                case 5:
                    quitarEmprestimo();
                    break;
                case 6:
                    executando = false;
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
        
        scanner.close();
    }

    private static void cadastrarCliente() {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        
        System.out.print("CPF: ");
        String cpf = scanner.nextLine();
        
        System.out.print("Valor do empréstimo: ");
        double valor = scanner.nextDouble();
        
        System.out.print("Taxa de juros anual (%): ");
        double taxa = scanner.nextDouble();
        
        System.out.print("Tempo em meses: ");
        int tempo = scanner.nextInt();
        
        Cliente cliente = controller.cadastrarCliente(nome, cpf, valor, taxa, tempo);
        System.out.println("Cliente cadastrado com sucesso! ID: " + cliente.getId());
    }

    private static void listarClientes() {
        List<Cliente> clientes = controller.listarClientes();
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }
        
        for (Cliente cliente : clientes) {
            System.out.println("\nID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Valor do empréstimo: R$ " + cliente.getValorEmprestimo());
            System.out.println("Status: " + (cliente.isQuitado() ? "Quitado" : "Em aberto"));
        }
    }

    private static void buscarClientePorCPF() {
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        
        Cliente cliente = controller.buscarClientePorCPF(cpf);
        if (cliente != null) {
            System.out.println("\nCliente encontrado:");
            System.out.println("ID: " + cliente.getId());
            System.out.println("Nome: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("Valor do empréstimo: R$ " + cliente.getValorEmprestimo());
            System.out.println("Status: " + (cliente.isQuitado() ? "Quitado" : "Em aberto"));
        } else {
            System.out.println("Cliente não encontrado.");
        }
    }

    private static void calcularJuros() {
        System.out.print("Digite o ID do cliente: ");
        Long id = scanner.nextLong();
        
        System.out.println("\nEscolha o tipo de cálculo:");
        System.out.println("1. Juros Simples");
        System.out.println("2. Juros Compostos");
        int tipo = scanner.nextInt();
        
        double juros = 0;
        double montante = 0;
        
        if (tipo == 1) {
            juros = controller.calcularJurosSimples(id);
            montante = controller.calcularMontanteSimples(id);
        } else if (tipo == 2) {
            juros = controller.calcularJurosCompostos(id);
            montante = controller.calcularMontanteComposto(id);
        } else {
            System.out.println("Opção inválida!");
            return;
        }
        
        System.out.println("\nResultado do cálculo:");
        System.out.println("Juros: R$ " + String.format("%.2f", juros));
        System.out.println("Montante total: R$ " + String.format("%.2f", montante));
    }

    private static void quitarEmprestimo() {
        System.out.print("Digite o ID do cliente: ");
        Long id = scanner.nextLong();
        
        if (controller.quitarEmprestimo(id)) {
            System.out.println("Empréstimo quitado com sucesso!");
        } else {
            System.out.println("Não foi possível quitar o empréstimo. Verifique se o cliente existe e se o empréstimo ainda não foi quitado.");
        }
    }
} 