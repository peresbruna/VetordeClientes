public class VetorClientes {
    private Cliente[] array;
    private int tamanhoAtual;

    public VetorClientes(){
        this.array = new Cliente[20];
        this.tamanhoAtual = 0;
    }

    public void adicionarCliente(Cliente cliente) {
        if(tamanhoAtual >= array.length){
            aumentarCapacidade();
        }
        array[tamanhoAtual++] = cliente;
    }

    public Cliente[] listarClientes() {
        Cliente[] clientesListados = new Cliente[tamanhoAtual];
        for (int i = 0; i < tamanhoAtual; i++) {
            clientesListados[i] = array[i];
        }
        return clientesListados;
    }

    public Cliente[] buscarClientesPorNome(String nome) {
        Cliente[] clientesEncontrados = new Cliente[tamanhoAtual];
        int contador = 0;
        for (int i = 0; i < tamanhoAtual; i++) {
            if (array[i].getNome().equalsIgnoreCase(nome)) {
                clientesEncontrados[contador++] = array[i];
            }
        }

        if (contador < clientesEncontrados.length) {
            Cliente[] resultado = new Cliente[contador];
            System.arraycopy(clientesEncontrados, 0, resultado, 0, contador);
            return resultado;
        }
        return clientesEncontrados;
    }

    public Cliente[] filtrarClientesPorDominio(String dominio) {
        Cliente[] clientesFiltrados = new Cliente[tamanhoAtual];
        int contador = 0;
        for (int i = 0; i < tamanhoAtual; i++) {
            if (array[i].getEmail().endsWith(dominio)) {
                clientesFiltrados[contador++] = array[i];
            }
        }

        if (contador < clientesFiltrados.length) {
            Cliente[] resultado = new Cliente[contador];
            System.arraycopy(clientesFiltrados, 0, resultado, 0, contador);
            return resultado;
        }
        return clientesFiltrados;
    }

    public void alterarCliente(int indice, Cliente novoCliente) {
        if (indice >= 0 && indice < tamanhoAtual) {
            array[indice] = novoCliente;
        } else {
            System.out.println("Índice fora dos limites.");
        }
    }

    public void removerCliente(int indice) {
        if (indice >= 0 && indice < tamanhoAtual) {
            for (int i = indice; i < tamanhoAtual - 1; i++) {
                array[i] = array[i + 1];
            }
            array[tamanhoAtual - 1] = null;
            tamanhoAtual--;
        } else {
            System.out.println("Índice fora dos limites.");
        }
    }

    public void inserirClienteNaPosicao(int indice, Cliente cliente) {
        if (indice >= 0 && indice <= tamanhoAtual) {
            if (tamanhoAtual >= array.length) {
                aumentarCapacidade();
            }
            for (int i = tamanhoAtual; i > indice; i--) {
                array[i] = array[i - 1];
            }
            array[indice] = cliente;
            tamanhoAtual++;
        } else {
            System.out.println("Índice fora dos limites.");
        }
    }

    public void aumentarCapacidade() {
        Cliente[] novoArray = new Cliente[array.length * 2];
        for (int i = 0; i < array.length; i++) {
            novoArray[i] = array[i];
        }
        array = novoArray;
    }
}