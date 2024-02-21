class CadastroProdutos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Produto[] produtos = cadastrarProdutos(scanner);
        ordenarProdutos(produtos);

        System.out.print("Digite o código do produto a ser buscado: ");
        int codigoBuscado = scanner.nextInt();

        int comparaSeq = buscaSequencial(produtos, codigoBuscado);
        int comparaBin = buscaBinaria(produtos, codigoBuscado);

        System.out.println("\nBusca Sequencial:");
        System.out.println("Número de comparações: " + comparaSeq);

        System.out.println("\nBusca Binária:");
        System.out.println("Número de comparações: " + comparaBin);

        scanner.close();
    }

    private static Produto[] cadastrarProdutos(Scanner scanner) {
        Produto[] produtos = new Produto[12];
        System.out.println("Cadastro de Produtos:");

        for (int i = 0; i < produtos.length; i++) {
            System.out.println("Produto " + (i + 1));
            System.out.print("Código: ");
            int codigo = scanner.nextInt();
            scanner.nextLine();
            System.out.print("Descrição: ");
            String descricao = scanner.nextLine();
            System.out.print("Preço: ");
            double preco = scanner.nextDouble();

            produtos[i] = new Produto(codigo, descricao, preco);
        }

        return produtos;
    }

    private static void ordenarProdutos(Produto[] produtos) {
        for (int i = 0; i < produtos.length - 1; i++) {
            for (int j = 0; j < produtos.length - i - 1; j++) {
                if (produtos[j].getCodigo() > produtos[j + 1].getCodigo()) {
                    Produto temp = produtos[j];
                    produtos[j] = produtos[j + 1];
                    produtos[j + 1] = temp;
                }
            }
        }
    }

    private static int buscaSequencial(Produto[] produtos, int codigoBuscado) {
        int comparações = 0;
        for (int i = 0; i < produtos.length; i++) {
            comparações++;
            if (produtos[i].getCodigo() == codigoBuscado) {
                return comparações;
            }
        }
        return comparações;
    }

    private static int buscaBinaria(Produto[] produtos, int codigoBuscado) {
        int comparações = 0;
        int inicio = 0;
        int fim = produtos.length - 1;

        while (inicio <= fim) {
            comparações++;
            int meio = (inicio + fim) / 2;
            if (produtos[meio].getCodigo() == codigoBuscado) {
                return comparações;
            } else if (produtos[meio].getCodigo() < codigoBuscado) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return comparações;
    }
}

class Produto {
    private int codigo;
    private String descricao;
    private double preco;

    public Produto(int codigo, String descricao, double preco) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }
}
