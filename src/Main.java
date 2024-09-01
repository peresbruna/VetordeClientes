public class Main {
    public static void main(String[] args) {
        VetorClientes vetorClientes = new VetorClientes();
        for (int i = 1; i <= 30; i++) {
            String nome = "Cliente" + i;
            int telefone = 2222-2222 + (i % 10);
            String email = "cliente" + i + "@exemplo.com";
            if (i % 2 == 0) {
                email = "cliente" + i + "@teste.com";
            }
            Cliente cliente = new Cliente(nome, telefone, email);
            vetorClientes.adicionarCliente(cliente);
        }

        System.out.println("Todos os clientes:");
        for (Cliente cliente : vetorClientes.listarClientes()) {
            System.out.println(cliente);
        }

        Cliente clienteAlterado = new Cliente("ClienteAlterado", 0000-0000, "alterado@exemplo.com");
        vetorClientes.alterarCliente(2, clienteAlterado);

        Cliente clienteInserido = new Cliente("ClienteInserido", 1111-1111, "inserido@exemplo.com");
        vetorClientes.inserirClienteNaPosicao(1, clienteInserido);

        vetorClientes.removerCliente(3);

        System.out.println("\nClientes após alterações:");
        for (Cliente cliente : vetorClientes.listarClientes()) {
            System.out.println(cliente);
        }

        Cliente[] clientesJoao = vetorClientes.buscarClientesPorNome("Cliente1");
        System.out.println("\nClientes com nome 'Cliente1':");
        for (Cliente cliente : clientesJoao) {
            System.out.println(cliente);
        }

        Cliente[] clientesExemplo = vetorClientes.filtrarClientesPorDominio("@exemplo.com");
        System.out.println("\nClientes com domínio '@exemplo.com':");
        for (Cliente cliente : clientesExemplo) {
            System.out.println(cliente);
        }
    }
}
